package com.ledinhkhang.qltv;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DecimalFormat;
import java.util.List;

public class ledinhkhang_AdapterSach extends RecyclerView.Adapter<ledinhkhang_AdapterSach.ViewHolder> {
    private List<ledinhkhang_Sach> listsachs;
    private final ledinhkhang_IClickListener clickListener;
    private final Context mContext;

    public ledinhkhang_AdapterSach( Context mContext,ledinhkhang_IClickListener clickListener) {
        this.mContext = mContext;
        this.clickListener = clickListener;
    }
    public void setDta(List<ledinhkhang_Sach> listsachs){
        this.listsachs = listsachs;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View studentView =
                inflater.inflate(R.layout.item_sach, parent, false);
        return new ViewHolder(studentView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ledinhkhang_Sach sach =  listsachs.get(position);
        holder.txt_maSP.setText("Mã sách: " + sach.getMaSach());
        holder.txt_tenSP.setText("Tên sách: " + sach.getTenSach());
        holder.txt_soLuong.setText("Số lượng: " + sach.getSoLuong() +(" cuốn"));
        DecimalFormat formatter = new DecimalFormat("###,###,###");
        holder.txt_Giaca.setText("Giá bán : "+formatter.format(sach.getGiaban())+" đ");
        holder.setClick(sach);
    }

    @Override
    public int getItemCount() {
        return listsachs.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txt_maSP;
        TextView txt_tenSP,txt_Giaca;
        TextView txt_soLuong;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_maSP = itemView.findViewById(R.id.tvMaSP);
            txt_tenSP = itemView.findViewById(R.id.tvtenSp);
            txt_soLuong = itemView.findViewById(R.id.tvSoLuong);
            txt_Giaca = itemView.findViewById(R.id.tvGiaBan);

        }
        public void setClick(ledinhkhang_Sach sach) {
            itemView.setOnLongClickListener(view -> {
                clickListener.OnLongClickListenerKhachHang(sach);
                return  true;
            });

            itemView.setOnClickListener(view ->{
                clickListener.OnClickListenerKhachHang(sach);
            });
        }
    }
}
