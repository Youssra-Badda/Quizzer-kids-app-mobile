package com.example.quizzer_app;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class FinaleScore extends AppCompatActivity {
   private TextView resultfinale;
   private TextView spentTime;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.finale_score);
        resultfinale= findViewById(R.id.result);
        spentTime=findViewById(R.id.time);
        int score=getIntent().getExtras().getInt("scorefinale");
        int questionSize=getIntent().getExtras().getInt("quetions");
        int TIME_SPENT=getIntent().getExtras().getInt("TIME_SPENT");

        resultfinale.setText(score+"/"+questionSize);
        spentTime.setText("le temp passe : "+TIME_SPENT);

    }
}
