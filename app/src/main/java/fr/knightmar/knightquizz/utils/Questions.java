package fr.knightmar.knightquizz.utils;

import java.util.Random;

public enum Questions {
    QUESTION1("question 1", "réponse 1", "réponse 2", "réponse 3", 2),
    QUESTION2("question 2", "réponse 1", "réponse 2", "réponse 3", 1),
    QUESTION3("question 3", "réponse 1", "réponse 2", "réponse 3", 3);


    private final String question;
    private final String answer1;
    private final String answer2;
    private final String answer3;
    private final int correctAnswer;

    Questions(String question, String answer1, String answer2, String answer3, int correctAnswer) {
        this.question = question;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.correctAnswer = correctAnswer;
    }

    // get an array of all the cards
    private static final Questions[] questions = Questions.values();
    // this generates random numbers
    private static final Random random = new Random();

    // choose a card at random
    public static Questions random() {
        return questions[random.nextInt(questions.length)];
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer1() {
        return answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public String getCorrectAnswer() {
        switch (correctAnswer) {
            case 1:
                return this.answer1;
            case 2:
                return this.answer2;
            case 3:
                return this.answer3;
            default:
                return "Error";
        }
    }
}
