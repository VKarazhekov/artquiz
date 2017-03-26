package lolo.mitko.hacktues;

import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by Mitko on 25.3.2017 г..
 */
public class PicturesQuestionsGame extends Activity{
    private Button btn_A, btn_B,btn_C,btn_D;
    private ArrayList<PictureQuizQuestion> questions = new ArrayList<PictureQuizQuestion>();
    private ImageView imageView = null;
    private TextView textView,scoreView,livesView ;
    private int score = 0;
    private int questionCounter = 0;
    private int lives = 3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.questions_game);
        imageView = (ImageView) findViewById(R.id.QuestionImage);
        textView = (TextView) findViewById(R.id.QuestionText);
        scoreView = (TextView) findViewById(R.id.livesView);
        livesView = (TextView) findViewById(R.id.livesView);
        AssetManager assetManager = getAssets();
        try {
            InputStream input = assetManager.open("PictureQuestions.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(input));
            String line;
            while((line=br.readLine())!=null){
                ArrayList<String> answers = new ArrayList<String>();
                String[] tokens = line.split(",");
                int resID = getResources().getIdentifier(tokens[1] , "drawable", getPackageName());

                for(int i=2;i<=5;i++){
                    answers.add(tokens[i]);
                }
                PictureQuizQuestion tmp = new PictureQuizQuestion(tokens[0],tokens[2],answers,resID);

                questions.add(tmp);

            }


        } catch (IOException e) {
            e.printStackTrace();
        }

        loadQuestion(questions.get(0));
        questionCounter++;

    }

    private void loadQuestion(PictureQuizQuestion question) {
        imageView.setImageResource(question.getImage_id());

        textView.setText(question.getQuestion_Text());

        btn_A = (Button) findViewById(R.id.button_A);
        btn_B = (Button) findViewById(R.id.button_B);
        btn_C = (Button) findViewById(R.id.button_C);
        btn_D = (Button) findViewById(R.id.button_D);

        ArrayList<String> answers = question.getAnswers();

        btn_A.setText(answers.get(0));
        btn_B.setText(answers.get(1));
        btn_C.setText(answers.get(2));
        btn_D.setText(answers.get(3));

        imageView.setImageResource(question.getImage_id());
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
    private void setLives(int lives_) {livesView.setText("Lives: "+lives_);}
}
