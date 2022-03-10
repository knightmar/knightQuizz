package fr.knightmar.knightquizz;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import fr.knightmar.knightquizz.utils.Questions;

public class GameActivity extends AppCompatActivity {
    protected TextView questionText;
    protected Button answer1Btn;
    protected Button answer2Btn;
    protected Button answer3Btn;
    Questions question;
    private Boolean isCorrect = null;
    private int score;
    private int nbQuestion = 1;
    private ArrayList<Integer> questionsToExcludes = new ArrayList<Integer>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        questionText = findViewById(R.id.question);
        answer1Btn = findViewById(R.id.answer1Btn);
        answer2Btn = findViewById(R.id.answer2Btn);
        answer3Btn = findViewById(R.id.answer3Btn);

        question = showQuestion();

        answer1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isCorrect = testAnswer(answer1Btn);
                if (isCorrect) {
                    if (nbQuestion < 9) {
                        question = showQuestion();
                        nbQuestion = nbQuestion + 1;
                        score = score + 10;
                    } else System.exit(0);
                    sendAToast(view.getContext(), "Bonne réponse, vous avez " + score + "points");
                } else {
                    if (nbQuestion < 9) {
                        question = showQuestion();
                        nbQuestion = nbQuestion + 1;
                        score = score - 10;
                    } else System.exit(0);
                    sendAToast(view.getContext(), "Dommage, vous avez " + score + "points");
                }
            }
        });

        answer2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isCorrect = testAnswer(answer2Btn);
                if (isCorrect) {
                    if (nbQuestion < 9) {
                        question = showQuestion();
                        nbQuestion = nbQuestion + 1;
                        score = score + 10;
                    } else System.exit(0);
                    sendAToast(view.getContext(), "Bonne réponse, vous avez " + score + "points");
                } else {
                    if (nbQuestion < 9) {
                        question = showQuestion();
                        nbQuestion = nbQuestion + 1;
                        score = score - 10;
                    } else System.exit(0);
                    sendAToast(view.getContext(), "Dommage, vous avez " + score + "points");
                }
            }

        });


        answer3Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isCorrect = testAnswer(answer3Btn);
                if (isCorrect) {
                    if (nbQuestion < 9) {
                        question = showQuestion();
                        nbQuestion = nbQuestion + 1;
                        score = score + 10;
                    } else System.exit(0);
                    sendAToast(view.getContext(), "Bonne réponse, vous avez " + score + "points");
                } else {
                    if (nbQuestion < 9) {
                        question = showQuestion();
                        nbQuestion = nbQuestion + 1;
                        score = score - 10;
                    } else System.exit(0);
                    sendAToast(view.getContext(), "Dommage, vous avez " + score + "points");
                }
            }
        });

    }

    private Questions showQuestion() {
        boolean questionIsOk = false;
        while (!questionIsOk){
            question = Questions.random();
            if (!isAlreadyChoose(question))
                questionIsOk = true;
        }
        questionsToExcludes.add(question.getId());
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

    private void sendAToast(Context context, String text) {
        Toast.makeText(context, text, Toast.LENGTH_LONG).show();
    }

    private boolean isAlreadyChoose(Questions questionToCheck) {
        System.out.println("is already choose fonction");
        for (int i = 0; i < questionsToExcludes.size(); i++) {
            if (questionToCheck.getId() == questionsToExcludes.get(i)) {
                System.out.println("the question is already choose " +questionToCheck.getId());
                return true;
            }
        }
        return false;
    }
}