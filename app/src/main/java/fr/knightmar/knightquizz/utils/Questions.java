package fr.knightmar.knightquizz.utils;

import java.util.Random;

public enum Questions {
    QUESTION1("Quel bloc de minecraft ne subit pas la gravitée ?", "l'oeuf de dragon ? ", "l'eau", "la tnt", 3),
    QUESTION2("Quelle est la couleur (255,0,255) ?", "vert", "rouge", "violet", 3),
    QUESTION3("Comment s'appelle le patron d'Amazon ?", "Jeff Bezos", "Nick Anderson", "Teddy Rayan", 1),
    QUESTION4("Quel logiciel permet de faire de la modélisation 3D ?", "Paint 3D", "Blender", "NordVPN", 2),
    QUESTION5("Comment traduit-on une salade de pommes de terre en Allemand ? ", "Kartoffelsalat", "Salatheu deu pômheu dheu tèrrheu", "dies ist ein Osterei", 1),
    QUESTION6("Lequel est un langague de programmtion ?", "HTML", "NorskyChemist", "Assembleur", 3),
    QUESTION7("Quel composant d'un ordinateur stoque de l'information de courte duréee", "la RAM", "le processeur", "le disque dur", 1),
    QUESTION8("Qu'est ce que le bitcoin ? ", "une crypto monnaie", "un système de transfert de fichiers", "une fable de La Fontaine", 1),
    QUESTION9("Google est : ", "un navigateur", "un moteur de recherche", "une crypto monaie", 2),
    QUESTION10("quelle est la racine carré de 9", "-7", "3", "81", 2),
    QUESTION11("Lequel est une marque de téléphone ?", "Tesla", "Rhinoshield", "Xiaomi", 3);


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
