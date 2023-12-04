package com.example.quizzer_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class SchoolSupplies extends AppCompatActivity {
    private ImageView imageView;
    private Button answerButton1, answerButton2, answerButton3, answerButton4;
    private String[][] answers = {
            {"Pencil","Eraser","Ruler" ,"Notebook"},
            {"Ruler", "Backpack", "Eraser", "Pencil case"},
            {"Pencil","Eraser","Ruler" ,"Notebook"},
            {"Ruler", "Backpack", "Notebook", "Pencil case"},
            {"Backpack","Pencil case","Art supplies","Ruler"},
            {"Backpack", "Art supplie", "Pencil case", "Eraser"},
            {"Notebook", "Art supplies", "Ruler", "Pencil"},
            {"Art supplies", "Notebook", "Pencil case", "Sharpener"},
            {"Calculator","Scissors", "Notebook", "Ruler"},
            {"Ruler", "Art supplies", "Calculator","Scissors"},
    };
    private String[] correctanswers={
            "Pencil","Eraser","Ruler" ,"Notebook","Backpack","Pencil case","Art supplies","Sharpener","Calculator","Scissors"
    };
    private int currentQuestionIndex = 0;
    private int score = 0;

    private CountDownTimer countDownTimer;
    private long timeLeftInMillis = 60000;  // 60 seconds

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school_supplies);
        answerButton1 = findViewById(R.id.reponse1);
        answerButton2 = findViewById(R.id.reponse2);
        answerButton3 = findViewById(R.id.reponse3);
        answerButton4 = findViewById(R.id.reponse4);

        updateQuestion();
        startTimer();
        answerButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(answerButton1.getText().toString()==correctanswers[currentQuestionIndex]){
                    score++;
                }
                currentQuestionIndex++;
                if (currentQuestionIndex < 10) {
                    updateQuestion();
                } else {
                    endQuiz();

                }
            }
        });
        answerButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(answerButton2.getText().toString()==correctanswers[currentQuestionIndex]){
                    score++;
                }
                currentQuestionIndex++;
                if (currentQuestionIndex < 10) {
                    updateQuestion();
                } else {
                    endQuiz();

                }
            }
        });
        answerButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(answerButton3.getText().toString()==correctanswers[currentQuestionIndex]){
                    score++;
                }
                currentQuestionIndex++;
                if (currentQuestionIndex < 10) {
                    updateQuestion();
                } else {
                    endQuiz();

                }
            }
        });

        answerButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(answerButton4.getText().toString()==correctanswers[currentQuestionIndex]){
                    score++;
                }
                currentQuestionIndex++;
                if (currentQuestionIndex < 10) {
                    updateQuestion();
                } else {
                    endQuiz();

                }
            }
        });






    }
    private void updateQuestion() {

        int imageResourceId = getResources().getIdentifier("elem" + (currentQuestionIndex + 1), "drawable", getPackageName());
        imageView=findViewById(R.id.questionImage);
        imageView.setImageResource(imageResourceId);
        answerButton1.setText(answers[currentQuestionIndex][0]);
        answerButton2.setText(answers[currentQuestionIndex][1]);
        answerButton3.setText(answers[currentQuestionIndex][2]);
        answerButton4.setText(answers[currentQuestionIndex][3]);
    }

    private void endQuiz() {
        // Quiz is complete, stop the timer
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }

        // Calculate the final score and time spent
        int finalScore = score;
        long timeSpentInSeconds = (60000 - timeLeftInMillis) / 1000;
        String result;
        if(finalScore>4){
            result="Win";
        }else{
            result="field";
        }
        // Launch the ResultsActivity
        Intent intent = new Intent(SchoolSupplies.this, FinalActivity.class);
        intent.putExtra("CORRECT_ANSWERS", finalScore);
        intent.putExtra("WRING_ANSWERS", 10-finalScore);
        intent.putExtra("TIME_SPENT", timeSpentInSeconds);
        intent.putExtra("RESULT", result);
        startActivity(intent);
        finish(); // Optional, if you want to finish the current activity
    }
    private void startTimer() {
        countDownTimer = new CountDownTimer(timeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMillis = millisUntilFinished;

            }

            @Override
            public void onFinish() {
                endQuiz();
            }
        }.start();
    }







}