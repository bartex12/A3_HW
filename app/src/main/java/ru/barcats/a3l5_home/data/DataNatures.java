package ru.barcats.a3l5_home.data;

import java.util.ArrayList;
import java.util.List;

import ru.barcats.a3l5_home.R;

public class DataNatures {

    private List<String> listPictures;
    private List<Integer> listResId;

    public DataNatures() {
        listPictures = new ArrayList<>();
        listPictures.add("Мы с тобой одной крови");
        listPictures.add("Морской узел");
        listPictures.add("Пришелец");
        listPictures.add("Просто пень");

        listResId = new ArrayList<>();
        listResId.add(R.drawable.woman_cow);
        listResId.add(R.drawable.tree);
        listResId.add(R.drawable.spader);
        listResId.add(R.drawable.penn);
    }

    public List<String> getListPictures() {
        return listPictures;
    }
    public List<Integer> getListResId() {
        return listResId;
    }
}
