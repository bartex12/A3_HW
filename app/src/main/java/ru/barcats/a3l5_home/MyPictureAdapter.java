package ru.barcats.a3l5_home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyPictureAdapter extends RecyclerView.Adapter<MyPictureAdapter.MyViewHolder> {

    private List<String> list;

    MyPictureAdapter( List<String> list){
    this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.textView.setText(list.get(position));
        switch (position){
            case 0:
                holder.imageView.setImageResource(R.drawable.orange);
                break;
            case 1:
                holder.imageView.setImageResource(R.drawable.apple1);
                break;
            case 2:
                holder.imageView.setImageResource(R.drawable.grusha);
                break;
            case 3:
                holder.imageView.setImageResource(R.drawable.limon);
                break;
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView textView;
        ImageView imageView;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text_);
            imageView = itemView.findViewById(R.id.imageView_);
        }
    }
}
