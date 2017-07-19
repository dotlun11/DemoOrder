package com.example.dotlun.demoorder;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    final String DATABASE_NAME = "RestaurantDB.sqlite";
    SQLiteDatabase database;
    ListView listView;
    ArrayList<KhachHang> list;
    AdapterKhachHang adapter;
    Button btnAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        readData();
        BottomNavigationView bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_Restaurant:
                        Intent intent = new Intent(MainActivity.this,Restaurant.class);
                        startActivity(intent);
                    case R.id.action_Coffe:
                      //  Intent icoffee = new Intent(MainActivity.this,Coffee.class);
                       // startActivity(icoffee);
                    case R.id.action_add3:
                       // Intent intent2 = new Intent(MainActivity.this,Karaoke.class);
                        //startActivity(intent2);
                }
                return true;
            }
        });
    }
    private void addControls(){

        listView = (ListView) findViewById(R.id.listView);
        list = new ArrayList<>();
        adapter = new AdapterKhachHang(this,list);
        listView.setAdapter(adapter);
    }
    private void readData(){
        database = Database.initDatabase(this,DATABASE_NAME);
        Cursor cursor = database.rawQuery("SELECT * FROM KhachHang",null);
        list.clear();
        for (int i = 0; i < cursor.getCount(); i ++) {
            cursor.moveToPosition(i);
            int id = cursor.getInt(0);
            String ten = cursor.getString(1);
            String email = cursor.getString(2);
            String sdt = cursor.getString(3);
            String noidung = cursor.getString(4);

            list.add(new KhachHang(id,ten,email,sdt,noidung));
        }
        adapter.notifyDataSetChanged();
    }
}