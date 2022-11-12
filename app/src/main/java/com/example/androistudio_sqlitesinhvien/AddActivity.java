package com.example.androistudio_sqlitesinhvien;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.androistudio_sqlitesinhvien.dao.SinhVienDAO;
import com.example.androistudio_sqlitesinhvien.model.SinhVien;

public class AddActivity extends AppCompatActivity {

    //khaibao
    private EditText edtHoTen, edtEmail, edtSDT;
    private RadioGroup rgGioiTinh;
    private RadioButton rb_nam, rb_nu;
    private Button btnThem, btnThoat;
    private int gioiTinh=1;

    private SinhVienDAO svDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        //
        Anhxa();

        svDao = new SinhVienDAO(AddActivity.this);

        rgGioiTinh.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if (checkedId == R.id.rb_nam){
                    gioiTinh = 1;
                }
                else {
                    gioiTinh = 0;
                }
            }
        });

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String hoTen = edtHoTen.getText().toString();
                String email = edtEmail.getText().toString();
                String SDT = edtSDT.getText().toString();
                SinhVien sv = new SinhVien(hoTen,gioiTinh,SDT,email);
                svDao.ThemSinhVien(sv);
                Toast.makeText(AddActivity.this,"Thêm thành công", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void Anhxa() {
        edtHoTen = (EditText) findViewById(R.id.edt_hoTen);
        edtEmail = (EditText) findViewById(R.id.edt_email);
        edtSDT = (EditText) findViewById(R.id.edt_SDT);
        rgGioiTinh = (RadioGroup) findViewById(R.id.rg_gioiTinh);
        rb_nam = (RadioButton) findViewById(R.id.rb_nam);
        rb_nu = (RadioButton) findViewById(R.id.rb_nu);
        btnThem = (Button) findViewById(R.id.btn_them);
        btnThoat = (Button) findViewById(R.id.btn_thoat);
    }
}