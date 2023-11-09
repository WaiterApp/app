package es.ifp.waiterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

import java.util.HashMap;
import java.util.Map;

public class Registro extends AppCompatActivity {

    private EditText box_nombre, box_apellidos, box_email, box_telefono, box_contrasena, box_confContra;
    private Button btn_registro, btn_volver;
    private Intent pasarPantalla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        box_nombre = findViewById(R.id.box_nombre_registro);
        box_apellidos = findViewById(R.id.box_apellidos_registro);
        box_email = findViewById(R.id.box_email_registro);
        box_telefono = findViewById(R.id.box_telefono_registro);
        box_contrasena = findViewById(R.id.box_contrasena_registro);
        box_confContra = findViewById(R.id.box_contrasena2_registro);

        btn_registro = findViewById(R.id.button_confirmar_resgistro);
        btn_volver = findViewById(R.id.button_atras_registro);


        btn_volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pasarPantalla = new Intent(Registro.this, InicioSesion.class);
                finish();
                startActivity(pasarPantalla);
            }
        });

        btn_registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Verificar si las contraseñas coinciden
                if(box_contrasena.getText().toString().equals(box_confContra.getText().toString()))
                {
                    registrarUsuario();
                } else {
                    Toast.makeText(Registro.this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public void registrarUsuario()
    {


        // Parámetros
        String email = box_email.getText().toString().trim();
        String contrasena = box_contrasena.getText().toString();
        String nombre = box_nombre.getText().toString();
        String apellidos = box_apellidos.getText().toString();
        String telefono = box_telefono.getText().toString();

        // Instanciar el RequestQueue.
        RequestQueue queue = MySingleton.getInstance(this.getApplicationContext()).getRequestQueue();
        // URL de nuestro servidor 000webhost
        String url = Constantes.URL_ALTA_USUARIO;

        // Solicitar respuesta de tipo String de la URL proporcionada.
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Obtener respuesta y verificar exito en registro

                        String respuesta = response.toString();

                        Toast.makeText(Registro.this, respuesta, Toast.LENGTH_SHORT).show();

                        if(respuesta.equals("Registro exitoso"))
                        {
                            pasarPantalla = new Intent(Registro.this, CodigoRestaurante.class);
                            finish();
                            startActivity(pasarPantalla);
                        } else if (respuesta.equals("Fallo en el registro")){
                            Toast.makeText(Registro.this, "Intentelo de nuevo mas tarde", Toast.LENGTH_SHORT).show();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Registro.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams()
            {
                // configurar los parámetros POST (EMAIL y contrasena) que se enviaran al servidor
                Map<String, String> params = new HashMap<>();
                params.put("email", email);
                params.put("contrasena", contrasena);
                params.put("nombre", nombre);
                params.put("apellidos", apellidos);
                params.put("telefono", telefono);
                return params;
            }
        };

        // Desactivar almacenamiento en caché
        stringRequest.setShouldCache(false);
        // Añadir request a la RequestQueue.
        MySingleton.getInstance(this).addToRequestQueue(stringRequest);


    }
}