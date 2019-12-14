package ru.barcats.a3l5_home.adapters;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class MyPageAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> fragments = new ArrayList<>();
    private ArrayList<String> tabTitles = new ArrayList<>();

    public MyPageAdapter(@NonNull FragmentManager fm) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
    }

    public void addFragment(Fragment fragment, String tabTitle){
        this.fragments.add(fragment);
        this.tabTitles.add(tabTitle);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles.get(position);
    }
}


/*
    //можно было не добавлять фрагменты  в список в методе addFragment из TabActivity,
    //а добавлять их прямо в адаптере в этом методе
    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return Fruits.newInstance();
            case 1:
                return Vegetables.newInstance();
            case 2:
                return Nature.newInstance();

            default:
                return  Fruits.newInstance();
        }
    }

        //если не добавлять фрагменты  в список в методе addFragment из TabActivity,
    //то нужно возвращать количество фрагментов
    @Override
    public int getCount() {
        return 3;
    }

        //можно было не добавлять заголовки в список в методе addFragment из TabActivity,
    //а добавлять их прямо в адаптере в этом методе
        @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Фрукты";
                case 1:
                    return "Овощи";
                case 2:
                    return "Природа";

                default:
                    return "Фрукты";
            }
    }
* */