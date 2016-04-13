package com.androidmate.anuj.memoryenhancer;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class SettingsActivity extends AppCompatActivity implements View.OnClickListener {

    RadioGroup radioGroup1,radioGroup2,radioGroup3;
    RadioButton radioButton1,radioButton2,radioButton3;
    RadioButton radioAndroid,radioiPhone,radioWindows,radioSlow,radioFast,radioFastest,radio010,radio15,radio20;
    Button btsave;
    int diff,maxno;
    float speed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if(toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle("Settings");
            getSupportActionBar().setHomeButtonEnabled(false);
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        }
        radioGroup1 = (RadioGroup) findViewById(R.id.radioGroup1);
        radioGroup2 = (RadioGroup) findViewById(R.id.radioGroup2);
        radioGroup3 = (RadioGroup) findViewById(R.id.radioGroup3);

        radioAndroid = (RadioButton) findViewById(R.id.radioAndroid);
        radioiPhone = (RadioButton) findViewById(R.id.radioiPhone);
        radioWindows = (RadioButton) findViewById(R.id.radioWindows);
        radioSlow = (RadioButton) findViewById(R.id.radioSlow);
        radioFast = (RadioButton) findViewById(R.id.radioFast);
        radioFastest = (RadioButton) findViewById(R.id.radioFastest);
        radio010 = (RadioButton) findViewById(R.id.radioTen);
        radio15 = (RadioButton) findViewById(R.id.radioFifteen);
        radio20 = (RadioButton) findViewById(R.id.radiotwenty);

        btsave = (Button) findViewById(R.id.btSaveSettings);
        btsave.setOnClickListener(this);
        checkState();

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void checkState() {
        SharedPreferences prefs = getSharedPreferences("Settings", MODE_PRIVATE);
        diff = prefs.getInt("diff", 10);
        speed = prefs.getFloat("speed", 3);
        maxno = prefs.getInt("maxno", 10);

        switch (diff){
            case 10:
                radioAndroid.setChecked(true);
                break;
            case 100:
                radioiPhone.setChecked(true);
                break;
            case 1000:
                radioWindows.setChecked(true);
                break;
        }


        switch ((int)(speed *10)){
            case 20:
                radioSlow.setChecked(true);
                break;
            case 10:
                radioFast.setChecked(true);
                break;
            case 5:
                radioFastest.setChecked(true);
                break;
        }

        switch (maxno){
            case 10:
                radio010.setChecked(true);
                break;
            case 15:
                radio15.setChecked(true);
                break;
            case 20:
                radio20.setChecked(true);
                break;
        }


    }

    @Override
    public void onClick(View v) {

        int selectedId1 = radioGroup1.getCheckedRadioButtonId();
        radioButton1 = (RadioButton) findViewById(selectedId1);

        int selectedId2 = radioGroup2.getCheckedRadioButtonId();
        radioButton2 = (RadioButton) findViewById(selectedId2);

        int selectedId3 = radioGroup3.getCheckedRadioButtonId();
        radioButton3 = (RadioButton) findViewById(selectedId3);

        switch (radioButton1.getText().toString()){
            case "Easy":
                diff = 10;

                break;
            case "Medium":
                diff = 100;


                break;
            case "Hard":
                diff = 1000;


                break;
        }


        switch (radioButton2.getText().toString()){
            case "Slow":
                 speed=2;
                break;
            case "Fast":
                speed =1;
                break;
            case "Fastest":
                speed = 0.5f;
                break;
        }

        switch (radioButton3.getText().toString()){
            case "10":
                maxno = 10;
                break;
            case "15":
                maxno = 15;
                break;
            case "20":
                maxno = 20;
                break;
        }

        SharedPreferences.Editor editor = getSharedPreferences("Settings",MODE_PRIVATE).edit();
        editor.putInt("diff", diff);
        editor.putFloat("speed", speed);
        editor.putInt("maxno", maxno);
        editor.commit();

        //Toast.makeText(this,String.valueOf(diff),Toast.LENGTH_LONG).show();
        Intent i = new Intent(SettingsActivity.this,MenuActivity.class);
        startActivity(i);
        finish();
    }
}

