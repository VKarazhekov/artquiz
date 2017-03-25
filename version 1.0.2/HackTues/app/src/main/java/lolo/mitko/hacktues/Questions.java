package lolo.mitko.hacktues;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Mitko on 25.3.2017 г..
 */
public class Questions extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.questions);

        enable_butons();
    }

    private void enable_butons() {
        Button butn = (Button) findViewById(R.id.button_easy);
        butn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),Questions_game.class);
                startActivity(i);
            }
        });
    }
}
