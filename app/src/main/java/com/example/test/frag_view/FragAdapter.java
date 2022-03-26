package com.example.test.frag_view;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.List;

public class FragAdapter extends FragmentStatePagerAdapter {

    List<String> titles;
    List<Fragment> frag_list;

    public FragAdapter(@NonNull FragmentManager fragmentManager,List<Fragment> frag_list,List<String> titles) {
        super(fragmentManager);
        this.frag_list=frag_list;
        this.titles = titles;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return frag_list.get(position);
    }

    @Override
    public int getCount() {
        return frag_list.size();
    }

    @NonNull
    @Override
    public CharSequence getPageTitle(int position){
        return titles.get(position);
    }


//    public FragAdapter(@NonNull FragmentManager fragmentManager,List<Fragment> frag_list) {
//        super(fragmentManager,null);
//        this.frag_list = frag_list;
//    }




}
