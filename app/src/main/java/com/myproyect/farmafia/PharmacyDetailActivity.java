package com.myproyect.farmafia;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class PharmacyDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pharmacy_detail);

        WebView webView = findViewById(R.id.webView);

        // Configuración del WebView
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true); // Habilitar JavaScript
        webView.setWebViewClient(new WebViewClient()); // Evitar abrir en navegador externo

        // Obtener datos del Intent
        String name = getIntent().getStringExtra("name");
        double latitude = getIntent().getDoubleExtra("latitude", 0.0);
        double longitude = getIntent().getDoubleExtra("longitude", 0.0);

        // Construir URL y cargar en el WebView
        String url = "https://www.openstreetmap.org/#map=18/" + latitude + "/" + longitude;
        webView.loadUrl(url);
    }
}
