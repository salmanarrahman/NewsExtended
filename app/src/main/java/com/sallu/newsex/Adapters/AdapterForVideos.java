package com.sallu.newsex.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sallu.newsex.ModelClass.TrendingModelClass;
import com.sallu.newsex.ModelClass.VideosModelClass;
import com.sallu.newsex.R;

import java.util.List;

public class AdapterForVideos  extends RecyclerView.Adapter<AdapterForVideos.MyViewHoldeer> {

    public List<VideosModelClass> list;

    public AdapterForVideos(List<VideosModelClass> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHoldeer onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_videos,parent,false);


        return new MyViewHoldeer(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHoldeer holder, int position) {

        VideosModelClass mClass =  list.get(position);
        holder.videoThumbnail.setImageResource(mClass.getThumbnail());
        holder.videoHeadline.setText(mClass.getNews());
        holder.reporter.setText(mClass.getReporter());
        holder.videoDuration.setText(mClass.getDuration());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class MyViewHoldeer extends RecyclerView.ViewHolder {
        public TextView videoHeadline, videoDuration,reporter;
        ImageView videoThumbnail;

        public MyViewHoldeer(View view) {
            super(view);
            reporter = view.findViewById(R.id.videoReporter);
            videoHeadline = (TextView) view.findViewById(R.id.videoheadline);
            videoDuration = (TextView) view.findViewById(R.id.videoDuration);
            videoThumbnail = view.findViewById(R.id.videoThumbnail);
        }
    }

}
