package com.example.quizzer_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Animals extends AppCompatActivity {
   Button btn1;
    Button btn2 ;
    Button btn3 ;
    Button btn4;
    ImageView imageView;
    private final String[][] answers = {
            {   "zebra", "Hedgehog", "Koala", "rabbit"},
            {"elephant", "giraffe", "Hedgehog", "rabbit"},
            {"hen", "snake", "fish", "Koala"},
            {"horse", "frog","elephant","giraffe"},
            {"panda", "dog", "mouse", "bird"},
            {"crocodile","turtle", "sheep", "hen"},
            {"frog", "panda", "rabbit", "bird"},
            {"sheep", "fish", "elephant","frog"},
            {"mouse", "turtle","giraffe","unicorn"},
            {"snake","horse", "crocodile","Hedgehog"},
            //************
            {   "turtle", "Hedgehog", "Koala", "rabbit"},
            {"elephant", "parrot", "Hedgehog", "rabbit"},
            {"hen", "panda", "unicorn", "bird"},
            {"sheep", "frog","elephant","giraffe"},
            {"panda", "fish", "horse", "bird"},
            {"crocodile","dog", "fish", "elephant"},
            {"hen", "mousse", "rabbit", "bird"},
            {"sheep", "fish", "hen","crocodile"},
            {"mouse", "turtle","parrot","elephant"},
            {"snake","giraffe", "crocodile","unicorn"}};
    private String[] correctanswers={
            "zebra", "Hedgehog", "snake", "horse", "dog",
            "hen", "frog", "elephant", "giraffe",
            "Hedgehog","Koala","rabbit","bird","sheep","panda",
            "fish","mousse","crocodile","turtle","unicorn"
    };
    private int currentQuestionIndex = 0;
    private int score = 0;

    private CountDownTimer countDownTimer;
    private long timeLeftInMillis = 300000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animals);
        btn1 = findViewById(R.id.choice1);
        btn2 = findViewById(R.id.choice2);
        btn3 = findViewById(R.id.choice3);
        btn4= findViewById(R.id.choice4);
        imageView = findViewById(R.id.animal);
          updateQuestion();
        startTimer();
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(btn1.getText().toString().equals(correctanswers[currentQuestionIndex])){
                    score++;
                }
                currentQuestionIndex++;
                if (currentQuestionIndex < 20) {
                    updateQuestion();
                } else {
                    endQuiz();

                }
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn2.getText().toString().equals(correctanswers[currentQuestionIndex])){
                    score++;
                }
                currentQuestionIndex++;
                if (currentQuestionIndex < 20) {
                    updateQuestion();
                } else {
                    endQuiz();

                }
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(btn3.getText().toString().equals(correctanswers[currentQuestionIndex])){
                    score++;
                }
                currentQuestionIndex++;
                if (currentQuestionIndex < 20) {
                    updateQuestion();
                } else {
                    endQuiz();

                }
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(btn4.getText().toString().equals(correctanswers[currentQuestionIndex])){
                    score++;
                }
                currentQuestionIndex++;
                if (currentQuestionIndex < 20) {
                    updateQuestion();
                } else {
                    endQuiz();

                }
            }
        });






    }






    void updateQuestion() {

        int imageResourceId = getResources().getIdentifier("animal" + (currentQuestionIndex + 1), "drawable", getPackageName());
        imageView.setImageResource(imageResourceId);
        btn1.setText(answers[currentQuestionIndex][0]);
        btn2.setText(answers[currentQuestionIndex][1]);
        btn3.setText(answers[currentQuestionIndex][2]);
        btn4.setText(answers[currentQuestionIndex][3]);
    }

    private void endQuiz() {
        // Quiz is complete, stop the timer
      if (countDownTimer != null) {
          countDownTimer.cancel();
        }

        // Calculate the final score and time spent
        int finalScore = score;
        long timeSpentInSeconds = (300000 - timeLeftInMillis) / 60000;
        String result;
        if(finalScore>10){
            result="Win";
        }else{
            result="field";
        }
        // Launch the ResultsActivity
        Intent intent = new Intent(Animals.this, ResultActivity.class);
        intent.putExtra("CORRECT_ANSWERS", finalScore);
        intent.putExtra("WRING_ANSWERS", 20-finalScore);
        intent.putExtra("TIME_SPENT", timeSpentInSeconds);
        intent.putExtra("result", result);
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
}}