package ru.barcats.a3l5_home;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

public class MainActivity extends AppCompatActivity implements
        NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = "33333";
    int optionId;
    ViewGroup parent;
    DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        drawer.openDrawer(GravityCompat.START);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawer.openDrawer(GravityCompat.START);
            }
        });
        //DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        parent = findViewById(R.id.content);
        optionId = R.layout.fragment_fruits;
        getNewFragment(optionId);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        // Handle navigation view item clicks here.
        int id = menuItem.getItemId();

        if (id == R.id.nav_frag1) {
            Log.d(TAG,"MainActivity onNavigationItemSelected fragment_fruits");
            optionId = R.layout.fragment_fruits;
        }  else if (id == R.id.nav_frag2) {
            Log.d(TAG,"MainActivity onNavigationItemSelected fragment_vegetables");
            optionId = R.layout.fragment_vegetables;
        }else if (id == R.id.nav_frag3) {
            Log.d(TAG, "MainActivity onNavigationItemSelected fragment_nature");
            optionId = R.layout.fragment_nature;
        }else if(id == R.id.nav_frag4) {
            Log.d(TAG,"MainActivity onNavigationItemSelected fragment_animals");
            optionId = R.layout.fragment_animals;
        }
        
        // Выделяем выбранный пункт меню в шторке
        menuItem.setChecked(true);

        getNewFragment(optionId);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return false;
    }

    private void getNewFragment(int id) {
        parent.removeAllViews();
        View newContent = getLayoutInflater().inflate(id, parent, false);
        parent.addView(newContent);
    }
}
