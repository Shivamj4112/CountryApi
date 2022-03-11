
package com.api.countryapi.CountryModel;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Eur {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("symbol")
    @Expose
    private String symbol;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

}
