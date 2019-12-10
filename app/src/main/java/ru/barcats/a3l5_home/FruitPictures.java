package ru.barcats.a3l5_home;

import java.util.ArrayList;
import java.util.List;

class FruitPictures {

    private List<String> listPictures;

    FruitPictures() {
        listPictures = new ArrayList<>();
        listPictures.add("Апельсин");
        listPictures.add("Яблоко");
        listPictures.add("Груша");
        listPictures.add("Лимон");
    }

    List<String> getListPictures() {
        return listPictures;
    }
}
