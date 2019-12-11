package ru.barcats.a3l5_home.data;

import java.util.ArrayList;
import java.util.List;

import ru.barcats.a3l5_home.R;

public class DataAnimals {

    private List<String> listPictures;
    private List<Integer> listResId;

    public DataAnimals() {
        listPictures = new ArrayList<>();
        listPictures.add("Винни Пух");
        listPictures.add("Пятячок");

        listResId = new ArrayList<>();
        listResId.add(R.drawable.vinni);
        listResId.add(R.drawable.pyatochk);

    }
    public List<String> getListPictures() {
        return listPictures;
    }
    public List<Integer> getListResId() {
        return listResId;
    }
}
