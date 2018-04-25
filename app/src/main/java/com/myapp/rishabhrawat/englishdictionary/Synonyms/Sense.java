
package com.myapp.rishabhrawat.englishdictionary.Synonyms;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Sense {

    @SerializedName("examples")
    @Expose
    private List<Example> examples = null;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("subsenses")
    @Expose
    private List<Subsense> subsenses = null;
    @SerializedName("synonyms")
    @Expose
    private List<Synonym_> synonyms = null;

    public List<Example> getExamples() {
        return examples;
    }

    public void setExamples(List<Example> examples) {
        this.examples = examples;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Subsense> getSubsenses() {
        return subsenses;
    }

    public void setSubsenses(List<Subsense> subsenses) {
        this.subsenses = subsenses;
    }

    public List<Synonym_> getSynonyms() {
        return synonyms;
    }

    public void setSynonyms(List<Synonym_> synonyms) {
        this.synonyms = synonyms;
    }

}
