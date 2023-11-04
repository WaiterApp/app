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

public class CodigoRestaurante extends AppCompatActivity {

    protected EditText boxCodigo, boxMesa;
    protected ImageButton buttonInfo, buttonQR;
    protected Button buttonEntrar;
    private Intent pasarPantalla;
    private String codigoRestaurante;
    private String mesa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_codigo_restaurante);

        boxCodigo = findViewById(R.id.box_codigo_codigoactivity);
        boxMesa = findViewById(R.id.box_mesa_codigoactivity);

        buttonInfo = findViewById(R.id.button_info_codigoactivity);
        buttonEntrar = findViewById(R.id.button_entrar_codigoactivity);
        buttonQR = findViewById(R.id.button_qr_codigoactivity);

        buttonEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                codigoRestaurante = boxCodigo.getText().toString();

                if (codigoRestaurante.equals("Pilar2023")) {

                    pasarPantalla = new Intent(CodigoRestaurante.this, RestaurantePilar.class);
                    finish();
                    startActivity(pasarPantalla);

                } else {
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