
package com.api.countryapi.CountryModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Currencies {

    @SerializedName("EUR")
    @Expose
    private Eur eur;

    public Eur getEur() {
        return eur;
    }

    public void setEur(Eur eur) {
        this.eur = eur;
    }

}
