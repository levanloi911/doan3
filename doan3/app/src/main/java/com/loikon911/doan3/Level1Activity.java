package com.loikon911.doan3;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AbsoluteLayout;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;


public class Level1Activity extends AppCompatActivity {
    private TextView moveCounter;
    private Dialog dialog;
    CountDownTimer w;
    MediaPlayer mediaPlayer;
    private TextView feedbackText;
    private Button[] buttons;
    private Boolean bad_move=false;
    private static final Integer[] goal = new Integer[] {0,1,2,3,4,5,6,7,8};
    private ArrayList<Integer> cells = new ArrayList<Integer>();
    ImageView load;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_1);
        Button mix = (Button)findViewById(R.id.start);
        Button back1 = (Button)findViewById(R.id.bacl);
        back1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                mediaPlayer.stop();
            }
        });

        // Thời gian
        final TextView tv1 = (TextView) findViewById(R.id.tv);
        w = new CountDownTimer(600000, 1000) {
            public void onTick(long mil) {
                tv1.setText("Seconds remaining: " + mil / 1000);
            }

            public void onFinish() {
                tv1.setText("Seconds remaining: 0");
                Ketthuc();

            }
        }.start();

        load = (ImageView)findViewById(R.id.loa);
        Toolbar toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

        //radom arr
        random();
        mix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Collections.shuffle(cells); //random cells array
                fill_grid();
            }
        });

        //loa
                mediaPlayer= MediaPlayer.create(Level1Activity.this,R.raw.nhacnen);
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


        buttons=findButtons();

        fill_grid();



        moveCounter = (TextView) findViewById(R.id.MoveCounter);
        feedbackText = (TextView) findViewById(R.id.FeedbackText);

        for (int i = 1; i < 9; i++) {
            buttons[i].setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    makeMove((Button) v);
                }
            });
        }
        moveCounter.setText("0");
        feedbackText.setText(R.string.game_feedback_text);
        feedbackText.setTextColor(Color.BLUE);

    }
    private void random() {
        for (int i = 0; i < 9; i++) {
            this.cells.add(i);
        }
        Collections.shuffle(this.cells); //random cells array
    }


    public Button[] findButtons() {
        Button[] b = new Button[9];
        b[0] = (Button) findViewById(R.id.Button00);
        b[1] = (Button) findViewById(R.id.Button01);
        b[2] = (Button) findViewById(R.id.Button02);
        b[3] = (Button) findViewById(R.id.Button03);
        b[4] = (Button) findViewById(R.id.Button04);
        b[5] = (Button) findViewById(R.id.Button05);
        b[6] = (Button) findViewById(R.id.Button06);
        b[7] = (Button) findViewById(R.id.Button07);
        b[8] = (Button) findViewById(R.id.Button08);
        return b;
    }
        public void makeMove(final Button b) {
        bad_move=true;
        int b_text,b_pos,zuk_pos;
        b_text=Integer.parseInt((String) b.getText());
        b_pos=find_pos(b_text);
        zuk_pos=find_pos(0);
        switch(zuk_pos)
        {
            case(0):
                if(b_pos==1||b_pos==3)
                    bad_move=false;
                break;
            case(1):
                if(b_pos==0||b_pos==2||b_pos==4)
                    bad_move=false;
                break;
            case(2):
                if(b_pos==1||b_pos==5)
                    bad_move=false;
                break;
            case(3):
                if(b_pos==0||b_pos==4||b_pos==6)
                    bad_move=false;
                break;
            case(4):
                if(b_pos==1||b_pos==3||b_pos==5||b_pos==7)
                    bad_move=false;
                break;
            case(5):
                if(b_pos==2||b_pos==4||b_pos==8)
                    bad_move=false;
                break;
            case(6):
                if(b_pos==3||b_pos==7)
                    bad_move=false;
                break;
            case(7):
                if(b_pos==4||b_pos==6||b_pos==8)
                    bad_move=false;
                break;
            case(8):
                if(b_pos==5||b_pos==7)
                    bad_move=false;
                break;
        }

        if(bad_move==true)
        {
            feedbackText.setText("Move Not Allowed");
            feedbackText.setTextColor(Color.RED);
            return;
        }
        feedbackText.setText("Move OK");
        feedbackText.setTextColor(Color.GREEN);
        cells.remove(b_pos);
        cells.add(b_pos, 0);
        cells.remove(zuk_pos);
        cells.add(zuk_pos,b_text);


        fill_grid();
        moveCounter.setText(Integer.toString(Integer.parseInt((String) moveCounter.getText())+1));

        //check win
        for(int i=0;i<9;i++)
        {
            if(cells.get(i)!=goal[i])
            {
                return;
            }
        }
        feedbackText.setText("we have a winner");
        Intent  intent = new Intent(Level1Activity.this, Level2Activity.class);
        Level1Activity.this.startActivity(intent);

    }

    public void fill_grid() {
        for (int i = 0; i < 9; i++) {
            int text = cells.get(i);
            AbsoluteLayout.LayoutParams absParams = (AbsoluteLayout.LayoutParams) buttons[text].getLayoutParams();
            switch (i)
            //kiểm tra toạ độ x,y của một cái view
            // set lại layout cho cái view đó

            {
                case (0):
                    absParams.x = 5;
                    absParams.y = 5;
                    buttons[text].setLayoutParams(absParams);
                    break;
                case (1):
                    absParams.x = 110;
                    absParams.y = 5;
                    buttons[text].setLayoutParams(absParams);
                    break;
                case (2):

                    absParams.x = 215;
                    absParams.y = 5;
                    buttons[text].setLayoutParams(absParams);
                    break;
                case (3):

                    absParams.x = 5;
                    absParams.y = 110;
                    buttons[text].setLayoutParams(absParams);
                    break;
                case (4):

                    absParams.x = 110;
                    absParams.y = 110;
                    buttons[text].setLayoutParams(absParams);
                    break;
                case (5):

                    absParams.x = 215;
                    absParams.y = 110;
                    buttons[text].setLayoutParams(absParams);
                    break;
                case (6):

                    absParams.x = 5;
                    absParams.y = 215;
                    buttons[text].setLayoutParams(absParams);
                    break;
                case (7):

                    absParams.x = 110;
                    absParams.y = 215;
                    buttons[text].setLayoutParams(absParams);
                    break;
                case (8):

                    absParams.x = 215;
                    absParams.y = 215;
                    buttons[text].setLayoutParams(absParams);
                    break;


            }

        }
    }

        public int find_pos(int element)
    {
        int i=0;
        for(i=0;i<9;i++)
        {
            if(cells.get(i)==element)
            {
                break;
            }
        }
        return i;
    }
    public void Ketthuc() {
            AlertDialog.Builder builder = new AlertDialog.Builder(Level1Activity.this, android.R.style.Theme_DeviceDefault_Dialog);
            builder.setTitle("Bạn đã thua cuộc");
            builder.setMessage("Hãy lựa chọn bên dưới để xác nhân");
            builder.setIcon(android.R.drawable.ic_notification_overlay);
            builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    onBackPressed();
                }
            });
            dialog.setCanceledOnTouchOutside(false);
            builder.show();
    }
}











