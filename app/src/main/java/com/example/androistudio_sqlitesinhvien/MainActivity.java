package com.example.androistudio_sqlitesinhvien;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.androistudio_sqlitesinhvien.adapter.SinhVienAdapter;
import com.example.androistudio_sqlitesinhvien.dao.SinhVienDAO;
import com.example.androistudio_sqlitesinhvien.model.SinhVien;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ImageView imgbtnThem;
    private ListView lvSinhVien;
    private List<SinhVien> sinhVienList;
    private SinhVienAdapter adapter;
    private SinhVienDAO svDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ánh xạ
        lvSinhVien = (ListView) findViewById(R.id.lv_sinhVien);
        imgbtnThem = (ImageView) findViewById(R.id.img_btn_them);
        // Có dữ liệu
        sinhVienList = new ArrayList<SinhVien>();
        svDao = new SinhVienDAO(MainActivity.this);
        sinhVienList = svDao.TatCaSinhVien();

        //
        adapter = new SinhVienAdapter(getApplicationContext(),sinhVienList);
        lvSinhVien.setAdapter(adapter);

        // Sự kiện list sinh viên
        suKien_ListView();


        Intent intent = getIntent();
        SinhVien sinhVien = (SinhVien) intent.getSerializableExtra("DULIEU");

        imgbtnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddActivity.class);
                startActivity(intent);
            }
        });

    }

    private void suKien_ListView() {
        lvSinhVien.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SinhVien sv = sinhVienList.get(position);
                Intent intent = new Intent(MainActivity.this, EditActivity.class);
                intent.putExtra("DULIEU", sv);
                startActivity(intent);
            }
        });
    }


    @Override
    protected void onResume() {
        super.onResume();
        sinhVienList.clear();
        sinhVienList.addAll(svDao.TatCaSinhVien());
        adapter.notifyDataSetChanged();
    }


}