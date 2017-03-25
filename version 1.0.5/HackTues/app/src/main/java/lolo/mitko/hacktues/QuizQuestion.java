package lolo.mitko.hacktues;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Mitko on 25.3.2017 г..
 */

public class QuizQuestion {
    private String question_Text;
    private ArrayList<String> answers;
    private int image_id;
    private String correctAnswers;

    public QuizQuestion(String question_Text, String currectAnswer, ArrayList<String>answers, int image_id) {
        this.correctAnswers = currectAnswer;
        this.question_Text = question_Text;
        this.answers = answers;
        this.image_id = image_id;
    }

    public String getQuestion_Text() {
        return question_Text;
    }

    public ArrayList<String> getAnswers() {
        Collections.shuffle(answers);
        return answers;
    }

    public int getImage_id() {
        return image_id;
    }

    public String getCorrectAnswers() {
        return correctAnswers;
    }
}
