package es.ifp.waiterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class CodigoRestaurante extends AppCompatActivity {

    protected EditText boxCodigo, boxMesa;
    protected TextView lblSaludo;
    protected ImageButton buttonInfo, buttonQR;
    protected Button buttonEntrar, buttonLogout;
    private Intent pasarPantalla;
    private String codigoRestaurante;
    private String mesa;
    public static final String SHARED_PREFS = "shared_prefs";
    public static final String EMAIL_KEY = "email_key";
    public static final String CONTRASENA_KEY = "contrasena_key";
    private SharedPreferences sharedPreferences;
    private String email, contrasena, nombreUsuario;
    private int idRestaurante =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_codigo_restaurante);

        // Inicializar las sharedprefs
        sharedPreferences = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
        // Obtener el correo y nombre de usuario de las sharedprefs y almacenarlos en las variables
        // email y nombreUsuario
        email = sharedPreferences.getString("email_key", null);
        nombreUsuario = sharedPreferences.getString("nombreUsuario_key",null);

        lblSaludo = findViewById(R.id.text_saludo_codigoactivity);
        if (nombreUsuario==null)
        {
            lblSaludo.setText("¡Bienvenido!");
        } else {
            lblSaludo.setText("¡Hola "+nombreUsuario+"!");
        }
        boxCodigo = findViewById(R.id.box_codigo_codigoactivity);
        boxMesa = findViewById(R.id.box_mesa_codigoactivity);

        buttonInfo = findViewById(R.id.button_info_codigoactivity);
        buttonEntrar = findViewById(R.id.button_entrar_codigoactivity);
        buttonLogout = findViewById(R.id.button_logout_codigoactivity);
        if (email==null)
        {
            buttonLogout.setEnabled(false);
        }
        buttonQR = findViewById(R.id.button_qr_codigoactivity);



        buttonEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                codigoRestaurante = boxCodigo.getText().toString();

                if (codigoRestaurante.equals("")){
                    Toast.makeText(CodigoRestaurante.this, "Introduzca un código", Toast.LENGTH_SHORT).show();
                } else {
                    // Verificar si el código introducido es válido
                    verificarCodigoRest();
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

        buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Llamar al método para modificar los valores en sharedprefs
                SharedPreferences.Editor editor = sharedPreferences.edit();
                // Limpiar los valores almacenados
                editor.clear();
                editor.apply();

                // Volver a la actividad de inicio de sesión
                pasarPantalla = new Intent(CodigoRestaurante.this, InicioSesion.class);
                finish();
                startActivity(pasarPantalla);
            }
        });



    }

    public void verificarCodigoRest(){

        // Obtener el codigo introducido por el usaurio
        final String CODIGO_REST = boxCodigo.getText().toString().trim();

        // Instanciar el RequestQueue.
        RequestQueue queue = MySingleton.getInstance(this.getApplicationContext()).getRequestQueue();
        // URL de nuestro servidor 000webhost
        String url = Constantes.URL_CODIGO_RESTAURANTE;

        // Solicitar respuesta de tipo String de la URL proporcionada.
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            Log.d("RESPUESTA", response.toString());
                            // Obtener un jsonobject del Json array
                            JSONObject jsonObject = new JSONObject(response);

                            if(jsonObject.getInt("codigo")==200){
                                Toast.makeText(CodigoRestaurante.this, jsonObject.getString("mensaje"), Toast.LENGTH_SHORT).show();
                                idRestaurante = jsonObject.getInt("id_restaurante");
                                // Si es válido, devolverá un id distinto de 0. Pasar a la siguiente pantalla
                                if (idRestaurante !=0) {
                                    pasarPantalla = new Intent(CodigoRestaurante.this, RestauranteActivity.class);
                                    pasarPantalla.putExtra("id_rest", idRestaurante);
                                    finish();
                                    startActivity(pasarPantalla);
                                }
                            } else if (jsonObject.getInt("codigo")==403) {
                                Toast.makeText(CodigoRestaurante.this, jsonObject.getString("mensaje"), Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(CodigoRestaurante.this, "Se ha producido un error, inténtelo de nuevo más tarde", Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(CodigoRestaurante.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams()
            {
                // configurar los parámetros POST (EMAIL y contrasena) que se enviaran al servidor
                Map<String, String> params = new HashMap<>();
                params.put("codigo_rest", CODIGO_REST);
                return params;
            }
        };

        // Desactivar almacenamiento en caché
        stringRequest.setShouldCache(false);
        // Añadir request a la RequestQueue.
        MySingleton.getInstance(this).addToRequestQueue(stringRequest);
    }

}