package com.example.memsl.myapplication;

import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;

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

public class CreateAcc extends AsyncTask<String,Void,String> {


    AlertDialog dialog;
    Context context;
    public CreateAcc(Context context){this.context = context;}

    @Override
    protected void onPreExecute()
    {
        dialog = new AlertDialog.Builder(context).create();
        dialog.setTitle("Login Result");
       //dialog.setMessage("Successful");

    }

    @Override
    protected void onPostExecute(String s)
    {
        dialog.setMessage(s);
        dialog.show();
    }
    @Override
    protected String doInBackground(String... data) {String result="";
        String name=data[0];
        String sex=data[1];
        String bir=data[2];
        String email=data[3];
        String password=data[4];

        String connstr="http://140.116.226.182/mems_client/355758080228806//create_account.php";
        //String connstr="http://192.168.0.108:8080/create_account.php";
        //String connstr="http://192.168.0.117/mySQL_exe/addInformation.php";
        //String connstr="http://192.168.0.108:8080/Login.php";
        try{
            URL url = new URL(connstr);
            HttpURLConnection http = (HttpURLConnection) url.openConnection();
            http.setRequestMethod("POST");
            http.setDoInput(true);
            http.setDoOutput(true);

            OutputStream ops = http.getOutputStream();
            BufferedWriter write = new BufferedWriter(new OutputStreamWriter(ops,"UTF-8"));

            String all_data = URLEncoder.encode("name","UTF-8")+"="+URLEncoder.encode(name,"UTF-8")
                    + "&&" +URLEncoder.encode("sex","UTF-8")+"="+URLEncoder.encode(sex,"UTF-8")
                    + "&&" +URLEncoder.encode("bir","UTF-8")+"="+URLEncoder.encode(bir,"UTF-8")
                    + "&&" +URLEncoder.encode("email","UTF-8")+"="+URLEncoder.encode(email,"UTF-8")
                    + "&&" +URLEncoder.encode("password","UTF-8")+"="+URLEncoder.encode(password,"UTF-8");

            //String all_data = URLEncoder.encode("addName","UTF-8")+"="+URLEncoder.encode(name,"UTF-8");

            write.write(all_data);
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
