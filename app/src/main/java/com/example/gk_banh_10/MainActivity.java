package com.example.gk_banh_10;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Banh_Onclick, TextWatcher {

    private RecyclerView rcv_Banh;
    private ArrayList<Banh> banhArrayList;
    private  Banh_Adapter banh_adapter;
    private EditText search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rcv_Banh = findViewById(R.id.rcv_Banh);

        search =findViewById(R.id.search);///////////////////////////////////////////////////////////////////////

        search.addTextChangedListener(this);///////////////////////////////////////////////////////////////////////

        banhArrayList = new ArrayList<>();
        banhArrayList.add(new Banh("Banh 01", "Banh ngon", 10, R.drawable.donut_red, 1));
        banhArrayList.add(new Banh("Banh 02", "Banh ngon", 20, R.drawable.donut_yellow, 2));
        banhArrayList.add(new Banh("Banh 03", "Banh ngon", 30, R.drawable.green_donut, 1));
        banhArrayList.add(new Banh("Banh 04", "Banh ngon", 40, R.drawable.tasty_donut, 1));

        banh_adapter = new Banh_Adapter(this,banhArrayList, this);
        rcv_Banh.setAdapter(banh_adapter);
        rcv_Banh.setHasFixedSize(true);
//        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
//        rcv_Banh.setLayoutManager(layoutManager);
        rcv_Banh.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

    }

    @Override
    public void itemClick(Banh banh) {
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        intent.putExtra("key", banh);
        startActivity(intent);

    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        filter(s.toString());

    }


    private void filter(String s) {
        ArrayList<Banh> banhss = new ArrayList<>();
        for (Banh b:banhArrayList){
            if (b.getTvName().toLowerCase().contains(s.toLowerCase()) || (b.getTvSoLuong()+"").toLowerCase().contains(s.toLowerCase())  ){
                banhss.add(b);
            }
        }
        banh_adapter.filterList(banhss);
    }
}