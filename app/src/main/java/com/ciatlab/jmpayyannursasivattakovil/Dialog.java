package com.ciatlab.jmpayyannursasivattakovil;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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

public class Dialog extends Activity implements View.OnClickListener {
    Button log;
    EditText uname,pswd;
    String UserName,Password;
    SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_dialog);

        log = (Button) findViewById(R.id.log);
        uname = (EditText)findViewById(R.id.user);
        pswd = (EditText)findViewById(R.id.pwrd);

        log.setOnClickListener(Dialog.this);

    }

    @Override
        public void onClick(View v) {
                class GetJSON extends AsyncTask<String, Void, String> {

                    @Override
                    protected void onPreExecute() {

                    }

                    @Override
                    protected String doInBackground(String... strings) {
                        try {
                            UserName=uname.getText().toString();
                            Password=pswd.getText().toString();
                            // String UserName = uname.toString();
                            Log.e("Usernameeee",""+UserName);
                            Log.e("Usernameeeepas",""+Password);
                            String Comp_url = "http://janamythri.com/Payyannur/SasiVattakovil/mobileapi/login.php";
                            URL url = new URL(Comp_url);
                            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                            httpURLConnection.setRequestMethod("POST");
                            httpURLConnection.setDoOutput(true);
                            httpURLConnection.setDoInput(true);
                            OutputStream outputStream = httpURLConnection.getOutputStream();
                            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                            String post_data =
                                    URLEncoder.encode("UserName", "UTF-8")
                                            + "=" + URLEncoder.encode(UserName, "UTF-8")
                                            +"&"+URLEncoder.encode("Password","UTF-8")
                                            +"="+URLEncoder.encode(Password,"UTF-8");
                            bufferedWriter.write(post_data);
                            bufferedWriter.flush();
                            bufferedWriter.close();
                            outputStream.close();

                            InputStream is = httpURLConnection.getInputStream();
                            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
                            String line;
                            StringBuffer response = new StringBuffer();
                            while ((line = rd.readLine()) != null) {
                                response.append(line);
                                response.append('\n');
                            }
                            rd.close();
                            String jsonData = response.toString();

                            Log.e("jsonData", jsonData);
                            return response.toString();


                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        return null;
                    }


                    @Override
                    protected void onPostExecute(String s) {
                        String Resp=s;
                        Log.e("UsernameeeeSSSSS",""+s);
                        Log.e("UsernameeeeUserName",""+UserName);

                        if(Resp.trim().equals(UserName.trim()))
                        {Log.e("UsernameeeeEquals",""+UserName);
                            sp = getSharedPreferences("Login", Activity.MODE_PRIVATE);
                            SharedPreferences.Editor editor = sp.edit();
                            editor.putString("Username", s);
                            editor.putString("Password", pswd.toString());
                            editor.apply();
                            // second param is the value returned when 1st param value is not available in file
                            String Name = sp.getString("Name",null);
                            int phone_number = sp.getInt("Phone",0);
                            // Toast.makeText(LoginActivity.this,"Login Success",Toast.LENGTH_LONG).show();
                            Intent intent=new  Intent(Dialog.this,AdminActivity.class);
                            Toast.makeText(getApplicationContext(),"Login Success",Toast.LENGTH_LONG).show();
                            startActivity(intent);

                            finish();

                        }
                        else {
                            uname.getText().clear();
                            uname.setHint("Invalid Username or Password");
                            uname.setHintTextColor(getResources().getColor(R.color.Hint));
                            pswd.getText().clear();
                        }




                        // JSONObject obj = null;
/*
                        try {
                            JSONArray jArray = new JSONArray(s);
                            for (int i = 0; i < jArray.length(); i++) {
                                obj = jArray.getJSONObject(i);
                            }

                            if (obj != null) {
                                 String Name = obj.getString("Name");

                            }

                        } catch (Exception ee) {
                            ee.printStackTrace();
                        }
*/

                    }

                }
                GetJSON getJSON = new GetJSON();
                getJSON.execute();

            }
    void showToastMessage(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT)
                .show();
    }

    }



  /*  @Override
    public void onClick(View v) {
        Toast.makeText(getApplicationContext(),"NXT ACTIVITY", Toast.LENGTH_SHORT)
                .show();

    }
*/



