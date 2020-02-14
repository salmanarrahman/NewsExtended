package com.sallu.newsex.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.solver.widgets.ConstraintHorizontalLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.sallu.newsex.Database.BreakingNews;
import com.sallu.newsex.ModelClass.BreakingnewsModelClass;
import com.sallu.newsex.R;

import java.util.List;

public class AdapterForBreakingNews extends  RecyclerView.Adapter<AdapterForBreakingNews.MyViewHolder> {

    List<BreakingNews> list;
    Context context;
    onNoteListener onNoteListener;
    public AdapterForBreakingNews(onNoteListener onNoteListener,Context context,List<BreakingNews> list) {
        this.context = context;
        this.list = list;
        this.onNoteListener = onNoteListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_breakingnews,parent,false);

        return new MyViewHolder(view,onNoteListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        BreakingNews mClass = list.get(position);
//        holder.backgroundImage.setImageResource(mClass.getBgImage());
        holder.breakingNewsHeadline.setText(mClass.getHeadline());
        holder.reporter.setText(mClass.getReporter());
        Glide.with(context).load("http://iamsalman.xyz/frontend/"+mClass.getThumbnail()).into(holder.backgroundImage);


    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder implements  View.OnClickListener{
        public TextView breakingNewsHeadline, reporter;
        ImageView backgroundImage;
        onNoteListener onNoteListener;

        public MyViewHolder(View view,onNoteListener onNoteListener) {
            super(view);
            this.onNoteListener = onNoteListener;
            breakingNewsHeadline = (TextView) view.findViewById(R.id.breakingNews);
            reporter = (TextView) view.findViewById(R.id.breakingNewsReporter);
            backgroundImage = view.findViewById(R.id.breakingNewsImage);
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
