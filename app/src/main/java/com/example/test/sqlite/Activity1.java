package com.example.test.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.test.R;

public class Activity1 extends AppCompatActivity {

    private MySQLite mySQLite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);

        mySQLite = new MySQLite(this);
    }

    public void insert(View view) {
        //获取数据库
        SQLiteDatabase database = mySQLite.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("id",1);
        values.put("name","光明");
        values.put("score",1200);
        long new_id = database.insert("stu",null,values);
        database.close();
        Log.e("插入数据的id是",new_id+"");
    }

    public void query(View view) {
        SQLiteDatabase database = mySQLite.getWritableDatabase();

        Cursor cursor = database.query("stu",new String[]{"id","name","score"},null,null
        ,null,null,null);

        if (cursor.getCount()!=0){
            while (cursor.moveToNext()){
                String id = cursor.getString(0);
                @SuppressLint("Range") String score = cursor.getString(cursor.getColumnIndex("score"));
                String name = cursor.getString(2);
                System.out.println(id +"  " + name+"  "+score);
            }
        }

        cursor.close();
        database.close();

    }

    public void delete(View view) {
        SQLiteDatabase database = mySQLite.getWritableDatabase();
        int total = database.delete("stu","id=?",new String[]{"1"});
        database.close();
        Log.e("受影响的数据条数",total +"");

    }

    public void updata(View view) {
        SQLiteDatabase Database = mySQLite.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name","光明哥");

        int total = Database.update("stu",values,"id=?",new String[]{"1"});

        Log.e("受影响的数据条数",total+"");

    }
}