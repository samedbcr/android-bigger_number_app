package com.example.biggernumberapp;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    private Button btnLeft;
    private Button btnRight;
    private TextView txtScore;
    private int score = 0;
    private int random1;
    private int random2;
    private ScrollView scrollView;

    public class LeftButton implements View.OnClickListener {

        public void onClick(View v){

            if(random1 >= random2){
                score++;
                txtScore.setText(String.format("Score: %d",score));
                txtScore.setTextColor(Color.parseColor("#05910B"));
                setRandomNumbers();
            }else {
                score--;
                txtScore.setText(String.format("Score: %d", score));
                txtScore.setTextColor(Color.parseColor("#BC0303"));
                setRandomNumbers();
            }
        }
    }

    public class RightButton implements View.OnClickListener {

        public void onClick(View v){

            if(random2 >= random1){
                score++;
                txtScore.setText(String.format("Score: %d",score));
                txtScore.setTextColor(Color.parseColor("#05910B"));
                setRandomNumbers();
            }else {
                score--;
                txtScore.setText(String.format("Score: %d", score));
                txtScore.setTextColor(Color.parseColor("#BC0303"));
                setRandomNumbers();
            }
        }
    }

    private void setRandomNumbers(){

        Random random = new Random();
        random1 = random.nextInt(30);
        random2 = random.nextInt(30);
        if(random1 == random2){
            random1 = random.nextInt(30);
            random2 = random.nextInt(30);

        }else {
            btnLeft.setText(Integer.toString(random1));
            btnRight.setText(Integer.toString(random2));
        }


    }

    private void init(){
        scrollView = new ScrollView(this);
        btnLeft = (Button) findViewById(R.id.btnLeft);
        btnRight = (Button) findViewById(R.id.btnRight);
        txtScore = (TextView) findViewById(R.id.txtScore);
        setRandomNumbers();

        RightButton rb = new RightButton();
        LeftButton lb = new LeftButton();

        btnLeft.setOnClickListener(lb);
        btnRight.setOnClickListener(rb);


 }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
}
