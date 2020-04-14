package com.example.witch_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvSplash , tvSubSplash;
    Button btnGet;
    Animation atg,btgOne,btgTwo;
    ImageView ivSplash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvSplash = findViewById(R.id.tvSplash);
        tvSubSplash = findViewById(R.id.tvSubSplash);
        btnGet = findViewById(R.id.btnGet);
        ivSplash = findViewById(R.id.ivSplesh);

        /// Load Animation
        atg = AnimationUtils.loadAnimation(this,R.anim.alpe_to_go);
        btgOne = AnimationUtils.loadAnimation(this,R.anim.btgone);
        btgTwo = AnimationUtils.loadAnimation(this,R.anim.btgtwo);

        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(MainActivity.this,StopWatchAct.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });

        /// Passing Animation
        ivSplash.startAnimation(atg);
        tvSplash.startAnimation(btgOne);
        tvSubSplash.startAnimation(btgOne);
        btnGet.startAnimation(btgTwo);

        //imprt fonts
        Typeface MLight = Typeface.createFromAsset(getAssets(),"fonts/MLight.ttf");
        Typeface MMedium = Typeface.createFromAsset(getAssets(),"fonts/MMedium.ttf");
        Typeface MRegular = Typeface.createFromAsset(getAssets(),"fonts/MRegular.ttf");
        /// customize fonts
        tvSplash.setTypeface(MRegular);
        tvSubSplash.setTypeface(MLight);
        btnGet.setTypeface(MMedium);

    }
}
