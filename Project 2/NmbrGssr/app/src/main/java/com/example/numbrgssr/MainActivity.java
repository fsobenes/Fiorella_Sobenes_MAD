package com.example.numbrgssr;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity{

    private Button checkButton;
    private Button restartButton;
    private TextView hintText;
    private TextView correctNum;
    private TextView finalText;
    private EditText numEntered;
    Integer num = 0;

    //https://stackoverflow.com/questions/45144071/android-how-to-generate-random-numbers-and-set-those-numbers-on-textviews
//    Random randomNum = new Random();
//    Integer n = randomNum.nextInt(49)+1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkButton = findViewById(R.id.checkButton);
        restartButton = findViewById(R.id.restartButton);
        hintText = findViewById(R.id.hintText);
        correctNum = findViewById(R.id.correctNum);
        finalText = findViewById(R.id.numWas);
        numEntered = findViewById(R.id.numEntered);
        restartButton();
//      https://stackoverflow.com/questions/16012548/hide-and-unhide-edittext?lq=1
        restartButton.setVisibility(View.GONE);
        finalText.setVisibility(View.GONE);
    }

    public void restartButton(View view){
        restartButton();
    }

    public void checkNum(View view){
        restartButton.setVisibility(View.VISIBLE);
        //numEntered.getText();
        String myString = numEntered.getText().toString();
        //https://stackoverflow.com/questions/42957168/converting-string-from-edittext-to-integer
        Log.d("DEBUG", myString);
        if (!myString.isEmpty()){
            int number = Integer.parseInt(myString);
            if (number == num){
                hintText.setText("Correct!");
                finalText.setText("The number was...");
                correctNum.setText(num.toString());
            }
            else if (number < num){
                hintText.setText("Higher!");
                finalText.setText("Guess Again");
            }
            else if (number > num){
                hintText.setText("Lower!");
                finalText.setText("Guess Again!");
            }
        }
        else{
            Toast toast = Toast.makeText(getApplicationContext(),"Enter a number", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    public void restartButton(){
        Random randomNum = new Random();
        num = randomNum.nextInt(49)+1;
        correctNum.setText("");
        hintText.setText("");
        finalText.setText("");
        restartButton.setVisibility(View.INVISIBLE);
    }

}
