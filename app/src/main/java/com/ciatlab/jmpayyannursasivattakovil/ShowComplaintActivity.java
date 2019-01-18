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

public class ShowComplaintActivity extends AppCompatActivity {
    JSONArray json_array;

    ProgressDialog p1;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<Show_class> show_classes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_complaint);

        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        show_classes = new ArrayList<>();

        loadrecyclerviewdata();




    }


    private void loadrecyclerviewdata() {
        p1 = ProgressDialog.show(ShowComplaintActivity.this, "Status ", "Updating...");


        String URL = "http://janamythri.com/Payyannur/SasiVattakovil/mobileapi/CouncillorComplaintView.php";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        p1.dismiss();
                        Log.e("resppppp", "" + response);
                        if ((!response.equals("[]"))&&(!response.equals("null"))) {

                                try {
                           /* JSONObject json_object = new JSONObject(response);
                            JSONArray json_array = json_object.getJSONArray(response);*/

                                    json_array = new JSONArray(response);
                                    int j;
                                    for (j = 0; j < json_array.length(); j++) {
                                        JSONObject o = json_array.getJSONObject(j);
                                        Show_class items = new Show_class
                                                (o.getString("Complaint"), o.getString("EmailId"),
                                                        o.getString("Id"), o.getString("Date"));
                                        Log.e("Jsonfilesss", "" + o.getString("Id"));
                                        show_classes.add(items);

                                    }
                                    adapter = new ShowAdapter(show_classes, getApplicationContext(), json_array);
                                    recyclerView.setAdapter(adapter);


                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }


                        }else {
                                Toast.makeText(ShowComplaintActivity.this, "No Complaints Registered yet", Toast.LENGTH_LONG).show();
                            }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();

                    }
                });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);


    }

}





/*
    class GetJSON extends AsyncTask<String, Void, String> {

        @Override
        protected void onPreExecute() {
            p1 = ProgressDialog.show(ShowComplaintActivity.this, "Status ", "Updating...");

        }

        @Override
        protected String doInBackground(String... strings) {
            try {

                String Comp_url = "http://216.10.246.248/demo1/mobileapi/login.php";
                URL url = new URL(Comp_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("UserName", "UTF-8") + "=" + URLEncoder.encode("", "UTF-8")
                        +"&" +URLEncoder.encode("Category","UTF-8")+"="+URLEncoder.encode("","UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();

                InputStream is = httpURLConnection.getInputStream();
                BufferedReader rd = new BufferedReader(new InputStreamReader(is));
                String line;
                StringBuffer response = new StringBuffer();
               */
/* while ((line = rd.readLine()) != null) {
                    response.append(line);
                    response.append('\n');
                }
                rd.close();
                jsonData = response.toString();

                Log.e("jsonData", jsonData);*//*

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

            try {
               */
/* JSONObject json_object =new JSONObject(s);
                JSONArray json_array=json_object.getJSONArray(s);*/
