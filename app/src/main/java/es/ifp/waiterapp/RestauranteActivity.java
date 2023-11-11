package es.ifp.waiterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
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

public class RestauranteActivity extends AppCompatActivity {

    protected ImageButton buttonMenu, buttonCamarero, buttonPagar;
    protected TextView lblNombreRestaurante;
    private Intent pasarPantalla;
    private Bundle extras;
    private int idRestaurante;
    private String nombreRestaurante;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurante);

        lblNombreRestaurante = findViewById(R.id.text_nombreRestaurante_RestActivity);
        buttonMenu = (ImageButton) findViewById(R.id.imageButton_menu_RestActivity);
        buttonCamarero = (ImageButton) findViewById(R.id.imageButton_camarero_RestActivity);
        buttonPagar = (ImageButton) findViewById(R.id.imageButton_pagar_RestActivity);

        extras = getIntent().getExtras();
        idRestaurante = extras.getInt("id_rest");

        obtenerNombreRestaurante();

        buttonMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pasarPantalla = new Intent(RestauranteActivity.this, CartaActivity.class);
                pasarPantalla.putExtra("id_rest", idRestaurante);
                finish();
                startActivity(pasarPantalla);

            }
        });

        buttonCamarero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(RestauranteActivity.this, "Un camarero acudirá a la mesa lo antes posible", Toast.LENGTH_SHORT).show();

            }
        });


        buttonPagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pasarPantalla = new Intent(RestauranteActivity.this, Pagar.class);
                finish();
                startActivity(pasarPantalla);

            }
        });

    }

    public void obtenerNombreRestaurante()
    {


        // Instanciar el RequestQueue.
        RequestQueue queue = MySingleton.getInstance(this.getApplicationContext()).getRequestQueue();
        // URL de nuestro servidor 000webhost
        String url = Constantes.URL_LEER_RESTAURANTE+"?id_restaurante="+idRestaurante;

        // Solicitar respuesta de tipo String de la URL proporcionada.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("RESPUESTA", response.toString());

                        // Modificar la etiqueta para indicar el nombre del restaurante
                        String nombreRestaurante = response.toString();
                        lblNombreRestaurante.setText(nombreRestaurante);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(RestauranteActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        // Desactivar almacenamiento en caché
        stringRequest.setShouldCache(false);
        // Añadir request a la RequestQueue.
        MySingleton.getInstance(this).addToRequestQueue(stringRequest);
    }

}