package es.ifp.waiterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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

import java.util.HashMap;
import java.util.Map;

public class InicioSesion extends AppCompatActivity {

    // Variables
    private EditText box_usuario, box_contrasena;
    private Button btn_inicioS, btn_registro, btn_continuarSinS;
    private Intent pasarPantalla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_sesion);

        // Relacionar las variables con los elementos del UI
        box_usuario = findViewById(R.id.box_usuario_iniciosesion);
        box_contrasena = findViewById(R.id.box_contrasena_iniciosesion);

        btn_inicioS = findViewById(R.id.button_incia_iniciosesion);
        btn_registro = findViewById(R.id.button_registro_iniciosesion);
        btn_continuarSinS = findViewById(R.id.button_noinicio_iniciosesion);

        // Ir a la actividad Registro
        btn_registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pasarPantalla = new Intent(InicioSesion.this, Registro.class);
                finish();
                startActivity(pasarPantalla);
            }
        });

        // Ir a la actividad CodigoRestaurante si se elige continuar sin iniciar sesión
        btn_continuarSinS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pasarPantalla = new Intent(InicioSesion.this, CodigoRestaurante.class);
                finish();
                startActivity(pasarPantalla);
            }
        });

        btn_inicioS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Verificar que las cajas no estén vacías
                if((box_usuario.getText().toString()).equalsIgnoreCase("")){
                    Toast.makeText(InicioSesion.this, "Introduzca un email", Toast.LENGTH_SHORT).show();
                } else if ((box_contrasena.getText().toString()).equalsIgnoreCase("")) {
                    Toast.makeText(InicioSesion.this, "Introduzca una contraseña", Toast.LENGTH_SHORT).show();
                } else {
                    iniciarSesion();
                }

            }
        });

    }

    public void iniciarSesion()
    {
        // Obtener el correo y la contraseña de las cajas EditText
        final String EMAIL = box_usuario.getText().toString().trim();
        final String CONTRASENA = box_contrasena.getText().toString().trim();

        // Crear la RequestQueue con Volley
        RequestQueue queue = MySingleton.getInstance(this.getApplicationContext()).getRequestQueue();

        // Crear un StringRequest para hacer la solicitud POST al servidor
        StringRequest stringRequest = new StringRequest(Request.Method.POST, Constantes.URL_INICIO_SESION,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Gestionar la respuesta del servidor
                        if (response.toString().equals("403")) {
                            // Fallo en el inicio de sesión, informar con un error
                            Toast.makeText(InicioSesion.this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
                        } else if (response.toString().equals("401")) {
                            // El usuario no existe en la base de datos
                            Toast.makeText(InicioSesion.this, "El correo indicado no está registrado", Toast.LENGTH_SHORT).show();
                        } else if (response.toString().equals("200")) {
                            // Inicio de sesión exitoso, ir a la siguente actividad
                            pasarPantalla = new Intent(InicioSesion.this, CodigoRestaurante.class);
                            finish();
                            startActivity(pasarPantalla);
                        } else {
                            // El usuario no existe en la base de datos
                            Toast.makeText(InicioSesion.this, "Se ha producido un error, inténtelo de nuevo mas tarde", Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // Gestionar error
                        Toast.makeText(InicioSesion.this, "Error: " + error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams()
            {
                // configurar los parámetros POST (EMAIL y contrasena) que se enviaran al servidor
                Map<String, String> params = new HashMap<>();
                params.put("email", EMAIL);
                params.put("contrasena", CONTRASENA);
                return params;
            }
        };
        // Desactivar almacenamiento en caché
        stringRequest.setShouldCache(false);
        // Add the request to the RequestQueue
        MySingleton.getInstance(this).addToRequestQueue(stringRequest);
    }

}