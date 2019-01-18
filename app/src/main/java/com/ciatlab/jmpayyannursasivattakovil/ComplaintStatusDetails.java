package com.ciatlab.jmpayyannursasivattakovil;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

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

public class ComplaintStatusDetails extends AppCompatActivity {
    ProgressDialog p1;
    TextView Cname, email,phone, muncipaplity, ward;
    TextView status;
    String Token  ;
    Context ctx;
    String Comp_url;
    String jsonData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complaint_status_details);
        Bundle ab=getIntent().getExtras();
        if (ab != null) {
            Token=ab.getString("Token_Code");
        }
        Log.e("Token_Code",""+Token);

        //id = (EditText) findViewById(R.id.id);
        Cname = (TextView) findViewById(R.id.cname);
       phone = (TextView) findViewById(R.id.phone);
        email = (TextView) findViewById(R.id.email);
        muncipaplity = (TextView) findViewById(R.id.muncipal);
        status = (TextView) findViewById(R.id.statustxt);
        ward = (TextView) findViewById(R.id.ward);




        class GetJSON extends AsyncTask<String, Void, String> {

            @Override
            protected void onPreExecute() {
                p1=ProgressDialog.show(ComplaintStatusDetails.this,"Status ","Updating...");

            }

            @Override
            protected String doInBackground(String... strings) {
                try {
                    String Tokenid = Token;
                    Comp_url = "http://janamythri.com/Payyannur/SasiVattakovil/mobileapi/ComplaintReply.php";
                    URL url = new URL(Comp_url);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                    String post_data = URLEncoder.encode("TokenNo", "UTF-8") + "=" + URLEncoder.encode(Tokenid, "UTF-8");
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
                    jsonData = response.toString();

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
                p1.dismiss();
                JSONObject obj = null;
                // Log.e("idstatusss","onpostexecute");
                Log.e("idstatusss","ssssss"+s);
                if(!s.trim().equals("null")&&(!s.equals("[]"))) {


                    try {
                        JSONArray jArray = new JSONArray(s);
                        for (int i = 0; i < jArray.length(); i++) {
                            obj = jArray.getJSONObject(i);
                        }

                        if (obj != null) {
                            // String ID = obj.getString("Id");
                            Log.e("idstatusss", "objid" + obj.getString("Id"));
                            String Name = obj.getString("Name");
                            String PhoneNo = obj.getString("PhoneNo");
                            String EmailId = obj.getString("EmailId");
                            String Wardno = obj.getString("Wardno");
                            String Municipality = obj.getString("Muncipality");
                            String Status = obj.getString("Status");
                            // Log.e("array_in_app", String.valueOf(array_in_app.length()));

                            //  id.setText(ID);
                            Cname.setText(Name);
                            phone.setText(PhoneNo);
                            email.setText(EmailId);
                            ward.setText(Wardno);
                            muncipaplity.setText(Municipality);
                            if (!Status.equals("")) {
                                status.setText(Status);
                            }

                             else {
                                status.setText("Will be updated soon.....");
                            }


                        }

                    } catch (Exception ee) {
                        ee.printStackTrace();
                    }
                }
                else {
                    Toast.makeText(ComplaintStatusDetails.this, "Invalid Token", Toast.LENGTH_LONG).show();
                }

            }

        }
        GetJSON getJSON = new GetJSON();
        getJSON.execute();
    }

}


