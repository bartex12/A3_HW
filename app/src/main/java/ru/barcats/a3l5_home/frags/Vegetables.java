package ru.barcats.a3l5_home.frags;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ru.barcats.a3l5_home.R;
import ru.barcats.a3l5_home.adapters.MyPictureAdapter;
import ru.barcats.a3l5_home.data.DataVegetables;

public class Vegetables extends Fragment {

    public static Vegetables newInstance() {
        return  new Vegetables();
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_vegetables, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initTextView(view);
        initRecycler(view);
    }

    private void initTextView(View view) {
        TextView tv = view.findViewById(R.id.text_vegetables);
        tv.setText(R.string.vegetables);
    }

    private void initRecycler(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.recyclerVegetables);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(),
                LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        DataVegetables dataPicture = new DataVegetables();
        MyPictureAdapter adapter = new MyPictureAdapter(dataPicture.getListPictures(),
                dataPicture.getListResId(),true);
        recyclerView.setAdapter(adapter);
    }
}