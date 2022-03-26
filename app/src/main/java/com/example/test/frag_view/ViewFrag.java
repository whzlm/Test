package com.example.test.frag_view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import com.example.test.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class ViewFrag extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_frag);


        //创建FragmentStatePagerAdapter 适配器----装载Fragment
        List<Fragment>  frags = new ArrayList<Fragment>();
        frags.add(new Frag1());
        frags.add(new Frag2());


        List<String> titles = new ArrayList<>();
        titles.add("页面一");
        titles.add("页面二");

        //创建Fragment适配器Adapter
        FragmentManager fragmentManager = this.getSupportFragmentManager();
        FragAdapter fragAdapter = new FragAdapter(fragmentManager,frags,titles);
        //加载Adapter
        ViewPager viewPage = this.findViewById(R.id.vp2);
        viewPage.setAdapter(fragAdapter);

        //配合TagLab使用
        TabLayout tabLayout = this.findViewById(R.id.tab1);
        tabLayout.setupWithViewPager(viewPage);




    }
}