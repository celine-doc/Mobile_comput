package com.example.myapplication;

import android.os.Bundle;
import android.view.View; // ⚠️ important
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {
    public final static String NAME = "com.example.myapplication.name";
    public final static String EMAIL = "com.example.myapplication.email";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Gère les insets (barres système)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    // 🔹 La méthode appelée par android:onClick="submit" dans ton XML
    public void submit(View view) {
        EditText eTname  = findViewById(R.id.name);
        EditText eTemail = findViewById(R.id.email);

        String name  = eTname.getText().toString().trim();
        String email = eTemail.getText().toString().trim();

        if (name.isEmpty() || email.isEmpty()) {
            Toast.makeText(this, "Remplis le nom et l'email", Toast.LENGTH_SHORT).show();
            return;
        }

        // Toast facultatif
        Toast.makeText(this, "Nom: " + name + "\nEmail: " + email, Toast.LENGTH_LONG).show();

        // 1️)Crée l'Intent pour ouvrir la seconde activité
        Intent intent = new Intent(this, SecondActivity.class);

        // 2️) Passe les informations via l'Intent
        intent.putExtra(NAME, name);
        intent.putExtra(EMAIL, email);

        // 3️) Démarre la seconde activité
        startActivity(intent);
    }


}

