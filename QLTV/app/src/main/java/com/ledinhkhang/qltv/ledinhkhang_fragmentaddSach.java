package com.ledinhkhang.qltv;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ledinhkhang_fragmentaddSach extends Fragment {
    private EditText etMa,etTen,etLoai,etTacGia,etSoLuong,etGia;
    private Button btnThem;
    
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_addsach, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        AnhXa(view);
       btnThem.setOnClickListener(view1 -> {
           String ma = etMa.getText().toString();
           String ten = etTen.getText().toString();
           String loai = etLoai.getText().toString();
           String tacgia = etTacGia.getText().toString();
           String soluong = etSoLuong.getText().toString();
           String gia = etGia.getText().toString();

           if(ma.isEmpty() || ten.isEmpty() || loai.isEmpty() ||tacgia.isEmpty() ||
                   soluong.isEmpty() ||gia.isEmpty() ) {
               Toast.makeText(getContext(),"Chưa điền đầy đủ thông tin",Toast.LENGTH_SHORT).show();
           }else{
               if(ledinhkhang_DatabaseApp.getInstance(getContext()).getSachDao().check(ma).size() == 0){

                   ledinhkhang_Sach khachHANG = new ledinhkhang_Sach(ma,ten,loai,tacgia
                           ,Long.valueOf(soluong),Long.valueOf(gia));
                   ledinhkhang_DatabaseApp.getInstance(getContext()).getSachDao()
                           .insertSach(khachHANG);
                   Toast.makeText(getContext(),"Thêm thành công",Toast.LENGTH_SHORT).show();
                   setEdittex();
                   //them sach thanh cong, chuyen ve man hinh chinh
                   Intent intent = new Intent(getActivity(), ledinhkhang_activitymain.class);
                   startActivity(intent);
               }else{
                   Toast.makeText(getContext(),"Mã sách đã tồn tại",Toast.LENGTH_SHORT).show();

               }
           }
       });
    }

    private void setEdittex() {
        etMa.setText("");
        etTen.setText("");
        etLoai.setText("");
        etTacGia.setText("");
        etSoLuong.setText("");
        etGia.setText("");
    }
    private void AnhXa(View view) {
        etMa = view.findViewById(R.id.etMaSach);
        etTen = view.findViewById(R.id.etTenSach);
        etLoai = view.findViewById(R.id.etLoaiSach);
        etTacGia = view.findViewById(R.id.etTacGia);
        etSoLuong = view.findViewById(R.id.etSoLuong);
        etGia = view.findViewById(R.id.etGia);
        btnThem = view.findViewById(R.id.btnThem);
    }
}