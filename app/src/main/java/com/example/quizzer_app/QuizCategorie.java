package com.example.quizzer_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class QuizCategorie extends AppCompatActivity {
    private Button animals;
    private Button fruit;
    private Button colors;
    private Button math;

    private Button school;
    private Button nature;

    private ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_ategorie);
        animals=findViewById(R.id.btnanimals);
        fruit=findViewById(R.id.btnfruit);
        colors=findViewById(R.id.btncolors);
        math=findViewById(R.id.btnmath);
        back=findViewById(R.id.back);
        school=findViewById(R.id.btnacc);
        nature=findViewById(R.id.btnNature);
        school.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent=new Intent(QuizCategorie.this,SchoolSupplies.class);
                startActivity(myintent);
                finish();
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent=new Intent(QuizCategorie.this,MainActivity.class);
                startActivity(myintent);
                finish();

            }
        });

        animals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myintent=new Intent(QuizCategorie.this,Animals.class);
                startActivity(myintent);
                animateButton(animals);
            }
        });
        fruit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myintent=new Intent(QuizCategorie.this,FoodCategory.class);
                startActivity(myintent);
                animateButton(fruit);
            }
        });
        colors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myintent=new Intent(QuizCategorie.this,ColorCategory.class);
                startActivity(myintent);
                animateButton(colors);
            }
        });
        math.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myintent=new Intent(QuizCategorie.this,QuizMath.class);
                startActivity(myintent);
                animateButton(math);
            }
        });
        nature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myintent=new Intent(QuizCategorie.this,Nature.class);
                startActivity(myintent);
                animateButton(nature);
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
