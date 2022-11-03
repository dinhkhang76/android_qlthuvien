package com.ledinhkhang.qltv;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "Sach")
public class ledinhkhang_Sach implements Serializable {
    @PrimaryKey
    @NonNull
    private String maSach;
    private String tenSach;
    private String loaiSach;
    private String tacGia;
    private Long soLuong;
    private Long giaban;

    public ledinhkhang_Sach(@NonNull String maSach, String tenSach, String loaiSach,
                            String tacGia, Long soLuong, Long giaban) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.loaiSach = loaiSach;
        this.tacGia = tacGia;
        this.soLuong = soLuong;
        this.giaban = giaban;
    }

    @NonNull
    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(@NonNull String maSach) {
        this.maSach = maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getLoaiSach() {
        return loaiSach;
    }

    public void setLoaiSach(String loaiSach) {
        this.loaiSach = loaiSach;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public Long getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Long soLuong) {
        this.soLuong = soLuong;
    }

    public Long getGiaban() {
        return giaban;
    }

    public void setGiaban(Long giaban) {
        this.giaban = giaban;
    }
}
