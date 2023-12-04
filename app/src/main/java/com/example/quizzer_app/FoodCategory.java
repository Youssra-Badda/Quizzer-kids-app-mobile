package com.example.quizzer_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class FoodCategory extends AppCompatActivity {
    private ImageView imageView;
    private Button answerButton1, answerButton2, answerButton3, answerButton4;
    private String[][] answers = {
            {"Apple" ," Banana" ," Orange","Strawberries"},
            {"Apple" ," Banana" ," Mango","Grapes"},
            {"Apple" ," Grapes" ," Orange","Pear"},
            {"Kiwi" ," Mango" ," Orange","Strawberries"},
            {"Kiwi", "Grapes","Orange","Pear"},
            {"Kiwi", "Mango","Grapes","Strawberries"},
            {"Kiwi", "Mango","Grapes","Pear"},
            {"Kiwi", "Plum","Grapes","Pear"},
            {"Melon","Plum", "Grapes","Pear"},
            {"Grapes","Pear", "Melon","Plum"},
            {"Tomato", "Carrot","Radish","Potato"},
            {"Tomato", "Bell Pepper","Radish","Turnip"},
            {"Tomato", "Bell Pepper","Radish","Turnip"},
            {"Tomato", "Bell Pepper","Radish","Turnip"},
            {"Lettuce","Cucumber","Carrot","Snow Peas"},
            {"Lettuce","Potato","Carrot","Snow Peas"},
            {"Lettuce","Cucumber","Carrot","Snow Peas"},
            {"Lettuce","Potato","Eggplant","Snow Peas"},
            {"Lettuce","Potato","Eggplant","Cucumber"},
            {"Eggplant","Cucumber","Carrot","Snow Peas"}
    };
    private String[] correctanswers={
            "Apple" ," Banana" ," Orange","Strawberries","Kiwi",
            "Mango","Grapes","Pear","Melon","Plum","Tomato",
            "Bell Pepper","Radish","Turnip","Lettuce","Potato",
            "Carrot","Snow Peas","Eggplant","Cucumber"
    };
    private int currentQuestionIndex = 0;
    private int score = 0;
    // Change this to the total number of questions in your quiz
    private CountDownTimer countDownTimer;
    private long timeLeftInMillis = 60000;  // 60 seconds

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_category);
        answerButton1 = findViewById(R.id.reponse1);
        answerButton2 = findViewById(R.id.reponse2);
        answerButton3 = findViewById(R.id.reponse3);
        answerButton4 = findViewById(R.id.reponse4);

        updateQuestion();
        startTimer();
        answerButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(answerButton1.getText().toString().equals(correctanswers[currentQuestionIndex])){
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
        answerButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(answerButton2.getText().toString().equals(correctanswers[currentQuestionIndex])){
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
        answerButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(answerButton3.getText().toString().equals(correctanswers[currentQuestionIndex])){
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

        answerButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(answerButton4.getText().toString().equals(correctanswers[currentQuestionIndex])){
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
    private void updateQuestion() {

        int imageResourceId = getResources().getIdentifier("food" + (currentQuestionIndex + 1), "drawable", getPackageName());
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
        if(finalScore>10){
            result="Win";
        }else{
            result="field";
        }
        // Launch the ResultsActivity
        Intent intent = new Intent(FoodCategory.this, FinalActivity.class);
        intent.putExtra("CORRECT_ANSWERS", finalScore);
        intent.putExtra("WRING_ANSWERS", 20-finalScore);
        intent.putExtra("TIME_SPENT", timeSpentInSeconds);
        intent.putExtra("RESULT", result);
        startActivity(intent);
        finish();  // Optional, if you want to finish the current activity
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