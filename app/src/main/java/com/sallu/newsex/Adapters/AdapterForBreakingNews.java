package com.sallu.newsex.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sallu.newsex.ModelClass.BreakingnewsModelClass;
import com.sallu.newsex.R;

import java.util.List;

public class AdapterForBreakingNews extends  RecyclerView.Adapter<AdapterForBreakingNews.MyViewHolder> {

    List<BreakingnewsModelClass> list;

    public AdapterForBreakingNews(List<BreakingnewsModelClass> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_breakingnews,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        BreakingnewsModelClass mClass = list.get(position);
        holder.backgroundImage.setImageResource(mClass.getBgImage());
        holder.breakingNewsHeadline.setText(mClass.getBreakingNews());
        holder.reporter.setText(mClass.getBreakingNewsReporter());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView breakingNewsHeadline, reporter;
        ImageView backgroundImage;

        public MyViewHolder(View view) {
            super(view);
            breakingNewsHeadline = (TextView) view.findViewById(R.id.breakingNews);
            reporter = (TextView) view.findViewById(R.id.breakingNewsReporter);
            backgroundImage = view.findViewById(R.id.breakingNewsImage);
        }
    }


}
