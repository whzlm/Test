package com.example.test.fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.test.R;

public class FragActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frag);

        //初始显示的Fragment界面
        getSupportFragmentManager().beginTransaction().replace(R.id.fgtest,new Fragment1()).commit();
    }

    public void showFrameMent1(View view) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fgtest,new Fragment1()).commit();
    }

    public void showFrameMent2(View view) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fgtest,new Fragment2()).commit();
    }
}