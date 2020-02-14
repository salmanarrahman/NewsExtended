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
import com.sallu.newsex.Database.Categories;
import com.sallu.newsex.Database.CategorywiseNews;
import com.sallu.newsex.ModelClass.BreakingnewsModelClass;
import com.sallu.newsex.ModelClass.CategorywiseNewsModelClass;
import com.sallu.newsex.R;

import java.util.List;

public class AdapterForCategoryNews extends  RecyclerView.Adapter<AdapterForCategoryNews.MyViewHolderr> {

    List<CategorywiseNews> list;
    Context context;
    onNoteListener onNoteListener;

    public AdapterForCategoryNews(onNoteListener onNoteListener,Context context,List<CategorywiseNews> list) {
        this.context = context;
        this.list = list;
        this.onNoteListener = onNoteListener;
    }

    @NonNull
    @Override
    public MyViewHolderr onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_news_by_category,parent,false);

        return new AdapterForCategoryNews.MyViewHolderr(view,onNoteListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderr holder, int position) {

        CategorywiseNews mClass = list.get(position);
        Glide.with(context).load("http://iamsalman.xyz/frontend/"+mClass.getThumbnail()).into(holder.backgroundImage);
        holder.headLine.setText(mClass.getHeadline());
        holder.reporter.setText(mClass.getReporter());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class MyViewHolderr extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView headLine, reporter;
        ImageView backgroundImage;
        onNoteListener onNoteListener;

        public MyViewHolderr(View view,onNoteListener onNoteListener) {
            super(view);
            this.onNoteListener = onNoteListener;
            headLine = (TextView) view.findViewById(R.id.headlineOfCategory);
            reporter = (TextView) view.findViewById(R.id.newsReporterByCategory);
            backgroundImage = view.findViewById(R.id.imageOfCategoryWise);
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
