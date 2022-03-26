package com.example.test.img;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.test.R;

import java.io.FileNotFoundException;

public class ImgActivity extends AppCompatActivity {

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_img);

        imageView = findViewById(R.id.iv1);
    }

    public static void getPermission(Activity activity){
        if(Build.VERSION.SDK_INT >=23){
            //获取系统的文写读写权限状态码(是否可读写)
            int isWriteable = ContextCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE);
            int isReadable = ContextCompat.checkSelfPermission(activity,Manifest.permission.READ_EXTERNAL_STORAGE);
            if(isWriteable!= PackageManager.PERMISSION_GRANTED || isReadable!= PackageManager.PERMISSION_GRANTED){
                //申请权限,会弹出授权对话框 ，可通过数组一次申请多个权限
                String permissions[] = {Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE};
                ActivityCompat.requestPermissions(activity,permissions,3);
            }else{
                Toast.makeText(activity,"已获取权限",Toast.LENGTH_SHORT).show();
            }
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode==3){
            for(int i = 0;i<grantResults.length;i++){
                if(grantResults[i]==-1){

                    finish();
                    Toast.makeText(this,"获取权限失败",Toast.LENGTH_SHORT).show();
                }
            }
        }
    }


    public void showResImg(View view) {
        imageView.setImageResource(R.drawable.maomao);

    }

    public void showDir(View view) {
        Bitmap bitmap = BitmapFactory.decodeFile("/");
        imageView.setImageBitmap(bitmap);
    }

    public void saveDir(View view) {
        Bitmap bitmap = BitmapFactory.decodeFile("/");
        try {
            bitmap.compress(Bitmap.CompressFormat.PNG,100,this.openFileOutput("test.png",MODE_PRIVATE));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}