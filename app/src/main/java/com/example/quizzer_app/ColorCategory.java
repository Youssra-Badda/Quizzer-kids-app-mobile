package com.example.quizzer_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ColorCategory extends AppCompatActivity {
    private ImageView imageView;
    private Button answerButton1, answerButton2, answerButton3, answerButton4;
    private String[][] answers = {
            {"Red", "Blue", "Green", "Yellow"},
            {"Blue", "Green", "Gold", "Orange"},
            {"Blue", "Green", "red", "pink"},
            {"Red", "Yellow", "Green", "Blue"},
            {"Blue", "Green", "Gold", "Orange"},
            {"Blue", "Purple", "Gold", "Orange"},
            {"Blue", "Beige", "Brown", "Orange"},
            {"Blue", "Gray", "Brown", "Orange"},
            {"Blue", "Gray", "Black", "Orange"},
            {"Gold", "Gray", "Black", "Orange"},
            {"Turquoise", "Blue", "Black", "Orange"},
            {"Gold", "Navy blue", "Turquoise", "Blue"}
    };
    private String[] correctanswers={
            "Red", "Green", "Pink", "Yellow", "Orange",
            "Purple", "Brown", "Gray", "Black",
           "Gold", "Blue"
    };
    private int currentQuestionIndex = 0;
    private int score = 0;

    private CountDownTimer countDownTimer;
    private long timeLeftInMillis = 60000;  // 60 seconds

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);
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

        int imageResourceId = getResources().getIdentifier("image" + (currentQuestionIndex + 1), "drawable", getPackageName());
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
        if(finalScore>5){
            result="Win";
        }else{
            result="field";
        }
        // Launch the ResultsActivity
        Intent intent = new Intent(ColorCategory.this, FinalActivity.class);
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