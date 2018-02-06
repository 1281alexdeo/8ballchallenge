package com.londonappbrewery.magiceightball;

import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private SoundPool mSoundPool;
    private int mCSoundId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //using soundpool to play sound on the device
        //create soundpool
        mSoundPool = new SoundPool(1,AudioManager.STREAM_MUSIC,0);
        //load soundID and returning it back
        mCSoundId =  mSoundPool.load(getApplicationContext(),R.raw.note1_c,1);
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
                Log.d("AskButton","ask button sound ");
                mSoundPool.play(mCSoundId,1.0f,1.0f,1,0,1.0f);
                //updating the ball on screen when ask button is pressed
               ball8.setImageResource(ballArray[randomNumber]);


            }
        });


    }


}
