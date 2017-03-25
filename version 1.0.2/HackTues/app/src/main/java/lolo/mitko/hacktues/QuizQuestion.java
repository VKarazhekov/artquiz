package lolo.mitko.hacktues;

import android.widget.ImageView;

/**
 * Created by Mitko on 25.3.2017 г..
 */

public class QuizQuestion {
    private String answer_A;
    private String answer_B;
    private String answer_C;
    private String answer_D;
    private int image_id;

    public QuizQuestion(String answer_A, String answer_B, String answer_C, String answer_D, int image_id) {
        this.answer_A = answer_A;
        this.answer_B = answer_B;
        this.answer_C = answer_C;
        this.answer_D = answer_D;
        this.image_id = image_id;
    }

    public String getAnswer_A() {
        return answer_A;
    }

    public String getAnswer_B() {
        return answer_B;
    }

    public String getAnswer_C() {
        return answer_C;
    }

    public String getAnswer_D() {
        return answer_D;
    }

    public int getImage_id() {
        return image_id;
    }
}
