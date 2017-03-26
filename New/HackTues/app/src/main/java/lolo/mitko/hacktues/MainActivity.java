package lolo.mitko.hacktues;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnPictures,btnQuotes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        enable_buttons();

    }

    private void enable_buttons() {
        btnPictures = (Button) findViewById(R.id.buttonPictures);
        btnQuotes = (Button) findViewById(R.id.buttonQuotes);

        btnPictures.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),PicturesQuestionsGame.class);
                startActivity(i);
            }
        });

        btnQuotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),QuotesQuizQuestionsGame.class);
                startActivity(i);
            }
        });

    }
}
