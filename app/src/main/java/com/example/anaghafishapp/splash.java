package com.example.anaghafishapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.airbnb.lottie.LottieAnimationView;

public class splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        LottieAnimationView animationView = findViewById(R.id.lottieAnimationView2);
        animationView.setAnimation("Logoanimation.json"); // Set the animation file

        animationView.loop(true); // Set the animation to loop

        // Start the animation
        animationView.playAnimation();

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run(){
                Intent intent = new Intent(splash.this, loginActivity.class);
                startActivity(intent);
                finish();
            }
        }, 2500);
    }
}