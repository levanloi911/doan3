package com.loikon911.doan3;

import android.media.MediaPlayer;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;


public class BaxbaActivity extends AppCompatActivity {
    Animation animation;
    Button [][] buttons;
    ImageView load;
    boolean onclick;
    int col, row, row1, col1;
    MediaPlayer mediaPlayer;

    //di chuyen
    private void dichuyentrai(){
       // if(row==row1)
        if (col>0){
          String x= (String) buttons[row][ col -1].getText();
          buttons[row][col].setText(x);
          buttons[row] [col-1].setText("");
          col = col -1;
        }
    }
    private  void dichuyenphai(){
        if (col<2) {
            String x = (String) buttons[row][col + 1].getText();
            buttons[row][col].setText(x);
            buttons[row][col + 1].setText("");
            col = col + 1;
        }
    }
    private  void dichuyenlen(){
        if (row>0) {
            String x = (String) buttons[col][row -1 ].getText();
            buttons[col][row].setText(x);
            buttons[col][row -1 ].setText("");
            row = row - 1;
        }
    }
    private  void dichuyenxuong(){
        if (row<2) {
            String x = (String) buttons[col][row +1 ].getText();
            buttons[col][row].setText(x);
            buttons[col][row +1 ].setText("");
            row = row + 1;
        }
    }
    private void dichuyen(){
        if (row == row1){
            if (col == col1 -1) dichuyenphai();
        }else if(col == col1 +1 ) dichuyentrai();
        if (col==col1)
        if(row1 == row +1)  dichuyenxuong();
        else if(row1 == row -1)  dichuyenlen();
    }

    //1. Tạo một mảng gồm n phần tử các số ngẫu nhiên
    private int[] taoMangNgauNhien(int n) {
        int[] A = new int[n];
        for (int i = 0; i < n; i++)
            A[i] = i+1;
        return tronNgauNhien(A);
    }
    private int[] tronNgauNhien(int[]A){
        int n= A.length, j, tmp;
        Random rd = new Random();
        for(int i =0; i<n; i++)
        {
            j = rd.nextInt(n);
            if(j<n) {
                tmp=A[i];
                A[i]=A[j];
                A[j]=tmp;
            }
        }
        return A;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baxba);

        load = (ImageView)findViewById(R.id.loa);



        Toolbar toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        //random and set text button
        buttons = new Button[][]{{(Button)findViewById(R.id.bt1),(Button)findViewById(R.id.bt2),(Button)findViewById(R.id.bt3)},{(Button)findViewById(R.id.bt4),(Button)findViewById(R.id.bt5),(Button)findViewById(R.id.bt6)},{(Button)findViewById(R.id.bt7),(Button)findViewById(R.id.bt8),(Button)findViewById(R.id.bt9) }};
        //buttons[0]= (Button)findViewById(R.id.bt1);


        buttons[0][0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                row1 =0; col1 = 0;
                dichuyen();
            }
        });
        buttons[0][1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                row1 =0; col1 = 1;
                dichuyen();
            }
        });
        buttons[0][2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                row1 =0; col1 = 2;
                dichuyen();
            }
        });
        buttons[1][0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                row1 =1; col1 = 0;
                dichuyen();
            }
        });
        buttons[1][1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                row1 =1; col1 = 1;
                dichuyen();
            }
        });
        buttons[1][2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                row1 =1; col1 = 2;
                dichuyen();
            }
        });
        buttons[2][0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                row1 =2; col1 = 0;
                dichuyen();
            }
        });
        buttons[2][1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                row1 =2; col1 = 1;
                dichuyen();
            }
        });
        buttons[2][2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                row1 =2; col1 = 2;
                dichuyen();
            }
        });

        Random random = new Random();
        int[] x = taoMangNgauNhien(8);
        for (int i = 0; i < 8; i++ )
            if (i<3)
        buttons[0][i%3].setText(x[i]+"");
            else
            if (i<6)
                buttons[1][i%3].setText(x[i]+"");
            else
                buttons[2][i%3].setText(x[i]+"");

        col =row=2;

//back home
        ActionBar actionbar = getSupportActionBar();
        if (actionbar != null) {
            actionbar.setDisplayHomeAsUpEnabled(true);
            actionbar.setHomeAsUpIndicator(R.drawable.back_home);
        }

        //xử lý loa
        load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer= MediaPlayer.create(BaxbaActivity.this,R.raw.nhacnen);
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.release();
                    mediaPlayer.pause();
                    load.setImageResource(R.drawable.ic_volume_off_black_24dp);
                }
                else {
                    mediaPlayer.start();
                    load.setImageResource(R.drawable.volume);
                }
                load.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(mediaPlayer.isPlaying()){
                            mediaPlayer.pause();
                            load.setImageResource(R.drawable.ic_volume_off_black_24dp);
                        }
                        else {
                            mediaPlayer.start();
                            load.setImageResource(R.drawable.volume);
                        }
                    }
                });
            }
        });
        onclick = false;
        if(onclick)
        animation = AnimationUtils.loadAnimation(this,R.anim.remove);
        else
            animation = AnimationUtils.loadAnimation(this, R.anim.remove_right);
        buttons[0][0].setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                v.setPadding(0,0,200,200);

                return false;
            }
        });


    }
}
