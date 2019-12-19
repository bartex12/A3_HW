package ru.barcats.a3l5_home;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ThemeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppThemeGreen);
        setContentView(R.layout.activity_theme);

        FloatingActionButton fab = findViewById(R.id.fabTheme);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ThemeActivity.this,
                        getResources().getString(R.string.simple_button),Toast.LENGTH_SHORT).show();
            }
        });
    }
}
