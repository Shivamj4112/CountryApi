
package com.api.countryapi.ModelClass;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Car {

    @SerializedName("signs")
    @Expose
    private List<String> signs = null;
    @SerializedName("side")
    @Expose
    private String side;

    public List<String> getSigns() {
        return signs;
    }

    public void setSigns(List<String> signs) {
        this.signs = signs;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

}
