package com.example.androistudio_sqlitesinhvien.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.androistudio_sqlitesinhvien.database.DbHelper;
import com.example.androistudio_sqlitesinhvien.model.SinhVien;

import java.util.ArrayList;
import java.util.List;

public class SinhVienDAO {

    private DbHelper csdl;

    public SinhVienDAO(Context context){
        csdl = new DbHelper(context);
    }

    //Lấy tất cả sinh viên
    public List<SinhVien> TatCaSinhVien() {
        String sql="SELECT * FROM SinhVien";
        List<SinhVien> sinhVienList = new ArrayList<SinhVien>();
        SQLiteDatabase database = csdl.getReadableDatabase();
        Cursor cursor = database.rawQuery(sql,null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast())
        {
            int masv = cursor.getInt(0);
            String hoten = cursor.getString(1);
            int gioitinh = cursor.getInt(2);
            String dienthoai = cursor.getString(3);
            String email = cursor.getString(4);
            SinhVien sv = new SinhVien(masv, hoten, gioitinh, dienthoai, email);
            sinhVienList.add(sv);
            cursor.moveToNext();
        }

        return sinhVienList;
    }

    //Lấy 1 sinh viên

    //Thêm sinh viên
    public void ThemSinhVien(SinhVien sv){
        SQLiteDatabase database = csdl.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("hoten",sv.getHoTen());
        values.put("email",sv.getEmail());
        values.put("dienthoai",sv.getDienThoai());
        values.put("gioitinh",sv.getGioiTinh());
        database.insert("SinhVien", "",values);
    }

    //Cập nhật sinh viên
    public void CapNhatSinhVien(SinhVien sv){
        SQLiteDatabase database = csdl.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("hoten",sv.getHoTen());
        values.put("email",sv.getEmail());
        values.put("dienthoai",sv.getDienThoai());
        values.put("gioitinh",sv.getGioiTinh());
        String masv = String.valueOf(sv.getMaSV());
        String thamso[] = {masv};
        database.update("SinhVien",values,"maSV=?",thamso);
    }

    //xóa sinh viên
    public void XoaSinhVien(SinhVien sv){
        SQLiteDatabase database = csdl.getWritableDatabase();
        String masv = String.valueOf(sv.getMaSV());
        String thamso[] = {masv};
        database.delete("SinhVien","maSV=?",thamso);

    }


}
