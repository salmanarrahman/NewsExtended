package com.sallu.newsex.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.sallu.newsex.Database.BreakingNews;
import com.sallu.newsex.Database.Dates;
import com.sallu.newsex.R;

import java.util.List;

public class AdapterForDialogue extends  RecyclerView.Adapter<AdapterForDialogue.MyViewHolder> {

    List<Dates> list;
    Context context;
    onNoteListener onNoteListener;
    public AdapterForDialogue(onNoteListener onNoteListener,Context context,List<Dates> list) {
        this.context = context;
        this.list = list;
        this.onNoteListener = onNoteListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_date,parent,false);

        return new MyViewHolder(view,onNoteListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Dates mClass = list.get(position);
        holder.text.setText(mClass.getDate());



    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder implements  View.OnClickListener{
        public TextView text;
        onNoteListener onNoteListener;

        public MyViewHolder(View view,onNoteListener onNoteListener) {
            super(view);
            this.onNoteListener = onNoteListener;
            text = (TextView) view.findViewById(R.id.dateText);

            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onNoteListener.onNoteClicked(getAdapterPosition());

        }
    }

    public interface onNoteListener{
        void onNoteClicked(int position);
    }


}
