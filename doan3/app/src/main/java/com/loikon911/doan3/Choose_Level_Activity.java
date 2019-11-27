package com.loikon911.doan3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Choose_Level_Activity extends AppCompatActivity {
    Button buton3x3, buton4x4, button5x5, button6x6, button7x7, button8x8;
    ImageView backhome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_levell);
        backhome = (ImageView)findViewById(R.id.back);
        buton3x3 = (Button)findViewById(R.id.baxba);
        buton4x4 = (Button)findViewById(R.id.a4x4);
        button5x5 = (Button)findViewById(R.id.bt5x5);
        button6x6 = (Button) findViewById(R.id.bt6x6);
        button7x7 = (Button) findViewById(R.id.bt7x7);
        button8x8 = (Button) findViewById(R.id.bt8x8);
        buton3x3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent  intent = new Intent(Choose_Level_Activity.this, Level1Activity.class);
                Choose_Level_Activity.this.startActivity(intent);
            }
        });
        buton4x4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent  intent = new Intent(Choose_Level_Activity.this, Level2Activity.class);
                Choose_Level_Activity.this.startActivity(intent);
            }
        });
        button5x5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Choose_Level_Activity.this, Level3Activity.class);
                Choose_Level_Activity.this.startActivity(intent);
            }
        });
        button6x6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Choose_Level_Activity.this, Level4Activity.class);
                Choose_Level_Activity.this.startActivity(intent);
            }
        });
        button7x7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Choose_Level_Activity.this, Level5Activity.class);
                Choose_Level_Activity.this.startActivity(intent);
            }
        });
        button8x8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Choose_Level_Activity.this, Level6.class);
                Choose_Level_Activity.this.startActivity(intent);
            }
        });
        backhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Choose_Level_Activity.this,MainActivity.class);
                Choose_Level_Activity.this.startActivity(intent);
            }
        });

    }
}
