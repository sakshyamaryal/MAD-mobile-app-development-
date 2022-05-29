package com.example.thiraa;

import androidx.appcompat.app.AppCompatActivity;

//import android.content.Intent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
//import android.view.View;

public class ActivityPage extends AppCompatActivity {
    //global variable
    Button quizBtn,diceBtn,feedback,save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page);
    /*
    * Navigating to other connected activities through intent
    *
    * */
        quizBtn = (Button) findViewById(R.id.button4);
        quizBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent quiz = new Intent(ActivityPage.this,Quiz.class);
                startActivity(quiz);
            }
        });
        diceBtn = (Button) findViewById(R.id.button5);
        diceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dice = new Intent(ActivityPage.this,PlayerName.class);
                startActivity(dice);
            }
        });
        feedback = (Button) findViewById(R.id.button7);
        feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent feed = new Intent(ActivityPage.this,FeedbackActivity.class);
                startActivity(feed);
            }
        });
        save= (Button) findViewById(R.id.button6);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dice = new Intent(ActivityPage.this,QuizSaveScore.class);
                startActivity(dice);
            }
        });
    }

}