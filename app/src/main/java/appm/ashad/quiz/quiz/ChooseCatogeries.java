package appm.ashad.quiz.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayout;
import android.view.View;

public class ChooseCatogeries extends AppCompatActivity {

    GridLayout grd;
    CardView cardViewofcomputer,cardViewofgadegts;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_catogeries);

        grd = findViewById(R.id.gridlayoutofmine);
        cardViewofcomputer = findViewById(R.id.computerquestion);
        cardViewofgadegts = findViewById(R.id.questionofgadegts);

        cardViewofcomputer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),highscore.class);
                startActivity(i);
            }
        });





    }
}
