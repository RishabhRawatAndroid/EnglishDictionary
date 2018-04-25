
package com.myapp.rishabhrawat.englishdictionary.DictionaryEntries;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Entry {

    @SerializedName("etymologies")
    @Expose
    private List<String> etymologies = null;
    @SerializedName("grammaticalFeatures")
    @Expose
    private List<GrammaticalFeature> grammaticalFeatures = null;
    @SerializedName("homographNumber")
    @Expose
    private String homographNumber;
    @SerializedName("notes")
    @Expose
    private List<Note> notes = null;
    @SerializedName("pronunciations")
    @Expose
    private List<Pronunciation> pronunciations = null;
    @SerializedName("senses")
    @Expose
    private List<Sense> senses = null;
    @SerializedName("variantForms")
    @Expose
    private List<VariantForm_> variantForms = null;

    public List<String> getEtymologies() {
        return etymologies;
    }

    public void setEtymologies(List<String> etymologies) {
        this.etymologies = etymologies;
    }

    public List<GrammaticalFeature> getGrammaticalFeatures() {
        return grammaticalFeatures;
    }

    public void setGrammaticalFeatures(List<GrammaticalFeature> grammaticalFeatures) {
        this.grammaticalFeatures = grammaticalFeatures;
    }

    public String getHomographNumber() {
        return homographNumber;
    }

    public void setHomographNumber(String homographNumber) {
        this.homographNumber = homographNumber;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    public List<Pronunciation> getPronunciations() {
        return pronunciations;
    }

    public void setPronunciations(List<Pronunciation> pronunciations) {
        this.pronunciations = pronunciations;
    }

    public List<Sense> getSenses() {
        return senses;
    }

    public void setSenses(List<Sense> senses) {
        this.senses = senses;
    }

    public List<VariantForm_> getVariantForms() {
        return variantForms;
    }

    public void setVariantForms(List<VariantForm_> variantForms) {
        this.variantForms = variantForms;
    }

}
