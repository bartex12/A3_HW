package ru.barcats.a3l5_home;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

import java.util.Objects;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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

//        //самое простое - вызвать заранее написанную TabActivity со всеми вкладками
//        // тогда при возврате по кнопке назад будет отображаться вкладка Fruits
//        Intent intent = new Intent(MainActivity.this, TabActivity.class);
//        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
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
        ft.replace(R.id.content, fragment);  // замена фрагмента
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);// эффект
        ft.commit();
    }


}
