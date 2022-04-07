package com.example.mediguide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class Splash_Screen_Activity extends AppCompatActivity {

    private static int SPLASH_DELAY = 4000;

    Animation top_anim , bottom_anim;

    ImageView heart_img;
    TextView medi_txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        heart_img = findViewById(R.id.heart_img);
        medi_txt = findViewById(R.id.medi_txt);
        // Animation
        top_anim = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottom_anim = AnimationUtils.loadAnimation(this,R.anim.botton_animation);

        heart_img.setAnimation(bottom_anim);
        medi_txt.setAnimation(top_anim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(Splash_Screen_Activity.this, DashBoard.class));
                finish();
            }
        },SPLASH_DELAY);

    }
}