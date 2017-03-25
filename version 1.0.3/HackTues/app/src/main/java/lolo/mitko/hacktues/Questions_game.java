package lolo.mitko.hacktues;

import android.app.Activity;
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
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by Mitko on 25.3.2017 г..
 */
public class Questions_game extends Activity{
    private List<Button> buttons[] = new List<Button>[];
    private ArrayList<QuizQuestion> questions = new ArrayList<QuizQuestion>();
    private ImageView imageView = null;
    private TextView textView,scoreView = null;
    private int score = 0;
    private String[] tokens = null;

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
                 tokens = line.split(",");
                int resID = getResources().getIdentifier(tokens[1] , "drawable", getPackageName());
                QuizQuestion tmp = new QuizQuestion(tokens[0],tokens[2],tokens[3],tokens[4],tokens[5],resID);
                questions.add(tmp);
             //   loadQuestion(tmp);
            }

            Random r = new Random();
            ArrayList<Integer> questionsAlreadyAsked = new ArrayList<>();
            while(){
                questions.get(r.nextInt(questions.size()));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void loadQuestion(QuizQuestion question) {
        imageView.setImageResource(question.getImage_id());

        textView.setText(question.getQuestionText());

        buttons[0].add((Button) findViewById(R.id.button_A));
        buttons[1].add((Button) findViewById(R.id.button_B));
        buttons[2].add((Button) findViewById(R.id.button_C));
        buttons[3].add((Button) findViewById(R.id.button_D));

        

        /// randomly set q- A,B,C,D to the buttons
        btn_A.setText(question.getAnswer_A());
        btn_B.setText(question.getAnswer_B());
        btn_C.setText(question.getAnswer_C());
        btn_D.setText(question.getAnswer_D());

        imageView.setImageResource(question.getImage_id());
        setScore(score);
        enable_buttons();
    }

    private void enable_buttons() {
        btn_A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score ++;

                setScore(score);
            }
        });

        btn_B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btn_C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btn_D.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }


    private void setScore(int score_){
        scoreView.setText("Score: "+score_);
    }

}
