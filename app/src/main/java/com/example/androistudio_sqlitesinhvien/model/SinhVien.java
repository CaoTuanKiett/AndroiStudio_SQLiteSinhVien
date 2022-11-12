package com.example.androistudio_sqlitesinhvien.model;

import java.io.Serializable;

public class SinhVien  implements Serializable {

    private int maSV;
    private String hoTen;
    private int gioiTinh;
    private String dienThoai;
    private String email;

    public SinhVien() {
    }

    public SinhVien(String hoTen, int gioiTinh, String dienThoai, String email) {
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.dienThoai = dienThoai;
        this.email = email;
    }

    public SinhVien(int maSV, String hoTen, int gioiTinh, String dienThoai, String email) {
        this.maSV = maSV;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.dienThoai = dienThoai;
        this.email = email;
    }

    public int getMaSV() {
        return maSV;
    }

    public void setMaSV(int maSV) {
        this.maSV = maSV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public int getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(int gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDienThoai() {
        return dienThoai;
    }

    public void setDienThoai(String dienThoai) {
        this.dienThoai = dienThoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
