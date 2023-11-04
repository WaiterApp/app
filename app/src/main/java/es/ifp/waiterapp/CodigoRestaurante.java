package es.ifp.waiterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class CodigoRestaurante extends AppCompatActivity {

    protected EditText boxCodigo, boxMesa;
    protected ImageButton buttonInfo, buttonQR;
    protected Button buttonEntrar;
    private Intent pasarPantalla;
    private String codigoRestaurante;
    private String mesa;
    protected Restaurante restaurante;
    protected ArrayList<Restaurante> restaurantes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_codigo_restaurante);

        boxCodigo = findViewById(R.id.box_codigo_codigoactivity);
        boxMesa = findViewById(R.id.box_mesa_codigoactivity);

        buttonInfo = findViewById(R.id.button_info_codigoactivity);
        buttonEntrar = findViewById(R.id.button_entrar_codigoactivity);
        buttonQR = findViewById(R.id.button_qr_codigoactivity);

        // Instanciar el RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        // String url ="http://192.168.1.133/App2/read.php"; //localhost XAMPP
        String url = "https://waiterappsite.000webhostapp.com//readRestaurante.php"; // 000webhost

        // Solicitar respuesta de tipo String de la URL proporcionada.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            // Crear JSON array con la respuesta del servidor
                            JSONArray jsonArray = new JSONArray(response);

                            // Iterar por cada elemento del array
                            for(int i=0;i<jsonArray.length();i++){
                                // Instanciar restaurante
                                restaurante = new Restaurante();
                                // Obtener un jsonobject de cada elemento del array
                                JSONObject jsonObject = jsonArray.getJSONObject(i);

                                restaurante.setIdRestaurante(jsonObject.getInt("id_restaurante")); // Asignar el id al atributo idRestaurante del objeto restaurante
                                restaurante.setNombre(jsonObject.getString("nombre")); // Asignar el nombre al atributo nombre del objeto restaurante
                                restaurante.setDireccion(jsonObject.getString("direccion")); // Etc ...
                                restaurante.setCodigoPostal(jsonObject.getInt("codigo_postal"));
                                restaurante.setRazonSocial(jsonObject.getString("razon_social"));
                                restaurante.setEmail(jsonObject.getString("email"));
                                restaurante.setSitioWeb(jsonObject.getString("sitio_web"));
                                restaurante.setContactoNombre(jsonObject.getString("contacto_nombre"));
                                restaurante.setTelefono(jsonObject.getInt("telefono"));
                                restaurante.setCodigoRestaurante(jsonObject.getString("codigo_restaurante"));

                                // Añadir el objeto restaurante a la lista de restaurantes
                                restaurantes.add(restaurante);
                            }
                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(CodigoRestaurante.this, "No existe ningún restaurante", Toast.LENGTH_SHORT).show();
            }
        });

        // Añadir request a la RequestQueue.
        queue.add(stringRequest);

        buttonEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                codigoRestaurante = boxCodigo.getText().toString();
                boolean coincidencia = false;

                for (Restaurante restaurante : restaurantes)
                {
                    if (codigoRestaurante.equalsIgnoreCase(restaurante.getCodigoRestaurante())) {
                        coincidencia = true;
                        pasarPantalla = new Intent(CodigoRestaurante.this, RestauranteActivity.class);
                        finish();
                        startActivity(pasarPantalla);
                        break;
                    }

                }
                if (!coincidencia){
                    Toast.makeText(CodigoRestaurante.this, "Código de restaurante erróneo", Toast.LENGTH_SHORT).show();
                }

            }

        });

        buttonInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(CodigoRestaurante.this, "Encontrará el código en su mesa, sino consulte a un camarero", Toast.LENGTH_SHORT).show();

            }
        });

        buttonQR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(CodigoRestaurante.this, "Próximamente", Toast.LENGTH_SHORT).show();

            }
        });



    }
}