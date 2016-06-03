package com.androidmate.anuj.memoryenhancer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener, Animation.AnimationListener {

    Button btStart,btSettings,btHowItWorks;
    Animation rotate;
    ImageView iv ;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        iv = (ImageView) findViewById(R.id.ivMenu);
        btStart = (Button) findViewById(R.id.btStart);
        btSettings = (Button) findViewById(R.id.btSettings);
        btHowItWorks = (Button) findViewById(R.id.btHowItWorks);

        rotate = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom);
        rotate.setAnimationListener(this);
        iv.setAnimation(rotate);
        btStart.setOnClickListener(this);
        btSettings.setOnClickListener(this);
        btHowItWorks.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.btStart:
                Intent i = new Intent(MenuActivity.this,PlayActivity.class);
                startActivity(i);
                break;

            case R.id.btSettings:

                Intent j = new Intent(MenuActivity.this,SettingsActivity.class);
                startActivity(j);
                break;
            case R.id.btHowItWorks:

                Intent k = new Intent(MenuActivity.this,HowItWorks.class);
                startActivity(k);
                break;
        }
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

    @Override
    public void onPause() {
        if (mAdView != null) {
            mAdView.pause();
        }
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mAdView != null) {
            mAdView.resume();
        }
    }

    @Override
    public void onDestroy() {
        if (mAdView != null) {
            mAdView.destroy();
        }
        super.onDestroy();
    }
}
