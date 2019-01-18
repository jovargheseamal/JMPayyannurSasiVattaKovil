package com.ciatlab.jmpayyannursasivattakovil;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
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
import java.util.Objects;

public class ShowComplaint2Activity extends AppCompatActivity {
    String id,STS;
    TextView Sname,phoneno,Email,Wardno,muncipality,Status;
    Button StatusButton;
    LinearLayout L;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_show_complaint2);
        Sname=(TextView)findViewById(R.id.cname);
        phoneno=(TextView)findViewById(R.id.phone);
        Email=(TextView)findViewById(R.id.email);
        Wardno=(TextView)findViewById(R.id.ward);
        muncipality=(TextView)findViewById(R.id.muncipal);
        Status=(EditText)findViewById(R.id.statustxt);
        StatusButton=(Button)findViewById(R.id.statusBtn);
        L=(LinearLayout)findViewById(R.id.mn);
        L.setFocusable(true);
        Bundle ab=getIntent().getExtras();
        if (ab != null) {
            id=ab.getString("ID");
        }
        loadrecyclerviewdata();
        StatusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 STS=Status.getText().toString();

                /*---------------------*/



                class GetJSON extends AsyncTask<String, Void, String> {

                    @Override
                    protected void onPreExecute() {
                      //  p1= ProgressDialog.show(ComplaintStatusDetails.this,"Status ","Updating...");

                    }

                    @Override
                    protected String doInBackground(String... strings) {
                        try {
                            String Id = id;
                            String Comp_url = "http://janamythri.com/Payyannur/SasiVattakovil/mobileapi/CouncillorComplaintReply.php";
                            URL url = new URL(Comp_url);
                            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                            httpURLConnection.setRequestMethod("POST");
                            httpURLConnection.setDoOutput(true);
                            httpURLConnection.setDoInput(true);
                            OutputStream outputStream = httpURLConnection.getOutputStream();
                            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                            String post_data = URLEncoder.encode("Id", "UTF-8") + "=" + URLEncoder.encode(Id, "UTF-8")+"&"
                                    +URLEncoder.encode("Status","UTF-8")+"="+URLEncoder.encode(STS,"UTF-8");
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
                       // p1.dismiss();
                        Log.e("responseee11",""+s);
                        JSONObject obj = null;
                        String Res=s.trim();
                        Log.e("responseee",""+Res);





/*
                        try {
                            JSONArray jArray = new JSONArray(s);
                            for (int i = 0; i < jArray.length(); i++) {
                                obj = jArray.getJSONObject(i);
                            }

                            if (obj != null) {
  Log.e("idstatusss", "objid" + obj.getString("Id"));
                                String Name = obj.getString("Name");
                                String PhoneNo = obj.getString("PhoneNo");
                                String EmailId = obj.getString("EmailId");
                                String Wardno = obj.getString("Wardno");
                                String Municipality = obj.getString("Muncipality");

                                String Status1 = obj.getString("Status");
                                Status.setText(Status1);

                            }


                        } catch (Exception ee) {
                            ee.printStackTrace();
                        }
*/
                        if(Res.equals("1"))
                        {
                            loadrecyclerviewdata();
                            Log.e("responseee",""+Res);
                            Intent intent=new Intent(ShowComplaint2Activity.this,ShowComplaintActivity.class);
                            Toast.makeText(ShowComplaint2Activity.this, "Status Successfully Updated", Toast.LENGTH_SHORT).show();
                            startActivity(intent);
                        }
                        else {
                            Toast.makeText(ShowComplaint2Activity.this, "Status Unsuccessfull", Toast.LENGTH_SHORT).show();

                        }

                    }

                }
                GetJSON getJSON = new GetJSON();
                getJSON.execute();


                         /*---------------------*/

            }
        });
    }

    private void loadrecyclerviewdata() {
        String URL = "http://janamythri.com/Payyannur/SasiVattakovil/mobileapi/CouncillorComplaintView.php";
        StringRequest stringRequest=new StringRequest(Request.Method.GET, URL,
                new Response.Listener<String>() {
                    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
                    @Override
                    public void onResponse(String response) {
                        try {



/* JSONObject json_object =new JSONObject(response);
                            JSONArray json_array=json_object.getJSONArray(response);*/

                            JSONArray json_array = new JSONArray(response);
                            int j;
                            for (j = 0;j<json_array.length();j++)
                            {
                                JSONObject o=json_array.getJSONObject(j);
                                if(Objects.equals(id, o.getString("Id"))) {
                                    // String ID = o.getString("Id");
                                    Log.e("idstatusss", "objid" + o.getString("Id"));
                                    String Name = o.getString("Name");
                                    String date = o.getString("Date");
                                    String Phone = o.getString("PhoneNo");
                                    String email = o.getString("EmailId");
                                    String ward = o.getString("Wardno");
                                    String Muncipality = o.getString("Muncipality");
                                    String status = o.getString("Status");


                                    //   id.setText(ID);
                                    Sname.setText(Name);
                                    muncipality.setText(Muncipality);
                                    phoneno.setText(Phone);
                                    Email.setText(email);
                                   // Date.setText(date);
                                    Wardno.setText(ward);
                                    Status.setText(status);

                                    // ward.setText(Wardno);
                                }
                            }




                        } catch (JSONException e) {
                            e.printStackTrace();
                        }




                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(),error.getMessage(),Toast.LENGTH_LONG).show();

                    }
                });
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);


    }

}
