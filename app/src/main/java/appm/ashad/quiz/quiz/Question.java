package appm.ashad.quiz.quiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;

public class Question extends AppCompatActivity {
    TextView question,score,noofquest,timee;
    RadioButton radioButton1,radioButton2,radioButton3,radioButton4;
    Button button;
    ProgressBar progressBar;
    int i=0;
    String array,option1,option2,option3,writeanswerarray;

    ArrayList ar=new ArrayList(Arrays.asList(array));
    ArrayList optionone=new ArrayList(Arrays.asList(option1));
    ArrayList optiontwo=new ArrayList(Arrays.asList(option2));
    ArrayList optionthree=new ArrayList(Arrays.asList(option3));
    ArrayList writeanswer=new ArrayList(Arrays.asList(writeanswerarray));





    String myurl="https://opentdb.com/api.php?amount=10&category=18&difficulty=easy&type=multiple";
    //https://opentdb.com/api.php?amount=10&category=18&difficulty=easy&type=multiple


    @Override
    protected void onStart() {
        super.onStart();
        askquestion();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        question=findViewById(R.id.question);
        radioButton1=findViewById(R.id.radioButton1);
        radioButton2=findViewById(R.id.radioButton2);
        radioButton3=findViewById(R.id.radioButton3);
        radioButton4=findViewById(R.id.radioButton4);
        button=findViewById(R.id.button);
        score=findViewById(R.id.score);
        noofquest=findViewById(R.id.noofquestion);
        timee=findViewById(R.id.time);
        progressBar=findViewById(R.id.progressBar2);
        Log.i("arrayfromoutside","is"+ar);
        Log.i("arrayfromoutside","is"+optionone);
        Log.i("arrayfromoutside","is"+optiontwo);
        Log.i("arrayfromoutside","is"+optionthree);
        Log.i("arrayfromoutside","is"+writeanswer);
        // answerList = new ArrayList<Answer>();


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("onclick","clicked");
                showquestion();

            }
        });



    }
    public void showprogressbar()
    {
        Log.i("progre","showing");
        progressBar.setVisibility(View.VISIBLE);
        question.setVisibility(View.INVISIBLE);
        radioButton1.setVisibility(View.INVISIBLE);
        radioButton2.setVisibility(View.INVISIBLE);
        radioButton3.setVisibility(View.INVISIBLE);
        radioButton4.setVisibility(View.INVISIBLE);
        button.setVisibility(View.INVISIBLE);
        score.setVisibility(View.INVISIBLE);
        noofquest.setVisibility(View.INVISIBLE);
        timee.setVisibility(View.INVISIBLE);

    }
    public void hideprogresbar()
    {
        Log.i("progre","hiding");
        progressBar.setVisibility(View.INVISIBLE);
        question.setVisibility(View.VISIBLE);
        radioButton1.setVisibility(View.VISIBLE);
        radioButton2.setVisibility(View.VISIBLE);
        radioButton3.setVisibility(View.VISIBLE);
        radioButton4.setVisibility(View.VISIBLE);
        button.setVisibility(View.VISIBLE);
        score.setVisibility(View.VISIBLE);
        noofquest.setVisibility(View.VISIBLE);
        timee.setVisibility(View.VISIBLE);

    }
    public void addquestion(String s)
    {

    }


    public void showquestion()
    {

        question.setText(ar.get(0).toString());
    }
    public void nextquestion()
    {



    }
    public void askquestion()
    {
        showprogressbar();

        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.GET, myurl, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.i("response","is "+response);
                try {
                    String responsecode=response.getString("response_code");
                    Log.i("respose code ","is "+responsecode);
                    if(responsecode.equals("0"))
                    {
                        hideprogresbar();
                        //proceed


                        JSONArray array=response.getJSONArray("results");
                        Log.i("array","is"+array);
                        for (int i=0;i<array.length();i++)
                        {
                            JSONObject questions=array.getJSONObject(i);
                            Log.i("question1","is "+questions);

                            String hereyourquestion=questions.getString("question");
                            Log.i("here is","your quesstion"+hereyourquestion);
                            addquestion(hereyourquestion);
                            ar.add(i,hereyourquestion);
                            Log.i("ar","is "+ar);
                            String hereyourcorrectanswer=questions.getString("correct_answer");
                            writeanswer.add(i,hereyourcorrectanswer);
                            JSONArray arrayofanswer=questions.getJSONArray("incorrect_answers");
                            Log.i("json array","of inccorrect answer"+arrayofanswer);
                            for (int j=0;j<arrayofanswer.length();j++)
                            {
                                JSONObject nw=arrayofanswer.getJSONObject(j);
                                String incorectanswerfirst=nw.getString("0");
                                optionone.add(j,incorectanswerfirst);
                                String incorrectanswersecond=nw.getString("1");
                                optiontwo.add(j,incorrectanswersecond);
                                String incorrectanswerthird=nw.getString("2");
                                optionthree.add(j,incorrectanswerthird);



                            }









                        }
                        radioButton2.setText("asssadasd");

//                        while(i<=array.length())
//                        {
//                            JSONObject question1=array.getJSONObject(i);
////                            Log.i("question1","is "+question1);
//                            String hereyourquestion=question1.get("question").toString();
//                            i++;
////                            Log.i("arrary","of "+arrayofquesstion);
//
//                        }








                    }

                    else
                    {

                        Toast.makeText(getApplicationContext(),"SOMETHING WENTS WRONG",Toast.LENGTH_SHORT).show();
                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        mysingleton.getInstance(getApplicationContext()).addToRequestque(jsonObjectRequest);
    }

}
