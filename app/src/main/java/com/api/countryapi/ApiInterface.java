package com.api.countryapi;

import com.api.countryapi.CountryModel.Country;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("v3.1/all")
    Call<List<Country>> getApiInterface();

}
