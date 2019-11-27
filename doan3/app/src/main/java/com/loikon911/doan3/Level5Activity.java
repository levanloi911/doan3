package com.loikon911.doan3;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AbsoluteLayout;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Collections;


public class Level5Activity extends AppCompatActivity {
    private TextView moveCounter;
    MediaPlayer mediaPlayer;
    private TextView feedbackText;
    private Button[] buttons;
    CountDownTimer w;
    Dialog dialog;
    private Boolean bad_move=false;
    private static final Integer[] goal = new Integer[] {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48};
    private ArrayList<Integer> cells = new ArrayList<Integer>();
    ImageView load;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level5);
        Button mix = (Button)findViewById(R.id.start);
        load = (ImageView)findViewById(R.id.loa);
        Toolbar toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

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
        //back home
        Button back1 = (Button)findViewById(R.id.bacl);
        back1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                mediaPlayer.stop();
            }
        });

        random();
        mix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                random();
            }
        });

        //xử lý loa
                mediaPlayer= MediaPlayer.create(Level5Activity.this,R.raw.nhacnen);
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

        for (int i = 1; i < 49; i++) {
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
        for (int i = 0; i < 49; i++) {
            this.cells.add(i);
        }
        Collections.shuffle(this.cells); //random cells array
    }


    public Button[] findButtons() {
        Button[] b = new Button[49];

        b[0] = (Button) findViewById(R.id.bt0);
        b[1] = (Button) findViewById(R.id.bt1);
        b[2] = (Button) findViewById(R.id.bt2);
        b[3] = (Button) findViewById(R.id.bt3);
        b[4] = (Button) findViewById(R.id.bt4);
        b[5] = (Button) findViewById(R.id.bt5);
        b[6] = (Button) findViewById(R.id.bt6);
        b[7] = (Button) findViewById(R.id.bt7);
        b[8] = (Button) findViewById(R.id.bt8);
        b[9] = (Button) findViewById(R.id.bt9);
        b[10] = (Button) findViewById(R.id.bt10);
        b[11] = (Button) findViewById(R.id.bt11);
        b[12] = (Button) findViewById(R.id.bt12);
        b[13] = (Button) findViewById(R.id.bt13);
        b[14] = (Button) findViewById(R.id.bt14);
        b[15] = (Button) findViewById(R.id.bt15);
        b[16] = (Button) findViewById(R.id.bt16);
        b[17] = (Button) findViewById(R.id.bt17);
        b[18] = (Button) findViewById(R.id.bt18);
        b[19] = (Button) findViewById(R.id.bt19);
        b[20] = (Button) findViewById(R.id.bt20);
        b[21] = (Button) findViewById(R.id.bt21);
        b[22] = (Button) findViewById(R.id.bt22);
        b[23] = (Button) findViewById(R.id.bt23);
        b[24] = (Button) findViewById(R.id.bt24);
        b[25] = (Button) findViewById(R.id.bt25);
        b[26] = (Button) findViewById(R.id.bt26);
        b[27] = (Button) findViewById(R.id.bt27);
        b[28] = (Button) findViewById(R.id.bt28);
        b[29] = (Button) findViewById(R.id.bt29);
        b[30] = (Button) findViewById(R.id.bt30);
        b[31] = (Button) findViewById(R.id.bt31);
        b[32] = (Button) findViewById(R.id.bt32);
        b[33] = (Button) findViewById(R.id.bt33);
        b[34] = (Button) findViewById(R.id.bt34);
        b[35] = (Button) findViewById(R.id.bt35);
        b[36] = (Button) findViewById(R.id.bt36);
        b[37] = (Button) findViewById(R.id.bt37);
        b[38] = (Button) findViewById(R.id.bt38);
        b[39] = (Button) findViewById(R.id.bt39);
        b[40] = (Button) findViewById(R.id.bt40);
        b[41] = (Button) findViewById(R.id.bt41);
        b[42] = (Button) findViewById(R.id.bt42);
        b[43] = (Button) findViewById(R.id.bt43);
        b[44] = (Button) findViewById(R.id.bt44);
        b[45] = (Button) findViewById(R.id.bt45);
        b[46] = (Button) findViewById(R.id.bt46);
        b[47] = (Button) findViewById(R.id.bt47);
        b[48] = (Button) findViewById(R.id.bt48);


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
                if(b_pos==1||b_pos==7)
                    bad_move=false;
                break;
            case(1):
                if(b_pos==0||b_pos==2||b_pos==8)
                    bad_move=false;
                break;
            case(2):
                if(b_pos==1||b_pos==3||b_pos==9)
                    bad_move=false;
                break;
            case(3):
                if(b_pos==2||b_pos==4||b_pos==10)
                    bad_move=false;
                break;
            case(4):
                if(b_pos==3||b_pos==5||b_pos==11)
                    bad_move=false;
                break;
            case(5):
                if(b_pos==4||b_pos==12||b_pos==6)
                    bad_move=false;
                break;
            case(6):
                if(b_pos==5||b_pos==13)
                    bad_move=false;
                break;
            case(7):
                if(b_pos==0||b_pos==8)
                    bad_move=false;
                break;
            case(8):
                if(b_pos==1||b_pos==7||b_pos==9||b_pos==15)
                    bad_move=false;
                break;

            case(9):
                if(b_pos==2||b_pos==8||b_pos==16||b_pos==10)
                    bad_move=false;
                break;

            case(10):
                if(b_pos==3||b_pos==9||b_pos==17||b_pos==11)
                    bad_move=false;
                break;

            case(11):
                if(b_pos==4||b_pos==10||b_pos==18||b_pos==12)
                    bad_move=false;
                break;
            case(12):
                if(b_pos==5||b_pos==11||b_pos==19||b_pos==13)
                    bad_move=false;
                break;
            case(13):
                if(b_pos==6||b_pos==12||b_pos==20)
                    bad_move=false;
                break;
            case(14):
                if(b_pos==7||b_pos==15||b_pos==21)
                    bad_move=false;
                break;
            case(15):
                if(b_pos==8||b_pos==14||b_pos==22||b_pos==16)
                    bad_move=false;
                break;
            case(16):
                if(b_pos==9||b_pos==15||b_pos==23||b_pos==17)
                    bad_move=false;
                break;
            case(17):
                if(b_pos==10||b_pos==16||b_pos==24||b_pos==18)
                    bad_move=false;
                break;
            case(18):
                if(b_pos==11||b_pos==17||b_pos==25||b_pos==19)
                    bad_move=false;
                break;
            case(19):
                if(b_pos==12||b_pos==18||b_pos==26||b_pos==20)
                    bad_move=false;
                break;
            case(20):
                if(b_pos==13||b_pos==19||b_pos==27)
                    bad_move=false;
                break;
            case(21):
                if(b_pos==14||b_pos==22||b_pos==28)
                    bad_move=false;
                break;
            case(22):
                if(b_pos==21||b_pos==15||b_pos==23||b_pos==29)
                    bad_move=false;
                break;
            case(23):
                if(b_pos==22||b_pos==16||b_pos==24||b_pos==30)
                    bad_move=false;
                break;
            case(24):
                if(b_pos==23||b_pos==17||b_pos==31||b_pos==25)
                    bad_move=false;
                break;


            case(25):
                if(b_pos==24||b_pos==18||b_pos==32||b_pos==26)
                    bad_move=false;
                break;
            case(26):
                if(b_pos==25||b_pos==19||b_pos==33||b_pos==27)
                    bad_move=false;
                break;
            case(27):
                if(b_pos==20||b_pos==26||b_pos==34)
                    bad_move=false;
                break;
            case(28):
                if(b_pos==21||b_pos==35||b_pos==29)
                    bad_move=false;
                break;
            case(29):
                if(b_pos==22||b_pos==28||b_pos==30||b_pos==36)
                    bad_move=false;
                break;
            case(30):
                if(b_pos==23||b_pos==29||b_pos==31||b_pos==37)
                    bad_move=false;
                break;
            case(31):
                if(b_pos==24||b_pos==30||b_pos==32||b_pos==38)
                    bad_move=false;
                break;
            case(32):
                if(b_pos==25||b_pos==31||b_pos==33||b_pos==39)
                    bad_move=false;
                break;
            case(33):
                if(b_pos==26||b_pos==32||b_pos==34||b_pos==40)
                    bad_move=false;
                break;

            case(34):
                if(b_pos==27|b_pos==33||b_pos==41)
                    bad_move=false;
                break;

            case(35):
                if(b_pos==28||b_pos==36||b_pos==42)
                    bad_move=false;
                break;

            case(36):
                if(b_pos==29||b_pos==35||b_pos==37||b_pos==43)
                    bad_move=false;
                break;
            case(37):
                if(b_pos==30||b_pos==36||b_pos==38||b_pos==44)
                    bad_move=false;
                break;
            case(38):
                if(b_pos==31||b_pos==37||b_pos==39||b_pos==45)
                    bad_move=false;
                break;
            case(39):
                if(b_pos==32||b_pos==38||b_pos==40||b_pos==46)
                    bad_move=false;
                break;
            case(40):
                if(b_pos==33||b_pos==39||b_pos==41||b_pos==47)
                    bad_move=false;
                break;
            case(41):
                if(b_pos==34||b_pos==40||b_pos==48)
                    bad_move=false;
                break;
            case(42):
                if(b_pos==25||b_pos==43)
                    bad_move=false;
                break;
            case(43):
                if(b_pos==36||b_pos==42||b_pos==44)
                    bad_move=false;
                break;
            case(44):
                if(b_pos==37||b_pos==43||b_pos==45)
                    bad_move=false;
                break;
            case(45):
                if(b_pos==38||b_pos==44||b_pos==46)
                    bad_move=false;
                break;
            case(46):
                if(b_pos==39|b_pos==45||b_pos==47)
                    bad_move=false;
                break;
            case(47):
                if(b_pos==40||b_pos==46||b_pos==48)
                    bad_move=false;
                break;
            case(48):
                if(b_pos==41||b_pos==47)
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
        for(int i=0;i<49;i++)
        {
            if(cells.get(i)!=goal[i])
            {
                return;
            }
        }
        feedbackText.setText("we have a winner");
    }

    //set lại layout
    public void fill_grid() {
        for (int i = 0; i < 49; i++) {
            int text = cells.get(i);
            AbsoluteLayout.LayoutParams absParams = (AbsoluteLayout.LayoutParams) buttons[text].getLayoutParams();
            switch (i)
            //kiểm tra toạ độ x,y của một cái view
            // set lại layout cho cái view đó

            {
                case (0):
                    absParams.x = 0;
                    absParams.y = 0;
                    buttons[text].setLayoutParams(absParams);
                    break;

                case (1):
                    absParams.x = 50;
                    absParams.y = 0;
                    buttons[text].setLayoutParams(absParams);
                    break;

                case (2):
                    absParams.x = 100;
                    absParams.y = 0;
                    buttons[text].setLayoutParams(absParams);
                    break;

                case (3):
                    absParams.x = 150;
                    absParams.y = 0;
                    buttons[text].setLayoutParams(absParams);
                    break;

                case (4):
                    absParams.x = 200;
                    absParams.y = 0;
                    buttons[text].setLayoutParams(absParams);
                    break;

                case (5):
                    absParams.x = 250;
                    absParams.y = 0;
                    buttons[text].setLayoutParams(absParams);
                    break;

                case (6):
                    absParams.x = 300;
                    absParams.y = 0;
                    buttons[text].setLayoutParams(absParams);
                    break;

                //2

                case (7):
                    absParams.x = 0;
                    absParams.y = 50;
                    buttons[text].setLayoutParams(absParams);
                    break;

                case (8):
                    absParams.x = 50;
                    absParams.y = 50;
                    buttons[text].setLayoutParams(absParams);
                    break;

                case (9):
                    absParams.x = 100;
                    absParams.y = 50;
                    buttons[text].setLayoutParams(absParams);
                    break;

                case (10):
                    absParams.x = 150;
                    absParams.y = 50;
                    buttons[text].setLayoutParams(absParams);
                    break;

                case (11):
                    absParams.x = 200;
                    absParams.y = 50;
                    buttons[text].setLayoutParams(absParams);
                    break;

                case (12):
                    absParams.x = 250;
                    absParams.y = 50;
                    buttons[text].setLayoutParams(absParams);
                    break;

                case (13):
                    absParams.x = 300;
                    absParams.y = 50;
                    buttons[text].setLayoutParams(absParams);
                    break;

                //3
                case (14):
                    absParams.x = 0;
                    absParams.y = 100;
                    buttons[text].setLayoutParams(absParams);
                    break;

                case (15):
                    absParams.x = 50;
                    absParams.y = 100;
                    buttons[text].setLayoutParams(absParams);
                    break;

                case (16):
                    absParams.x = 100;
                    absParams.y = 100;
                    buttons[text].setLayoutParams(absParams);
                    break;

                case (17):
                    absParams.x = 150;
                    absParams.y = 100;
                    buttons[text].setLayoutParams(absParams);
                    break;

                case (18):
                    absParams.x = 200;
                    absParams.y = 100;
                    buttons[text].setLayoutParams(absParams);
                    break;

                case (19):
                    absParams.x = 250;
                    absParams.y = 100;
                    buttons[text].setLayoutParams(absParams);
                    break;

                case (20):
                    absParams.x = 300;
                    absParams.y = 100;
                    buttons[text].setLayoutParams(absParams);
                    break;

                //4
                case (21):
                    absParams.x = 0;
                    absParams.y = 150;
                    buttons[text].setLayoutParams(absParams);
                    break;

                case (22):
                    absParams.x = 50;
                    absParams.y = 150;
                    buttons[text].setLayoutParams(absParams);
                    break;

                case (23):
                    absParams.x = 100;
                    absParams.y = 150;
                    buttons[text].setLayoutParams(absParams);
                    break;

                case (24):
                    absParams.x = 150;
                    absParams.y = 150;
                    buttons[text].setLayoutParams(absParams);
                    break;

                case (25):
                    absParams.x = 200;
                    absParams.y = 150;
                    buttons[text].setLayoutParams(absParams);
                    break;

                case (26):
                    absParams.x = 250;
                    absParams.y = 150;
                    buttons[text].setLayoutParams(absParams);
                    break;

                case (27):
                    absParams.x = 300;
                    absParams.y = 150;
                    buttons[text].setLayoutParams(absParams);
                    break;
                //5
                case (28):
                    absParams.x = 0;
                    absParams.y = 200;
                    buttons[text].setLayoutParams(absParams);
                    break;

                case (29):
                    absParams.x = 50;
                    absParams.y = 200;
                    buttons[text].setLayoutParams(absParams);
                    break;

                case (30):
                    absParams.x = 100;
                    absParams.y = 200;
                    buttons[text].setLayoutParams(absParams);
                    break;

                case (31):
                    absParams.x = 150;
                    absParams.y = 200;
                    buttons[text].setLayoutParams(absParams);
                    break;

                case (32):
                    absParams.x = 200;
                    absParams.y = 200;
                    buttons[text].setLayoutParams(absParams);
                    break;

                case (33):
                    absParams.x = 250;
                    absParams.y = 200;
                    buttons[text].setLayoutParams(absParams);
                    break;

                case (34):
                    absParams.x = 300;
                    absParams.y = 200;
                    buttons[text].setLayoutParams(absParams);
                    break;

                    //6


                case (35):
                    absParams.x = 0;
                    absParams.y = 250;
                    buttons[text].setLayoutParams(absParams);
                    break;

                case (36):
                    absParams.x = 50;
                    absParams.y = 250;
                    buttons[text].setLayoutParams(absParams);
                    break;

                case (37):
                    absParams.x = 100;
                    absParams.y = 250;
                    buttons[text].setLayoutParams(absParams);
                    break;

                case (38):
                    absParams.x = 150;
                    absParams.y = 250;
                    buttons[text].setLayoutParams(absParams);
                    break;

                case (39):
                    absParams.x = 200;
                    absParams.y = 250;
                    buttons[text].setLayoutParams(absParams);
                    break;

                case (40):
                    absParams.x = 250;
                    absParams.y = 250;
                    buttons[text].setLayoutParams(absParams);
                    break;

                case (41):
                    absParams.x = 300;
                    absParams.y = 250;
                    buttons[text].setLayoutParams(absParams);
                    break;

                    //7

                case (42):
                    absParams.x = 0;
                    absParams.y = 300;
                    buttons[text].setLayoutParams(absParams);
                    break;

                case (43):
                    absParams.x = 50;
                    absParams.y = 300;
                    buttons[text].setLayoutParams(absParams);
                    break;

                case (44):
                    absParams.x = 100;
                    absParams.y = 300;
                    buttons[text].setLayoutParams(absParams);
                    break;

                case (45):
                    absParams.x = 150;
                    absParams.y = 300;
                    buttons[text].setLayoutParams(absParams);
                    break;

                case (46):
                    absParams.x = 200;
                    absParams.y = 300;
                    buttons[text].setLayoutParams(absParams);
                    break;

                case (47):
                    absParams.x = 250;
                    absParams.y = 300;
                    buttons[text].setLayoutParams(absParams);
                    break;

                case (48):
                    absParams.x = 300;
                    absParams.y = 300;
                    buttons[text].setLayoutParams(absParams);
                    break;

            }

        }
    }

    public int find_pos(int element)
    {
        int i=0;
        for(i=0;i<49;i++)
        {
            if(cells.get(i)==element)
            {
                break;
            }
        }
        return i;
    }
    public void Ketthuc() {
        AlertDialog.Builder builder = new AlertDialog.Builder(Level5Activity.this, android.R.style.Theme_DeviceDefault_Dialog);
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







