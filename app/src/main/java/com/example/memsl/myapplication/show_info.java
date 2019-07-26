package com.example.memsl.myapplication;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class show_info extends AppCompatActivity {
    private TextView txt_info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_info);

        new catch_info().execute();
    }

    private class catch_info extends AsyncTask<String,Void,String>
    {



        @Override
        protected void onPreExecute()
        {
            txt_info = (TextView)findViewById(R.id.txt_info);

        }

        protected  void onPostExecute(String s)
        {
            txt_info.setText(s);
        }


        @Override
        protected String doInBackground(String... strings) {
            String result="";

            //String connstr="http://192.168.0.108:8080/psw_login.php";
            String connstr="http://192.168.0.108:8080//CatchDataTest.php";
            //String connstr="http://140.116.226.182/mems_client/355758080228806//psw_login.php";
            //String connstr="http://192.168.0.108:8080/CatchDataTest";

            try{
                URL url = new URL(connstr);
                HttpURLConnection http = (HttpURLConnection) url.openConnection();
                http.setRequestMethod("POST");
                http.setDoInput(true);
                http.setDoOutput(true);


                InputStream ips = http.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(ips,"ISO-8859-1"));
                String line="";
                while((line=reader.readLine()) != null) {
                    result += line;
                }
                reader.close();
                ips.close();
                http.disconnect();
                return result;
            }catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return result;
        }
    }
}


