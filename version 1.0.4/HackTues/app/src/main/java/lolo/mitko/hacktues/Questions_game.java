package lolo.mitko.hacktues;

import android.app.Activity;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
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
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import java.util.Random;

/**
 * Created by Mitko on 25.3.2017 г..
 */
public class Questions_game extends Activity{
    private Button btn_A, btn_B,btn_C,btn_D;
    private ArrayList<QuizQuestion> questions = new ArrayList<QuizQuestion>();
    private ImageView imageView = null;
    private TextView textView,scoreView = null;
    private int score = 0;
    private ArrayList<String> answers = new ArrayList<String>();

    private String currectAnswer;

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
                String[] tokens = line.split(",");
                int resID = getResources().getIdentifier(tokens[1] , "drawable", getPackageName());
                currectAnswer = tokens[2];
                for(int i=2;i<=5;i++){
                    answers.add(tokens[i]);
                }
                QuizQuestion tmp = new QuizQuestion(tokens[0],tokens[2],tokens[3],tokens[4],tokens[5],resID);

               // questions.add(tmp);
                loadQuestion(tmp);
            }

           // Random r = new Random();
            //ArrayList<Integer> questionsAlreadyAsked = new ArrayList<>();
           // while(){

             //   questions.get(r.nextInt(questions.size()));
            //}

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void loadQuestion(QuizQuestion question) {
        imageView.setImageResource(question.getImage_id());

        textView.setText(question.getQuestionText());

        btn_A = (Button) findViewById(R.id.button_A);
        btn_B = (Button) findViewById(R.id.button_B);
        btn_C = (Button) findViewById(R.id.button_C);
        btn_D = (Button) findViewById(R.id.button_D);

        Collections.shuffle(answers);

        /// randomly set q- A,B,C,D to the buttons
        btn_A.setText(answers.get(0));
        btn_B.setText(answers.get(1));
        btn_C.setText(answers.get(2));
        btn_D.setText(answers.get(3));

        imageView.setImageResource(question.getImage_id());
        setScore(score);
        enable_buttons();
    }

    private void enable_buttons() {
        btn_A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkAswer(((Button) v).getText().toString())){
                    score ++;
                }else{
                    score--;
                }

                setScore(score);
            }
        });

        btn_B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkAswer(((Button) v).getText().toString())){
                    score ++;
                }else{
                    score --;
                }
                setScore(score);
            }
        });

        btn_C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkAswer(btn_B.getText().toString())){
                    score ++;
                }else{
                    score --;
                }
                setScore(score);
            }
        });

        btn_D.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkAswer(((Button) v).getText().toString())){
                    score ++;
                }else{
                    score --;
                }
                setScore(score);
            }
        });
    }

    private boolean checkAswer(String answer) {
        if(Objects.equals(answer, currectAnswer)){
            return true;
        }else{
            return false;
        }
    }


    private void setScore(int score_){
        scoreView.setText("Score: "+score_);
    }

}
