package com.example.luckynumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class SecondActivity extends AppCompatActivity {

    TextView heading, luckyNumber;
    Button btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        heading = findViewById(R.id.heading);
        luckyNumber = findViewById(R.id.lucky_no);
        btn2 = findViewById(R.id.btn2);


     // Reciving the data from main activity
        Intent i = getIntent();
        String userName = i.getStringExtra("name");


        //Genrating the random number
        int random_num = generateRandomNumber();
        luckyNumber.setText(""+random_num);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShareData(userName, random_num);
            }
        });
    }

    public  int generateRandomNumber(){
        Random random = new Random();
        int upper_limit = 1000;

        int randomNumberGenerated = random.nextInt(upper_limit);
        return randomNumberGenerated;
    }

    public void ShareData(String username, int randomNum){
//implicit intent
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setType("text/plain");

        //additional information

        i.putExtra(Intent.EXTRA_SUBJECT,username + "got lucky number");
        i.putExtra(Intent.EXTRA_TEXT,"His lucky number is :" +randomNum);


        startActivities(new Intent[]{Intent.createChooser(i, "choose a platform")});
    }
}