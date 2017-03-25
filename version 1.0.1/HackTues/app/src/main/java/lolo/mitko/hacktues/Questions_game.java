package lolo.mitko.hacktues;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

/**
 * Created by Mitko on 25.3.2017 г..
 */
public class Questions_game extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.questions_game);
        ImageView imageView = (ImageView) findViewById(R.id.question_image);
    }
}
