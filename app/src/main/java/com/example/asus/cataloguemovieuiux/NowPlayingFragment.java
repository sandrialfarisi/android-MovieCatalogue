package com.example.asus.cataloguemovieuiux;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class NowPlayingFragment extends android.support.v4.app.Fragment implements LoaderManager.LoaderCallbacks<ArrayList<MovieItems>>{

    RecyclerView recyclerView;
    MovieAdapter adapter;
    ArrayList<MovieItems> movieItems;

    static final String EXTRAS_MOVIE = "EXTRAS_MOVIE";

    Context context;

    public NowPlayingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_now_playing, container, false);

        recyclerView = (RecyclerView)view.findViewById(R.id.listView);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new MovieAdapter(getActivity());
        adapter.notifyDataSetChanged();

        recyclerView.setAdapter(adapter);

        getLoaderManager().initLoader(0, null, this);

        Button btnDetail = (Button)view.findViewById(R.id.btn_detail);

//        showMovie();

        return view;
    }
/*
    private void showMovie(){
        //      recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter.setListMovie(movieItems);
        recyclerView.setAdapter(adapter);

        ItemClickSupport.addTo(recyclerView).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                showSelectedMovie(movieItems.get(position));
            }
        });

    }


    private void showSelectedMovie(MovieItems movieItems) {
//            Toast.makeText(this, "Kami memilih " + movieItems.getTitle(), Toast.LENGTH_SHORT).show();

        MovieItems movieItems1 = new MovieItems();
        movieItems1.setTitle(movieItems.getTitle());
        movieItems1.setOverview(movieItems.getOverview());
        movieItems1.setRelease_date(movieItems.getRelease_date());
        movieItems1.setVote_average(movieItems.getVote_average());
        movieItems1.setPoster_path(movieItems.getPoster_path());

        //Intent intent = new Intent(getActivity(), DetailMovie.class);
        //intent.putExtra(DetailMovie.EXTRA_ITEMS, movieItems);
        //startActivity(intent);

        DetailFragment mDetailFragment  = new DetailFragment();
        FragmentManager mFragmentManager = getFragmentManager();
        FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentTransaction.replace(R.id.content_main, mDetailFragment , DetailFragment.class.getSimpleName());
        mFragmentTransaction.addToBackStack(null);
        mFragmentTransaction.commit();
    }

*/
    @NonNull
    @Override
    public Loader<ArrayList<MovieItems>> onCreateLoader(int i, @Nullable Bundle args) {
        return new NowPlayingLoader(getContext());
    }

    @Override
    public void onLoadFinished(@NonNull Loader<ArrayList<MovieItems>> loader, ArrayList<MovieItems> data) {
        adapter.setListMovie(data);
        movieItems = data;
    }

    @Override
    public void onLoaderReset(@NonNull Loader<ArrayList<MovieItems>> loader) {
        adapter.setListMovie(null);
    }

}
