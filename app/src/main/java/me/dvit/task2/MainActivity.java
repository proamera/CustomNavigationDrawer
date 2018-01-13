package me.dvit.task2;
import android.content.res.Resources;
import android.content.res.TypedArray;
import  android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
        List<CustomMenu> customMenus = new ArrayList<>();
   // TypedArray tArray = getResources().obtainTypedArray(R.array.menuicons);
   // Resources resources = getResources();

   // String[] menuItemName2  = resources.getStringArray(R.array.menunames);

    String menuItemName []={"Home" ,"About","Profile","Contact Us"};
    int menuItemIcon [] ={R.drawable.icon ,R.drawable.icon,R.drawable.icon,R.drawable.icon};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        for (int i =0; i< menuItemName.length;i++ ){
            CustomMenu customMenu = new CustomMenu(menuItemName[i] ,menuItemIcon[i]);
            customMenus.add(customMenu);
        }
       // tArray.recycle();
        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addOnItemTouchListener( new RecyclerItemClickListener(this, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        position=recyclerView.getChildLayoutPosition(recyclerView);
                        if (position==0){
                            HomeFragment fragment = new HomeFragment();
                            FragmentTransaction fragmentTransaction =getSupportFragmentManager()
                                    .beginTransaction();
                            fragmentTransaction.replace(R.id.main_content, fragment);
                            fragmentTransaction.addToBackStack(null);
                            fragmentTransaction.commit();

                        }else if (position==1){
                            AboutFragment fragment = new AboutFragment();
                            FragmentTransaction fragmentTransaction =getSupportFragmentManager()
                                    .beginTransaction();
                            fragmentTransaction.replace(R.id.main_content, fragment);
                            fragmentTransaction.addToBackStack(null);
                            fragmentTransaction.commit();
                        }
                        else if (position==2){
                            profileFragment fragment = new profileFragment();
                            FragmentTransaction fragmentTransaction =getSupportFragmentManager()
                                    .beginTransaction();
                            fragmentTransaction.replace(R.id.main_content, fragment);
                            fragmentTransaction.addToBackStack(null);
                            fragmentTransaction.commit();
                        }
                        else if (position==3){
                            ContactFragment fragment = new ContactFragment();
                            FragmentTransaction fragmentTransaction =getSupportFragmentManager()
                                    .beginTransaction();
                            fragmentTransaction.replace(R.id.main_content, fragment);
                            fragmentTransaction.addToBackStack(null);
                            fragmentTransaction.commit();
                        }

                    }
                })
        );
        MenuAdapter adapter = new MenuAdapter(customMenus) ;

        recyclerView.setAdapter(adapter);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
