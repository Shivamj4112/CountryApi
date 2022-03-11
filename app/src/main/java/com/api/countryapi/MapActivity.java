package com.api.countryapi;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MapActivity extends AppCompatActivity {

    WebView wview;
    ImageView arrow_back,refresh;
    ProgressDialog dialog;
    TextView check_connection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        wview = findViewById(R.id.webview);
        arrow_back = findViewById(R.id.arrow_back);
        refresh = findViewById(R.id.refresh);
        check_connection = findViewById(R.id.check_connection);

        dialog = new ProgressDialog(MapActivity.this);
        dialog.setMessage("Loading Please wait....");
        dialog.setCancelable(false);
        dialog.show();

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        try {
            ConnectivityManager manager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
            NetworkInfo info = manager.getActiveNetworkInfo();

            if (info != null && info.isConnectedOrConnecting()){

                dialog.dismiss();
                WebSettings webSettings = wview.getSettings();
                webSettings.setJavaScriptEnabled(true);
                wview.loadUrl(getIntent().getStringExtra("link"));
            }else {
                dialog.dismiss();
                Toast.makeText(this, "No Internet", Toast.LENGTH_LONG).show();

                refresh.setVisibility(View.VISIBLE);
                check_connection.setVisibility(View.VISIBLE);
                wview.setVisibility(View.GONE);

                refresh.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        dialog.show();

                        ConnectivityManager manager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
                        NetworkInfo info = manager.getActiveNetworkInfo();

                        if (info != null && info.isConnected()){

                            dialog.dismiss();

                            refresh.setVisibility(View.GONE);
                            check_connection.setVisibility(View.GONE);
                            wview.setVisibility(View.VISIBLE);

                            WebSettings webSettings2 = wview.getSettings();
                            webSettings2.setJavaScriptEnabled(true);
                            wview.loadUrl(getIntent().getStringExtra("link"));
                        }
                        else {
                            dialog.dismiss();

                            refresh.setVisibility(View.VISIBLE);
                            check_connection.setVisibility(View.VISIBLE);
                            wview.setVisibility(View.GONE);

                            Toast.makeText(MapActivity.this, "No Internet", Toast.LENGTH_LONG).show();
                        }
                    }
                });

            }
        }catch (Exception e){
        }

        arrow_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();
            }
        });
    }
}