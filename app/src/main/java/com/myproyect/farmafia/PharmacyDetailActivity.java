package com.myproyect.farmafia;

import android.os.Bundle;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

public class PharmacyDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pharmacy_detail);

        WebView webView = findViewById(R.id.webView);
        String name = getIntent().getStringExtra("name");
        double latitude = getIntent().getDoubleExtra("latitude", 0.0);
        double longitude = getIntent().getDoubleExtra("longitude", 0.0);

        String url = "https://www.openstreetmap.org/?mlat=" + latitude + "&mlon=" + longitude + "#map=18/" + latitude + "/" + longitude;
        webView.loadUrl(url);
    }
}
