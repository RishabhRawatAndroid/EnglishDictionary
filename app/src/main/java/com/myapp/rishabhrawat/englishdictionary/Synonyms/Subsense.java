
package com.myapp.rishabhrawat.englishdictionary.Synonyms;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Subsense {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("synonyms")
    @Expose
    private List<Synonym> synonyms = null;
    @SerializedName("regions")
    @Expose
    private List<String> regions = null;
    @SerializedName("registers")
    @Expose
    private List<String> registers = null;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Synonym> getSynonyms() {
        return synonyms;
    }

    public void setSynonyms(List<Synonym> synonyms) {
        this.synonyms = synonyms;
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

}
