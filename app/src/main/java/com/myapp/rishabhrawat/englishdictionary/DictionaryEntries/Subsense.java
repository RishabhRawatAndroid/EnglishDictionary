
package com.myapp.rishabhrawat.englishdictionary.DictionaryEntries;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Subsense {

    @SerializedName("definitions")
    @Expose
    private List<String> definitions = null;
    @SerializedName("examples")
    @Expose
    private List<Example_> examples = null;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("short_definitions")
    @Expose
    private List<String> shortDefinitions = null;
    @SerializedName("thesaurusLinks")
    @Expose
    private List<ThesaurusLink> thesaurusLinks = null;
    @SerializedName("notes")
    @Expose
    private List<Note> notes = null;
    @SerializedName("domains")
    @Expose
    private List<String> domains = null;
    @SerializedName("registers")
    @Expose
    private List<String> registers = null;
    @SerializedName("regions")
    @Expose
    private List<String> regions = null;

    public List<String> getDefinitions() {
        return definitions;
    }

    public void setDefinitions(List<String> definitions) {
        this.definitions = definitions;
    }

    public List<Example_> getExamples() {
        return examples;
    }

    public void setExamples(List<Example_> examples) {
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

    public List<ThesaurusLink> getThesaurusLinks() {
        return thesaurusLinks;
    }

    public void setThesaurusLinks(List<ThesaurusLink> thesaurusLinks) {
        this.thesaurusLinks = thesaurusLinks;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    public List<String> getDomains() {
        return domains;
    }

    public void setDomains(List<String> domains) {
        this.domains = domains;
    }

    public List<String> getRegisters() {
        return registers;
    }

    public void setRegisters(List<String> registers) {
        this.registers = registers;
    }

    public List<String> getRegions() {
        return regions;
    }

    public void setRegions(List<String> regions) {
        this.regions = regions;
    }

}
