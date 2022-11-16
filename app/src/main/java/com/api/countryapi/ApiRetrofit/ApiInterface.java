package com.api.countryapi.ApiRetrofit;

import com.api.countryapi.ModelClass.Country;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("v3.1/all")
    Call<List<Country>> getApiInterface();

}
