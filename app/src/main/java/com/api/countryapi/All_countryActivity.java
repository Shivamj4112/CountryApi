package com.api.countryapi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.api.countryapi.CountryModel.Country;
import com.bumptech.glide.Glide;

import java.util.List;

public class All_countryActivity extends AppCompatActivity {

    ImageView flags1;
    List<Country> datalist;
    ImageView coatOfArms;
    TextView country_name, independent, status, unMember, currencies_name, currencies_symbol;
    TextView capital, region, subregion, languages, latilongi1, latilongi2, landlocked;
    TextView borders, area, flag, population, fifa, timezones, continents;
    TextView startOfWeek, capitalInfo1, capitalInfo2, coatOfArmstext;
    Button googleMaps, openStreetMaps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_country);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        flags1 = findViewById(R.id.flags);
        coatOfArms = findViewById(R.id.coatOfArms);

        country_name = findViewById(R.id.country_name);
        independent = findViewById(R.id.independent);
        status = findViewById(R.id.status);
        unMember = findViewById(R.id.unMember);
        currencies_name = findViewById(R.id.currencies_name);
        currencies_symbol = findViewById(R.id.currencies_symbol);

        capital = findViewById(R.id.capital);
        region = findViewById(R.id.region);
        subregion = findViewById(R.id.subregion);
        languages = findViewById(R.id.languages);
        latilongi1 = findViewById(R.id.latilongi1);
        latilongi2 = findViewById(R.id.latilongi2);
        landlocked = findViewById(R.id.landlocked);

        borders = findViewById(R.id.borders);
        area = findViewById(R.id.area);
        flag = findViewById(R.id.flag);
        population = findViewById(R.id.population);
        fifa = findViewById(R.id.fifa);
        timezones = findViewById(R.id.timezones);
        continents = findViewById(R.id.continents);

        startOfWeek = findViewById(R.id.startOfWeek);
        capitalInfo1 = findViewById(R.id.capitalInfo1);
        capitalInfo2 = findViewById(R.id.capitalInfo2);
        coatOfArmstext = findViewById(R.id.coatOfArmstext);

        googleMaps = findViewById(R.id.googleMaps);
        openStreetMaps = findViewById(R.id.openStreetMaps);

        datalist = Adapter.datalist;


        //        Adding Images
        int flags = getIntent().getIntExtra("flgs", 0);

        try {
            Glide.with(All_countryActivity.this).load(datalist.get(flags).getFlags().getPng()).into(flags1);
        } catch (Exception e) {
        }

        try {
            if (datalist.get(flags).getCoatOfArms() != null){

                coatOfArms.setVisibility(View.VISIBLE);
                coatOfArmstext.setVisibility(View.GONE);

                Glide.with(All_countryActivity.this).load(datalist.get(flags).getCoatOfArms().getPng()).into(coatOfArms);
            }
            else {
                coatOfArms.setVisibility(View.GONE);
                coatOfArmstext.setVisibility(View.VISIBLE);
            }

        } catch (Exception e) {

        }

//        Adding String data
        try {

            country_name.setText(datalist.get(flags).getName().getCommon());
        } catch (Exception e) {

        }
        try {

        } catch (Exception e) {

        }
        try {

            if (datalist.get(flags).getIndependent() == true) {
                independent.setText("true");
            } else {
                independent.setText("false");
            }
        } catch (Exception e) {

        }

        try {
            status.setText(datalist.get(flags).getStatus());
        } catch (Exception e) {
        }

        try {

            if (datalist.get(flags).getUnMember() == true) {
                unMember.setText("true");
            } else {
                unMember.setText("false");
            }
        } catch (Exception e) {
        }

        try {
            currencies_name.setText(datalist.get(flags).getCurrencies().getEur().getName());
            currencies_symbol.setText(datalist.get(flags).getCurrencies().getEur().getSymbol());
        } catch (Exception e) {
        }

        try {
            if (datalist.get(flags).getCapital() != null) {
                capital.setText(datalist.get(flags).getCapital().get(0));
            } else {
                capital.setText("No Capital");
            }
        } catch (Exception e) {

        }
        try {
            region.setText(datalist.get(flags).getRegion());
        } catch (Exception e) {

        }
        try {
            subregion.setText(datalist.get(flags).getSubregion());
        } catch (Exception e) {

        }
        try {
            languages.setText(datalist.get(flags).getLanguages().getCnr());
        } catch (Exception e) {

        }
        try {
            latilongi1.setText(datalist.get(flags).getLatlng().get(0).toString());
            latilongi2.setText("/" + datalist.get(flags).getLatlng().get(1).toString());
        } catch (Exception e) {

        }
        try {
            if (datalist.get(flags).getLandlocked() == true) {
                landlocked.setText("true");
            } else {
                landlocked.setText("false");
            }
        } catch (Exception e) {

        }
        try {

            if (datalist.get(flags).getBorders() != null) {
                borders.setText(datalist.get(flags).getBorders().toString());
            } else {
                borders.setText("No Border");

            }
        } catch (Exception e) {
        }

        try {
            borders.setText(datalist.get(flags).getBorders().toString());
        } catch (Exception e) {
        }

        try {
            area.setText(datalist.get(flags).getArea().toString());
        } catch (Exception e) {
        }

        try {
            flag.setText(datalist.get(flags).getFlag());
        } catch (Exception e) {
        }

        try {
            population.setText(datalist.get(flags).getPopulation());
        } catch (Exception e) {
        }

        try {
            if (datalist.get(flags).getFifa() != null){
                fifa.setText(datalist.get(flags).getFifa());
            }
            else {
                fifa.setText("No Fifa");
            }

        } catch (Exception e) {
        }

        try {
            timezones.setText(datalist.get(flags).getTimezones().get(0));
        } catch (Exception e) {
        }

        try {
            for (int i = 0; i < datalist.get(flags).getContinents().size(); i++) {

                continents.setText(datalist.get(flags).getContinents().get(0));
            }
        } catch (Exception e) {
        }

        try {
            startOfWeek.setText(datalist.get(flags).getStartOfWeek());
        } catch (Exception e) {
        }

        try {

            googleMaps.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    link(datalist.get(flags).getMaps().getGoogleMaps());
                }
            });

            openStreetMaps.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    link(datalist.get(flags).getMaps().getOpenStreetMaps());
                }
            });
        } catch (Exception e) {
        }

        try {
            population.setText(datalist.get(flags).getPopulation());
        }catch (Exception e){
        }

        try {
            for (int i = 0; i < 5; i++) {

                capitalInfo1.setText(datalist.get(flags).getCapitalInfo().getLatlng().get(0).toString());
                capitalInfo2.setText(","+datalist.get(flags).getCapitalInfo().getLatlng().get(1).toString());
            }
        }catch (Exception e){

        }
    }

    void link(String link) {

        Intent intent = new Intent(All_countryActivity.this, MapActivity.class);
        intent.putExtra("link", link);
        startActivity(intent);
    }
}