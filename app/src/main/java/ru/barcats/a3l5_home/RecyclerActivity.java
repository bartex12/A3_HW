package ru.barcats.a3l5_home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RecyclerActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    boolean isCard;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        initButtons();
        initRecycler();
    }

    private void initButtons() {
        Button button = findViewById(R.id.buttonIsCard);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isCard =true;
                initRecycler();
            }
        });
        Button buttonDiscard = findViewById(R.id.buttonDiscard);
        buttonDiscard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isCard =false;
                initRecycler();
            }
        });
    }

    private void initRecycler() {
        recyclerView = findViewById(R.id.recycler);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        FruitPictures dataPicture = new FruitPictures();
        MyPictureAdapter adapter = new MyPictureAdapter(dataPicture.getListPictures(), isCard);
        recyclerView.setAdapter(adapter);
    }
}
