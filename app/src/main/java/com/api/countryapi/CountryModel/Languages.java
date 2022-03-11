
package com.api.countryapi.CountryModel;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Languages {

    @SerializedName("cnr")
    @Expose
    private String cnr;

    public String getCnr() {
        return cnr;
    }

    public void setCnr(String cnr) {
        this.cnr = cnr;
    }

}
