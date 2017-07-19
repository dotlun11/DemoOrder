package com.example.dotlun.demoorder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Dotlun on 11/07/2017.
 */

public class AdapterKhachHang extends BaseAdapter {
    Context context;
    ArrayList<KhachHang> list;

    public AdapterKhachHang(Context context, ArrayList<KhachHang> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
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
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.listview_row,null);
        TextView txtId = (TextView)row.findViewById(R.id.txtID);
        TextView txtName = (TextView)row.findViewById(R.id.txtName);
        TextView txtEmail = (TextView)row.findViewById(R.id.txtEmail);
        TextView txtSdt = (TextView)row.findViewById(R.id.txtSDT);
        TextView txtNoidung = (TextView)row.findViewById(R.id.txtNoiDung);

        KhachHang khachHang = list.get(position);
        txtId.setText(khachHang.id + "");
        txtName.setText(khachHang.ten);
        txtEmail.setText(khachHang.email);
        txtSdt.setText(khachHang.sdt);
        txtNoidung.setText(khachHang.noidung);
        return row;
    }
}
