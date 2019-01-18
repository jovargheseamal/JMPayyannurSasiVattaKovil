package com.ciatlab.jmpayyannursasivattakovil;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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

import java.util.ArrayList;
import java.util.List;

public class NotificationActivity extends AppCompatActivity {
    ProgressDialog p1;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<NotificationClass> noticlass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        recyclerView=(RecyclerView)findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        noticlass=new ArrayList<>();

        loadrecyclerviewdata();



    }

    private void loadrecyclerviewdata() {
        p1= ProgressDialog.show(NotificationActivity.this,"Downloading","Please wait");

        String URL = "http://janamythri.com/Payyannur/SasiVattakovil/mobileapi/Notification.php";
        StringRequest stringRequest=new StringRequest(Request.Method.GET, URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        p1.dismiss();
                        Log.e("loggggggg",""+response);
                        if( !response.trim().equals("null")) {
                            if (!response.equals("[]")) {
                                try {



                           /* JSONObject json_object =new JSONObject(response);
                            JSONArray json_array=json_object.getJSONArray(response);*/
                                    JSONArray json_array = new JSONArray(response);
                                    int j;
                                    for (j = 0; j < json_array.length(); j++) {
                                        JSONObject o = json_array.getJSONObject(j);
                                        NotificationClass items = new NotificationClass
                                                (o.getString("Title"), o.getString("Date"),
                                                        o.getString("Id"), o.getString("Content"));
                                        noticlass.add(items);

                                    }
                                    adapter = new NotificationAdapter(noticlass, getApplicationContext());
                                    recyclerView.setAdapter(adapter);


                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }

                            }
                        }
                        else{
                            Toast.makeText(NotificationActivity.this,"No Notification Available",Toast.LENGTH_LONG).show();

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


