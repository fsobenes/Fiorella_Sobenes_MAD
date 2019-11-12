package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private TextView bikiniCharacter;
    private ToggleButton toggle;
    private EditText name;
    private Spinner characteristic;
    private RadioGroup colors;
    private CheckBox money1;
    private CheckBox money2;
    private CheckBox money3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bikiniCharacter = findViewById(R.id.message);
        toggle = findViewById(R.id.toggleButton);
        name = findViewById(R.id.editText);
        characteristic = findViewById(R.id.spinner);
        colors = findViewById(R.id.radioGroup);
        money1 = findViewById(R.id.checkBox);
        money2 = findViewById(R.id.checkBox2);
        money3 = findViewById(R.id.checkBox3);
    }

    public void check(View view){
        boolean location = toggle.isChecked();

        String chartype = String.valueOf(characteristic.getSelectedItem());

        int colors_selection = colors.getCheckedRadioButtonId();

        Boolean money11 = money1.isChecked();
        Boolean money22 = money2.isChecked();
        Boolean money33 = money3.isChecked();

        String finalChar;

        String nameValue = name.getText().toString();

        if (colors_selection == -1) {
            Context context = getApplicationContext();
            CharSequence text = "Please select a color";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

        }
        else {
            if (location) {
                if (colors_selection == R.id.radioButton1) {
                    finalChar = "Mr. Krabs";
                }
                else {
                    switch (chartype) {
                        case "Uhhhhh":
                            finalChar = "Patrick";
                            break;
                        case "Science":
                            finalChar = "Sandy";
                            break;
                        case "Music":
                            finalChar = "Squidward";
                            break;
                        case "Money":
                            finalChar = "Mr. Krabs";
                            break;
                        case "Jellyfish":
                            finalChar = "Spongebob";
                            break;
                        default:
                            finalChar = "Spongebob";
                    }
                }
            }
            else {
                if (colors_selection == R.id.radioButton1) {
                    if (money11) {
                        finalChar = "Mr. Krabs";
                    }
                    else if (money22) {
                        finalChar = "Sandy";
                    }
                    else if(money33){
                        finalChar = "Mr. Krabs";
                    }
                    else {
                        finalChar = "Spongebob";
                    }
                }
                else {
                    switch (chartype) {
                        case "Uhhhhh":
                            finalChar = "Patrick";
                            break;
                        case "Science":
                            finalChar = "Sandy";
                            break;
                        case "Music":
                            finalChar = "Squidward";
                            break;
                        case "Money":
                            finalChar = "Mr. Krabs";
                            break;
                        case "Jellyfish":
                            finalChar = "Spongebob";
                            break;
                        default:
                            finalChar = "Spongebob";
                    }
                }
            }
            bikiniCharacter.setText("Hi "+ nameValue + ", " + finalChar + " is the sport for you");
        }

    }
}
