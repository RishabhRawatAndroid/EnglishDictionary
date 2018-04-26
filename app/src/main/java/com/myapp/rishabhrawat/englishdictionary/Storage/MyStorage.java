package com.myapp.rishabhrawat.englishdictionary.Storage;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.List;

public class MyStorage {

    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    Context context;

    List<String> sentenselist;

    List<String> synonymlist;
    List<String> antonymlist;

    List<String> searchlist;

    List<String> grammertype;
    List<String> grammertext;
    List<String> grammerdefination;
    List<String> grammerlexical;
    String audiofile;
    List<String> phenoticnotation;
    List<String> phenoticSpelling;


    MyStorage(Context context)
    {
        this.context=context;
        preferences=context.getSharedPreferences("myfile",0);
        editor=preferences.edit();
    }

    public List<String> getSentenselist() {
        return sentenselist;
    }

    public void setSentenselist(List<String> sentenselist) {
        this.sentenselist = sentenselist;
    }

    public List<String> getSynonymlist() {
        return synonymlist;
    }

    public void setSynonymlist(List<String> synonymlist) {
        this.synonymlist = synonymlist;
    }

    public List<String> getAntonymlist() {
        return antonymlist;
    }

    public void setAntonymlist(List<String> antonymlist) {
        this.antonymlist = antonymlist;
    }

    public List<String> getSearchlist() {
        return searchlist;
    }

    public void setSearchlist(List<String> searchlist) {
        this.searchlist = searchlist;
    }

    public List<String> getGrammertype() {
        return grammertype;
    }

    public void setGrammertype(List<String> grammertype) {
        this.grammertype = grammertype;
    }

    public List<String> getGrammertext() {
        return grammertext;
    }

    public void setGrammertext(List<String> grammertext) {
        this.grammertext = grammertext;
    }

    public List<String> getGrammerdefination() {
        return grammerdefination;
    }

    public void setGrammerdefination(List<String> grammerdefination) {
        this.grammerdefination = grammerdefination;
    }

    public List<String> getGrammerlexical() {
        return grammerlexical;
    }

    public void setGrammerlexical(List<String> grammerlexical) {
        this.grammerlexical = grammerlexical;
    }

    public String getAudiofile() {
        return audiofile;
    }

    public void setAudiofile(String audiofile) {
        this.audiofile = audiofile;
    }

    public List<String> getPhenoticnotation() {
        return phenoticnotation;
    }

    public void setPhenoticnotation(List<String> phenoticnotation) {
        this.phenoticnotation = phenoticnotation;
    }

    public List<String> getPhenoticSpelling() {
        return phenoticSpelling;
    }

    public void setPhenoticSpelling(List<String> phenoticSpelling) {
        this.phenoticSpelling = phenoticSpelling;
    }
}
