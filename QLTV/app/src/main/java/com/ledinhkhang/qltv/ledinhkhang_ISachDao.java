package com.ledinhkhang.qltv;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ledinhkhang_ISachDao {

    @Insert
    public void insertSach(ledinhkhang_Sach sach);

    @Update
    public void updateSach(ledinhkhang_Sach sach);

    @Delete
    public void deleteSach(ledinhkhang_Sach sach);

    @Query("SELECT * FROM Sach")
    public List<ledinhkhang_Sach> getListSach();

    @Query("SELECT * FROM sach WHERE maSach = :masach")
    public List<ledinhkhang_Sach> check(String masach);
}
