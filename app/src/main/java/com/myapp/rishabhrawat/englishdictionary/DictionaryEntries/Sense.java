
package com.myapp.rishabhrawat.englishdictionary.DictionaryEntries;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Sense {

    @SerializedName("definitions")
    @Expose
    private List<String> definitions = null;
    @SerializedName("examples")
    @Expose
    private List<Example> examples = null;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("short_definitions")
    @Expose
    private List<String> shortDefinitions = null;
    @SerializedName("subsenses")
    @Expose
    private List<Subsense> subsenses = null;
    @SerializedName("thesaurusLinks")
    @Expose
    private List<ThesaurusLink_> thesaurusLinks = null;
    @SerializedName("notes")
    @Expose
    private List<Note_> notes = null;
    @SerializedName("domains")
    @Expose
    private List<String> domains = null;

    public List<String> getDefinitions() {
        return definitions;
    }

    public void setDefinitions(List<String> definitions) {
        this.definitions = definitions;
    }

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

    public List<String> getShortDefinitions() {
        return shortDefinitions;
    }

    public void setShortDefinitions(List<String> shortDefinitions) {
        this.shortDefinitions = shortDefinitions;
    }

    public List<Subsense> getSubsenses() {
        return subsenses;
    }

    public void setSubsenses(List<Subsense> subsenses) {
        this.subsenses = subsenses;
    }

    public List<ThesaurusLink_> getThesaurusLinks() {
        return thesaurusLinks;
    }

    public void setThesaurusLinks(List<ThesaurusLink_> thesaurusLinks) {
        this.thesaurusLinks = thesaurusLinks;
    }

    public List<Note_> getNotes() {
        return notes;
    }

    public void setNotes(List<Note_> notes) {
        this.notes = notes;
    }

    public List<String> getDomains() {
        return domains;
    }

    public void setDomains(List<String> domains) {
        this.domains = domains;
    }

}
