package es.ifp.waiterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class RestaurantePilar extends AppCompatActivity {

    protected ImageButton buttonMenu;
    protected ImageButton buttonCamarero;
    protected ImageButton buttonPagar;

    private Intent pasarPantalla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurante_pilar);

        buttonMenu = (ImageButton) findViewById(R.id.imageButton_menu_pilar);
        buttonCamarero = (ImageButton) findViewById(R.id.imageButton_camarero_pilar);
        buttonPagar = (ImageButton) findViewById(R.id.imageButton_pagar_pilar);

        buttonMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pasarPantalla = new Intent(RestaurantePilar.this, MenuPilar.class);
                finish();
                startActivity(pasarPantalla);

            }
        });

        buttonCamarero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(RestaurantePilar.this, "Un camarero acudirá a la mesa lo antes posible", Toast.LENGTH_SHORT).show();

            }
        });


        buttonPagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pasarPantalla = new Intent(RestaurantePilar.this, Pagar.class);
                finish();
                startActivity(pasarPantalla);

            }
        });

    }
}