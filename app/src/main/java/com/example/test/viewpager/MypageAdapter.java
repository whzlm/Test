package com.example.test.viewpager;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

public class MypageAdapter extends PagerAdapter {

    List<View> page_list;

    public MypageAdapter(List<View> page_list){
        this.page_list = page_list;
    }


    @Override
    public int getCount() {
        return page_list.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @Override
    //销毁一个页卡
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView(page_list.get(position));
    }

    @NonNull
    @Override
    //实例化一个页卡
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        container.addView(page_list.get(position));
        return page_list.get(position);
    }



//    @Override
//    //销毁一个页面
//    public void destoryItem(@NonNull ViewGroup container,int posithon,@NonNull Object object)
//    {
//        container.removeView(page_list.get(posithon));
//    }

}
