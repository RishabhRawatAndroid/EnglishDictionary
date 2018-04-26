package com.myapp.rishabhrawat.englishdictionary;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.google.gson.Gson;
import com.myapp.rishabhrawat.englishdictionary.Antonyms.AntonymsList;
import com.myapp.rishabhrawat.englishdictionary.Antonyms.Synonym;
import com.myapp.rishabhrawat.englishdictionary.DictionaryEntries.EntriesList;
import com.myapp.rishabhrawat.englishdictionary.DictionaryEntries.GrammaticalFeature;
import com.myapp.rishabhrawat.englishdictionary.DictionaryEntries.GrammaticalFeature___;
import com.myapp.rishabhrawat.englishdictionary.DictionaryEntries.Pronunciation__;
import com.myapp.rishabhrawat.englishdictionary.FragmentPack.MainFragment;
import com.myapp.rishabhrawat.englishdictionary.FragmentPack.SaveWordFragment;
import com.myapp.rishabhrawat.englishdictionary.Search.SearchList;
import com.myapp.rishabhrawat.englishdictionary.Sentense.LexicalEntry;
import com.myapp.rishabhrawat.englishdictionary.Sentense.Result;
import com.myapp.rishabhrawat.englishdictionary.Sentense.Sentence;
import com.myapp.rishabhrawat.englishdictionary.Sentense.SentenseList;
import com.myapp.rishabhrawat.englishdictionary.Synonyms.Entry;
import com.myapp.rishabhrawat.englishdictionary.Synonyms.Sense;
import com.myapp.rishabhrawat.englishdictionary.Synonyms.SynonymsList;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    MainFragment mainFragment;
    SaveWordFragment saveWordFragment;
    boolean main_fragment_status;
    boolean save_fragment_status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        AppBarLayout appBarLayout=findViewById(R.id.appbar);
        appBarLayout.setElevation(0);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        mainFragment = new MainFragment();

        saveWordFragment = new SaveWordFragment();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.fragment_layout, mainFragment);
        transaction.commit();
        main_fragment_status = true;  //it means current fragment in main
        save_fragment_status = false;



