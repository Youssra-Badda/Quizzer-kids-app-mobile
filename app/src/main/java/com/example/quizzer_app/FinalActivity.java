package com.example.quizzer_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class FinalActivity extends AppCompatActivity {
    private TextView score1;
    private TextView score2;
    private TextView temp;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);
        score1 = findViewById(R.id.score1);
        score2=findViewById(R.id.score2);

        temp = findViewById(R.id.time);
        result = findViewById(R.id.resulte);

        Intent intent = getIntent();
        int finalScore1 = intent.getIntExtra("CORRECT_ANSWERS", 0);
        int  finalScore2=intent.getIntExtra("WRING_ANSWERS",0);
        long timeSpent = intent.getLongExtra("TIME_SPENT", 0);
        String resultText = intent.getStringExtra("RESULT");

        // Convert int and long to String before setting them
        score1.setText(String.valueOf(finalScore1));
        score2.setText(String.valueOf(finalScore2));
        temp.setText(String.valueOf(timeSpent)+" secondes");
        result.setText(resultText);
    }
}
