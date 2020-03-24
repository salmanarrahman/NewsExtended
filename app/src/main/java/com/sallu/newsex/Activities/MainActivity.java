package com.sallu.newsex.Activities;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.messaging.FirebaseMessaging;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.sallu.newsex.Adapters.SectionsPagerAdapter;
import com.sallu.newsex.Utils.Config;
import com.sallu.newsex.Database.Categories;
import com.sallu.newsex.Database.DatabaseCall;
import com.sallu.newsex.Database.MyAppDatabase;
import com.sallu.newsex.R;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.view.Menu;
import android.widget.Toast;

import java.util.List;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
    AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        Logger.addLogAdapter(new AndroidLogAdapter());
        MobileAds.initialize(getApplicationContext(),"ca-app-pub-3940256099942544~3347511713");

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
        adView = findViewById(R.id.adView);
        AdRequest adRequest =new  AdRequest.Builder().build();
        adView.loadAd(adRequest);


        //notifications
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){

            NotificationChannel channel = new
                    NotificationChannel(Config.PUSH_NOTIFICATION,Config.PUSH_NOTIFICATION, NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);



            FirebaseMessaging.getInstance().subscribeToTopic(Config.TOPIC_GLOBAL)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            String msg = getString(R.string.msg_subscribed);
                            if (!task.isSuccessful()) {
                                msg = getString(R.string.msg_subscribe_failed);
                            }

                        }
                    });

        }

        //changing font
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/Raleway-Regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );



        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(null);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        addMenuItemInNavMenuDrawer();
    }





    private void addMenuItemInNavMenuDrawer() {
        List<Categories> list = DatabaseCall.getCategoryList(MyAppDatabase.getAppDatabase(getApplicationContext()));
        final  NavigationView navView = (NavigationView) findViewById(R.id.nav_view);
                Menu menu = navView.getMenu();
                Menu submenu = menu.addSubMenu(Config.NEWS_CATEGORIES);
                  String info = "";

                for (Categories cat:list){
                    String  category = cat.getCategory();
                    int id = cat.getId();
                    info = category ;
                    submenu.add(0,id,0,info);
                }


                navView.invalidate();

    }



    @Override
    public void onBackPressed() {
       DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else{

            this.finishActivity(1);
        }



    }



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        // Handle navigation view item clicks here.
        String id = String.valueOf(item.getItemId());
        Intent intent=new Intent(MainActivity.this,ShowNewsByCategory.class);
        intent.putExtra("id",id);
        startActivity(intent);
      //  Toast.makeText(getApplicationContext(),"pressed "+id,Toast.LENGTH_SHORT).show();

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

}
