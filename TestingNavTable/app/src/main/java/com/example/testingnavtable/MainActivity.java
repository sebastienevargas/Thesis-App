package com.example.testingnavtable;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import android.view.MenuItem;

import com.example.testingnavtable.Navigation_Bottom.FirstFragment;
import com.example.testingnavtable.Navigation_Bottom.SecondFragment;
import com.example.testingnavtable.Navigation_Bottom.ThirdFragment;
import com.example.testingnavtable.Navigation_Drawer.Accounts;
import com.example.testingnavtable.Navigation_Drawer.Bookmarks;
import com.example.testingnavtable.Navigation_Drawer.Settings;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity
        implements BottomNavigationView.OnNavigationItemSelectedListener,
        NavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bottomNavigationView;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle actionBarDrawerToggle;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the toolbar
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);  // Set the toolbar as the ActionBar

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);

        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.botnav_Home);

        navigationView.setNavigationItemSelectedListener(this);

        // Set up the ActionBarDrawerToggle with the toolbar and the DrawerLayout
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout,
                toolbar, R.string.drawer_open, R.string.drawer_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();


    }

    FirstFragment firstFragment = new FirstFragment();
    SecondFragment secondFragment = new SecondFragment();
    ThirdFragment thirdFragment = new ThirdFragment();
    Accounts Account = new Accounts();
    Bookmarks Bookmarks = new Bookmarks();
    Settings Settings = new Settings();

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();

        if (itemId == R.id.botnav_Home) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.flFragment, firstFragment)
                    .commit();
            drawerLayout.closeDrawers();
            return true;
        } else if (itemId == R.id.botnav_Search) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.flFragment, secondFragment)
                    .commit();
            drawerLayout.closeDrawers();
            return true;
        } else if (itemId == R.id.botnav_Task) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.flFragment, thirdFragment)
                    .commit();
            drawerLayout.closeDrawers();
            return true;
        } else if (itemId == R.id.nav_Bookmarks) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.flFragment, Bookmarks)
                    .commit();
            drawerLayout.closeDrawers();
            return true;
        } else if (itemId == R.id.nav_Account) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.flFragment, Account)
                    .commit();
            drawerLayout.closeDrawers();
            return true;
        } else if (itemId == R.id.nav_Setting) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.flFragment, Settings)
                    .commit();
            drawerLayout.closeDrawers();
            return true;
        } else if (itemId == R.id.nav_Logout) {
            // Handle Logout action
            drawerLayout.closeDrawers();
            return true;
        }

        return false;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
