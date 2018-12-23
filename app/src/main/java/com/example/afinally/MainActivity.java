package com.example.afinally;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button real;
    int con;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        real=(Button)findViewById(R.id.real);

    }
    public void start(View view){
        con=con+1;
        Intent it=new Intent(this,Main2Activity.class);
        startActivityForResult(it,100);
        if(con==6){
            real.setVisibility(View.VISIBLE);
        }
    }
    public void des(View view){
        AlertDialog.Builder bdr=new AlertDialog.Builder(this);
        bdr.setMessage("你是隻生活在雞舍的雞，為了不被吃掉，努力活下去吧!!\n" +
                "健康、精神、外貌會隨回答的選項上升或下降，其中一個到達0或100，將面臨殘酷的命運。");
        bdr.setTitle("遊戲說明:");
        bdr.setCancelable(true);
        bdr.show();
    }
    public void real(View view){
        Intent it=new Intent(this,Main4Activity.class);
        startActivityForResult(it,100);
    }
}
