package ru.barcats.a3l5_home;


import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import ru.barcats.a3l5_home.frags.Animals;
import ru.barcats.a3l5_home.frags.Fruits;
import ru.barcats.a3l5_home.frags.Nature;
import ru.barcats.a3l5_home.frags.Vegetables;

public class MainActivity extends AppCompatActivity implements
        NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = "33333";
    Toolbar toolbar;
    DrawerLayout drawer;
    Fragment fragment;

    public static final String NEW_THEME = "NEW_THEME";
    private int themeCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //если не первый запуск, то меняем тему в зависимости от кода, выбранного в настройках
        if(savedInstanceState != null){
            themeCode = savedInstanceState.getInt(NEW_THEME);
            switch (themeCode) {
                case 0:
                    setTheme(R.style.AppTheme);
                    break;
                case 1:
                    setTheme(R.style.AppThemeGreen);
                    break;
                case 2:
                    setTheme(R.style.AppThemePurple);
                    break;
            }
        }
        //делаем всё остальное, что обычно делаем в onCreate
        initActivity();

        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
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

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        fragment = Animals.newInstance();

        setPicturesFragment(fragment);
    }

    private void initActivity() {
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
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

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        fragment = Fruits.newInstance();

        setPicturesFragment(fragment);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.standard:
                themeCode = 0;
                break;
            case R.id.green:
                themeCode = 1;
                break;
            case R.id.yellow:
                themeCode = 2;
                break;

        }
        recreate();
        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        int id = menuItem.getItemId();

        if (id == R.id.nav_frag1) {
            Log.d(TAG,"MainActivity onNavigationItemSelected fragment_fruits");
            fragment = Fruits.newInstance();

        }  else if (id == R.id.nav_frag2) {
            Log.d(TAG,"MainActivity onNavigationItemSelected fragment_vegetables");
            fragment = Vegetables.newInstance();

        }else if (id == R.id.nav_frag3) {
            Log.d(TAG, "MainActivity onNavigationItemSelected fragment_nature");
            fragment = Nature.newInstance();

        }else if (id == R.id.nav_frag4) {
            Log.d(TAG, "MainActivity onNavigationItemSelected fragment_animals");
            fragment = Animals.newInstance();

        }else {
            fragment = Nature.newInstance();
        }
        // Выделяем выбранный пункт меню в шторке
        menuItem.setChecked(true);

        setPicturesFragment(fragment);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return false;
    }

    private void setPicturesFragment(Fragment fragment) {
        Log.d(TAG, "MainActivity setPicturesFragment");
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.content1, fragment);  // замена фрагмента
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);// эффект
        ft.commit();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(NEW_THEME, themeCode);
    }
}
