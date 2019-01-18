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

public class EventActivity extends AppCompatActivity {
    ProgressDialog p1;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<ListClass> listClasses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        recyclerView=(RecyclerView)findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        listClasses=new ArrayList<>();

        loadrecyclerviewdata();



    }










    private void loadrecyclerviewdata() {
        p1= ProgressDialog.show(EventActivity.this,"Status ","Updating...");


        String URL = "http://janamythri.com/Payyannur/SasiVattakovil/mobileapi/list_itemdata.php";
        StringRequest stringRequest=new StringRequest(Request.Method.GET, URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        p1.dismiss();
                        Log.e("respppppppp", "" + response);
                        if (!response.equals("[]")) {
                            if (!response.trim().equals("null")) {
                                try {



                           /* JSONObject json_object =new JSONObject(response);
                            JSONArray json_array=json_object.getJSONArray(response);*/
                                    JSONArray json_array = new JSONArray(response);
                                    int j;
                                    for (j = 0; j < json_array.length(); j++) {
                                        JSONObject o = json_array.getJSONObject(j);
                                        ListClass items = new ListClass
                                                (o.getString("Eventname"), o.getString("Description"),
                                                        o.getString("Id"), o.getString("Date"));
                                        Log.e("Jsonfilesss", "" + o.getString("Id"));
                                        listClasses.add(items);

                                    }
                                    adapter = new MyAdapter(listClasses, getApplicationContext());
                                    recyclerView.setAdapter(adapter);


                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }

                            }
                        }else {
                                Toast.makeText(EventActivity.this, "No Events To Display", Toast.LENGTH_LONG).show();
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


