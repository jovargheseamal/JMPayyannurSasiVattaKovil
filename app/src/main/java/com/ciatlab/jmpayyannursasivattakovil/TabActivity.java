package com.ciatlab.jmpayyannursasivattakovil;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

public class TabActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);


        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("Complaints"));
        tabLayout.addTab(tabLayout.newTab().setText("Status"));
         
        tabLayout.setTabTextColors(ContextCompat.getColor(getApplicationContext(), R.color.button),
                ContextCompat.getColor(getApplicationContext(), R.color.texttitle));



        Toolbar mybar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(mybar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        assert mybar !=null;

        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        final com.ciatlab.jmpayyannursasivattakovil.PagerAdapter adapter1 = new com.ciatlab.jmpayyannursasivattakovil.PagerAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(adapter1);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());


            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        //creating the adapter
   /* MyListAdapter adapter = new MyListAdapter(this,R.layout.my_custom_list,profList);

    //attaching adapter to the listview
    listView.setAdapter(adapter);*/
    }
}
