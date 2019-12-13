package ru.barcats.a3l5_home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import ru.barcats.a3l5_home.dialogs.MessageDialog;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class BottomActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom);

        bottomNavigationView = findViewById(R.id.bottomView);
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();
                MessageDialog dialog;
                switch (id){
                    case R.id.navigation_air:
                        dialog = MessageDialog.newInstance(
                                "Летайте самолётами Аэрофлота");
                        dialog.show(getSupportFragmentManager(), "dialog message");
                        return  true;

                    case R.id.navigation_car:
                        dialog = MessageDialog.newInstance(
                                "Покупайте электромобили Тесла");
                        dialog.show(getSupportFragmentManager(), "dialog message");
                        return  true;

                    case R.id.navigation_ship:
                        dialog = MessageDialog.newInstance(
                                "Самолёт - хорошо, машина - хорошо, а олени лучше");
                        dialog.show(getSupportFragmentManager(), "dialog message");
                        return  true;
                }
                return false;
            }
        });
    }
}
