package com.androidmate.anuj.memoryenhancer;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class PlayActivity extends AppCompatActivity implements Animation.AnimationListener {

    int i=0;
    int diff,maxno;
    float speed;
    int sum =0;
    ArrayList list;
    TextView view;
    Animation blink;
   // private Handler handler = new Handler();
    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        view = (TextView) findViewById(R.id.tvDigit);
        list = new ArrayList();
        blink = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.blink);
        blink.setAnimationListener(this);
        getSettings();
        set();

    }

    private void nextActivity() {
        Handler hr = new Handler();
        hr.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(PlayActivity.this, ResultActivity.class);
                intent.putExtra("sum", sum);
                intent.putExtra("list", list);
                startActivity(intent);
                finish();
            }
        }, 2000);
    }

    private void getSettings() {
        SharedPreferences prefs = getSharedPreferences("Settings", MODE_PRIVATE);
        diff = prefs.getInt("diff", 10);
        speed = prefs.getFloat("speed", 3);
        maxno = prefs.getInt("maxno", 10);


    }

    @Override
    public void onDestroy() {
        handler.removeCallbacksAndMessages(null);
        super.onDestroy();
    }

    public void set() {

        handler = new Handler();

        handler.post(new Runnable() {
            @Override
            public void run() {
                Random r = new Random();
                int num = r.nextInt(diff);
                i++;
                if (i <= maxno) {
                    sum += num;
                    list.add("" + num);
                    String snum = String.valueOf(num);
                    view.setText(snum);
                    view.startAnimation(blink);
                    handler.postDelayed(this, Math.round(1000 * speed));

                } else {
                    view.setText("Loading Answer...");
                        nextActivity();
                    }

                }

            });


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
