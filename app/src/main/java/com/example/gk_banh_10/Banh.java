package com.example.gk_banh_10;

import java.io.Serializable;

public class Banh implements Serializable {
    private String tvName, tvNote;
    private int tvGia;
    private int imageView;
    private int tvSoLuong;

    public Banh(String tvName, String tvNote, int tvGia, int imageView, int tvSoLuong) {
        this.tvName = tvName;
        this.tvNote = tvNote;
        this.tvGia = tvGia;
        this.imageView = imageView;
        this.tvSoLuong = tvSoLuong;
    }

    public String getTvName() {
        return tvName;
    }

    public void setTvName(String tvName) {
        this.tvName = tvName;
    }

    public String getTvNote() {
        return tvNote;
    }

    public void setTvNote(String tvNote) {
        this.tvNote = tvNote;
    }

    public int getTvGia() {
        return tvGia;
    }

    public void setTvGia(int tvGia) {
        this.tvGia = tvGia;
    }

    public int getImageView() {
        return imageView;
    }

    public void setImageView(int imageView) {
        this.imageView = imageView;
    }

    public int getTvSoLuong() {
        return tvSoLuong;
    }

    public void setTvSoLuong(int tvSoLuong) {
        this.tvSoLuong = tvSoLuong;
    }
}
