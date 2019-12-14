package ru.barcats.a3l5_home.adapters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import ru.barcats.a3l5_home.frags.AnimalsFabricated;
import ru.barcats.a3l5_home.frags.AnimalsHome;
import ru.barcats.a3l5_home.frags.AnimalsWild;

public class MyFragmentPageAlapter extends FragmentPagerAdapter {

    public MyFragmentPageAlapter(@NonNull FragmentManager fm) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
    }


    //можно не добавлять фрагменты  в список в методе addFragment из Activity,
    //а добавлять их прямо в адаптере в этом методе
    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return AnimalsFabricated.newInstance();
            case 1:
                return AnimalsHome.newInstance();
            case 2:
                return AnimalsWild.newInstance();

            default:
                return  AnimalsFabricated.newInstance();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Мульт";
            case 1:
                return "Домашние";
            case 2:
                return "Дикие";

            default:
                return "Мульт";
        }
    }
}

