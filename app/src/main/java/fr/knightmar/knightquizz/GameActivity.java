package fr.knightmar.knightquizz;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import fr.knightmar.knightquizz.utils.Questions;

public class GameActivity extends AppCompatActivity {
    protected TextView questionText;
    protected Button answer1Btn;
    protected Button answer2Btn;
    protected Button answer3Btn;
    Questions question;
    private Boolean isCorrect = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        questionText = findViewById(R.id.question);
        answer1Btn = findViewById(R.id.answer1Btn);
        answer2Btn = findViewById(R.id.answer2Btn);
        answer3Btn = findViewById(R.id.answer3Btn);

        int nbQuestion = 0;
        question = showQuestion();

        answer1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isCorrect = testAnswer(answer1Btn);
                if (isCorrect) {
                    System.out.println("knightmarApp : correct answer");
                } else {
                    System.out.println("knightmarApp : not correct answer");
                }
            }
        });

        answer2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isCorrect = testAnswer(answer2Btn);
                if (isCorrect) {
                    System.out.println("knightmarApp : correct answer");
                } else {
                    System.out.println("knightmarApp : not correct answer");
                }
            }
        });

        answer3Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isCorrect = testAnswer(answer3Btn);
                if (isCorrect) {
                    System.out.println("knightmarApp : correct answer");
                } else {
                    System.out.println("knightmarApp : not correct answer");
                }
            }
        });

    }

    private Questions showQuestion() {
        Questions question = Questions.random();
        questionText.setText(question.getQuestion());
        answer1Btn.setText(question.getAnswer1());
        answer2Btn.setText(question.getAnswer2());
        answer3Btn.setText(question.getAnswer3());
        return question;
    }

    private boolean testAnswer(Button answerButton) {
        if (question != null)
            return answerButton.getText() == question.getCorrectAnswer();
        else
            return false;
    }
}