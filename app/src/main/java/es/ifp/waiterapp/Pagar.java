
package es.ifp.waiterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class Pagar extends AppCompatActivity {

    protected ImageButton buttonApp;
    protected ImageButton buttonTarjeta;
    protected ImageButton buttonEfectivo;
    protected Button buttonVolver;

    private Intent pasarPantalla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagar);

        buttonApp = (ImageButton) findViewById(R.id.imageButton_app_pagar);
        buttonTarjeta = (ImageButton) findViewById(R.id.imageButton_tarjeta_pagar);
        buttonEfectivo = (ImageButton) findViewById(R.id.imageButton_efectivo_pagar);
        buttonVolver = (Button) findViewById(R.id.button_volver_pagar);

        buttonApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Pagar.this, "Próximamente", Toast.LENGTH_SHORT).show();
            }
        });

        buttonEfectivo.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Pagar.this, "Un camarero acudirá lo antes posible a su mesa", Toast.LENGTH_SHORT).show();
            }
        }));

        buttonTarjeta.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Pagar.this, "Un camarero acudirá lo antes posible a su mesa", Toast.LENGTH_SHORT).show();
            }
        }));

        buttonVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pasarPantalla = new Intent(Pagar.this, RestaurantePilar.class);
                finish();
                startActivity(pasarPantalla);

            }
        });


    }
}