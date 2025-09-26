
package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        // Bouton Previous pour revenir en arrière
        Button previousButton = findViewById(R.id.previousButton);
        previousButton.setOnClickListener(v -> finish()); // finish() ferme cette activité et revient à la précédente
    }
}
