package com.example.memsl.myapplication;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class create_account extends AppCompatActivity {
    private EditText name,birthday,email,password,password_check;
    private RadioButton sexF,sexM;
    private RadioGroup radiosex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        getSupportActionBar().hide();//隱藏TitleBar

        name=(EditText)findViewById(R.id.edt_name);
        birthday=(EditText)findViewById(R.id.edt_bir);
        email=(EditText)findViewById(R.id.edt_mail);
        password=(EditText)findViewById(R.id.edt_psw);
        password_check=(EditText)findViewById(R.id.edt_checkpsw);
        sexM=(RadioButton)findViewById(R.id.radio_M);
        sexF=(RadioButton)findViewById(R.id.radio_F);
        radiosex = (RadioGroup)findViewById(R.id.radio_Sex);

    }

    public void clickCreate(View view)
    {
        int sexID=radiosex.getCheckedRadioButtonId();
        String Get_name=name.getText().toString();
        String Get_bir=birthday.getText().toString();
        String Get_email=email.getText().toString();
        String Get_password="";
        String Get_sex="";
        if(sexID==0)
            Get_sex="F";
        else
            Get_sex="M";

        //確認格式
        boolean check_Empty=name.getText().toString().matches("") || email.getText().toString().matches("")||password.getText().toString().matches("") || password_check.getText().toString().matches("");
        boolean check_pswEqual=password.getText().toString().equals(password_check.getText().toString());
        boolean check_emailRegExp=Get_email.matches("[a-zA-Z0-9._]+@([a-zA-Z0-9_]+.[a-zA-Z0-9_]+)+");
        boolean check_birthday=Get_bir.matches("[1-9]{4}-[0-1][0-9]-[0-9]{2}");

        if(check_Empty)
        {

            AlertDialog.Builder builder = new AlertDialog.Builder(create_account.this)
                    .setTitle("Error")
                    .setMessage("重要欄位不可為空")
                    .setPositiveButton("知道了", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
            builder.show();
        }else if(!check_pswEqual)
        {
            AlertDialog.Builder builder = new AlertDialog.Builder(create_account.this)
                    .setTitle("Error")
                    .setMessage("密碼確認錯誤\n請重新輸入")
                    .setPositiveButton("確認", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            password.setText("");
                            password_check.setText("");
                        }
                    });
            builder.show();
        } else if(!check_emailRegExp){
            AlertDialog.Builder builder = new AlertDialog.Builder(create_account.this)
                    .setTitle("Error")
                    .setMessage("信箱格式錯誤\n請按照參考格式重新輸入")
                    .setPositiveButton("確認", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            email.setText("");

                        }
                    });
            builder.show();

        } else if(!check_birthday)
            {
                AlertDialog.Builder builder = new AlertDialog.Builder(create_account.this)
                        .setTitle("Error")
                        .setMessage("生日格式錯誤\n請按照參考格式重新輸入")
                        .setPositiveButton("確認", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                birthday.setText("");
                            }
                        });
                builder.show();
            } else {
                Get_password=password.getText().toString();
                CreateAcc CA = new CreateAcc(this);
                CA.execute(Get_name, Get_sex, Get_bir, Get_email, Get_password);
            }
    }

    public void backtoHome(View view)
    {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
