package appm.ashad.quiz.quiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayout;

public class ChooseCatogeries extends AppCompatActivity {
    GridLayout grd;
    CardView cardViewofcomputer,cardViewofgadegts;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_catogeries);
        grd=findViewById(R.id.gridlayoutofmine);
        cardViewofcomputer=findViewById(R.id.computerquestion);
        cardViewofgadegts=findViewById(R.id.questionofgadegts);






    }
}
