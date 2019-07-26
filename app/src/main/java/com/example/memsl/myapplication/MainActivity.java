package com.example.memsl.myapplication;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private EditText account,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();//隱藏tTitleBar

        account = (EditText) findViewById(R.id.edt_act);
        password = (EditText)findViewById(R.id.edt_psw);
    }
    public void clickLogin(View view)
    {
        /*AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("資料");
        builder.setMessage("Your Account is\t"+account.getText()+"\nYour password is\t"+password.getText());
        builder.show();*/
        String act = account.getText().toString();
        String psw = password.getText().toString();
        //String act="yenwei";
        //String psw="xup6u04jo3";
        //String qrcode="123456";
        Login lg = new Login(this);
        lg.execute(act,psw);
        //lg.execute(" "," ");
    }
    public void clickCreateAccount(View view)
    {
        Intent intent = new Intent(this,create_account.class);
        startActivity(intent);
    }
    public void clickExit(View view)
    {
        android.os.Process.killProcess(android.os.Process.myPid());
    }
    public void clickTest(View view)
    {
        Intent intent = new Intent(this,show_info.class);
        startActivity(intent);

    }

    protected void onDestroy() {

        super.onDestroy();
        android.os.Process.killProcess(android.os.Process.myPid());
    }
}
