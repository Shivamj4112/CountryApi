
package com.api.countryapi.CountryModel;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class NativeName {

    @SerializedName("cnr")
    @Expose
    private Cnr cnr;

    public Cnr getCnr() {
        return cnr;
    }

    public void setCnr(Cnr cnr) {
        this.cnr = cnr;
    }

}
