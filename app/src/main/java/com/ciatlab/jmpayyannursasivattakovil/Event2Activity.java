package com.ciatlab.jmpayyannursasivattakovil;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class Event2Activity extends AppCompatActivity {

    String comingId,CEname,Cdesc,Cdate;
    ImageView image1;
    TextView Ename,Date,Desc,muncipaplity,complaint,ward,id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event2);
       // id=(EditText)findViewById(R.id.id);
        Ename=(TextView) findViewById(R.id.ename);
        Date=(TextView)findViewById(R.id.date);
        Desc=(TextView)findViewById(R.id.desc);
        image1=(ImageView) findViewById(R.id.image1);
       // muncipaplity=(EditText)findViewById(R.id.muncipal);
        //complaint=(EditText)findViewById(R.id.complaint);
       // ward=(EditText)findViewById(R.id.ward);

        Bundle abBundle= getIntent().getExtras();
        if (abBundle != null) {
            comingId=abBundle.getString("ID");
            CEname=abBundle.getString("Ename");
            Cdesc=abBundle.getString("Desc");
            Cdate=abBundle.getString("Date");
            //Toast.makeText(Event2Activity.this,comingId,Toast.LENGTH_LONG).show();
            //   id.setText(ID);
            Ename.setText(CEname);
            Date.setText(Cdate);
            Desc.setText(Cdesc);
            Log.e("CominfIdddd","v"+comingId+".jpg");
            String url="http://janamythri.com/Payyannur/SasiVattakovil/Image/events_images/"+comingId+".jpg";
            Picasso.with(Event2Activity.this).load(url)
                    .into(image1);

            // ward.setText(Wardno);
           // loadrecyclerviewdata();
        }

    }
/*
    private void loadrecyclerviewdata() {
        String URL = "http://216.10.246.248/demo/mobileapi/list_itemdata.php";
        StringRequest stringRequest=new StringRequest(Request.Method.GET, URL,
                new Response.Listener<String>() {
                    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
                    @Override
                    public void onResponse(String response) {
                        try {



                           */
/* JSONObject json_object =new JSONObject(response);
                            JSONArray json_array=json_object.getJSONArray(response);*//*

                            JSONArray json_array = new JSONArray(response);
                            int j;
                            for (j = 0;j<json_array.length();j++)
                            {
                                JSONObject o=json_array.getJSONObject(j);
                                if(Objects.equals(comingId, o.getString("Id"))) {
                                   // String ID = o.getString("Id");
                                    Log.e("idstatusss", "objid" + o.getString("Id"));
                                    String EName = o.getString("Category");
                                    String date = o.getString("Place");
                                    String desc = o.getString("Contactno1");
                                   // String Wardno = o.getString("Contactno2");

                                  //   id.setText(ID);
                                    Ename.setText(EName);
                                    Date.setText(date);
                                    Desc.setText(desc);
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
*/
}
