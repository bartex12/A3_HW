package ru.barcats.a3l5_home.data;

import java.util.ArrayList;
import java.util.List;

import ru.barcats.a3l5_home.R;

public class DataFabricated {

    private List<String> listPictures;
    private List<Integer> listResId;

    public DataFabricated() {
        listPictures = new ArrayList<>(3);
        listPictures.add("Микки Маус");
        listPictures.add("Том");
        listPictures.add("Джерри");
        listPictures.add("Винни Пух");
        listPictures.add("Пятачок");

        listResId = new ArrayList<>(3);
        listResId.add(R.drawable.mickey_mouse1_12);
        listResId.add(R.drawable.tom1_12);
        listResId.add(R.drawable.jerry1_12);
        listResId.add(R.drawable.vinni1_12);
        listResId.add(R.drawable.pyatochk1_12);

    }
    public List<String> getListPictures() {
        return listPictures;
    }
    public List<Integer> getListResId() {
        return listResId;
    }
}
