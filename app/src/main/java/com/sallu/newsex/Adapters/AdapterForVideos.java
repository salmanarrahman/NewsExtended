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
import com.sallu.newsex.Database.Video;
import com.sallu.newsex.R;

import java.util.List;

public class AdapterForVideos  extends RecyclerView.Adapter<AdapterForVideos.MyViewHoldeer> {

    public List<Video> list;
    Context context;
    onNoteListener onNoteListener;


    public AdapterForVideos(Context context, List<Video> list,onNoteListener onNoteListener) {
        this.list = list;
        this.context = context;
        this.onNoteListener = onNoteListener;

    }

    @NonNull
    @Override
    public MyViewHoldeer onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_videos,parent,false);
        return new MyViewHoldeer(itemView,onNoteListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHoldeer holder, int position) {
        Video mClass =  list.get(position);
        holder.reporter.setText(mClass.getCameraman());
        Glide.with(context).load("http://iamsalman.xyz/newsX/"+mClass.getThumbnail()).into(holder.videoThumbnail);
        holder.videoHeadline.setText(mClass.getTitle());
        holder.play.setVisibility(View.VISIBLE);
        holder.play.setImageResource(R.drawable.play_thumbnail);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class MyViewHoldeer extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView videoHeadline, videoDuration,reporter;
        ImageView videoThumbnail,play;
        onNoteListener onNoteListener;


        public MyViewHoldeer(View view,onNoteListener onNoteListener) {
            super(view);
            this.onNoteListener = onNoteListener;
            reporter = view.findViewById(R.id.videoReporter);
            videoHeadline = (TextView) view.findViewById(R.id.videoTitle);
            videoThumbnail = view.findViewById(R.id.videoThumbnail);
            play = view.findViewById(R.id.play_thumbnail);
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
