package com.androidmate.anuj.memoryenhancer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ResultActivity extends AppCompatActivity implements View.OnClickListener {
    int sum;
    ArrayList<String> list;
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        //lv = (ListView) findViewById(R.id.lvNum);
        TextView tvsum = (TextView) findViewById(R.id.tvSum);
        TextView tvNumresult = (TextView) findViewById(R.id.tvNumResults);
        Button btback = (Button) findViewById(R.id.btBack);
        sum = getIntent().getIntExtra("sum",0);
        tvsum.setText("Sum = "+sum);
        list = (ArrayList<String>) getIntent().getSerializableExtra("list");
        String res = list.get(0);
        for(int i=1;i<list.size();i++){
            res= res + " + "+ list.get(i);
        }
        tvNumresult.setText(res);
        btback.setOnClickListener(this);
        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list);
        //lv.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(ResultActivity.this,MenuActivity.class);
        startActivity(i);
        finish();
    }
}
