package com.myapp.rishabhrawat.englishdictionary.Storage;

import android.content.Context;
import android.content.SharedPreferences;

import com.myapp.rishabhrawat.englishdictionary.Antonyms.Antonym;
import com.myapp.rishabhrawat.englishdictionary.DictionaryEntries.GrammaticalFeature;
import com.myapp.rishabhrawat.englishdictionary.DictionaryEntries.LexicalEntry;
import com.myapp.rishabhrawat.englishdictionary.DictionaryEntries.Pronunciation;
import com.myapp.rishabhrawat.englishdictionary.DictionaryEntries.Pronunciation__;
import com.myapp.rishabhrawat.englishdictionary.DictionaryEntries.Sense;
import com.myapp.rishabhrawat.englishdictionary.Search.Result;
import com.myapp.rishabhrawat.englishdictionary.Sentense.Sentence;
import com.myapp.rishabhrawat.englishdictionary.Synonyms.Synonym;

import java.util.List;

public class MyStorage {

    List<Sentence> sentenselist;

    List<Synonym> synonymlist;
    List<Antonym> antonymlist;

    List<com.myapp.rishabhrawat.englishdictionary.Search.Result> searchlist;

    List<GrammaticalFeature> grammer;
    List<Sense> definition;
    List<LexicalEntry> lexicalcategory;
    List<Pronunciation__> pronunciations;

    public List<Sentence> getSentenselist() {
        return sentenselist;
    }

    public void setSentenselist(List<Sentence> sentenselist) {
        this.sentenselist = sentenselist;
    }

    public List<Synonym> getSynonymlist() {
        return synonymlist;
    }

    public void setSynonymlist(List<Synonym> synonymlist) {
        this.synonymlist = synonymlist;
    }

    public List<Antonym> getAntonymlist() {
        return antonymlist;
    }

    public void setAntonymlist(List<Antonym> antonymlist) {
        this.antonymlist = antonymlist;
    }

    public List<Result> getSearchlist() {
        return searchlist;
    }

    public void setSearchlist(List<Result> searchlist) {
        this.searchlist = searchlist;
    }

    public List<GrammaticalFeature> getGrammer() {
        return grammer;
    }

    public void setGrammer(List<GrammaticalFeature> grammer) {
        this.grammer = grammer;
    }

    public List<Sense> getDefinition() {
        return definition;
    }

    public void setDefinition(List<Sense> definition) {
        this.definition = definition;
    }

    public List<LexicalEntry> getLexicalcategory() {
        return lexicalcategory;
    }

    public void setLexicalcategory(List<LexicalEntry> lexicalcategory) {
        this.lexicalcategory = lexicalcategory;
    }

    public List<Pronunciation__> getPronunciations() {
        return pronunciations;
    }

    public void setPronunciations(List<Pronunciation__> pronunciations) {
        this.pronunciations = pronunciations;
    }
}
