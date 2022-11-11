package com.example.androistudio_sqlitesinhvien.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    public DbHelper(@Nullable Context context) {
        super(context, "SinhVien.sqlite", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlSVCreate = "CREATE TABLE IF NOT EXISTS " +
                "SinhVien(maSV INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "hoTen VARCHAR(200)," +
                "gioiTinh INTEGER," +
                "dienThoai VARCHAR(13)," +
                "email VARCHAR(200))" ;
        db.execSQL(sqlSVCreate);



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
