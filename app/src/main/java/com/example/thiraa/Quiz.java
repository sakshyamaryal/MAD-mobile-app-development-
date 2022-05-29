package com.example.thiraa;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class Quiz extends AppCompatActivity  {
//declaring global variable for all fields
    TextView tvtotalNumberOfqns;
    TextView changeQuestion;
    RadioButton one, two, three, four;
    Button submitButton;
    Button saveButton;
    TextView scr;

    TextView tv;
    static int score=0;
    int totalNoQuestion = QuizQuestionsAnswer.totalQuestions.length;
    int indexCurrentQn = 0;
    String userAnswer = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
//calling variable by its id
        tvtotalNumberOfqns = findViewById(R.id.textView);
        changeQuestion = findViewById(R.id.question);
        one = findViewById(R.id.answer1);
        two = findViewById(R.id.answer2);
        three = findViewById(R.id.answer3);
        four= findViewById(R.id.answer4);
        submitButton = findViewById(R.id.submit);
        saveButton = findViewById(R.id.savebtn);
//        scr = findViewById(R.id.scores);

        one.findViewById(R.id.submit);
        two.findViewById(R.id.submit);
        three.findViewById(R.id.submit);
        four.findViewById(R.id.submit);
        submitButton.findViewById(R.id.submit);

        nextQuestion();
//go to quizsave score class by pasing intent
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent saveQuiz = new Intent(Quiz.this,QuizSaveScore.class);
                startActivity(saveQuiz);
            }
        });
// if answer is coorrect score will increment with current question index number
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button clickedButton = (Button) v;
                if(clickedButton.getId()==R.id.submit){
                    if(userAnswer.equals(QuizQuestionsAnswer.rightAnswers[indexCurrentQn])){
                        score++;

                    }
                    indexCurrentQn++;
                    //calling method to pass to next question
                    nextQuestion();

                }else{
                    //choices button clicked
                    userAnswer  = clickedButton.getText().toString();


                }
            }
        });

    }
    //display dialog box

    private void displayScoreMessage() {
        AlertDialog dialog = new AlertDialog.Builder(Quiz.this)
                .setTitle("Status")
                .setMessage("Your Score is "+ score + " out of "+ totalNoQuestion)
                .setCancelable(false)
                .setPositiveButton("OKAY", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();

                    }
                }).create();
        dialog.show();
    }

//increment the question in upper method and display score message is called to get the dialouge box
/* the idea of displayint the question in the array is taken from the internet
*https://www.youtube.com/watch?v=pKMqJAc6wYw&t=579s
*
*
*
*  */
    // if the question is completed it will display dialog box because indexCurrentQn is incrementing by1
    void nextQuestion(){
        if(indexCurrentQn == totalNoQuestion ){
            displayScoreMessage();
            return;
        }
        changeQuestion.setText(QuizQuestionsAnswer.totalQuestions[indexCurrentQn]);//set text of the index 1 answer
        one.setText(QuizQuestionsAnswer.options[indexCurrentQn][0]); //set text of the index 0 answer
        two.setText(QuizQuestionsAnswer.options[indexCurrentQn][1]);
        three.setText(QuizQuestionsAnswer.options[indexCurrentQn][2]);
        four.setText(QuizQuestionsAnswer.options[indexCurrentQn][3]);

    }
}