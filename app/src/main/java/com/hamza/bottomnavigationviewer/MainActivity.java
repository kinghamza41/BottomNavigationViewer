package com.hamza.bottomnavigationviewer;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    ViewPager viewPager;
    CustomSwipeAdapter customSwipeAdapter;

    VideoView myvideo;
    MediaController mediaController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//Toolbar For menu
        /*Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(mToolbar);
*/
//Other Activity Data(ViewPager)
        viewPager=(ViewPager)findViewById(R.id.view_pager);
        customSwipeAdapter=new CustomSwipeAdapter(this);
        viewPager.setAdapter(customSwipeAdapter);


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(selListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new HomeFragment()).commit();

       /* myvideo = (VideoView) findViewById(R.id.videoplayer);*/

     /*   mediaController = new MediaController(this);
*/
        /*String path = "android.resource://com.hamza.bottomnavigationviewer/" + R.raw.mycreation;
        Uri uri = Uri.parse(path);
        myvideo.setVideoURI(uri);
        myvideo.setMediaController(mediaController);
        mediaController.setAnchorView(myvideo);
        myvideo.start();*/
    }
    //Menu Creation

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.item1:
                Toast.makeText(MainActivity.this, item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.item2:
                Toast.makeText(MainActivity.this, item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.item3:
                Toast.makeText(MainActivity.this, item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

//Bottom Navgation

    private BottomNavigationView.OnNavigationItemSelectedListener selListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectedFragment = null;
                    switch (menuItem.getItemId()) {

                        case R.id.nav_home:
                            selectedFragment = new HomeFragment();
                            break;
                        case R.id.nav_favourite:
                            selectedFragment = new FavouriteFragment();
                            break;
                        case R.id.nav_search:
                            selectedFragment = new SearchFragment();
                            break;
                        case R.id.nav_help:
                            selectedFragment = new HelpFragment();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedFragment).commit();
                    return true;
                }
            };
}
