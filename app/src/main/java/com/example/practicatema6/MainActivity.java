package com.example.practicatema6;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText etCorreo;
    private EditText etContraseña;
    private Button bContinuar;
    private Switch sRecordar;
    private TextView tvMensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etCorreo = findViewById(R.id.etCorreo);
        etContraseña = findViewById(R.id.etContraseña);
        bContinuar = findViewById(R.id.bContinuar);
        sRecordar = findViewById(R.id.sRecordar);
        tvMensaje = findViewById(R.id.tvMensaje);

        bContinuar.setOnClickListener(v -> {
            String correo = etCorreo.getText().toString();
            String contraseña = etContraseña.getText().toString();

            if (correo.equals("abb0030@gmail.com") && contraseña.equals("12345")) {

                tvMensaje.setText("Usuario y contraseña correctas");
                tvMensaje.setTextColor(Color.GREEN);

                if (sRecordar.isChecked()) {
                    tvMensaje.setText("Usuario y contraseña correctas y contraseña guardada");
                }


                Intent intent = new Intent(MainActivity.this, SegundaPnatalla.class);

                intent.putExtra("correo", correo);

                startActivity(intent);

            } else {
                tvMensaje.setText("Usuario y/o contraseña incorrectas");
                tvMensaje.setTextColor(Color.RED);
            }
        });
    }
}
