package com.myapp.rishabhrawat.englishdictionary.FragmentPack;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.myapp.rishabhrawat.englishdictionary.Antonyms.AntonymsList;
import com.myapp.rishabhrawat.englishdictionary.DictionaryAPI;
import com.myapp.rishabhrawat.englishdictionary.DictionaryEntries.EntriesList;
import com.myapp.rishabhrawat.englishdictionary.DictionaryEntries.GrammaticalFeature;
import com.myapp.rishabhrawat.englishdictionary.DictionaryEntries.Pronunciation__;
import com.myapp.rishabhrawat.englishdictionary.R;
import com.myapp.rishabhrawat.englishdictionary.RetrofitInstance;
import com.myapp.rishabhrawat.englishdictionary.Search.SearchList;
import com.myapp.rishabhrawat.englishdictionary.Sentense.LexicalEntry;
import com.myapp.rishabhrawat.englishdictionary.Sentense.Result;
import com.myapp.rishabhrawat.englishdictionary.Sentense.Sentence;
import com.myapp.rishabhrawat.englishdictionary.Sentense.SentenseList;
import com.myapp.rishabhrawat.englishdictionary.Storage.MyStorage;
import com.myapp.rishabhrawat.englishdictionary.Synonyms.Entry;
import com.myapp.rishabhrawat.englishdictionary.Synonyms.Sense;
import com.myapp.rishabhrawat.englishdictionary.Synonyms.SynonymsList;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import qdx.bezierviewpager_compile.BezierRoundView;
import qdx.bezierviewpager_compile.vPage.BezierViewPager;
import qdx.bezierviewpager_compile.vPage.CardPagerAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainFragment extends Fragment {



    Context context;
    List<String> images=new ArrayList<>();
    CardPagerAdapter adapter;
    BezierViewPager pager;
    BezierRoundView roundView;

    EditText searchText;
    ImageView mic_btn;
    static  String text;

    MyStorage storage;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_main,container,false);

        searchText=view.findViewById(R.id.search_text);
        mic_btn=view.findViewById(R.id.mic_btn);

        context=container.getContext();
        LaodImages();
        adapter=new CardPagerAdapter(context);
        adapter.addImgUrlList(images);
        pager=view.findViewById(R.id.viewpager);
        pager.setAdapter(adapter);
        roundView=view.findViewById(R.id.round_view);
        roundView.attach2ViewPage(pager);


        searchText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

                if(actionId== EditorInfo.IME_ACTION_DONE)
                {
                    if(TextUtils.isEmpty(searchText.getText().toString().trim()))
                    {
                        Toast.makeText(context, "Please must enter the word", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        storage=new MyStorage();
                        text=searchText.getText().toString().trim().toLowerCase();
                        CallingAllApi(text);

                    }
                    InputMethodManager imm = (InputMethodManager)v.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                    return true;
                }

                return false;
            }

        });

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("English Dictionary");
    }

    private void LaodImages()
    {
        images.add("https://getopentalk.com/wp-content/uploads/2017/10/headings_10327_56832.jpeg");
        images.add("https://is3-ssl.mzstatic.com/image/thumb/Purple111/v4/17/a0/84/17a08416-693c-4d8b-33fc-cafc13bd0a9b/mzl.sclvdava.png/1200x630bb.jpg");
        images.add("http://www.learnesl.net/wp-content/uploads/2016/01/Untitled-4.jpg");
        images.add("http://www.myenglishlanguage.com/wp-content/uploads/2012/03/english-grammar1.jpg");
    }


    @Override
    public void onDestroy() {
        super.onDestroy();

    }

    private void CallingAllApi(String mytext) {

                DictionaryAPI dictionaryAPI= RetrofitInstance.getRetrofitInstance().create(DictionaryAPI.class);
        Call<SentenseList> call=dictionaryAPI.getSentenseListData(mytext);
        Log.d("RISHABH","URL IS "+call.request().url());
        Log.d("RISHABH","HEADER IS "+call.request().headers());

        call.enqueue(new Callback<SentenseList>() {
            @Override
            public void onResponse(Call<SentenseList> call, Response<SentenseList> response) {
                if (response.isSuccessful()){
                    Log.d("RISHABH SUCC", response.body().toString());

                    List<Result> results=response.body().getResults();
                    Result result=results.get(0);
                    List<LexicalEntry> lexicalEntries=result.getLexicalEntries();
                    LexicalEntry lexicalEntry=lexicalEntries.get(0);
                    List<Sentence> sentenceList=lexicalEntry.getSentences();
//                    for(int i=0;i<=sentenceList.size()-1;i++)
//                    {
//                        Log.d("RISHABH DATA",sentenceList.get(i).getText());
//                    }
                    storage.setSentenselist(sentenceList);

            }
                else
                    Log.d("RISHABH FAIL,","Response have a error"+response.message());
            }

            @Override
            public void onFailure(Call<SentenseList> call, Throwable t) {
                Log.d("RISHABH","RESPONSE FAILURE "+t.toString());
            }
        });


        Call<SynonymsList> synonymsListCall=dictionaryAPI.getSynonymsListData(mytext);
        synonymsListCall.enqueue(new Callback<SynonymsList>() {
            @Override
            public void onResponse(Call<SynonymsList> call, Response<SynonymsList> response) {

                List<com.myapp.rishabhrawat.englishdictionary.Synonyms.Result> resultList=response.body().getResults();
                com.myapp.rishabhrawat.englishdictionary.Synonyms.Result result=resultList.get(0);
                List<com.myapp.rishabhrawat.englishdictionary.Synonyms.LexicalEntry> lexicalEntries=result.getLexicalEntries();
                com.myapp.rishabhrawat.englishdictionary.Synonyms.LexicalEntry lexicalEntry=lexicalEntries.get(0);
                List<Entry> entryList=lexicalEntry.getEntries();
                Entry entry=entryList.get(0);
                List<Sense> senseList=entry.getSenses();
                Sense sense=senseList.get(0);
                List<com.myapp.rishabhrawat.englishdictionary.Synonyms.Synonym> synonymList=sense.getSynonyms();
//                for(int i=0;i<=synonymList.size()-1;i++)
//                {
//                    System.out.println(synonymList.get(i).getText());
//                }
                storage.setSynonymlist(synonymList);
            }

            @Override
            public void onFailure(Call<SynonymsList> call, Throwable t) {

            }
        });


        Call<AntonymsList> antonymsListCall=dictionaryAPI.getAntonymsListData(mytext);
              antonymsListCall.enqueue(new Callback<AntonymsList>() {
            @Override
            public void onResponse(Call<AntonymsList> call, Response<AntonymsList> response) {

                List<com.myapp.rishabhrawat.englishdictionary.Antonyms.Result> resultList=response.body().getResults();
                com.myapp.rishabhrawat.englishdictionary.Antonyms.Result result=resultList.get(0);
                List<com.myapp.rishabhrawat.englishdictionary.Antonyms.LexicalEntry> lexicalEntries=result.getLexicalEntries();
                com.myapp.rishabhrawat.englishdictionary.Antonyms.LexicalEntry lexicalEntry=lexicalEntries.get(0);
                List<com.myapp.rishabhrawat.englishdictionary.Antonyms.Entry> entryList=lexicalEntry.getEntries();
                com.myapp.rishabhrawat.englishdictionary.Antonyms.Entry entry=entryList.get(0);
                List<com.myapp.rishabhrawat.englishdictionary.Antonyms.Sense> senseList=entry.getSenses();
                com.myapp.rishabhrawat.englishdictionary.Antonyms.Sense sense=senseList.get(0);
                List<com.myapp.rishabhrawat.englishdictionary.Antonyms.Antonym> antonymsList=sense.getAntonyms();
//                for(int i=0;i<=antonymsList.size()-1;i++)
//                {
//                    System.out.println(antonymsList.get(i).getText());
//                }
                storage.setAntonymlist(antonymsList);
            }

            @Override
            public void onFailure(Call<AntonymsList> call, Throwable t) {

            }
        });

        Call<SearchList> searchListCall=dictionaryAPI.getSearchListData(mytext);
        Log.d("RISHABH",searchListCall.request().url().toString());
        searchListCall.enqueue(new Callback<SearchList>() {
            @Override
            public void onResponse(Call<SearchList> call, Response<SearchList> response) {
                if(response.isSuccessful())
                {
                    Log.d("RISHBAH","response come successfully");
                     List<com.myapp.rishabhrawat.englishdictionary.Search.Result> resultList=response.body().getResults();
//                    for(int i=0;i<=resultList.size()-1;i++)
//                    {
//                        System.out.println("DATA "+resultList.get(i).getWord());
//                    }
                    storage.setSearchlist(resultList);
                }
                else
                {
                    Log.d("RISHABH","RESPONSE HAS AN ERROR");
                }
            }

            @Override
            public void onFailure(Call<SearchList> call, Throwable t) {

            }
        });


        final Call<EntriesList> entriesListCall=dictionaryAPI.getEntryListData(mytext);
        entriesListCall.enqueue(new Callback<EntriesList>() {
            @Override
            public void onResponse(Call<EntriesList> call, Response<EntriesList> response) {
                if(response.isSuccessful()) {
                    List<com.myapp.rishabhrawat.englishdictionary.DictionaryEntries.Result> resultList = response.body().getResults();
                    com.myapp.rishabhrawat.englishdictionary.DictionaryEntries.Result result = resultList.get(0);

                    List<com.myapp.rishabhrawat.englishdictionary.DictionaryEntries.LexicalEntry> lexicalEntries = result.getLexicalEntries();
                    com.myapp.rishabhrawat.englishdictionary.DictionaryEntries.LexicalEntry lexicalEntry = lexicalEntries.get(0);

                    List<com.myapp.rishabhrawat.englishdictionary.DictionaryEntries.Entry> entries = lexicalEntry.getEntries();
                    com.myapp.rishabhrawat.englishdictionary.DictionaryEntries.Entry entry = entries.get(0);

                    List<GrammaticalFeature> grammaticalFeatureList = entry.getGrammaticalFeatures();
//                    for(int i=0;i<=grammaticalFeatureList.size()-1;i++)
//                    {
//                        System.out.println(grammaticalFeatureList.get(i).getText()+" "+grammaticalFeatureList.get(i).getType());
//                    }
                    storage.setGrammer(grammaticalFeatureList);

                    List<com.myapp.rishabhrawat.englishdictionary.DictionaryEntries.Sense> senseList = entry.getSenses();
//                    for(int i=0;i<=senseList.size()-1;i++)
//                    {
//                        System.out.println(senseList.get(i).getDefinitions());
//                    }
                    storage.setDefinition(senseList);

//                    for(int i=0;i<=lexicalEntries.size()-1;i++)
//                    {
//                        System.out.println(lexicalEntries.get(i).getLexicalCategory());
//                    }
                    storage.setLexicalcategory(lexicalEntries);

                    String filepath = null;

                    List<Pronunciation__> pronunciation__list = lexicalEntries.get(0).getPronunciations();
//                    for(int i=0;i<=pronunciation__list.size()-1;i++)
//                    {
//                        System.out.println(pronunciation__list.get(i).getAudioFile()+" "+pronunciation__list.get(i).getPhoneticNotation()+" "+pronunciation__list.get(i).getPhoneticSpelling());
//
//                        if(filepath==null)
//                          filepath=pronunciation__list.get(i).getAudioFile();
//
//                    }

                    storage.setPronunciations(pronunciation__list);
                }
            }

            @Override
            public void onFailure(Call<EntriesList> call, Throwable t) {

            }
        });

    }
}
