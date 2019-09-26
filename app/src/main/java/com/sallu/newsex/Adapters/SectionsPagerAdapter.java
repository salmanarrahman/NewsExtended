package com.sallu.newsex.Adapters;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.sallu.newsex.Activities.FragmentBrakingNews;
import com.sallu.newsex.Activities.FragmentVideos;
import com.sallu.newsex.Activities.FragmentTrending;
import com.sallu.newsex.Utils.Config;

public class SectionsPagerAdapter extends FragmentPagerAdapter {

    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                FragmentTrending fragmentTrending=new FragmentTrending();
                Bundle bundle=new Bundle();
             //   bundle.putString("NAME",nameString);
             //   profileActivity.setArguments(bundle);
                return fragmentTrending;
            case 1:
                FragmentBrakingNews fragmentBrakingNews = new FragmentBrakingNews();
                return fragmentBrakingNews;
            case 2:
            FragmentVideos fragmentPhotos=new FragmentVideos();
            return fragmentPhotos;

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        // Show 3 total pages.
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return Config.TRENDING;
            case 1:
                return Config.BRAKING_NEWS;
            case 2:
                return Config.VIDEOS;


        }
        return null;
    }
}