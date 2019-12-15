package ru.barcats.a3l5_home.frags;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ru.barcats.a3l5_home.R;
import ru.barcats.a3l5_home.adapters.MyPictureAdapter;
import ru.barcats.a3l5_home.data.DataFabricated;
import ru.barcats.a3l5_home.data.DataFruits;

/**
 * A simple {@link Fragment} subclass.
 */
public class AnimalsFabricated extends Fragment {

    private static final String TAG = "33333";

    public static AnimalsFabricated newInstance() {
        return  new AnimalsFabricated();
    }

    public AnimalsFabricated() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_animals_fabricated, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initRecycler(view);
    }

    private void initRecycler(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.recycler_fabricated);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(),
                LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        DataFabricated dataPicture = new DataFabricated();
        MyPictureAdapter adapter = new MyPictureAdapter(dataPicture.getListPictures(),
                dataPicture.getListResId(),true);
        Log.d(TAG,"AnimalsFabricated initRecycler list.size = " +
                dataPicture.getListPictures().size());
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
    }
}
