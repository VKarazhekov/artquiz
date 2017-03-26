package lolo.mitko.hacktues;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Mitko on 25.3.2017 г..
 */
public class QuizResult extends Activity{

    private Button backButton;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);

        backButton = (Button) findViewById(R.id.ButtonBack);
        textView = (TextView) findViewById(R.id.scoreView);

        textView.setText("Your score is: "+getIntent().getExtras().get("score"));

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });

    }
}
