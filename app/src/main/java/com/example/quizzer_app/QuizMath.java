package com.example.quizzer_app;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuizMath extends AppCompatActivity {

    private List<Question> questions;
    private int currentQuestion = 0;
    private int correctAnswers = 0;
    private ImageView questionTextView;
    private TextView  answer1TextView, answer2TextView, answer3TextView, answer4TextView;

    private ImageView back;
    private CountDownTimer countDownTimer;
    private long timeLeftInMillis = 60000;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_math);

        // Initialisez vos questions ici
        initializeQuestions();

        // Initialisez les vues
        questionTextView = findViewById(R.id.Question);
        answer1TextView = findViewById(R.id.answer1);
        answer2TextView = findViewById(R.id.answer2);
        answer3TextView = findViewById(R.id.answer3);
        answer4TextView = findViewById(R.id.answer4);
        back=findViewById(R.id.back);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent=new Intent(QuizMath.this,QuizCategorie.class);
                startActivity(myintent);
                finish();

            }
        });
        // Affichez la première question
        showQuestion(currentQuestion);



    }
    private void initializeQuestions() {
        questions = new ArrayList<>();

        // Question 1
        List<String> answers1 = Arrays.asList("9", "3", "10", "12");
        Question question1 = new Question("qst1", answers1, 0);
        questions.add(question1);

        // Question 2
        List<String> answers2 = Arrays.asList("carrot: 5 ,Eggplant: 4 ,Beans: 1 ", "carrot: 6 ,Eggplant: 4 ,Beans: 3 ", "carrot: 7 ,Eggplant: 8 ,Beans: 1", "carrot: 3 ,Eggplant: 4 ,Beans: 7 ");
        Question question2 = new Question("qst2", answers2, 1);
        questions.add(question2);

        // Question 3
        List<String> answers3 = Arrays.asList("10 , 12 , 8", "3 , 6 , 4", "1 , 5 , 8", "12 , 3 , 8 , 9");
        Question question3 = new Question("qst3", answers3, 1);
        questions.add(question3);

        // Question 4
        List<String> answers4 = Arrays.asList("10 ", "3", "1 ", "6");
        Question question4 = new Question("qst4", answers4, 3);
        questions.add(question4);

        // Question 5
        List<String> answers5 = Arrays.asList("14", "4", "8", "12");
        Question question5 = new Question("qst5", answers5, 0);
        questions.add(question5);

        // Question 6
        List<String> answers6 = Arrays.asList("10", "11", "1", "12 ");
        Question question6 = new Question("qst6", answers6, 1);
        questions.add(question6);

        // Question 7
        List<String> answers7 = Arrays.asList("6", "16", "26", "36");
        Question question7 = new Question("qst7", answers7, 0);
        questions.add(question7);

        // Question 8
        List<String> answers8 = Arrays.asList("12", "8", "5", "10");
        Question question8 = new Question("qst8", answers8, 3);
        questions.add(question8);

        // Question 9
        List<String> answers9 = Arrays.asList("11", "7", "6", "9");
        Question question9 = new Question("qst9", answers9, 2);
        questions.add(question9);

        // Question 10
        List<String> answers10 = Arrays.asList("1 , 4 , 7 , 8", "7 , 3 , 6", "2 , 3 , 5 , 6", "9 , 8 , 9 , 1");
        Question question10 = new Question("qst10", answers10, 0);
        questions.add(question10);

        // Question 11
        List<String> answers11 = Arrays.asList("4 , 6 , 8 , 9", "1 , 4 , 6 , 1 ", "2 , 5 , 6 , 9", "9 , 10 , 11 , 12");
        Question question11 = new Question("qst11", answers11, 2);
        questions.add(question11);
    }

    // Fonction de gestionnaire de clic pour les réponses
    public void onAnswerClick(View view) {
        TextView selectedAnswer = (TextView) view;

        // Vérifiez si la réponse est correcte
        if (isCorrectAnswer(selectedAnswer.getText().toString())) {
            correctAnswers++;
        }

        // Passez à la question suivante
        currentQuestion++;

        // Vérifiez si toutes les questions ont été répondues
        if (currentQuestion < questions.size()) {
            // Affichez la question suivante
            showQuestion(currentQuestion);
        } else {
            // Affichez le score final
            showFinalScore();
        }
    }

    // Affiche la question actuelle
    private void showQuestion(int questionIndex) {
        Question currentQuestion = questions.get(questionIndex);

        // Affichez la question
        String imageName=currentQuestion.getQuestionText();
        int resId = getResources().getIdentifier(imageName, "drawable", getPackageName());
        questionTextView.setImageResource(resId);
        // Affichez les réponses
        List<String> answers = currentQuestion.getAnswers();
        answer1TextView.setText(answers.get(0));
        answer2TextView.setText(answers.get(1));
        answer3TextView.setText(answers.get(2));
        answer4TextView.setText(answers.get(3));
    }

    // Affiche le score final
    private void showFinalScore() {
        Intent finalescore=new Intent(QuizMath.this,FinaleScore.class);
        long timeSpentInSeconds = (60000 - timeLeftInMillis) / 1000;
        finalescore.putExtra("TIME_SPENT", timeSpentInSeconds);
        finalescore.putExtra("CORRECT_ANSWERS", correctAnswers);
        finalescore.putExtra("WRING_ANSWERS", 20-correctAnswers);


        finalescore.putExtra("quetions",questions.size());
        startActivity(finalescore);


    }

    // Vérifie si la réponse est correcte
    private boolean isCorrectAnswer(String answer) {
        Question currentQuestion = questions.get(this.currentQuestion);
        int correctAnswerIndex = currentQuestion.getCorrectAnswerIndex();

        // Comparez la réponse avec l'index de la réponse correcte
        return answer.equals(currentQuestion.getAnswers().get(correctAnswerIndex));
    }

    private void startTimer() {
        countDownTimer = new CountDownTimer(timeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMillis = millisUntilFinished;

            }

            @Override
            public void onFinish() {
                showFinalScore();
            }
        }.start();
    }

}


////////////



