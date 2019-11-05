package com.example.christmas;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.editText);
    }
    public void merryXmas(View view){
        String nameEntered = name.getText().toString();

        TextView myMessage = findViewById(R.id.message);
        myMessage.setText("Merry Christmas " + nameEntered +"!");
        ImageView gift = findViewById(R.id.imageView);
        gift.setImageResource(R.drawable.cane);
    }
}
