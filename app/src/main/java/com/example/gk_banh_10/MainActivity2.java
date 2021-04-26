package com.example.gk_banh_10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    private TextView tvName_02, tvGia_02, tvNote_02, tvSoLuong_02;
    private ImageView imageView_02;
    private ImageButton imageButton_Minus_02, imageButton_Add_02;
    private Button btn_ADD;
    Banh banh;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        imageView_02 = findViewById(R.id.imageView_02);
        tvName_02 = findViewById(R.id.tvName_02);
        tvGia_02 = findViewById(R.id.tvGia_02);
        tvNote_02 = findViewById(R.id.tvNote_02);
        tvSoLuong_02 = findViewById(R.id.tvSoLuong_02);
        imageButton_Add_02 = findViewById(R.id.imageButton_Add_02);
        imageButton_Minus_02 = findViewById(R.id.imageButton_Minus_02);

        btn_ADD = findViewById(R.id.btn_ADD);

        Intent intent = getIntent();
        if(intent != null){
            banh = (Banh) intent.getSerializableExtra("key");
            tvName_02.setText(banh.getTvName());
            tvGia_02.setText(banh.getTvGia()+"");
            tvSoLuong_02.setText(banh.getTvSoLuong()+"");
            tvNote_02.setText(banh.getTvNote());
            imageView_02.setImageResource(banh.getImageView());

        }

        imageButton_Add_02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int soLuong = Integer.parseInt(tvSoLuong_02.getText().toString());
                soLuong++;
                tvSoLuong_02.setText(soLuong+"");
                banh.setTvSoLuong(soLuong);
            }
        });

        imageButton_Minus_02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int soLuong = Integer.parseInt(tvSoLuong_02.getText().toString());
                if(soLuong > 1){
                    soLuong--;
                    tvSoLuong_02.setText(soLuong+"");
                    banh.setTvSoLuong(soLuong);
                }

            }
        });




    }
}