
package com.api.countryapi.CountryModel;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Gini {

    @SerializedName("2016")
    @Expose
    private Double _2016;

    public Double get2016() {
        return _2016;
    }

    public void set2016(Double _2016) {
        this._2016 = _2016;
    }

}
