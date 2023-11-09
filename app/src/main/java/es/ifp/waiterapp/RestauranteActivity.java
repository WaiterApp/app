package es.ifp.waiterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class RestauranteActivity extends AppCompatActivity {

    protected ImageButton buttonMenu;
    protected ImageButton buttonCamarero;
    protected ImageButton buttonPagar;

    private Intent pasarPantalla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurante);

        buttonMenu = (ImageButton) findViewById(R.id.imageButton_menu_RestActivity);
        buttonCamarero = (ImageButton) findViewById(R.id.imageButton_camarero_RestActivity);
        buttonPagar = (ImageButton) findViewById(R.id.imageButton_pagar_RestActivity);

        buttonMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pasarPantalla = new Intent(RestauranteActivity.this, MenuPilar.class);
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
}