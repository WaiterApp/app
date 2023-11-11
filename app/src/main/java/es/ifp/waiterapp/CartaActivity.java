package es.ifp.waiterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class CartaActivity extends AppCompatActivity {

    protected Button buttonEntrantes, buttonPrincipales, buttonComplementos, buttonBebidas, buttonPostres;
    protected ImageButton buttonAtras, buttonComandaActual, buttonCarta, buttonCamarero, buttonComandaTotal, buttonPagar;
    private Intent pasarPantalla;
    private Bundle extras;
    private int idRestaurante;
    private String nombreRestaurante;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carta);

        buttonEntrantes = findViewById(R.id.button_entrantes_menu);
        buttonPrincipales = findViewById(R.id.button_principales_menu);
        buttonComplementos = findViewById(R.id.button_complementos_menu);
        buttonBebidas = findViewById(R.id.button_bebidas_menu);
        buttonPostres = findViewById(R.id.button_postres_menu);
        buttonAtras = findViewById(R.id.button_atras_menu);
        buttonComandaActual = findViewById(R.id.button_comandaActual_menu);
        buttonCarta = findViewById(R.id.button_carta_menu);
        buttonCamarero = findViewById(R.id.button_camarero_menu);
        buttonComandaTotal = findViewById(R.id.button_comandaTotal_menu);
        buttonPagar = findViewById(R.id.button_pagar_menu);

        extras = getIntent().getExtras();
        idRestaurante = extras.getInt("id_rest");
        nombreRestaurante = extras.getString("nombre");

        buttonEntrantes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(CartaActivity.this, "Agua añadida a la comanda", Toast.LENGTH_SHORT).show();

            }
        });

        buttonPrincipales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(CartaActivity.this, "Cocacola añadida a la comanda", Toast.LENGTH_SHORT).show();

            }
        });

        buttonComplementos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(CartaActivity.this, "Hamburguesa añadida a la comanda", Toast.LENGTH_SHORT).show();

            }
        });

        buttonPostres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(CartaActivity.this, "Bocata añadido a la comanda", Toast.LENGTH_SHORT).show();

            }
        });

        buttonBebidas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(CartaActivity.this, "Flan añadido a la comanda", Toast.LENGTH_SHORT).show();

            }
        });


        buttonAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pasarPantalla = new Intent(CartaActivity.this, RestauranteActivity.class);
                pasarPantalla.putExtra("id_rest", idRestaurante);
                pasarPantalla.putExtra("nombre", nombreRestaurante);
                finish();
                startActivity(pasarPantalla);

            }
        });

    }
}