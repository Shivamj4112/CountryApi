
package com.api.countryapi.ModelClass;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class NativeName {

    @SerializedName("spa")
    @Expose
    private Spa spa;

    public Spa getSpa() {
        return spa;
    }

    public void setSpa(Spa spa) {
        this.spa = spa;
    }

}
