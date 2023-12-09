package com.example.quizzer_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ResultActivity extends AppCompatActivity {
    Button result, score, time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        result = findViewById(R.id.result);
        score = findViewById(R.id.score);
        time = findViewById(R.id.time);
        Intent i = getIntent();
        String resultValue= i.getStringExtra("result");
        int scoreValue= i.getIntExtra("CORRECT_ANSWERS",0);
       Long timeValue= i.getLongExtra("TIME_SPENT",0);


        result.setText("you "+resultValue);
        score.setText(scoreValue +"correct ansawrs");
        time.setText("you passed "+timeValue+" min");
        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}