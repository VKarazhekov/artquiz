package lolo.mitko.hacktues;

import android.app.Activity;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by Mitko on 25.3.2017 г..
 */
public class Questions_game extends Activity{
    private Button
    private ArrayList<QuizQuestion> questions = new ArrayList<QuizQuestion>();
    private ImageView imageView = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.questions_game);
        imageView = (ImageView) findViewById(R.id.question_image);
        AssetManager assetManager = getAssets();
        try {
            InputStream input = assetManager.open("questions.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(input));

            String line;
            while((line=br.readLine())!=null){
                Log.d("123",line);
                String[] token = line.split(",");
                QuizQuestion tmp = new QuizQuestion(token[1],token[2],token[3],token[4],1);
                loadQuestions(tmp);
            }
            Log.d("123","passed");
        } catch (IOException e) {
            Log.d("123","nope");
            e.printStackTrace();
        }

    }

    private void loadQuestions(QuizQuestion question) {
        imageView.setImageResource(R.drawable.mona_lisa);

    }


}
