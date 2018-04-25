
package com.myapp.rishabhrawat.englishdictionary.DictionaryEntries;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Translation {

    @SerializedName("domains")
    @Expose
    private List<String> domains = null;
    @SerializedName("grammaticalFeatures")
    @Expose
    private List<GrammaticalFeature_> grammaticalFeatures = null;
    @SerializedName("language")
    @Expose
    private String language;
    @SerializedName("notes")
    @Expose
    private List<Note__> notes = null;
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

    public List<GrammaticalFeature_> getGrammaticalFeatures() {
        return grammaticalFeatures;
    }

    public void setGrammaticalFeatures(List<GrammaticalFeature_> grammaticalFeatures) {
        this.grammaticalFeatures = grammaticalFeatures;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public List<Note__> getNotes() {
        return notes;
    }

    public void setNotes(List<Note__> notes) {
        this.notes = notes;
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
