package com.myproyect.farmafia;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Pharmacy> pharmacyList = new ArrayList<>();
    private RecyclerView recyclerView;
    private PharmacyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        loadPharmaciesFromAssets();
        adapter = new PharmacyAdapter(pharmacyList, pharmacy -> {
            Intent intent = new Intent(MainActivity.this, PharmacyDetailActivity.class);
            intent.putExtra("name", pharmacy.getName());
            intent.putExtra("latitude", pharmacy.getLatitude());
            intent.putExtra("longitude", pharmacy.getLongitude());
            startActivity(intent);
        });
        recyclerView.setAdapter(adapter);
    }

    private void loadPharmaciesFromAssets() {
        try {
            InputStream is = getAssets().open("pharmacies.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            String json = new String(buffer, "UTF-8");

            JSONArray jsonArray = new JSONArray(json);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i);
                Pharmacy pharmacy = new Pharmacy(
                        obj.getString("name"),
                        obj.getString("phone"),
                        obj.getDouble("latitude"),
                        obj.getDouble("longitude")
                );
                pharmacyList.add(pharmacy);
            }
        } catch (Exception e) {
            Toast.makeText(this, "Error loading data", Toast.LENGTH_SHORT).show();
        }
    }
}
