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
import com.sallu.newsex.Database.TrendingNews;
import com.sallu.newsex.ModelClass.TrendingModelClass;
import com.sallu.newsex.R;

import java.util.List;

public class AdapterForTrendingPage extends RecyclerView.Adapter<AdapterForTrendingPage.MyViewHolder> {

    public List<TrendingNews> list;
    public Context context;
    onNoteListener onNoteListener;


    public AdapterForTrendingPage(onNoteListener onNoteListener,Context context, List<TrendingNews> list) {
        this.context = context;
        this.list = list;
        this.onNoteListener = onNoteListener;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_trending,parent,false);

        return new MyViewHolder(itemView,onNoteListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        TrendingNews modelClass = list.get(position);
        holder.headline.setText(modelClass.getHeadline());
        holder.reporter.setText(modelClass.getReporter());
       // holder.backgroundImage.setImageResource(modelClass.getBackgroundImage());
        Glide.with(context).load("http://iamsalman.xyz/frontend/"+modelClass.getThumbnail()).into(holder.backgroundImage);


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView headline, reporter;
        ImageView backgroundImage;
        onNoteListener onNoteListener;


        public MyViewHolder(View view,onNoteListener onNoteListener) {
            super(view);
            this.onNoteListener = onNoteListener;
            headline = (TextView) view.findViewById(R.id.trendingHeadlines);
            reporter = (TextView) view.findViewById(R.id.trendingReporter);
            backgroundImage = view.findViewById(R.id.trendingImage);
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
