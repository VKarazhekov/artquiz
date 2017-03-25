package lolo.mitko.hacktues;

import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Log;
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
    private ArrayList<QuizQuestion> questions = new ArrayList<QuizQuestion>();
    private ImageView imageView = null;
    private TextView textView,scoreView = null;
    private int score = 0;
    private int questionCounter = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.questions_game);
        imageView = (ImageView) findViewById(R.id.question_image);
        textView = (TextView) findViewById(R.id.question_text);
        scoreView = (TextView) findViewById(R.id.score);
        AssetManager assetManager = getAssets();
        try {
            InputStream input = assetManager.open("questions.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(input));
            String line;
            while((line=br.readLine())!=null){
                ArrayList<String> answers = new ArrayList<String>();
                Log.d("123",line);
                String[] tokens = line.split(",");
                int resID = getResources().getIdentifier(tokens[1] , "drawable", getPackageName());

                for(int i=2;i<=5;i++){
                    answers.add(tokens[i]);
                }
                QuizQuestion tmp = new QuizQuestion(tokens[0],tokens[2],answers,resID);

                questions.add(tmp);
                //answers.clear();

            }


        } catch (IOException e) {
            e.printStackTrace();
        }

        loadQuestion(questions.get(0));
        questionCounter++;

    }

    private void loadQuestion(QuizQuestion question) {
        imageView.setImageResource(question.getImage_id());

        textView.setText(question.getQuestion_Text());

        btn_A = (Button) findViewById(R.id.button_A);
        btn_B = (Button) findViewById(R.id.button_B);
        btn_C = (Button) findViewById(R.id.button_C);
        btn_D = (Button) findViewById(R.id.button_D);

        ArrayList<String> answers = question.getAnswers();

        /// randomly set q- A,B,C,D to the buttons
        btn_A.setText(answers.get(0));
        btn_B.setText(answers.get(1));
        btn_C.setText(answers.get(2));
        btn_D.setText(answers.get(3));

        imageView.setImageResource(question.getImage_id());
        setScore(score);
        enable_buttons(question.getCorrectAnswers());
    }

    private void enable_buttons(final String currectAnswer) {
        btn_A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Objects.equals(((Button) v).getText().toString(), currectAnswer)){
                    score ++;
                }

                setScore(score);

                checkCounter();
            }
        });

        btn_B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Objects.equals(((Button) v).getText().toString(), currectAnswer)){
                    score ++;
                }

                setScore(score);

                checkCounter();

            }
        });

        btn_C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Objects.equals(((Button) v).getText().toString(), currectAnswer)) {
                    score++;
                }
                setScore(score);

                checkCounter();

            }
        });

        btn_D.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Objects.equals(((Button) v).getText().toString(), currectAnswer)){
                    score ++;
                }
                setScore(score);

                checkCounter();

            }
        });
    }

    private void checkCounter() {
        if(score == 5 || questionCounter == 2 ){
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

}
