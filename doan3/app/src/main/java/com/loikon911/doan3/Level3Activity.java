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


public class Level3Activity extends AppCompatActivity {
    private TextView moveCounter;
    MediaPlayer mediaPlayer;
    private TextView feedbackText;
    CountDownTimer w;
    private Button[] buttons;
    Dialog dialog;
    private Boolean bad_move=false;
    private static final Integer[] goal = new Integer[] {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24};
    private ArrayList<Integer> cells = new ArrayList<Integer>();
    ImageView load;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level3);

        //back home
        Button back1 = (Button)findViewById(R.id.bacl);
        back1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                mediaPlayer.stop();
            }
        });

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
        ActionBar actionbar = getSupportActionBar();
        if (actionbar != null) {
            actionbar.setDisplayHomeAsUpEnabled(true);
            actionbar.setHomeAsUpIndicator(R.drawable.back_home);
        }
        random();


        mix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Collections.shuffle(cells); //random cells array
                fill_grid();
            }
        });

        //xử lý loa

                mediaPlayer= MediaPlayer.create(Level3Activity.this,R.raw.nhacnen);
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

        for (int i = 1; i < 25; i++) {
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
        for (int i = 0; i < 25; i++) {
            this.cells.add(i);
        }
        Collections.shuffle(this.cells); //random cells array
    }


    public Button[] findButtons() {
        Button[] b = new Button[25];

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
                if(b_pos==1||b_pos==5)
                    bad_move=false;
                break;
            case(1):
                if(b_pos==0||b_pos==2||b_pos==6)
                    bad_move=false;
                break;
            case(2):
                if(b_pos==1||b_pos==3||b_pos==7)
                    bad_move=false;
                break;
            case(3):
                if(b_pos==2||b_pos==4||b_pos==8)
                    bad_move=false;
                break;
            case(4):
                if(b_pos==3||b_pos==9)
                    bad_move=false;
                break;
            case(5):
                if(b_pos==0||b_pos==6||b_pos==10)
                    bad_move=false;
                break;
            case(6):
                if(b_pos==1||b_pos==5||b_pos==7||b_pos==11)
                    bad_move=false;
                break;
            case(7):
                if(b_pos==2||b_pos==6||b_pos==8||b_pos==12)
                    bad_move=false;
                break;
            case(8):
                if(b_pos==3||b_pos==7||b_pos==9||b_pos==13)
                    bad_move=false;
                break;

            case(9):
                if(b_pos==4||b_pos==8||b_pos==14)
                    bad_move=false;
                break;

            case(10):
                if(b_pos==5||b_pos==11||b_pos==15)
                    bad_move=false;
                break;

            case(11):
                if(b_pos==6||b_pos==10||b_pos==12||b_pos==16)
                    bad_move=false;
                break;
            case(12):
                if(b_pos==7||b_pos==11||b_pos==13||b_pos==17)
                    bad_move=false;
                break;
            case(13):
                if(b_pos==8||b_pos==12||b_pos==14||b_pos==18)
                    bad_move=false;
                break;
            case(14):
                if(b_pos==9||b_pos==13||b_pos==19)
                    bad_move=false;
                break;
            case(15):
                if(b_pos==10||b_pos==16||b_pos==20)
                    bad_move=false;
                break;
            case(16):
                if(b_pos==11||b_pos==15||b_pos==17||b_pos==21)
                    bad_move=false;
                break;
            case(17):
                if(b_pos==12||b_pos==16||b_pos==18||b_pos==22)
                    bad_move=false;
                break;
            case(18):
                if(b_pos==13||b_pos==17||b_pos==19||b_pos==23)
                    bad_move=false;
                break;
            case(19):
                if(b_pos==14||b_pos==18||b_pos==24)
                    bad_move=false;
                break;
            case(20):
                if(b_pos==15||b_pos==21)
                    bad_move=false;
                break;
            case(21):
                if(b_pos==16||b_pos==20||b_pos==22)
                    bad_move=false;
                break;
            case(22):
                if(b_pos==17||b_pos==21||b_pos==23)
                    bad_move=false;
                break;
            case(23):
                if(b_pos==18||b_pos==22||b_pos==24)
                    bad_move=false;
                break;
            case(24):
                if(b_pos==19||b_pos==23)
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
        for(int i=0;i<25;i++)
        {
            if(cells.get(i)!=goal[i])
            {
                return;
            }
        }
        feedbackText.setText("we have a winner");
    }

