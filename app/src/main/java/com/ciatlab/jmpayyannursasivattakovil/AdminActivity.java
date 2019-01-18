package com.ciatlab.jmpayyannursasivattakovil;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class AdminActivity extends AppCompatActivity {
    ImageView Event1,Complaints1,Notification1;
    TextView Event2,Complaints2,Notification2;

    private static ViewPager mPager;
    private static int currentPage = 0;
    private static int NUM_PAGES = 0;
    private static final Integer[] IMAGES= {R.drawable.one,R.drawable.two,R.drawable.three};
    private ArrayList<Integer> ImagesArray = new ArrayList<Integer>();

    @Override
    public void onBackPressed() {

            Intent start = new Intent(Intent.ACTION_MAIN);
            start.addCategory(Intent.CATEGORY_HOME);
            start.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            start.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(start);
        }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        init();
        Event1=(ImageView) findViewById(R.id.eventimg);
        Event2=(TextView) findViewById(R.id.eventtxt);
        Complaints1=(ImageView) findViewById(R.id.compimg);
        Complaints2=(TextView) findViewById(R.id.comptxt);
        Notification1=(ImageView) findViewById(R.id.notfyimg);
        Notification2=(TextView) findViewById(R.id.notfytxt);




        Toolbar mybar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(mybar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        assert mybar !=null;

        Complaints1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nxt = new Intent(AdminActivity.this,ShowComplaintActivity.class);
                startActivity(nxt);
            }
        });
        Complaints2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nxt = new Intent(AdminActivity.this,ShowComplaintActivity.class);
                startActivity(nxt);
            }
        });

        Event1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nxt = new Intent(AdminActivity.this,EventActivity.class);
                startActivity(nxt);
            }
        });
        Event2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nxt = new Intent(AdminActivity.this,EventActivity.class);
                startActivity(nxt);
            }
        });

        Notification1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nxt=new Intent(AdminActivity.this,NotificationActivity.class);
                startActivity(nxt);
            }
        });
        Notification2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nxt=new Intent(AdminActivity.this,NotificationActivity.class);
                startActivity(nxt);
            }
        });



    }
    private void init() {


        for (int i = 0; i < IMAGES.length; i++)
            ImagesArray.add(IMAGES[i]);

        mPager = (ViewPager) findViewById(R.id.pager);


        mPager.setAdapter(new SlidingImage_Adapter(AdminActivity.this, ImagesArray));


        final float density = getResources().getDisplayMetrics().density;


        NUM_PAGES = IMAGES.length;


        // Auto start of viewpager
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == NUM_PAGES) {
                    currentPage = 0;
                }
                mPager.setCurrentItem(currentPage++, true);
            }
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 3000, 3000);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu2, menu);
        return super.onCreateOptionsMenu(menu);

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.s1:
                break;
            case R.id.s2:
/*
                i.putExtra("phhhh",PHONE_NUMBER);
*/
                break;
            case  R.id.s3:

                SharedPreferences flag =getSharedPreferences("Login", Activity.MODE_PRIVATE);
                SharedPreferences.Editor editor =flag.edit();
                editor.putString("Username",null);
                editor.apply();
                Intent logout = new Intent(AdminActivity.this, MainActivity.class);
                startActivity(logout);
                break;
            default:
                return super.onOptionsItemSelected(item);

        }
        return true;
    }


}

