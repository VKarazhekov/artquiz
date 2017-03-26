package lolo.mitko.hacktues;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Mitko on 26.3.2017 г..
 */
public class QuotesQuizQuestion {

    private String question_Text;
    private ArrayList<String> answers;
    private String QuoteText;
    private String correctAnswers;

    public QuotesQuizQuestion(String question_Text, ArrayList<String> answers, String quoteText, String correctAnswers) {
        this.question_Text = question_Text;
        this.answers = answers;
        this.QuoteText = quoteText;
        this.correctAnswers = correctAnswers;
    }

    public String getQuestion_Text() {
        return question_Text;
    }

    public ArrayList<String> getAnswers() {
        Collections.shuffle(answers);
        return answers;
    }

    public String getQuoteText() {
        return QuoteText;
    }

    public String getCorrectAnswers() {
        return correctAnswers;
    }
}
