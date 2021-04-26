package com.example.gk_banh_10;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Banh_Adapter extends RecyclerView.Adapter<Banh_Adapter.ThingViewHolder> {
    private Context context;
    private ArrayList<Banh> banhs;
    Banh_Onclick banh_onclick;

    public Banh_Adapter(Context context, ArrayList<Banh> banhs, Banh_Onclick banh_onclick) {
        this.context = context;
        this.banhs = banhs;
        this.banh_onclick = banh_onclick;
    }

    @NonNull
    @Override
    public Banh_Adapter.ThingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.layout01, parent, false);

        return new ThingViewHolder(view, this);
    }



    @Override
    public int getItemCount() {
        return banhs.size();
    }

    public void filterList(ArrayList<Banh> banhss) {
        banhs = banhss;
        notifyDataSetChanged();
    }


    public class ThingViewHolder extends RecyclerView.ViewHolder {
        private TextView tvName_01, tvGia_01, tvNote_01, tvSoLuong;
        private ImageView imageView_01;
        private ImageButton imageButton_01;
        Banh banh;
        Banh_Adapter adapter;


        public ThingViewHolder(@NonNull View itemView, Banh_Adapter banh_adapter) {
            super(itemView);
            tvName_01 = itemView.findViewById(R.id.tvName_01);
            tvGia_01 = itemView.findViewById(R.id.tvGia_01);
            tvNote_01 = itemView.findViewById(R.id.tvNote_01);
            imageView_01 = itemView.findViewById(R.id.imageView_01);
            imageButton_01 = itemView.findViewById(R.id.imageButton_Add_01);
//            tvSoLuong = itemView.findViewById(R.id.tvSoLuong_02);

            this.adapter = banh_adapter;

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    banh_onclick.itemClick(banh);
                }
            });


        }
    }


    @Override
    public void onBindViewHolder(@NonNull Banh_Adapter.ThingViewHolder holder, int position) {
        Banh banh = banhs.get(position);

        holder.banh = banhs.get(position);


        holder.tvName_01.setText(banh.getTvName());
        holder.tvGia_01.setText(banh.getTvGia()+"");
        holder.tvNote_01.setText(banh.getTvNote());
        holder.imageView_01.setImageResource(banh.getImageView());
//        holder.tvSoLuong.setText(banh.getTvSoLuong()+"");


    }
}
