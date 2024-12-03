package com.myproyect.farmafia;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private PharmacyAdapter adapter;
    private List<Pharmacy> pharmacyList;
    private FirebaseFirestore firestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        pharmacyList = new ArrayList<>();
        adapter = new PharmacyAdapter(pharmacyList, this::onPharmacySelected);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        firestore = FirebaseFirestore.getInstance();

        // Load data from Firestore
        loadPharmacies();
    }

    private void loadPharmacies() {
        firestore.collection("pharmacies")
                .get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        for (QueryDocumentSnapshot document : task.getResult()) {
                            Pharmacy pharmacy = document.toObject(Pharmacy.class);
                            pharmacyList.add(pharmacy);
                        }
                        adapter.notifyDataSetChanged();
                    }
                });
    }

    private void onPharmacySelected(Pharmacy pharmacy) {
        Intent intent = new Intent(this, PharmacyDetailActivity.class);
        intent.putExtra("pharmacy", pharmacy);
        startActivity(intent);
    }
}
