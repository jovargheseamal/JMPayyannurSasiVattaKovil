package com.ciatlab.jmpayyannursasivattakovil;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.util.Log;

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

/**
 * Created by ADMIN on 27-04-2018.
 */

public class ComplaintRegisterClass extends AsyncTask<String,Void,String> {
    ProgressDialog p1;

    Context context;
    AlertDialog alertDialog;
    ComplaintRegisterClass(Context ctx) {
        context = ctx;
    }
    @Override
    protected String doInBackground(String... strings) {
        String Name= strings[0];
        String Phone= strings[1];
        String Email= strings[2];
        String Ward= strings[3];
        String Munciplality=strings[4] ;
        String Complaint= strings[5];
        String login_url = "http://janamythri.com/Payyannur/SasiVattakovil/mobileapi/complaint.php";

        try {
            URL url = new URL(login_url);
            HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            OutputStream outputStream = httpURLConnection.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
            String post_data = URLEncoder.encode("Name","UTF-8")+"="+URLEncoder.encode(Name,"UTF-8")+"&"
                    +URLEncoder.encode("EmailId","UTF-8")+"="+URLEncoder.encode(Email,"UTF-8")+"&"
                    +URLEncoder.encode("PhoneNo","UTF-8")+"="+URLEncoder.encode(Phone,"UTF-8")+"&"

                    +URLEncoder.encode("Wardno","UTF-8")+"="+URLEncoder.encode(Ward,"UTF-8")+"&"
                    +URLEncoder.encode("Muncipality","UTF-8")+"="+URLEncoder.encode(Munciplality,"UTF-8")+"&"
                    +URLEncoder.encode("Complaint","UTF-8")+"="+URLEncoder.encode(Complaint,"UTF-8");
            bufferedWriter.write(post_data);
            bufferedWriter.flush();
            bufferedWriter.close();
            outputStream.close();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
            String result="";
            String line="";
            while((line = bufferedReader.readLine())!= null) {
                result += line;
            }
            bufferedReader.close();
            inputStream.close();
            httpURLConnection.disconnect();
            return result;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }

    @Override
    protected void onPreExecute() {
         alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle("Status");
    }

    @Override
    protected void onPostExecute(String aVoid) {
         alertDialog.setMessage(aVoid);
        Log.e("Response",""+aVoid);
        alertDialog.show();


      //  TextView txtView = (TextView) ((Activity)context).findViewById(R.id.text);
     }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}


