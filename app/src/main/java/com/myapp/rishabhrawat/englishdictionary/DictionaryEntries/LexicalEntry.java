
package com.myapp.rishabhrawat.englishdictionary.DictionaryEntries;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LexicalEntry {

    @SerializedName("derivativeOf")
    @Expose
    private List<DerivativeOf> derivativeOf = null;
    @SerializedName("derivatives")
    @Expose
    private List<Derivative> derivatives = null;
    @SerializedName("entries")
    @Expose
    private List<Entry> entries = null;
    @SerializedName("grammaticalFeatures")
    @Expose
    private List<GrammaticalFeature___> grammaticalFeatures = null;
    @SerializedName("language")
    @Expose
    private String language;
    @SerializedName("lexicalCategory")
    @Expose
    private String lexicalCategory;
    @SerializedName("notes")
    @Expose
    private List<Note_____> notes = null;
    @SerializedName("pronunciations")
    @Expose
    private List<Pronunciation__> pronunciations = null;
    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("variantForms")
    @Expose
    private List<VariantForm__> variantForms = null;

    public List<DerivativeOf> getDerivativeOf() {
        return derivativeOf;
    }

    public void setDerivativeOf(List<DerivativeOf> derivativeOf) {
        this.derivativeOf = derivativeOf;
    }

    public List<Derivative> getDerivatives() {
        return derivatives;
    }

    public void setDerivatives(List<Derivative> derivatives) {
        this.derivatives = derivatives;
    }

    public List<Entry> getEntries() {
        return entries;
    }

    public void setEntries(List<Entry> entries) {
        this.entries = entries;
    }

    public List<GrammaticalFeature___> getGrammaticalFeatures() {
        return grammaticalFeatures;
    }

    public void setGrammaticalFeatures(List<GrammaticalFeature___> grammaticalFeatures) {
        this.grammaticalFeatures = grammaticalFeatures;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getLexicalCategory() {
        return lexicalCategory;
    }

    public void setLexicalCategory(String lexicalCategory) {
        this.lexicalCategory = lexicalCategory;
    }

    public List<Note_____> getNotes() {
        return notes;
    }

    public void setNotes(List<Note_____> notes) {
        this.notes = notes;
    }

    public List<Pronunciation__> getPronunciations() {
        return pronunciations;
    }

    public void setPronunciations(List<Pronunciation__> pronunciations) {
        this.pronunciations = pronunciations;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<VariantForm__> getVariantForms() {
        return variantForms;
    }

    public void setVariantForms(List<VariantForm__> variantForms) {
        this.variantForms = variantForms;
    }

}
