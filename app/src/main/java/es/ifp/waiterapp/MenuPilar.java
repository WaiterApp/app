package es.ifp.waiterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MenuPilar extends AppCompatActivity {

    protected Button buttonAgua;
    protected Button buttonCola;
    protected Button buttonHamburguesa;
    protected Button buttonBocata;
    protected Button buttonHelado;
    protected Button buttonFlan;
    protected Button buttonVolver;

    private Intent pasarPantalla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_pilar);

        buttonAgua = (Button) findViewById(R.id.button_agua_menupilar);
        buttonCola = (Button) findViewById(R.id.button_cocacola_menupilar);
        buttonHamburguesa = (Button) findViewById(R.id.button_hamburguesa_menupilar);
        buttonBocata = (Button) findViewById(R.id.button_bocata_menupilar);
        buttonFlan = (Button) findViewById(R.id.button_flan_menupilar);
        buttonHelado = (Button) findViewById(R.id.button_helado_menupilar);
        buttonVolver = (Button) findViewById(R.id.button_volver_menupilar);

        buttonAgua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(MenuPilar.this, "Agua añadida a la comanda", Toast.LENGTH_SHORT).show();

            }
        });

        buttonCola.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(MenuPilar.this, "Cocacola añadida a la comanda", Toast.LENGTH_SHORT).show();

            }
        });

        buttonHamburguesa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(MenuPilar.this, "Hamburguesa añadida a la comanda", Toast.LENGTH_SHORT).show();

            }
        });

        buttonBocata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(MenuPilar.this, "Bocata añadido a la comanda", Toast.LENGTH_SHORT).show();

            }
        });

        buttonFlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(MenuPilar.this, "Flan añadido a la comanda", Toast.LENGTH_SHORT).show();

            }
        });

        buttonHelado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(MenuPilar.this, "Flan añadido a la comanda", Toast.LENGTH_SHORT).show();

            }
        });

        buttonVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pasarPantalla = new Intent(MenuPilar.this, RestaurantePilar.class);
                finish();
                startActivity(pasarPantalla);

            }
        });

    }
}