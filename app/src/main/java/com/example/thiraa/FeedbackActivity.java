package com.example.thiraa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FeedbackActivity extends AppCompatActivity {

    EditText name, feedback;
    Button send;
/*
* The idea of the feedback extra features in line number 38,39,40 is taken from the youtube and internet
* https://www.youtube.com/watch?v=0jR87MImwy8
* https://developer.android.com/training/sharing/send
*
* */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        name = findViewById(R.id.name);
        feedback = findViewById(R.id.feedback);
        send = findViewById(R.id.btnsend);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String uname = name.getText().toString();
                String ufeedback = feedback.getText().toString();
                /*
                To send from one activity to another activity
                */
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("plain/text");
                intent.putExtra(Intent.EXTRA_TEXT, "Name: " + uname +"\n\nFeedback:" + ufeedback);
                startActivity(intent);
            }
        });
    }
}