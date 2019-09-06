package com.loikon911.doan3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity {
    Button buton3x3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        buton3x3 = (Button)findViewById(R.id.baxba);
        buton3x3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent  intent = new Intent(Main2Activity.this,BaxbaActivity.class);
                Main2Activity.this.startActivity(intent);
            }
        });
    }
}
