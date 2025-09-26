package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Récupère le nom envoyé depuis MainActivity
        Intent intent = getIntent();
        String name = intent.getStringExtra(MainActivity.NAME);

        // Affiche "Hello [nom]"
        TextView textView = findViewById(R.id.textHello);
        textView.setText("Hello " + name);

        // ImageView : juste pour afficher l'image
        ImageView imageView = findViewById(R.id.imageView);
        imageView.setImageResource(R.drawable.image); // ton image dans drawable

        // Bouton Next
        Button nextButton = findViewById(R.id.nextButton);
        nextButton.setOnClickListener(v -> {
                Intent thirdIntent = new Intent(this, ThirdActivity.class);
                startActivity(thirdIntent); // lance la ThirdActivity
        });
    }
}


