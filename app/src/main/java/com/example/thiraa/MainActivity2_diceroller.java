package com.example.thiraa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class MainActivity2_diceroller extends AppCompatActivity {

    public static final Random RANDOM = new Random(); // random number function
    private ImageView imageOne, imageTwo; // for  2 different image prototype
    TextView greaterText; //declaring variable to find greater number

    TextView name1, name2; //variable
    String info1;
    TextView edText;

    private String file = "info";
    TextView nameViewText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2_diceroller);


        name1 = findViewById(R.id.textview1); //variable declaring the id's
        name2 = findViewById(R.id.textview2);
        Intent intent = getIntent(); //getting intent for names
        String player1 = intent.getStringExtra("NAME1"); //name
        String player2 = intent.getStringExtra("NAME2");

        name1.setText(player1); //displaying name
        name2.setText(player2);


        //show username
        nameViewText = findViewById(R.id.textView12);
        Intent i = getIntent();
        String username = i.getStringExtra("NAME");
        nameViewText.setText(username);


        Button saveBtn = (Button) findViewById(R.id.button3); //calling save button by id

        Button roll = (Button) findViewById(R.id.roll); // for roll button
        imageOne = (ImageView) findViewById(R.id.image1); //access image1
        imageTwo = (ImageView) findViewById(R.id.image2); //access image2

        roll.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                int val1 = diceRollRandomNumberGenerator(); //method name
                int val2 =  diceRollRandomNumberGenerator(); //function name

                int resourceOne = getResources().getIdentifier("face" + val1, "drawable", "com.example.thiraa"); //geting image resources
                int resourceTwo = getResources().getIdentifier("face" + val2, "drawable", "com.example.thiraa");

                imageOne.setImageResource(resourceOne); //method
                imageTwo.setImageResource(resourceTwo);

                winnerDisplay(val1,val2,player1,player2); //method call
            }
        });

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //onclick method for page transfer

                        edText = (TextView) findViewById(R.id.textView);
                         //getting text user enters to save
                        info1 = edText.getText().toString();
                        //exception handling and saving data code
                        try {
                            //file creation mode
                            FileOutputStream fileSave = openFileOutput(file, Context.MODE_PRIVATE);
                            String content;
                            content = info1;
                            fileSave.write(content.getBytes());

                            fileSave.close();
                            Toast.makeText(getBaseContext(),"file saved",Toast.LENGTH_SHORT).show();
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

        });

    }

    public void winnerDisplay(int value1, int value2, String p1,String p2){ //getting data of winner
        greaterText = (TextView) findViewById(R.id.textView);
        if (value1 >= value2){
            greaterText.setText(Integer.toString(value1) + " : "+ p1 +" DICE1 is the WINNER!");

        }
        else if (value1 < value2){
            greaterText.setText(Integer.toString(value2) + " : "+ p2 +" DICE2 is the WINNER!");

        }

    }

    public static int diceRollRandomNumberGenerator(){ //method to call random number with different faces
       //RANDOM is from the global variable
        return RANDOM.nextInt(6) + 1;

    }
}