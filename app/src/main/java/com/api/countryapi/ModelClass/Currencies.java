
package com.api.countryapi.ModelClass;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Currencies {

    @SerializedName("UYU")
    @Expose
    private Uyu uyu;

    public Uyu getUyu() {
        return uyu;
    }

    public void setUyu(Uyu uyu) {
        this.uyu = uyu;
    }

}
