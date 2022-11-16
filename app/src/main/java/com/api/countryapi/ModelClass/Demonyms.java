
package com.api.countryapi.ModelClass;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Demonyms {

    @SerializedName("eng")
    @Expose
    private Eng eng;
    @SerializedName("fra")
    @Expose
    private Fra__1 fra;

    public Eng getEng() {
        return eng;
    }

    public void setEng(Eng eng) {
        this.eng = eng;
    }

    public Fra__1 getFra() {
        return fra;
    }

    public void setFra(Fra__1 fra) {
        this.fra = fra;
    }

}
