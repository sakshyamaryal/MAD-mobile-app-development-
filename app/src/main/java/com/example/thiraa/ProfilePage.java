package com.example.thiraa;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
//import android.widget.Button;
import android.widget.Button;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Calendar;

public class ProfilePage extends AppCompatActivity {
    Calendar calendar; // variable for calender widget
    String dateContext; // string variable
    TextView textDate; // textview variable
    Button menuNavigate;
    TextView nameView,passwordView; //text view variable

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);

        //  for current date
        calendar = Calendar.getInstance(); // instance method for calender
        dateContext = DateFormat.getDateInstance().format(calendar.getTime()); //display format in calender style
        textDate = findViewById(R.id.todaysDate); //view by id for current date
        textDate.setText(dateContext); //calling current date


        nameView = findViewById(R.id.textView4); //calling variable of viewText
        passwordView = findViewById(R.id.textView7);
        menuNavigate = findViewById(R.id.button2);


        /*    set string in line number 48
        * https://www.youtube.com/watch?v=tNmxq4OVq7E
        *
        * */
        Intent intent = getIntent(); // passing intent
        String username = intent.getStringExtra("NAME"); //calling username from mainactivity
        String password = intent.getStringExtra("PASSWORD"); //calling password from mainactivity

        nameView.setText(username); // usernamed displyed in profile page
        passwordView.setText(password); //password displayed

        menuNavigate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menu; // calling intent to go to Activity page from xml file with onclick
                menu = new Intent(ProfilePage.this,ActivityPage.class);
                startActivity(menu);
            }
        });


    }

}