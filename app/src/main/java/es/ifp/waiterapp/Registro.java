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
                registrarUsuario();
            }
        });

    }

    public void registrarUsuario()
    {
        // Instanciar el RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        // URL de nuestro servidor 000webhost
        String url = Constantes.URL_READ_RESTAURANTE;

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

                            }
                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Registro.this, "****", Toast.LENGTH_SHORT).show();
            }
        });

        // Añadir request a la RequestQueue.
        queue.add(stringRequest);

    }
}