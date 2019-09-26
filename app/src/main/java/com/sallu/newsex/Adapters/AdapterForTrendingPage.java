package com.sallu.newsex.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sallu.newsex.ModelClass.TrendingModelClass;
import com.sallu.newsex.R;

import java.util.List;

public class AdapterForTrendingPage extends RecyclerView.Adapter<AdapterForTrendingPage.MyViewHolder> {

    public List<TrendingModelClass> list;

    public AdapterForTrendingPage(List<TrendingModelClass> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_trending,parent,false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        TrendingModelClass modelClass = list.get(position);
        holder.headline.setText(modelClass.getHeadline());
        holder.reporter.setText(modelClass.getReporter());
        holder.backgroundImage.setImageResource(modelClass.getBackgroundImage());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView headline, reporter;
        ImageView backgroundImage;

        public MyViewHolder(View view) {
            super(view);
            headline = (TextView) view.findViewById(R.id.headLines);
            reporter = (TextView) view.findViewById(R.id.reporter);
            backgroundImage = view.findViewById(R.id.trendingImage);
        }
    }

}
