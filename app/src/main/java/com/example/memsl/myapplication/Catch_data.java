package com.example.memsl.myapplication;

import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class Catch_data extends AsyncTask<String,Void,String> {


    Context context;
    public Catch_data(Context context){this.context = context;}
    //AlertDialog dialog;

    @Override
    protected void onPreExecute()
    {
        //dialog = new AlertDialog.Builder(context).create();
        //dialog.setTitle("Catch Data");

    }

    protected  void onPostExecute(String s)
    {
        //dialog.show();
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
