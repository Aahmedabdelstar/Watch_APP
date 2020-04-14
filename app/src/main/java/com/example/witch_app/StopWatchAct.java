package com.example.witch_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;

public class StopWatchAct extends AppCompatActivity {

    Button btnStart , btnStop;
    ImageView icanchor;
    Animation roundingalone;
    Chronometer timehere;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop_watch);

        btnStart = findViewById(R.id.btnGet);
        icanchor = findViewById(R.id.icon_cher);
        btnStop = findViewById(R.id.btnStop);
        timehere= findViewById(R.id.timeHere);

        //// Load Animation
        roundingalone= AnimationUtils.loadAnimation(this,R.anim.rounding);
        btnStop.setAlpha(0);

        /// import fonts
        Typeface MMedium = Typeface.createFromAsset(getAssets(),"fonts/MMedium.ttf");
        /// customize fonts
        btnStart.setTypeface(MMedium);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               icanchor.startAnimation(roundingalone);
               btnStop.animate().alpha(1).translationY(-80).setDuration(300).start();
               btnStart.animate().alpha(0).setDuration(300).start();
               // start Time
                timehere.setBase(SystemClock.elapsedRealtime());
                timehere.start();
            }
        });
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                               // start Time
                //timehere.setBase(SystemClock.elapsedRealtime());
                timehere.stop();
                icanchor.clearAnimation();
            }
        });

    }
}
