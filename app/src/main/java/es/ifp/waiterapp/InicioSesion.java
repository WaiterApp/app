package es.ifp.waiterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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

    }

}