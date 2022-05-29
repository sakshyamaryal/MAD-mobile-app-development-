package com.example.thiraa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PlayerName extends AppCompatActivity {

    EditText player1, player2; //declaring widgets variable
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_name);
        Button play = (Button) findViewById(R.id.button8);
        play.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent;
                player1 = (EditText) findViewById(R.id.editTextTextPersonName3); // calling variable by id of Edittext user with viewbyid
                player2= (EditText) findViewById(R.id.editTextTextPersonName4);// calling variable by id of Edittext Password with viewbyid

                intent = new Intent(getApplicationContext(), MainActivity2_diceroller.class); // calling intent to go to profile page
                intent.putExtra("NAME1", player1.getText().toString());
                intent.putExtra("NAME2", player2.getText().toString()); //getting username for dice user
                startActivity(intent); // calling variable intent
            }
        });
    }
}





