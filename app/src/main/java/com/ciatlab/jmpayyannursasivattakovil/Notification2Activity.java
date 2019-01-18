package com.ciatlab.jmpayyannursasivattakovil;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Notification2Activity extends AppCompatActivity {


    String comingId,NTtitle,NTcontent,NTdate;
    TextView Tname,Date,muncipaplity,complaint,ward,id;
    TextView Content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification2);
        // id=(EditText)findViewById(R.id.id);
        Tname=(TextView) findViewById(R.id.Title);
        Date=(TextView) findViewById(R.id.date1);
        Content=(TextView) findViewById(R.id.content);
        // muncipaplity=(EditText)findViewById(R.id.muncipal);
        //complaint=(EditText)findViewById(R.id.complaint);
        // ward=(EditText)findViewById(R.id.ward);

        Bundle abBundle= getIntent().getExtras();
        if (abBundle != null) {
            comingId=abBundle.getString("ID");
            NTcontent=abBundle.getString("Content");
            NTtitle=abBundle.getString("Title");
            NTdate=abBundle.getString("Date");
           // Toast.makeText(Notification2Activity.this,comingId,Toast.LENGTH_LONG).show();
            //   id.setText(ID);
            Tname.setText(NTtitle);
            Date.setText(NTdate);
            Content.setText(NTcontent);
            // ward.setText(Wardno);
            //loadrecyclerviewdata();
        }

    }
/*    private void loadrecyclerviewdata() {
        String URL = "http://216.10.246.248/demo/mobileapi/Notification.php";
        StringRequest stringRequest=new StringRequest(Request.Method.GET, URL,
                new Response.Listener<String>() {
                    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
                    @Override
                    public void onResponse(String response) {
                        try {



                           *//* JSONObject json_object =new JSONObject(response);
                            JSONArray json_array=json_object.getJSONArray(response);*//*
                            JSONArray json_array = new JSONArray(response);
                            int j;
                            for (j = 0;j<json_array.length();j++)
                            {
                                JSONObject o=json_array.getJSONObject(j);
                                if(Objects.equals(comingId, o.getString("Id"))) {
                                    // String ID = o.getString("Id");
                                    Log.e("idstatusss", "objid" + o.getString("Id"));
                                    String TName = o.getString("Title");
                                    String date = o.getString("Date");
                                    String content = o.getString("Content");
                                    // String Wardno = o.getString("Contactno2");

                                    //   id.setText(ID);
                                    Tname.setText(TName);
                                    Date.setText(date);
                                    Content.setText(content);
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


    }*/}
