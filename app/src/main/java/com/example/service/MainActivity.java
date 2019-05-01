package com.example.service;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button start;
    private Button stop;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start = findViewById(R.id.start);
        stop = findViewById(R.id.stop);

        stop.setOnClickListener(this);
        start.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        Intent service = new Intent(this, LogService.class);

        switch (v.getId()){
            case R.id.start: startService(service);
                break;
            case R.id.stop: stopService(service);
                break;
        }
    }
}
