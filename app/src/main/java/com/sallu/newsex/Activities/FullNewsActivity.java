package com.sallu.newsex.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.sallu.newsex.R;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class FullNewsActivity extends AppCompatActivity {

    ImageView imageView;
    TextView headline,news,reporter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_news);
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/Raleway-Regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );

        imageView = findViewById(R.id.extendedImage);
        headline = findViewById(R.id.extendedHeadline);
        news = findViewById(R.id.extendedNews);
        reporter = findViewById(R.id.extendedReporter);

        Bundle bundle = getIntent().getExtras();
        String Headline = bundle.getString("headline");
        String News = bundle.getString("news");
        String Reporter = bundle.getString("reporter");
        String image = bundle.getString("image");

        Glide.with(getApplicationContext()).load("http://iamsalman.xyz/frontend/"+image).into(imageView);

        headline.setText(Headline);
        news.setText(News);
        reporter.setText(Reporter);


    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }


}
