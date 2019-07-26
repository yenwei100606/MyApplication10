package com.example.memsl.myapplication;

/*正確
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.MalformedParameterizedTypeException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class Login extends AsyncTask <String,Void,String> {
    AlertDialog dialog;
    Context context;
    public Login(Context context){this.context = context;}

    @Override
    protected void onPreExecute()
    {
        dialog = new AlertDialog.Builder(context).create();
        dialog.setTitle("Login Result");
        //dialog.setMessage("Successful");
    }

    protected  void onPostExecute(String s)
    {
        dialog.setMessage(s);
        dialog.show();

        if(s.contains("successful"))
        {

        }

    }

    @Override
    protected String doInBackground(String... voids) {
        String result="";
        String user=voids[0];
        String pass=voids[1];

        //String connstr="http://192.168.0.108:8080/psw_login.php";
        String connstr="http://192.168.0.108:8080/CatchDataTest.php";
       // String connstr="http://140.116.226.182/mems_client/355758080228806//psw_login.php";

        try{
            URL url = new URL(connstr);
            HttpURLConnection http = (HttpURLConnection) url.openConnection();
            http.setRequestMethod("POST");
            http.setDoInput(true);
            http.setDoOutput(true);

            OutputStream ops = http.getOutputStream();
            BufferedWriter write = new BufferedWriter(new OutputStreamWriter(ops,"UTF-8"));
            String data = URLEncoder.encode("user","UTF-8")+"="+URLEncoder.encode(user,"UTF-8")
                       + "&&" +URLEncoder.encode("pass","UTF-8")+"="+URLEncoder.encode(pass,"UTF-8");

            write.write(data);
            write.flush();
            write.close();
            ops.close();

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


}*/

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.MalformedParameterizedTypeException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class Login extends AsyncTask <String,Void,String> {
    AlertDialog dialog;
    Context context;
    public Login(Context context){this.context = context;}

    @Override
    protected void onPreExecute()
    {
        dialog = new AlertDialog.Builder(context).create();
        dialog.setTitle("Catch Data");
        //dialog.setMessage("Successful");
    }

    protected  void onPostExecute(String s)
    {
        dialog.setMessage(s);
        dialog.show();


    }

    @Override
    protected String doInBackground(String... voids) {
        String result="";
        String user=voids[0];
        String pass=voids[1];

        //String connstr="http://192.168.0.108:8080/psw_login.php";
        String connstr="http://192.168.0.108:8080/psw_login.php";
        //String connstr="http://140.116.226.182/mems_client/355758080228806//psw_login.php";
        //String connstr="http://192.168.0.108:8080/CatchDataTest";

        try{
            URL url = new URL(connstr);
            HttpURLConnection http = (HttpURLConnection) url.openConnection();
            http.setRequestMethod("POST");
            http.setDoInput(true);
            http.setDoOutput(true);

            OutputStream ops = http.getOutputStream();
            BufferedWriter write = new BufferedWriter(new OutputStreamWriter(ops,"UTF-8"));
            String data = URLEncoder.encode("user","UTF-8")+"="+URLEncoder.encode(user,"UTF-8")
                    + "&&" +URLEncoder.encode("pass","UTF-8")+"="+URLEncoder.encode(pass,"UTF-8");

            write.write(data);
            write.flush();
            write.close();
            ops.close();

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



