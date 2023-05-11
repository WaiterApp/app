package es.ifp.waiterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ListadoRestaurantes extends AppCompatActivity {

    protected Button buttonPilar;
    protected Button buttonKiko;
    protected Button buttonLola;

    private Intent pasarPantalla;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_restaurantes);

        buttonPilar = (Button) findViewById(R.id.button_pilar_listadorestaurantes);
        buttonKiko = (Button) findViewById(R.id.button_kiko_listadorestaurantes);
        buttonLola = (Button) findViewById(R.id.button_lola_listadorestaurantes);

        buttonPilar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pasarPantalla = new Intent(ListadoRestaurantes.this, CodigoRestaurante.class);
                finish();
                startActivity(pasarPantalla);

            }
        });


    }
}