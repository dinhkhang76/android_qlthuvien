package com.ledinhkhang.qltv;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;



public class ledinhkhang_fragmentlistSach extends Fragment implements  ledinhkhang_IClickListener{
    private ledinhkhang_AdapterSach adapterSach;
    private  IClickSendDataSach iClickSendDataSach;
    public interface IClickSendDataSach {
        public void onItemClickSach(ledinhkhang_Sach sach);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof IClickSendDataSach ){
            iClickSendDataSach= (IClickSendDataSach ) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement onViewSelected");
        }
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_listsach, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        EditText etTimkiemDH = view.findViewById(R.id.etTimkiemSanPham);
        RecyclerView rvSach = view.findViewById(R.id.rvSanPham);
        adapterSach = new ledinhkhang_AdapterSach(getContext(),this);
        adapterSach.setDta(getListSachs());
        rvSach.setHasFixedSize(true);
        rvSach.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        rvSach.setAdapter(adapterSach);


        etTimkiemDH.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                adapterSach.setDta(timkiemSach(getListSachs(),s.toString()));
            }
        });
    }

    private ArrayList<ledinhkhang_Sach> getListSachs() {
        return (ArrayList<ledinhkhang_Sach>) ledinhkhang_DatabaseApp.getInstance(getContext()).getSachDao().getListSach();
    }

    @Override
    public void OnClickListenerKhachHang(ledinhkhang_Sach sach) {
        iClickSendDataSach.onItemClickSach(sach);
    }

    @Override
    public void OnLongClickListenerKhachHang(ledinhkhang_Sach sach) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Thông báo")
                .setMessage("Bạn muốn xóa sách này?")
                .setPositiveButton("XÓA", (dialogInterface, i) -> {
                    ledinhkhang_DatabaseApp.getInstance(getContext()).getSachDao().deleteSach(sach);
                    adapterSach.setDta(ledinhkhang_DatabaseApp.getInstance(getContext()).getSachDao().getListSach());
                })
                .setNegativeButton("KHÔNG", (dialogInterface, i) -> dialogInterface.dismiss()).setIcon(R.drawable.ic_baseline_warning_24)
                .show();
    }
    private ArrayList<ledinhkhang_Sach> timkiemSach(ArrayList<ledinhkhang_Sach> list, String s){
        ArrayList<ledinhkhang_Sach> list1 = new ArrayList<>();
        for( ledinhkhang_Sach item : list){
            if(item.getTenSach().trim().toLowerCase().contains(s.trim().toLowerCase())){
                list1.add(item);
            }
        }
        return list1;
    }

    @Override
    public void onResume() {
        super.onResume();
        adapterSach.setDta(getListSachs());
    }
}