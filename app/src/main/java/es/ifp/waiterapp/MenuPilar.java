package es.ifp.waiterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MenuPilar extends AppCompatActivity {

    protected Button buttonEntrantes;
    protected Button buttonPrincipales;
    protected Button buttonComplementos;
    protected Button buttonBebidas;
    protected Button buttonPostres;
    protected ImageButton buttonAtras;
    protected ImageButton buttonComandaActual;
    protected ImageButton buttonCarta;
    protected ImageButton buttonCamarero;
    protected ImageButton buttonComandaTotal;
    protected ImageButton buttonPagar;

    private Intent pasarPantalla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_pilar);

        buttonEntrantes = (Button) findViewById(R.id.button_entrantes_menu);
        buttonPrincipales = (Button) findViewById(R.id.button_principales_menu);
        buttonComplementos = (Button) findViewById(R.id.button_complementos_menu);
        buttonBebidas = (Button) findViewById(R.id.button_bebidas_menu);
        buttonPostres = (Button) findViewById(R.id.button_postres_menu);
        buttonAtras = (ImageButton) findViewById(R.id.button_atras_menu);
        buttonComandaActual = (ImageButton) findViewById(R.id.button_comandaActual_menu);
        buttonCarta = (ImageButton) findViewById(R.id.button_carta_menu);
        buttonCamarero = (ImageButton) findViewById(R.id.button_camarero_menu);
        buttonComandaTotal = (ImageButton) findViewById(R.id.button_comandaTotal_menu);
        buttonPagar = (ImageButton) findViewById(R.id.button_pagar_menu);

        buttonEntrantes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(MenuPilar.this, "Agua añadida a la comanda", Toast.LENGTH_SHORT).show();

            }
        });

        buttonPrincipales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(MenuPilar.this, "Cocacola añadida a la comanda", Toast.LENGTH_SHORT).show();

            }
        });

        buttonComplementos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(MenuPilar.this, "Hamburguesa añadida a la comanda", Toast.LENGTH_SHORT).show();

            }
        });

        buttonPostres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(MenuPilar.this, "Bocata añadido a la comanda", Toast.LENGTH_SHORT).show();

            }
        });

        buttonBebidas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(MenuPilar.this, "Flan añadido a la comanda", Toast.LENGTH_SHORT).show();

            }
        });


        buttonAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pasarPantalla = new Intent(MenuPilar.this, CodigoRestaurante.class);
                finish();
                startActivity(pasarPantalla);

            }
        });

    }
}