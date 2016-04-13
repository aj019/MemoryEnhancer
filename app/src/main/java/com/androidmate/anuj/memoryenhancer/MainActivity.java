package com.androidmate.anuj.memoryenhancer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements Animation.AnimationListener {

    TextView tvMemory,tvEnhancer;
    Animation move_up,move_down;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvMemory = (TextView) findViewById(R.id.tvMemory);
        tvEnhancer = (TextView) findViewById(R.id.tvEnhancer);

        move_down = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.move_down);
        move_up = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.move_up);
        move_down.setAnimationListener(this);
        move_up.setAnimationListener(this);
        tvMemory.startAnimation(move_down);
        tvEnhancer.startAnimation(move_up);
        Thread background = new Thread() {
            public void run() {

                try {
                    // Thread will sleep for 5 seconds
                    sleep(4*1000);

                    // After 5 seconds redirect to another intent
                    Intent i = new Intent(MainActivity.this,MenuActivity.class);
                    startActivity(i);
                    finish();

                } catch (Exception e) {

                }
            }
        };

        // start thread
        background.start();

    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {

    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
