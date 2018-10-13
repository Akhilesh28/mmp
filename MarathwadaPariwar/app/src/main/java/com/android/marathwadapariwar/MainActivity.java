package com.android.marathwadapariwar;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Slide;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.DefaultSliderView;

import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

//    ViewPager viewPager;
    ListView listView;
    SliderLayout sliderLayout;

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id = item.getItemId();

                if(id == R.id.nav_disclaimer){
                    Toast.makeText(MainActivity.this, "Disclaimer", Toast.LENGTH_SHORT).show();
                } else if(id == R.id.nav_developers){
                    Toast.makeText(MainActivity.this, "Developers", Toast.LENGTH_SHORT).show();
                }


                return true;
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

//        viewPager = (ViewPager)findViewById(R.id.viewPager);
//
//        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this);
//        viewPager.setAdapter(viewPagerAdapter);

        //slider start
        sliderLayout = (SliderLayout) findViewById(R.id.slider);

        HashMap<String,Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put("slide1",R.drawable.slide1);
        file_maps.put("slide2",R.drawable.slide2);
        file_maps.put("slide3",R.drawable.slide3);
        file_maps.put("slide4", R.drawable.slide4);
        file_maps.put("slide5", R.drawable.slide5);
        file_maps.put("slide6", R.drawable.slide6);
        file_maps.put("slide7", R.drawable.slide7);
        file_maps.put("slide8", R.drawable.slide8);
        file_maps.put("slide9", R.drawable.slide9);

        for(String name : file_maps.keySet()) {
            DefaultSliderView defaultSliderView = new DefaultSliderView(this);
            defaultSliderView.image(file_maps.get(name));

            defaultSliderView.bundle(new Bundle());


            sliderLayout.addSlider(defaultSliderView);
        }
        //slider end

        ArrayAdapter<String> titleAdapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.titles));

        listView = (ListView)findViewById(R.id.listView);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, InfoActivity.class);
                intent.putExtra("Title", listView.getItemAtPosition(i).toString());
                startActivity(intent);
            }
        });
//        listView.addHeaderView(viewPager);
        listView.setAdapter(titleAdapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(actionBarDrawerToggle.onOptionsItemSelected(item)){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStop() {
        sliderLayout.stopAutoCycle();
        super.onStop();
    }
}
