
package com.api.countryapi.CountryModel;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Idd {

    @SerializedName("root")
    @Expose
    private String root;
    @SerializedName("suffixes")
    @Expose
    private List<String> suffixes = null;

    public String getRoot() {
        return root;
    }

    public void setRoot(String root) {
        this.root = root;
    }

    public List<String> getSuffixes() {
        return suffixes;
    }

    public void setSuffixes(List<String> suffixes) {
        this.suffixes = suffixes;
    }

}
