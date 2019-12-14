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
import ru.barcats.a3l5_home.adapters.MyPictureAdapter;
import ru.barcats.a3l5_home.data.DataNatures;
import ru.barcats.a3l5_home.R;

public class Nature extends Fragment {

    public static Nature newInstance() {
        return  new Nature();
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_nature, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initTextView(view);
        initRecycler(view);
    }

    private void initTextView(View view) {
        TextView tv = view.findViewById(R.id.text_nature);
        tv.setText(R.string.nature);
    }

    private void initRecycler(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.recyclerNatures);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(),
                LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        DataNatures dataPicture = new DataNatures();
        MyPictureAdapter adapter = new MyPictureAdapter(dataPicture.getListPictures(),
                dataPicture.getListResId(), true);
        recyclerView.setAdapter(adapter);
    }
}