//đặt lại button trên layout
    public void fill_grid() {
        for (int i = 0; i < 25; i++) {
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
                    absParams.x = 65;
                    absParams.y = 0;
                    buttons[text].setLayoutParams(absParams);
                    break;

                case (2):
                    absParams.x = 130;
                    absParams.y = 0;
                    buttons[text].setLayoutParams(absParams);
                    break;

                case (3):
                    absParams.x = 195;
                    absParams.y = 0;
                    buttons[text].setLayoutParams(absParams);
                    break;

                case (4):
                    absParams.x = 260;
                    absParams.y = 0;
                    buttons[text].setLayoutParams(absParams);
                    break;

                    //2

                case (5):
                    absParams.x = 0;
                    absParams.y = 65;
                    buttons[text].setLayoutParams(absParams);
                    break;

                case (6):
                    absParams.x = 65;
                    absParams.y = 65;
                    buttons[text].setLayoutParams(absParams);
                    break;

                case (7):
                    absParams.x = 130   ;
                    absParams.y = 65;
                    buttons[text].setLayoutParams(absParams);
                    break;

                case (8):
                    absParams.x = 195;
                    absParams.y = 65;
                    buttons[text].setLayoutParams(absParams);
                    break;

                case (9):
                    absParams.x = 260;
                    absParams.y = 65;
                    buttons[text].setLayoutParams(absParams);
                    break;

                    //3
                case (10):
                    absParams.x = 0;
                    absParams.y = 130;
                    buttons[text].setLayoutParams(absParams);
                    break;

                case (11):
                    absParams.x = 65;
                    absParams.y = 130;
                    buttons[text].setLayoutParams(absParams);
                    break;

                case (12):
                    absParams.x = 130;
                    absParams.y = 130;
                    buttons[text].setLayoutParams(absParams);
                    break;

                case (13):
                    absParams.x = 195;
                    absParams.y = 130;
                    buttons[text].setLayoutParams(absParams);
                    break;

                case (14):
                    absParams.x = 260;
                    absParams.y = 130;
                    buttons[text].setLayoutParams(absParams);
                    break;


                //4
                case (15):
                    absParams.x = 0;
                    absParams.y = 195;
                    buttons[text].setLayoutParams(absParams);
                    break;

                case (16):
                    absParams.x = 65;
                    absParams.y = 195;
                    buttons[text].setLayoutParams(absParams);
                    break;

                case (17):
                    absParams.x = 130;
                    absParams.y = 195;
                    buttons[text].setLayoutParams(absParams);
                    break;

                case (18):
                    absParams.x = 195;
                    absParams.y = 195;
                    buttons[text].setLayoutParams(absParams);
                    break;

                case (19):
                    absParams.x = 260;
                    absParams.y = 195;
                    buttons[text].setLayoutParams(absParams);
                    break;

                //5
                case (20):
                    absParams.x = 0;
                    absParams.y = 260;
                    buttons[text].setLayoutParams(absParams);
                    break;

                case (21):
                    absParams.x = 65;
                    absParams.y = 260;
                    buttons[text].setLayoutParams(absParams);
                    break;

                case (22):
                    absParams.x = 130;
                    absParams.y = 260;
                    buttons[text].setLayoutParams(absParams);
                    break;

                case (23):
                    absParams.x = 195;
                    absParams.y = 260;
                    buttons[text].setLayoutParams(absParams);
                    break;

                case (24):
                    absParams.x = 260;
                    absParams.y = 260;
                    buttons[text].setLayoutParams(absParams);
                    break;



            }

        }
    }

    public int find_pos(int element)
    {
        int i=0;
        for(i=0;i<25;i++)
        {
            if(cells.get(i)==element)
            {
                break;
            }
        }
        return i;
    }
    public void Ketthuc() {
        AlertDialog.Builder builder = new AlertDialog.Builder(Level3Activity.this, android.R.style.Theme_DeviceDefault_Dialog);
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







