package com.api.countryapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.app.ProgressDialog;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import com.api.countryapi.CountryModel.Country;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recycle;
    ProgressDialog dialog;
    Adapter adapter;
    List<Country> datalist;
    EditText search_country;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        recycle = findViewById(R.id.recycle);
        search_country = findViewById(R.id.search_country);

        dialog = new ProgressDialog(this);
        dialog.setCancelable(false);
        dialog.setTitle("Loading......");
        dialog.setMessage("Please wait......");
        dialog.show();

        ConnectivityManager manager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo info = manager.getActiveNetworkInfo();

        if (info != null && info.isConnected()){

            ApiInterface apiInterface = ApiClient.getApiclient().create(ApiInterface.class);

            apiInterface.getApiInterface().enqueue(new Callback<List<Country>>() {
                @Override
                public void onResponse(Call<List<Country>> call, Response<List<Country>> response) {

                    if (response.isSuccessful()){

                        dialog.dismiss();

                        datalist = response.body();

                        adapter = new Adapter(MainActivity.this,datalist);
                        recycle.setLayoutManager(new GridLayoutManager(MainActivity.this,2));
                        recycle.setAdapter(adapter);

                        search_country.setVisibility(View.VISIBLE);

                        search_country.addTextChangedListener(new TextWatcher() {
                            @Override
                            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                            }
                            @Override
                            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                fliter(charSequence.toString(),MainActivity.this);
                            }

                            @Override
                            public void afterTextChanged(Editable editable) {

                            }
                        });

                    }
                }
                @Override
                public void onFailure(Call<List<Country>> call, Throwable t) {

                    dialog.dismiss();
                    Toast.makeText(MainActivity.this, ""+t.getMessage(), Toast.LENGTH_LONG).show();
                }
            });
        }
        else {
            dialog.dismiss();
            Toast.makeText(this, "No Internet", Toast.LENGTH_SHORT).show();
        }

    }
    void fliter(String string , Activity activity){

        List<Country>datalist2 = new ArrayList<>();

        for (int i = 0; i < datalist.size(); i++) {

            if (datalist.get(i).getName().getCommon().toLowerCase().contains(string.toLowerCase())){
                datalist2.add(datalist.get(i));
            }
        }
        adapter = new Adapter(activity,datalist2);
        recycle.setAdapter(adapter);
    }
}