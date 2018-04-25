package com.myapp.rishabhrawat.englishdictionary;

import com.myapp.rishabhrawat.englishdictionary.Antonyms.AntonymsList;
import com.myapp.rishabhrawat.englishdictionary.DictionaryEntries.EntriesList;
import com.myapp.rishabhrawat.englishdictionary.Search.SearchList;
import com.myapp.rishabhrawat.englishdictionary.Sentense.SentenseList;
import com.myapp.rishabhrawat.englishdictionary.Synonyms.SynonymsList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface DictionaryAPI {

    @GET("/entries/en/{word_id}")
    Call<SearchList> getSearchListData(@Path("word_id") String word_id);

    @GET("/entries/en/{word_id}/sentences")
    Call<SentenseList> getSentenseListData(@Path("word_id") String word_id);

    @GET("/entries/en/{word_id}/antonyms")
    Call<AntonymsList> getAntonymsListData(@Path("word_id") String word_id);

    @GET("/entries/en/{word_id}/synonyms")
    Call<SynonymsList> getSynonymsListData(@Path("word_id") String word_id);

    @GET("/entries/en/{word_id}")
    Call<EntriesList> getEntryListData(@Path("word_id") String word_id);

}