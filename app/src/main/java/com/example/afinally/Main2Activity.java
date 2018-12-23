package com.example.afinally;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Main2Activity extends AppCompatActivity {

    String[] ques={"外面陽光普照，農場主人打開大門讓我們出去透透氣，你決定",
                    "雞舍突然換了新飼料，其他雞都不吃，你",
                    "一個小孩跑進來抓你翅膀，你",
                    "一隻雞突然攻擊你，你",
                    "喝了雞舍的水好像有怪怪的味道，你",
                    "有隻發神經的雞不停亂叫，讓你無法入睡",
                    "今天下雨，一群雞在雨中玩耍",
                    "聽說隔壁棚的竹鼠過得很苦",
                    "一隻小貓跑進了雞舍",
                    "今天氣晴"};
    String[] anser={"1.不去 ,2.去",
                    "1.吃 ,2.不吃",
                    "1.咬他 ,2.任由他處置",
                    "1.打回去 ,2.快跑",
                    "1.停下不喝 ,2.繼續喝",
                    "1.以和為貴，不去理他 ,2.讓他閉嘴，再也無法出聲",
                    "1.像傻逼一樣加入她們 ,2.在雞舍中休息、打理自己",
                    "1.竹鼠是什麼，可以吃嗎 ,2.想著自己是否跟他們一樣",
                    "1.用土和草隱藏自己 ,2.不理會他",
                    "1.天氣真好，好好活動活動 ,2.天氣不重要，重點要如何讓小美注意到我"};
    TextView hpt,mpt,apt,que,cod;
    SeekBar hp,mp,ap;
    Button ansb;
    int hpc=50,mpc=50,apc=50,num,count=0,end;
    int ahp,amp,aap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        hpt=(TextView)findViewById(R.id.hpt);
        mpt=(TextView)findViewById(R.id.mpt);
        apt=(TextView)findViewById(R.id.apt);
        que=(TextView)findViewById(R.id.que);
        hp=(SeekBar)findViewById(R.id.hp);
        mp=(SeekBar)findViewById(R.id.mp);
        ap=(SeekBar)findViewById(R.id.ap);
        ansb=(Button)findViewById(R.id.ansb);
        show();
        rou();
        loop();
    }

    private void rou(){
        Random x=new Random();
        num=x.nextInt(10);
        que.setText(ques[num]);
    }
    public void loop(){
        if(ansb!=null){
            ansb.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final AlertDialog.Builder dialog=new AlertDialog.Builder(Main2Activity.this);
                    dialog.setTitle("回答選項");
                    dialog.setMessage(anser[num]);

                    dialog.setNeutralButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(Main2Activity.this,"取消回答",Toast.LENGTH_SHORT).show();
                        }
                    });

                    dialog.setNegativeButton("回答1", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            setans1();
                            count++;
                        }
                    });

                    dialog.setPositiveButton("回答2", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            setans2();
                            count++;
                        }
                    });
                    dialog.show();
                }
            });
        }
    }
    private void setans1(){
        switch (num){
            case 0:
                ahp=-20;
                amp=-10;
                aap=10;
                break;
            case 1:
                ahp=30;
                amp=-20;
                aap=30;
                break;
            case 2:
                ahp=-10;
                amp=20;
                aap=10;
                break;
            case 3:
                ahp=-10;
                amp=20;
                aap=-20;
                break;
            case 4:
                ahp=10;
                amp=-20;
                aap=-30;
                break;
            case 5:
                ahp=0;
                amp=-30;
                aap=0;
                break;
            case 6:
                ahp=-30;
                amp=0;
                aap=0;
                break;
            case 7:
                ahp=30;
                amp=0;
                aap=0;
                break;
            case 8:
                ahp=0;
                amp=0;
                aap=-30;
                break;
            case 9:
                ahp=0;
                amp=30;
                aap=0;
                break;
        }
        hpc=hpc+ahp;
        mpc=mpc+amp;
        apc=apc+aap;
        think();
        show();
        rou();
    }
    private void setans2(){
        switch (num){
            case 0:
                ahp=20;
                amp=20;
                aap=-20;
                break;
            case 1:
                ahp=-10;
                amp=10;
                aap=10;
                break;
            case 2:
                ahp=-40;
                amp=-30;
                aap=-30;
                break;
            case 3:
                ahp=-20;
                amp=-20;
                aap=20;
                break;
            case 4:
                ahp=50;
                amp=30;
                aap=40;
                break;
            case 5:
                ahp=0;
                amp=30;
                aap=0;
                break;
            case 6:
                ahp=0;
                amp=0;
                aap=30;
                break;
            case 7:
                ahp=0;
                amp=-30;
                aap=0;
                break;
            case 8:
                ahp=-30;
                amp=0;
                aap=0;
                break;
            case 9:
                ahp=0;
                amp=0;
                aap=30;
                break;
        }
        hpc=hpc+ahp;
        mpc=mpc+amp;
        apc=apc+aap;
        think();
        show();
        rou();
    }
    private void think(){
        if(count >=10)
        {
            Intent it=new Intent(this,Main4Activity.class);
            startActivityForResult(it,100);
            finish();
        }
        if((hpc>=100)||(hpc<=0)||(mpc>=100)||(mpc<=0)||(apc>=100)||(apc<=0)){
            if(hpc>=100){end=0;}
            else if(hpc<=0){end=1;}
            else if(mpc>=100){end=2;}
            else if(mpc<=0){end=3;}
            else if(apc>=100){end=4;}
            else{end=5;}
            Intent it=new Intent(this,Main3Activity.class);
            Bundle bundle=new Bundle();
            bundle.putInt("END",end);
            it.putExtras(bundle);
            startActivityForResult(it,100);
            finish();
        }
    }
    private void show(){
        hp.setProgress(hpc);
        mp.setProgress(mpc);
        ap.setProgress(apc);
        hpt.setText(""+hpc);
        mpt.setText(""+mpc);
        apt.setText(""+apc);
    }
}

