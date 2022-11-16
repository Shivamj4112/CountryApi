
package com.api.countryapi.ModelClass;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Gini {

    @SerializedName("2019")
    @Expose
    private Double _2019;

    public Double get2019() {
        return _2019;
    }

    public void set2019(Double _2019) {
        this._2019 = _2019;
    }

}
