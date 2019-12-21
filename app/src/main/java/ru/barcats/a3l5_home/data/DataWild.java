package ru.barcats.a3l5_home.data;

import java.util.ArrayList;
import java.util.List;

import ru.barcats.a3l5_home.R;

public class DataWild {

    private List<String> listPictures;
    private List<Integer> listResId;

    public DataWild() {
        listPictures = new ArrayList<>(3);
        listPictures.add("Волк");
        listPictures.add("Леопард");
        listPictures.add("Медведь");


        listResId = new ArrayList<>(3);
        listResId.add(R.drawable.wolf1_12);
        listResId.add(R.drawable.leopard1_12);
        listResId.add(R.drawable.bear1_12);

    }
    public List<String> getListPictures() {
        return listPictures;
    }
    public List<Integer> getListResId() {
        return listResId;
    }
}
