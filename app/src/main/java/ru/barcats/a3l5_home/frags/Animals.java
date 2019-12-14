package ru.barcats.a3l5_home.frags;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import ru.barcats.a3l5_home.adapters.MyFragmentPageAlapter;
import ru.barcats.a3l5_home.adapters.MyPageAdapter;
import ru.barcats.a3l5_home.data.DataAnimals;
import ru.barcats.a3l5_home.adapters.MyPictureAdapter;
import ru.barcats.a3l5_home.R;

public class Animals extends Fragment {

    public static Animals newInstance() {
        return  new Animals();
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_animals, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        MyFragmentPageAlapter adapter = new MyFragmentPageAlapter(
                Objects.requireNonNull(getActivity()).getSupportFragmentManager());
        ViewPager viewPager = view.findViewById(R.id.view_pager_animals);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(0);
        TabLayout tabs = view.findViewById(R.id.tabs_animals);
        tabs.setupWithViewPager(viewPager);

    }

}