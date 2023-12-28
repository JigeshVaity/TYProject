package com.example.anaghafishapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.airbnb.lottie.LottieAnimationView;
import com.example.anaghafishapp.Useractivity.HomeFragment;

public class loginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        LottieAnimationView animationView = findViewById(R.id.lottieAnimationView1);
        animationView.setAnimation("login.json"); // Set the animation file

        animationView.loop(true); // Set the animation to loop

        // Start the animation
        animationView.playAnimation();

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run(){
                Intent intent = new Intent(loginActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 4000);
    }
}