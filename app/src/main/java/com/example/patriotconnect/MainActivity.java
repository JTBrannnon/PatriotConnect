package com.example.patriotconnect;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, HousingFragment.OnHousingFragmentInteractionListener,
        SettingsFragment.OnFragmentInteractionListener, AboutFragment.OnFragmentInteractionListener,
        HomePageFragment.OnFragmentInteractionListener, VHAFragment.onVHAFragmentInteractionListener {

    private HousingFragment housingFragment;
    private FrameLayout container;
    private SettingsFragment settingsFragment;
    private AboutFragment aboutFragment;
    private HomePageFragment homePageFragment;
    private VHAFragment vhaFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        container = findViewById(R.id.container);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
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

        if (id == R.id.nav_home) {
            if (homePageFragment == null) {
                homePageFragment = new HomePageFragment();
                FragmentTransaction homePageFrag = getSupportFragmentManager().beginTransaction();
                homePageFrag.add(R.id.container, homePageFragment).commit();

            }

        } else if (id == R.id.nav_housing) {
            housingFragment = new HousingFragment();
            FragmentTransaction housingFrag = getSupportFragmentManager().beginTransaction();
            housingFrag.replace(R.id.container, housingFragment).commit();
            setTitle(getResources().getString(R.string.nav_housing_title));

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_tools) {

        } else if (id == R.id.nav_settings) {
            settingsFragment = new SettingsFragment();
            FragmentTransaction settingsFrag = getSupportFragmentManager().beginTransaction();
            settingsFrag.replace(R.id.container, settingsFragment).commit();
        } else if (id == R.id.nav_about) {
            aboutFragment = new AboutFragment();
            FragmentTransaction aboutFrag = getSupportFragmentManager().beginTransaction();
            aboutFrag.replace(R.id.container, aboutFragment).commit();
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onVHAFragmentInteraction(Uri uri) {

    }

    // on
    @Override
    public void onHousingInteraction() {
        vhaFragment = new VHAFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.container, vhaFragment)
                .commit();
    }
}
