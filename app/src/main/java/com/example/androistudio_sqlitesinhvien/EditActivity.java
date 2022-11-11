package com.example.androistudio_sqlitesinhvien;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.androistudio_sqlitesinhvien.dao.SinhVienDAO;
import com.example.androistudio_sqlitesinhvien.model.SinhVien;

public class EditActivity extends AppCompatActivity {

    private TextView tvHoTen;
    private EditText edtHoTen, edtEmail, edtSDT;
    private RadioGroup rgGioiTinh;
    private RadioButton rb_nam, rb_nu;
    private Button btnLuu, btnThoat, btnXoa;
    private SinhVienDAO svDAO;
    int  gioiTinh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        svDAO = new SinhVienDAO(EditActivity.this);

        //Lấy dữ liệu
        Intent intent = getIntent();
        SinhVien sinhVien = (SinhVien) intent.getSerializableExtra("DULIEU");

        AnhXa();

        // Đẩy dữ liệu
        edtHoTen.setText(sinhVien.getHoTen());
        edtEmail.setText(sinhVien.getEmail());
        edtSDT.setText(sinhVien.getDienThoai());
        if(sinhVien.getGioiTinh() == 1){
            rb_nam.setChecked(true);
            gioiTinh = 1;
        }
        else {
            rb_nu.setChecked(true);
            gioiTinh = 0;
        }

        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //Sự kiện click giới tính
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

        // Click LƯU
        btnLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sinhVien.setHoTen(edtHoTen.getText().toString());
                sinhVien.setEmail(edtEmail.getText().toString());
                sinhVien.setDienThoai(edtSDT.getText().toString());
                sinhVien.setGioiTinh(gioiTinh);
                svDAO.CapNhatSinhVien(sinhVien);

            }
        });

        btnXoa.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(EditActivity.this, android.R.style.Theme_DeviceDefault_Light_Dialog);
                builder.setTitle("DELETE");
                builder.setMessage("Bạn muốn XÓA ????");
                builder.setIcon(android.R.drawable.ic_dialog_alert);

                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        sinhVien.setHoTen(edtHoTen.getText().toString());
                        sinhVien.setEmail(edtEmail.getText().toString());
                        sinhVien.setDienThoai(edtSDT.getText().toString());
                        sinhVien.setGioiTinh(gioiTinh);
                        svDAO.XoaSinhVien(sinhVien);

                        finish();
                    }
                });

                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

                builder.show();

            }
        });


    }

    private void AnhXa() {
        edtHoTen = (EditText) findViewById(R.id.edt_hoTen);
        edtEmail = (EditText) findViewById(R.id.edt_email);
        edtSDT = (EditText) findViewById(R.id.edt_SDT);
        rgGioiTinh = (RadioGroup) findViewById(R.id.rg_gioiTinh);
        rb_nam = (RadioButton) findViewById(R.id.rb_nam);
        rb_nu = (RadioButton) findViewById(R.id.rb_nu);
        btnLuu = (Button) findViewById(R.id.btn_luu);
        btnThoat = (Button) findViewById(R.id.btn_thoat);
        btnXoa = (Button) findViewById(R.id.btn_xoa);
        tvHoTen = (TextView) findViewById(R.id.tv_hoTen);
    }
}