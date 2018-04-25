
package com.myapp.rishabhrawat.englishdictionary.Synonyms;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LexicalEntry {

    @SerializedName("entries")
    @Expose
    private List<Entry> entries = null;
    @SerializedName("language")
    @Expose
    private String language;
    @SerializedName("lexicalCategory")
    @Expose
    private String lexicalCategory;
    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("variantForms")
    @Expose
    private List<VariantForm_> variantForms = null;

    public List<Entry> getEntries() {
        return entries;
    }

    public void setEntries(List<Entry> entries) {
        this.entries = entries;
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<VariantForm_> getVariantForms() {
        return variantForms;
    }

    public void setVariantForms(List<VariantForm_> variantForms) {
        this.variantForms = variantForms;
    }

}
