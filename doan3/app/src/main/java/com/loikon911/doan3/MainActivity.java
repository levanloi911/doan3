package com.loikon911.doan3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button batdau1, video;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        batdau1 = (Button)findViewById(R.id.batdau);
        video = (Button)findViewById(R.id.videoView);
        batdau1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MainActivity.this,Main2Activity.class);
                MainActivity.this.startActivity(intent);
            }
        });
        video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MainActivity.this, OpenVideoActivity.class);
                MainActivity.this.startActivity(intent);

            }
        });

    }
}
