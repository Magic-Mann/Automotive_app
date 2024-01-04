package com.example.automotivereservation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class CustomerList extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<String> id, name, type, location, dateR;
    DatabaseHelper DB;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_list);
        DB = new DatabaseHelper(this);
        id = new ArrayList<>();
        name = new ArrayList<>();
        type = new ArrayList<>();
        location = new ArrayList<>();
        dateR = new ArrayList<>();
        recyclerView = findViewById(R.id.list);
        adapter = new MyAdapter(this,id,name,type,location,dateR);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displaydata();
        


    }

    private void displaydata() {

        Cursor cursor = DB.getdata();
        if(cursor.getCount() == 0){
            Toast.makeText(CustomerList.this,"No Entry Exists",Toast.LENGTH_SHORT).show();
            return;
        }
        else{
            while (cursor.moveToNext()){
                id.add(cursor.getString(0));
                name.add(cursor.getString(1));
                type.add(cursor.getString(2));
                location.add(cursor.getString(3));
                dateR.add(cursor.getString(4));
            }
        }
    }
}