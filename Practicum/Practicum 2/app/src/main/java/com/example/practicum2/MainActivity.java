package com.example.practicum2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    private EditText name;
    private ToggleButton toggle;
    private Spinner spinning;
    private Button location;
    private CheckBox salsa;
    private CheckBox sourCream;
    private CheckBox cheese;
    private CheckBox guac;
    private Switch switching;
    private TextView finalText;
    private ImageView finalImage;
    private String message;


    private location myLocation  = new location();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name=findViewById(R.id.editText);
        toggle=findViewById(R.id.toggleButton);
        spinning=findViewById(R.id.spinner);
        salsa=findViewById(R.id.salsa);
        sourCream=findViewById(R.id.sourcream);
        cheese=findViewById(R.id.cheese);
        guac=findViewById(R.id.guac);
        switching=findViewById(R.id.switch1);
        finalImage=findViewById(R.id.imageResult);
        finalText=findViewById(R.id.finalText);
        location=findViewById(R.id.button3);

        View.OnClickListener onclick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                location(v);
            }
        };
        location.setOnClickListener(onclick);

    }

    public void findBurrito(View view) {
        String myName = name.getText().toString();

        finalImage.setImageResource(R.drawable.burrito);
        if (myName.isEmpty()) {

            Toast toast = Toast.makeText(getApplicationContext(), "Please enter your name", Toast.LENGTH_SHORT);
            toast.show();
        } else {
            if (!toggle.isChecked()){
                String mm = "meat";
                message = (myName + " wants a " +mm+" burrito");
                finalText.setText(message);
                if (switching.isChecked()){
                    String ss = "corn tortilla";
                    message = (myName + " wants a " +ss+" "+mm+" burrito");
                    finalText.setText(message);
                    if(salsa.isChecked()){
                        String tt = "salsa";
                        message = (myName + " wants a " +ss+" "+mm+" burrito with "+tt);
                        finalText.setText(message);
                        if ((sourCream.isChecked())||(salsa.isChecked())){
                            String hhh = "sour cream";
                            message = (myName + " wants a " +ss+" "+mm+" burrito with "+tt +" and " +hhh);
                            finalText.setText(message);
                        }
                    }
                    else if(sourCream.isChecked()){
                        String tt = "sour cream";
                        message = (myName + " wants a " +ss+" "+mm+" burrito with "+tt);
                        finalText.setText(message);
                    }
                    else if (cheese.isChecked()){
                        String tt = "cheese";
                        message = (myName + " wants a " +ss+" "+mm+" burrito with "+tt);
                        finalText.setText(message);
                    }
                    else if (guac.isChecked()){
                        String tt = "guacamole";
                        message = (myName + " wants a " +ss+" "+mm+" burrito with "+tt);
                        finalText.setText(message);
                    }


                }
                else{
                    String ss = "flour tortilla";
                    message = (myName + " wants a " +ss+" "+mm+" burrito");
                    finalText.setText(message);
                }
            }
            else if (toggle.isChecked()) {
                String mm = "veggie";
                message = (myName + " wants a " + mm + " burrito");
                finalText.setText(message);

                if (switching.isChecked()){
                    String ss = "corn tortilla";
                    message = (myName + " wants a " +ss+" "+mm+" burrito");
                    finalText.setText(message);

                    if(salsa.isChecked()){
                        String tt = "salsa";
                        message = (myName + " wants a " +ss+" "+mm+" burrito with "+tt);
                        finalText.setText(message);

                        if ((sourCream.isChecked())||(salsa.isChecked())){
                            String hhh = "sour cream";
                            message = (myName + " wants a " +ss+" "+mm+" burrito with "+tt +" and " +hhh);
                            finalText.setText(message);
                        }
                    }
                    else if(sourCream.isChecked()){
                        String tt = "sour cream";
                        message = (myName + " wants a " +ss+" "+mm+" burrito with "+tt);
                        finalText.setText(message);
                    }
                    else if (cheese.isChecked()){
                        String tt = "cheese";
                        message = (myName + " wants a " +ss+" "+mm+" burrito with "+tt);
                        finalText.setText(message);
                    }
                    else if (guac.isChecked()){
                        String tt = "guacamole";
                        message = (myName + " wants a " +ss+" "+mm+" burrito with "+tt);
                        finalText.setText(message);
                    }


                }
            }
        }





    }

    public void location(View view){

        Integer picked = spinning.getSelectedItemPosition();
        myLocation.setPlace(picked);

        String chosenPlace = myLocation.getPlace();
        String placeURL = myLocation.getPlaceURL();
        System.out.println("main activity");
        System.out.println(chosenPlace);

        Intent intent = new Intent(this, Main2Activity.class);
        intent.putExtra("place", chosenPlace);
        intent.putExtra("placeURL", placeURL);
        startActivity(intent);
    }
}
