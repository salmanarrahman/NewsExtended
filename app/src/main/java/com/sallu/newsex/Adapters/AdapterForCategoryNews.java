package com.sallu.newsex.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sallu.newsex.Database.Categories;
import com.sallu.newsex.ModelClass.BreakingnewsModelClass;
import com.sallu.newsex.ModelClass.CategorywiseNewsModelClass;
import com.sallu.newsex.R;

import java.util.List;

public class AdapterForCategoryNews extends  RecyclerView.Adapter<AdapterForCategoryNews.MyViewHolderr> {

    List<CategorywiseNewsModelClass> list;

    public AdapterForCategoryNews(List<CategorywiseNewsModelClass> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolderr onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_news_by_category,parent,false);

        return new AdapterForCategoryNews.MyViewHolderr(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderr holder, int position) {

        CategorywiseNewsModelClass mClass = list.get(position);
        holder.backgroundImage.setImageResource(mClass.getBgImage());
        holder.headLine.setText(mClass.getHeadline());
        holder.reporter.setText(mClass.getReporter());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class MyViewHolderr extends RecyclerView.ViewHolder {
        public TextView headLine, reporter;
        ImageView backgroundImage;

        public MyViewHolderr(View view) {
            super(view);
            headLine = (TextView) view.findViewById(R.id.headlineOfCategory);
            reporter = (TextView) view.findViewById(R.id.newsReporterByCategory);
            backgroundImage = view.findViewById(R.id.imageOfCategoryWise);
        }
    }


}
