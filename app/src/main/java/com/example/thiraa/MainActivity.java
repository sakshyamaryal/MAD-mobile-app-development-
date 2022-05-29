package com.example.thiraa;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText username; // EditText variable for creating username
    EditText password; // EditText variable for creating password
    Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login = findViewById(R.id.button);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent; // Intent variable
                username = (EditText) findViewById(R.id.editTextTextPersonName); // calling variable by id of Edittext user with viewById
                password= (EditText) findViewById(R.id.editTextTextPersonName2);// calling variable by id of Edittext Password with viewById

                //creating username and password with string and get field
                if(username.getText().toString().equals("aryal") && password.getText().toString().equals("aryal") || username.getText().toString().equals("sakshyam") && password.getText().toString().equals("aryal")){
   intent = new Intent(getApplicationContext(), ProfilePage.class); // calling intent to go to profile page
                    intent.putExtra("NAME", username.getText().toString());
                    intent.putExtra("PASSWORD", password.getText().toString()); //getting the text from the user from edittext
                    startActivity(intent);

                    Toast.makeText( MainActivity.this, "Successful login",Toast.LENGTH_LONG).show(); // display message
                }
                else{
                    Toast.makeText( MainActivity.this, "Incorrect username or password.",Toast.LENGTH_LONG).show(); // display message
                    showAlertDialog("User Unauthorized !");
                }
            }
        });
    }


    //method for warning message in dialogbox
    private void showAlertDialog(String warningMessage) {
        AlertDialog dialog = new AlertDialog.Builder(MainActivity.this)
                .setTitle("Status")
                .setMessage(warningMessage)
                .setCancelable(false)
                .setPositiveButton("TryAgain", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                }).create();
        dialog.show();
    }

}