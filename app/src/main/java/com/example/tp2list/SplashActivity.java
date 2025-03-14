package com.example.tp2list;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    private ImageView logoImage;
    private TextView appTitle, appSlogan;

    private ImageView spinImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        logoImage = findViewById(R.id.logoImage);
        appTitle = findViewById(R.id.appTitle);
        appSlogan = findViewById(R.id.appSlogan);


            spinImg = findViewById(R.id.spinImg);
            Thread t = new Thread() {
                @Override
                public void run() {
                    try {
                        RotateAnimation rotate = new RotateAnimation(0, 180, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                        rotate.setDuration(5000);
                        rotate.setInterpolator(new LinearInterpolator());
                        spinImg.setAnimation(rotate);
                        Intent intent = new Intent(SplashActivity.this, ListPizzaActivity.class);
                        sleep(5000);
                        startActivity(intent);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };
            t.start();

        }

        @Override
        protected void onPause () {
            super.onPause();
            finish();
        }
    }