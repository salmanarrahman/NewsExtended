package com.sallu.newsex.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.sallu.newsex.R;
import com.sallu.newsex.Utils.Config;

public class VideoPlayerActivity extends YouTubeBaseActivity {

    YouTubePlayerView youTubePlayerView;
    YouTubePlayer.OnInitializedListener onInitializedListener;
    TextView headlineText,cameramanText,news;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);
        youTubePlayerView = findViewById(R.id.youtubePlayerView);
        headlineText = findViewById(R.id.videoTitle);
        cameramanText = findViewById(R.id.cameraManText);
        news = findViewById(R.id.littleDescription);

        Bundle bundle = getIntent().getExtras();
        String Headline = bundle.getString("headline");
        String News = bundle.getString("news");
        String Reporter = bundle.getString("cameraman");
        final String address = bundle.getString("videoAdd");

        headlineText.setText(Headline);
        cameramanText.setText(Reporter);
        news.setText(News);

        onInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {

             //   youTubePlayer.loadVideo("hYPvuYH75eg");
                youTubePlayer.loadVideo(address);

            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };

        youTubePlayerView.initialize(Config.API_KEY,onInitializedListener);


    }
}
