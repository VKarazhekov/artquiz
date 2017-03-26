package lolo.mitko.hacktues;

import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by Mitko on 26.3.2017 г..
 */

public class QuotesQuizQuestionsGame extends Activity {

    private Button btn_A, btn_B, btn_C, btn_D;
    private ArrayList<QuotesQuizQuestion> questions = new ArrayList<QuotesQuizQuestion>();
    private TextView textView, scoreView, livesView, quoteView;
    private int questionCounter = 0;
    private int score = 0;
    private int lives = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quote_game);
        quoteView = (TextView) findViewById(R.id.QuestionQuote);
        textView = (TextView) findViewById(R.id.QuestionText);
        scoreView = (TextView) findViewById(R.id.score);
        livesView = (TextView) findViewById(R.id.livesView);
        AssetManager assetManager = getAssets();

        try {
            InputStream input = assetManager.open("QuotesQuestions.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(input));
            String line;
            while ((line = br.readLine()) != null) {
                ArrayList<String> answers = new ArrayList<String>();
                String[] tokens = line.split(",");

                for (int i = 2; i <= 5; i++) {
                    answers.add(tokens[i]);
                }
                QuotesQuizQuestion tmp = new QuotesQuizQuestion(tokens[0],answers, tokens[1],tokens[2]);

                questions.add(tmp);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }


        loadQuestion(questions.get(0));
        questionCounter++;
    }

    private void loadQuestion(QuotesQuizQuestion question) {
        textView.setText(question.getQuestion_Text());
        quoteView.setText(question.getQuoteText());

        btn_A = (Button) findViewById(R.id.button_A);
        btn_B = (Button) findViewById(R.id.button_B);
        btn_C = (Button) findViewById(R.id.button_C);
        btn_D = (Button) findViewById(R.id.button_D);

        ArrayList<String> answers = question.getAnswers();

        btn_A.setText(answers.get(0));
        btn_B.setText(answers.get(1));
        btn_C.setText(answers.get(2));
        btn_D.setText(answers.get(3));

        setLives(lives);
        setScore(score);
        enable_buttons(question.getCorrectAnswers());

    }

    private void enable_buttons(final String currectAnswer) {
        btn_A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Objects.equals(((Button) v).getText().toString(), currectAnswer)){
                    score ++;
                }else{
                    lives--;
                }


                setScore(score);
                setLives(lives);
                checkCounter();
            }
        });

        btn_B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Objects.equals(((Button) v).getText().toString(), currectAnswer)){
                    score ++;
                }else{
                    lives--;
                }

                setScore(score);
                setLives(lives);
                checkCounter();

            }
        });

        btn_C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Objects.equals(((Button) v).getText().toString(), currectAnswer)) {
                    score++;
                }else{
                    lives--;
                }
                setScore(score);
                setLives(lives);
                checkCounter();

            }
        });

        btn_D.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Objects.equals(((Button) v).getText().toString(), currectAnswer)){
                    score ++;
                }else{
                    lives--;
                }
                setScore(score);
                setLives(lives);
                checkCounter();

            }
        });
    }

    private void checkCounter() {
        if(lives == 0 || questionCounter == 5 ){
            Intent i = new Intent(getApplicationContext(),QuizResult.class);
            i.putExtra("score",score);
            startActivity(i);

        }else{
            loadQuestion(questions.get(questionCounter));
            questionCounter++;
        }
    }



    private void setScore(int score_){
        scoreView.setText("Score: "+score_);
    }
    private void setLives(int lives_) {livesView.setText("Lives: "+lives_);
    }
}