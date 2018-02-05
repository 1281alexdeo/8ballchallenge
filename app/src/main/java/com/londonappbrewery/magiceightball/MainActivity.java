package com.londonappbrewery.magiceightball;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonAsk = (Button)findViewById(R.id.btnAsk);
        final ImageView ball8 = (ImageView)findViewById(R.id.image8ball);

        //array to hold all 5 balls
        final int[] ballArray = {
                R.drawable.ball12x,
                R.drawable.ball22x,
                R.drawable.ball32x,
                R.drawable.ball42x,
                R.drawable.ball52x

        };

        //setting action listener to buttonAsk
        buttonAsk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random randomNumberGenerator = new Random();
                int randomNumber = randomNumberGenerator.nextInt(5);
                Log.d("AskButton","ask button pressed!!" + randomNumber);

                //updating the ball on screen when ask button is pressed
               ball8.setImageResource(ballArray[randomNumber]);
            }
        });



    }
}
