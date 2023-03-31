package com.application.adapterapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DBHelper helper;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        helper=new DBHelper(MainActivity.this);
        db=helper.getWritableDatabase();
        Button button1=findViewById(R.id.button_add);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // String sql="insert into testing(id,name,age) values(1,'zs',2021)";
                //db.execSQL(sql);
                ContentValues values=new ContentValues();
                values.put("id",1);
                values.put("name","刘四");
                values.put("age",2022);
                db.insert("testing",null,values);
                Toast.makeText(MainActivity.this, "创建成功", Toast.LENGTH_SHORT).show();
            }
        });
    }
}