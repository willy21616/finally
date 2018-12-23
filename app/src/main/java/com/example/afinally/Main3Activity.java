package com.example.afinally;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Main3Activity extends AppCompatActivity {

    TextView showend;
    Button endb;
    ImageView imv;
    int end;
    String[] ends={"你看這隻雞雖然很健康，但吃太多啦，在這樣養下去不划算是不行的，不如我們拿他來做土窯雞吧!",
                    "這隻雞滿身是傷，不值得醫，不如我們把它做成三杯雞",
                    "這隻雞太有活力了，這樣下去會打傷其他雞，不如我們今天吃麻油雞吧",
                    "你看這隻雞一動也不動，一直縮在牆角，看來是得了憂鬱症拉，這樣下去是不行的，不如我們拿它來做鹽酥雞吧!",
                    "這隻雞真漂亮，適合拿來見客，今天有客人，不如就把你烤了",
                    "你看這隻雞長太醜拉，這會沒人買的，這樣下去是不行的，不如我們把它燉成雞湯吧!"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        showend=(TextView)findViewById(R.id.showend);
        endb=(Button)findViewById(R.id.endb);
        imv=(ImageView)findViewById(R.id.imv);

        Intent it=getIntent();
        Bundle bundle=it.getExtras();
        end=bundle.getInt("END");
        showend.setText(ends[end]);

        switch (end){
            case 0:
                imv.setImageResource(R.drawable.t03);
                break;
            case 1:
                imv.setImageResource(R.drawable.t05);
                break;
            case 2:
                imv.setImageResource(R.drawable.t06);
                break;
            case 3:
                imv.setImageResource(R.drawable.t02);
                break;
            case 4:
                imv.setImageResource(R.drawable.t07);
                break;
            case 5:
                imv.setImageResource(R.drawable.t04);
                break;
        }
    }
    public void gob(View view){
        finish();
    }

}
