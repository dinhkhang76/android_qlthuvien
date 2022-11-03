package com.ledinhkhang.qltv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ledinhkhang_activityUpdate extends AppCompatActivity {
    private EditText etMa,etTen,etLoai,etTacGia,etSoLuong,etGia;
    private Button btnUpdate;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ledinhkhang_update);
        anhXa();
        btnUpdate.setOnClickListener(view -> {
            if(btnUpdate.getText().toString().equals("CẬP NHẬT")) {
                textView.setText("CẬP NHẬT SÁCH");
                etTen.setEnabled(true);
                etLoai.setEnabled(true);
                etTacGia.setEnabled(true);
                etSoLuong.setEnabled(true);
                etGia.setEnabled(true);
                btnUpdate.setText("LƯU THÔNG TIN");
            }else if(btnUpdate.getText().toString().equals("LƯU THÔNG TIN")){
                String ten = etTen.getText().toString();
                String ma = etMa.getText().toString();
                String loai = etLoai.getText().toString();
                String tacgia = etTacGia.getText().toString();
                String soluong = etSoLuong.getText().toString();
                String gia = etGia.getText().toString();
                if(ten.isEmpty() || ma.isEmpty() || loai.isEmpty() ||tacgia.isEmpty() ||
                        soluong.isEmpty() ||gia.isEmpty() ) {
                    Toast.makeText(getApplicationContext(),"Chưa điền đầy đủ thông tin",Toast.LENGTH_SHORT).show();
                }else{
                    ledinhkhang_Sach khachHANG = new ledinhkhang_Sach(ma,ten,loai,tacgia
                            ,Long.valueOf(soluong),Long.valueOf(gia));
                    ledinhkhang_DatabaseApp.getInstance(getApplicationContext()).getSachDao()
                            .updateSach(khachHANG);
                    Toast.makeText(getApplicationContext(),"Cập nhật thành công",Toast.LENGTH_SHORT).show();
                    textView.setText("CHI TIẾT SÁCH");
                    btnUpdate.setText("CẬP NHẬT");
                    etTen.setEnabled(false);
                    etLoai.setEnabled(false);
                    etTacGia.setEnabled(false);
                    etSoLuong.setEnabled(false);
                    etGia.setEnabled(false);
                    //cap nhat thanh cong, chuyen ve man hinh chinh
                    Intent intent = new Intent(ledinhkhang_activityUpdate.this,ledinhkhang_activitymain.class);
                    startActivity(intent);



                }
            }

        });

    }

    private void anhXa() {
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        ledinhkhang_Sach sach = (ledinhkhang_Sach) bundle.getSerializable("SACH");
        etTen = findViewById(R.id.etTenSU);
        etTen.setText(sach.getTenSach());

        etMa = findViewById(R.id.etmaSU);
        etMa.setText(sach.getMaSach());

        etLoai = findViewById(R.id.etLoaiU);
        etLoai.setText(sach.getLoaiSach());

        etTacGia = findViewById(R.id.etTacU);
        etTacGia.setText(sach.getTacGia());

        etSoLuong = findViewById(R.id.etSoU);
        etSoLuong.setText(sach.getSoLuong()+"");

        etGia = findViewById(R.id.etGiaU);
        etGia.setText(sach.getGiaban()+"");

        btnUpdate = findViewById(R.id.btnUpdate);
        textView = findViewById(R.id.textView);
    }
}