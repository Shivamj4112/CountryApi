
package com.api.countryapi.ModelClass;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Name {

    @SerializedName("common")
    @Expose
    private String common;
    @SerializedName("official")
    @Expose
    private String official;
    @SerializedName("nativeName")
    @Expose
    private NativeName nativeName;

    public String getCommon() {
        return common;
    }

    public void setCommon(String common) {
        this.common = common;
    }

    public String getOfficial() {
        return official;
    }

    public void setOfficial(String official) {
        this.official = official;
    }

    public NativeName getNativeName() {
        return nativeName;
    }

    public void setNativeName(NativeName nativeName) {
        this.nativeName = nativeName;
    }

}
