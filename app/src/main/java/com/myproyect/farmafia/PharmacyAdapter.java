package com.myproyect.farmafia;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PharmacyAdapter extends RecyclerView.Adapter<PharmacyAdapter.ViewHolder> {

    private final List<Pharmacy> pharmacyList;
    private final OnPharmacyClickListener listener;

    public PharmacyAdapter(List<Pharmacy> pharmacyList, OnPharmacyClickListener listener) {
        this.pharmacyList = pharmacyList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pharmacy, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Pharmacy pharmacy = pharmacyList.get(position);
        holder.tvName.setText(pharmacy.getName());
        holder.tvPhone.setText(pharmacy.getPhone());
        holder.itemView.setOnClickListener(v -> listener.onPharmacyClick(pharmacy));
    }

    @Override
    public int getItemCount() {
        return pharmacyList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvPhone;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
            tvPhone = itemView.findViewById(R.id.tv_phone);
        }
    }

    public interface OnPharmacyClickListener {
        void onPharmacyClick(Pharmacy pharmacy);
    }
}
