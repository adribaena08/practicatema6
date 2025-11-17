package com.example.practicatema6;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SegundaPnatalla extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_segunda_pnatalla);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView tvCorreo = findViewById(R.id.textView4);
        String correoRecibido = getIntent().getStringExtra("correo");
        tvCorreo.setText(correoRecibido);

        Button botDesconectar = findViewById(R.id.button);

        botDesconectar.setOnClickListener(v -> {

            Intent intent = new Intent(SegundaPnatalla.this, MainActivity.class);
            startActivity(intent);
        });
    }
}
