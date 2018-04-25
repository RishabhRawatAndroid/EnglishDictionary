package com.myapp.rishabhrawat.englishdictionary.FragmentPack;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.myapp.rishabhrawat.englishdictionary.R;

import java.util.ArrayList;
import java.util.List;

import qdx.bezierviewpager_compile.BezierRoundView;
import qdx.bezierviewpager_compile.vPage.BezierViewPager;
import qdx.bezierviewpager_compile.vPage.CardPagerAdapter;

public class MainFragment extends Fragment {



    Context context;
    List<String> images=new ArrayList<>();
    CardPagerAdapter adapter;
    BezierViewPager pager;
    BezierRoundView roundView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_main,container,false);
        context=container.getContext();
        LaodImages();
        adapter=new CardPagerAdapter(context);
        adapter.addImgUrlList(images);
        pager=view.findViewById(R.id.viewpager);
        pager.setAdapter(adapter);
        roundView=view.findViewById(R.id.round_view);
        roundView.attach2ViewPage(pager);



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
}
