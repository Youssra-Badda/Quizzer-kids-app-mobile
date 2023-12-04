package com.example.quizzer_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
     private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=findViewById(R.id.btnplay);
        Animation fadeIn = AnimationUtils.loadAnimation(this,R.anim.fade_in);
        btn.startAnimation(fadeIn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myintent=new Intent(MainActivity.this,QuizCategorie.class);
                startActivity(myintent);
                animateButton(btn);
            }
        });

    }
    private void animateButton(Button button) {
        // Animation de zoom
        Animation animation = new ScaleAnimation(1.0f, 1.2f, 1.0f, 1.2f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        animation.setDuration(300); // Durée de l'animation en millisecondes
        animation.setFillAfter(false); // Maintenir l'état après l'animation (false pour revenir à l'état d'origine)

        // Appliquer l'animation au bouton
        button.startAnimation(animation);
    }
}