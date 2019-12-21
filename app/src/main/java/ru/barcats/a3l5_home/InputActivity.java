package ru.barcats.a3l5_home;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

public class InputActivity extends AppCompatActivity {

    EditText inputName;
    Button input;
    Button close;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        initViews();
    }

    private void initViews() {
        inputName = findViewById(R.id.etName);

        input = findViewById(R.id.buttonInput);
        input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = inputName.getText().toString();
                if (name.isEmpty()){
                    Snackbar.make(inputName, getResources().getString(R.string.snackBarText),
                            Snackbar.LENGTH_SHORT).show();
                }else if (name.length()>10){
                    Snackbar.make(inputName, getResources().getString(R.string.snackBarText10),
                            Snackbar.LENGTH_SHORT).show();
                }else {
                    Intent intent = new Intent(InputActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });

        close = findViewById(R.id.buttonExit);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
