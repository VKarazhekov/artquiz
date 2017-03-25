package lolo.mitko.hacktues;

/**
 * Created by Mitko on 25.3.2017 г..
 */

public class QuizQuestion {
    private String question_Text;
    private String[] answers;
    private int image_id;
    private String correctAnswers;

    public QuizQuestion(String question_Text,String currectAnswer,String[]answers, int image_id) {
        this.question_Text = question_Text;
        this.answers = answers;
        this.image_id = image_id;
    }

    public String getQuestionText(){
        return question_Text;
    }
    

    public String getCorrectAnswers() {
        return correctAnswers;
    }

    public int getImage_id() {
        return image_id;
    }
}
