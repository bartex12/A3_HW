package ru.barcats.a3l5_home.data;

import java.util.ArrayList;
import java.util.List;

import ru.barcats.a3l5_home.R;

public class DataFruits {

    private List<String> listPictures;
    private List<Integer> listResId;

    public DataFruits() {
        listPictures = new ArrayList<>();
        listPictures.add("Апельсин");
        listPictures.add("Яблоко");
        listPictures.add("Груша");
        listPictures.add("Лимон");

        listResId = new ArrayList<>();
        listResId.add(R.drawable.orange);
        listResId.add(R.drawable.apple1);
        listResId.add(R.drawable.grusha);
        listResId.add(R.drawable.limon);
    }
    public List<String> getListPictures() {
        return listPictures;
    }
    public List<Integer> getListResId() {
        return listResId;
    }
}
