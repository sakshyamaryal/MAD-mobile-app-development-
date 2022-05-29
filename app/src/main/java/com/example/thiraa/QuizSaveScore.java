package com.example.thiraa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class QuizSaveScore extends AppCompatActivity {
    // getting variables
    Button bOne, bTwo;
    TextView textView1,textView2,textView3;
    EditText edText1,edText2,edText3;

    String info1;
    String info2;
    String info3;
    private String file = "info"; //data call
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_save_score);
        //calling the varibale name and widget names by id
// call id name
        bOne = (Button) findViewById(R.id.save);
        bTwo = (Button) findViewById(R.id.load);

        edText1 = (EditText) findViewById(R.id.name);
        edText2 = (EditText) findViewById(R.id.score);
        edText3=  (EditText) findViewById(R.id.dates);

        textView1 = (TextView) findViewById(R.id.display1);
        textView2 = (TextView) findViewById(R.id.display1);
        textView3 = (TextView) findViewById(R.id.display1);

        //creating on click listner with button 1
        bOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                info1 = edText1.getText().toString(); //getting text user enters to save
                info2 = edText2.getText().toString();
                info3 = edText3.getText().toString();
                //exception handling and saving data code
                try {
                    FileOutputStream fileSave = openFileOutput(file, Context.MODE_PRIVATE);
                   String content;
                         content = info1+"--"+info2+"--"+info3;
                         fileSave.write(content.getBytes());
//                    fileSave.write(info2.getBytes());
                    fileSave.close();
                    Toast.makeText(getBaseContext(),"file saved",Toast.LENGTH_SHORT).show();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        bTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { //creating onclick listner with button 2 for loading the name of user
                String temporaryValue = ""; //blank variable
//                String score = "";
                //writing the user provided data
                /*
                * line number 83, 84 and line number 54,57 idea is taken from the internet
                * https://www.tutorialspoint.com/android/android_internal_storage.htm
                *
                *
                * */
                try {
                    FileInputStream finalWrite= openFileInput(file);
                    int ex = 0; //character to stringScreen Shot 2022-05-28 at 03.57.35
                    while( (ex = finalWrite.read()) != -1) {
                        temporaryValue = temporaryValue + Character.toString((char)  + ex); //passing character to string with char name
                    }
                // catching exception
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                textView1.setText(temporaryValue); //display the user provided data
                textView2.setText(temporaryValue);
                Toast.makeText(getBaseContext(),"file read",Toast.LENGTH_SHORT).show();
                }


        });


    }
}