package ru.barcats.a3l5_home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import ru.barcats.a3l5_home.adapters.MyPageAdapter;
import ru.barcats.a3l5_home.frags.Fruits;
import ru.barcats.a3l5_home.frags.Nature;
import ru.barcats.a3l5_home.frags.Vegetables;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class TabActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);

        Fragment fragment1 = Fruits.newInstance();
        Fragment fragment2 = Vegetables.newInstance();
        Fragment fragment3 = Nature.newInstance();

        //здесь используется вариант добавления фрагментов в адаптер из активити
        //есть ещё вариант добавления фрагментов внутри адаптера - см. MyFragmentPageAlapter
        MyPageAdapter adapter = new MyPageAdapter(getSupportFragmentManager());
        adapter.addFragment(fragment1, getResources().getString(R.string.fruit));
        adapter.addFragment(fragment2, getResources().getString(R.string.vegetables));
        adapter.addFragment(fragment3, getResources().getString(R.string.nature));

        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(3);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
    }
}
