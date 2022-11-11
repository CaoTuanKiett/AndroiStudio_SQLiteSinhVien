package com.example.androistudio_sqlitesinhvien.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.androistudio_sqlitesinhvien.R;
import com.example.androistudio_sqlitesinhvien.model.SinhVien;

import java.util.List;

public class SinhVienAdapter extends BaseAdapter {

    private List<SinhVien> sinhVienList;
    private Context context;

    public SinhVienAdapter(Context context, List<SinhVien> listList) {
        this.context = context;
        this.sinhVienList = listList;
    }

    @Override
    public int getCount() {
        return sinhVienList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        ViewHolder viewHolder;

        if (view == null) {
            viewHolder = new ViewHolder();

            // Convert resoure to View
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.list_item_sinhvien, null);

            // Ánh xạ
            viewHolder.tvMaSV = view.findViewById(R.id.tv_maSV);
            viewHolder.tvHoTen = view.findViewById(R.id.tv_hoTen);
            viewHolder.tvSDT = view.findViewById(R.id.tv_SDT);
            viewHolder.tvEmail = view.findViewById(R.id.tv_email);
            viewHolder.ivHinh = view.findViewById(R.id.iv_hinh);

            view.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) view.getTag();
        }

        SinhVien sv = sinhVienList.get(position);
        viewHolder.tvMaSV.setText("Mã SV :"+ sv.getMaSV());
        viewHolder.tvHoTen.setText("Họ Tên :"+ sv.getHoTen());
        viewHolder.tvSDT.setText("SĐT :"+ sv.getDienThoai());
        viewHolder.tvEmail.setText("Email :"+ sv.getEmail());
        if (sv.getGioiTinh()==0) {
            viewHolder.ivHinh.setImageResource(R.drawable.cat1);
        }
        else {
            viewHolder.ivHinh.setImageResource(R.drawable.cat2);
        }

        return view;
    }

    class ViewHolder {
        ImageView ivHinh;
        TextView tvMaSV, tvHoTen, tvSDT, tvEmail;
    }

}
