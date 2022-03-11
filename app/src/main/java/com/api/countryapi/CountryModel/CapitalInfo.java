
package com.api.countryapi.CountryModel;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class CapitalInfo {

    @SerializedName("latlng")
    @Expose
    private List<Double> latlng = null;

    public List<Double> getLatlng() {
        return latlng;
    }

    public void setLatlng(List<Double> latlng) {
        this.latlng = latlng;
    }

}
