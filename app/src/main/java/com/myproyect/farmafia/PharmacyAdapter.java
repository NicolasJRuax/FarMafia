package com.myproyect.farmafia;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PharmacyAdapter extends RecyclerView.Adapter<PharmacyAdapter.PharmacyViewHolder> {

    private final List<Pharmacy> pharmacyList;
    private final OnPharmacyClickListener listener;

    public PharmacyAdapter(List<Pharmacy> pharmacyList, OnPharmacyClickListener listener) {
        this.pharmacyList = pharmacyList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public PharmacyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pharmacy, parent, false);
        return new PharmacyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PharmacyViewHolder holder, int position) {
        Pharmacy pharmacy = pharmacyList.get(position);
        holder.tvName.setText(pharmacy.getName());
        holder.tvPhone.setText(pharmacy.getPhone());
        holder.itemView.setOnClickListener(v -> listener.onPharmacyClick(pharmacy));
    }

    @Override
    public int getItemCount() {
        return pharmacyList.size();
    }

    static class PharmacyViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvPhone;
        ImageView ivIcon;

        public PharmacyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
            tvPhone = itemView.findViewById(R.id.tv_phone);
            ivIcon = itemView.findViewById(R.id.iv_icon);
        }
    }

    public interface OnPharmacyClickListener {
        void onPharmacyClick(Pharmacy pharmacy);
    }
}
