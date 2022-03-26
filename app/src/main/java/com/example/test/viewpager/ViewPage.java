package com.example.test.viewpager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.example.test.R;

import java.util.ArrayList;
import java.util.List;

public class ViewPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_page);


        ViewPager viewPage = this.findViewById(R.id.vp1);

        //创建需要切换的界面

        List<View> listPages = new ArrayList<>();

        listPages.add(LayoutInflater.from(this).inflate(R.layout.activity_page1,null));
        listPages.add(LayoutInflater.from(this).inflate(R.layout.activity_page2,null));
        listPages.add(LayoutInflater.from(this).inflate(R.layout.activity_page3,null));

        MypageAdapter mypageAdapter = new MypageAdapter(listPages);



        viewPage.setAdapter(mypageAdapter);
    }

    }
