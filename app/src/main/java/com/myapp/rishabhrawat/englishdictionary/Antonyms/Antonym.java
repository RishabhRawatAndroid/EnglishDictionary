
package com.myapp.rishabhrawat.englishdictionary.Antonyms;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Antonym {

    @SerializedName("domains")
    @Expose
    private List<String> domains = null;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("language")
    @Expose
    private String language;
    @SerializedName("regions")
    @Expose
    private List<String> regions = null;
    @SerializedName("registers")
    @Expose
    private List<String> registers = null;
    @SerializedName("text")
    @Expose
    private String text;

    public List<String> getDomains() {
        return domains;
    }

    public void setDomains(List<String> domains) {
        this.domains = domains;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public List<String> getRegions() {
        return regions;
    }

    public void setRegions(List<String> regions) {
        this.regions = regions;
    }

    public List<String> getRegisters() {
        return registers;
    }

    public void setRegisters(List<String> registers) {
        this.registers = registers;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