//        DictionaryAPI dictionaryAPI= RetrofitInstance.getRetrofitInstance().create(DictionaryAPI.class);
//        Call<SentenseList> call=dictionaryAPI.getSentenseListData("beautiful");
//        Log.d("RISHABH","URL IS "+call.request().url());
//        Log.d("RISHABH","HEADER IS "+call.request().headers());
//
//        call.enqueue(new Callback<SentenseList>() {
//            @Override
//            public void onResponse(Call<SentenseList> call, Response<SentenseList> response) {
//                if (response.isSuccessful()){
//                    Log.d("RISHABH SUCC", response.body().toString());
//
//                    List<Result> results=response.body().getResults();
//                    Result result=results.get(0);
//                    List<LexicalEntry> lexicalEntries=result.getLexicalEntries();
//                    LexicalEntry lexicalEntry=lexicalEntries.get(0);
//                    List<Sentence> sentenceList=lexicalEntry.getSentences();
//                    for(int i=0;i<=sentenceList.size()-1;i++)
//                    {
//                        Log.d("RISHABH DATA",sentenceList.get(i).getText());
//                    }
//
//            }
//                else
//                    Log.d("RISHABH FAIL,","Response have a error"+response.message());
//            }
//
//            @Override
//            public void onFailure(Call<SentenseList> call, Throwable t) {
//                Log.d("RISHABH","RESPONSE FAILURE "+t.toString());
//            }
//        });
//
//
//        Call<SynonymsList> synonymsListCall=dictionaryAPI.getSynonymsListData("beautiful");
//        synonymsListCall.enqueue(new Callback<SynonymsList>() {
//            @Override
//            public void onResponse(Call<SynonymsList> call, Response<SynonymsList> response) {
//
//                List<com.myapp.rishabhrawat.englishdictionary.Synonyms.Result> resultList=response.body().getResults();
//                com.myapp.rishabhrawat.englishdictionary.Synonyms.Result result=resultList.get(0);
//                List<com.myapp.rishabhrawat.englishdictionary.Synonyms.LexicalEntry> lexicalEntries=result.getLexicalEntries();
//                com.myapp.rishabhrawat.englishdictionary.Synonyms.LexicalEntry lexicalEntry=lexicalEntries.get(0);
//                List<Entry> entryList=lexicalEntry.getEntries();
//                Entry entry=entryList.get(0);
//                List<Sense> senseList=entry.getSenses();
//                Sense sense=senseList.get(0);
//                List<com.myapp.rishabhrawat.englishdictionary.Synonyms.Synonym> synonymList=sense.getSynonyms();
//                for(int i=0;i<=synonymList.size()-1;i++)
//                {
//                    System.out.println(synonymList.get(i).getText());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<SynonymsList> call, Throwable t) {
//
//            }
//        });
//
//
//                Call<AntonymsList> synonymsListCall=dictionaryAPI.getAntonymsListData("angry");
//              synonymsListCall.enqueue(new Callback<AntonymsList>() {
//            @Override
//            public void onResponse(Call<AntonymsList> call, Response<AntonymsList> response) {
//
//                List<com.myapp.rishabhrawat.englishdictionary.Antonyms.Result> resultList=response.body().getResults();
//                com.myapp.rishabhrawat.englishdictionary.Antonyms.Result result=resultList.get(0);
//                List<com.myapp.rishabhrawat.englishdictionary.Antonyms.LexicalEntry> lexicalEntries=result.getLexicalEntries();
//                com.myapp.rishabhrawat.englishdictionary.Antonyms.LexicalEntry lexicalEntry=lexicalEntries.get(0);
//                List<com.myapp.rishabhrawat.englishdictionary.Antonyms.Entry> entryList=lexicalEntry.getEntries();
//                com.myapp.rishabhrawat.englishdictionary.Antonyms.Entry entry=entryList.get(0);
//                List<com.myapp.rishabhrawat.englishdictionary.Antonyms.Sense> senseList=entry.getSenses();
//                com.myapp.rishabhrawat.englishdictionary.Antonyms.Sense sense=senseList.get(0);
//                List<com.myapp.rishabhrawat.englishdictionary.Antonyms.Antonym> antonymsList=sense.getAntonyms();
//                for(int i=0;i<=antonymsList.size()-1;i++)
//                {
//                    System.out.println(antonymsList.get(i).getText());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<AntonymsList> call, Throwable t) {
//
//            }
//        });
//
//
//        Call<SearchList> searchListCall=dictionaryAPI.getSearchListData("beautiful");
//        Log.d("RISHABH",searchListCall.request().url().toString());
//        searchListCall.enqueue(new Callback<SearchList>() {
//            @Override
//            public void onResponse(Call<SearchList> call, Response<SearchList> response) {
//                if(response.isSuccessful())
//                {
//                    Log.d("RISHBAH","response come successfully");
//                     List<com.myapp.rishabhrawat.englishdictionary.Search.Result> resultList=response.body().getResults();
//                    for(int i=0;i<=resultList.size()-1;i++)
//                    {
//                        System.out.println("DATA "+resultList.get(i).getWord());
//                    }
//
//                }
//                else
//                {
//                    Log.d("RISHABH","RESPONSE HAS AN ERROR");
//                }
//            }
//
//            @Override
//            public void onFailure(Call<SearchList> call, Throwable t) {
//
//            }
//        });
//
//
//        final Call<EntriesList> entriesListCall=dictionaryAPI.getEntryListData("Agree");
//        entriesListCall.enqueue(new Callback<EntriesList>() {
//            @Override
//            public void onResponse(Call<EntriesList> call, Response<EntriesList> response) {
//                if(response.isSuccessful())
//                {
//                    List<com.myapp.rishabhrawat.englishdictionary.DictionaryEntries.Result> resultList=response.body().getResults();
//                    com.myapp.rishabhrawat.englishdictionary.DictionaryEntries.Result result=resultList.get(0);
//
//                    List<com.myapp.rishabhrawat.englishdictionary.DictionaryEntries.LexicalEntry> lexicalEntries=result.getLexicalEntries();
//                    com.myapp.rishabhrawat.englishdictionary.DictionaryEntries.LexicalEntry lexicalEntry=lexicalEntries.get(0);
//
//                    List<com.myapp.rishabhrawat.englishdictionary.DictionaryEntries.Entry> entries=lexicalEntry.getEntries();
//                    com.myapp.rishabhrawat.englishdictionary.DictionaryEntries.Entry entry=entries.get(0);
//
//                    List<GrammaticalFeature> grammaticalFeatureList=entry.getGrammaticalFeatures();
//                    for(int i=0;i<=grammaticalFeatureList.size()-1;i++)
//                    {
//                        System.out.println(grammaticalFeatureList.get(i).getText()+" "+grammaticalFeatureList.get(i).getType());
//                    }
//
//                    List<com.myapp.rishabhrawat.englishdictionary.DictionaryEntries.Sense> senseList=entry.getSenses();
//                    for(int i=0;i<=senseList.size()-1;i++)
//                    {
//                        System.out.println(senseList.get(i).getDefinitions());
//                    }
//
//                    for(int i=0;i<=lexicalEntries.size()-1;i++)
//                    {
//                        System.out.println(lexicalEntries.get(i).getLexicalCategory());
//                    }
//                    String filepath=null;
//
//                    List<Pronunciation__> pronunciation__list=lexicalEntries.get(0).getPronunciations();
//                    for(int i=0;i<=pronunciation__list.size()-1;i++)
//                    {
//                        System.out.println(pronunciation__list.get(i).getAudioFile()+" "+pronunciation__list.get(i).getPhoneticNotation()+" "+pronunciation__list.get(i).getPhoneticSpelling());
//
//                        if(filepath==null)
//                          filepath=pronunciation__list.get(i).getAudioFile();
//
//                    }
//
//                    MediaPlayer mp = new MediaPlayer();
//                    try {
//                        mp.setDataSource(filepath);
//                        Thread.sleep(1000);
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    try {
//                        mp.prepare();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                    mp.start();
//                }
//                else
//                {
//
//                    Log.d("RISHABH","Response has an error");
//                }
//            }
//
//            @Override
//            public void onFailure(Call<EntriesList> call, Throwable t) {
//
//            }
//        });




    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        FragmentTransaction ft;
        if (id == R.id.nav_main) {
            // Handle the camera action
           if (!main_fragment_status) {
                ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.fragment_layout, mainFragment);
                ft.detach(mainFragment);
                ft.attach(mainFragment);
                main_fragment_status=true;
                save_fragment_status = false;
                ft.commit();
            }

        } else if (id == R.id.nav_save) {
           if (!save_fragment_status) {
                ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.fragment_layout, saveWordFragment);
                main_fragment_status = false;
                save_fragment_status=true;
                ft.commit();
            }

        } else if (id == R.id.nav_setting) {

        } else if (id == R.id.nav_share) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
