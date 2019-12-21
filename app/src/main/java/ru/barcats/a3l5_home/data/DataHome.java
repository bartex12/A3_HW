package ru.barcats.a3l5_home.data;

import java.util.ArrayList;
import java.util.List;

import ru.barcats.a3l5_home.R;

public class DataHome {

    private List<String> listPictures;
    private List<Integer> listResId;

    public DataHome() {
        listPictures = new ArrayList<>(3);
        listPictures.add("Собака");
        listPictures.add("Кошка");
        listPictures.add("Черепаха");


        listResId = new ArrayList<>(3);
        listResId.add(R.drawable.dog1_12);
        listResId.add(R.drawable.cat1_12);
        listResId.add(R.drawable.turtle1_12);

    }
    public List<String> getListPictures() {
        return listPictures;
    }
    public List<Integer> getListResId() {
        return listResId;
    }
}
