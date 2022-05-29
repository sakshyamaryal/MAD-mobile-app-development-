package com.example.thiraa;

/*
* The idea of joining two pages for the questions was taken from youtube video
* https://www.youtube.com/watch?v=pKMqJAc6wYw&t=579s
*
* */
public class QuizQuestionsAnswer {
    //string variable with array
    public static String totalQuestions[] ={
            "Which is highest mountain in the world?",
            "Which country is known as land of rising sun?",
            "Where is pyramid located at?",
            "Which country has highest population?",
            "Where did sushi originate? ",
    };
    //string variable with array of 2 dimension for the radio button
    public static String options[][] = {
            {"Mt.Everest","Ketu","munal","Kanchanjanga"},
            {"Japan","Nepal","Uk","USA"},
            {"Korea","Egypt","Australia","Ghana"},
            {"USA","Nepal","Russia","India"},
            {"china","Nepal","Russia","India"}
    };
    //correct answer
    public static String rightAnswers[] = {
            "Mt.Everest",
            "Japan",
            "Egypt",
            "Russia",
            "china"

    };
}
