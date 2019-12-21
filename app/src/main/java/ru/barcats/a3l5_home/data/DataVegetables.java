package ru.barcats.a3l5_home.data;

import java.util.ArrayList;
import java.util.List;

import ru.barcats.a3l5_home.R;

public class DataVegetables {

    private List<String> listPictures;
    private List<Integer> listResId;

    public DataVegetables() {
        listPictures = new ArrayList<>();
        listPictures.add("Морковь");
        listPictures.add("Перец");
        listPictures.add("Свёкла");
        listPictures.add("Помидор");

        listResId = new ArrayList<>();
        listResId.add(R.drawable.morkov);
        listResId.add(R.drawable.perez);
        listResId.add(R.drawable.repa);
        listResId.add(R.drawable.tomato);
    }

    public List<String> getListPictures() {
        return listPictures;
    }
    public List<Integer> getListResId() {
        return listResId;
    }
}
