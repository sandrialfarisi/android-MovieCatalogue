package com.example.asus.cataloguemovieuiux;


import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
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
import android.widget.ListView;

import java.util.ArrayList;



public class SearchFragment extends android.support.v4.app.Fragment implements LoaderManager.LoaderCallbacks<ArrayList<MovieItems>>{

    RecyclerView recyclerView;
    MovieAdapter adapter;
    EditText editMovie;
    Button btnSearch;
    ArrayList<MovieItems> movieItems;

    static final String EXTRAS_MOVIE = "EXTRAS_MOVIE";


    public SearchFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_search, container, false);

        recyclerView = (RecyclerView)view.findViewById(R.id.listView);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new MovieAdapter(getActivity());
        adapter.notifyDataSetChanged();

        recyclerView.setAdapter(adapter);

        editMovie = (EditText)view.findViewById(R.id.searchView);
        btnSearch = (Button)view.findViewById(R.id.btn_search);

        btnSearch.setOnClickListener(myListener);


        String judul = editMovie.getText().toString();
        Bundle bundle = new Bundle();
        bundle.putString(EXTRAS_MOVIE, judul);


        getLoaderManager().initLoader(0, bundle, this);

        return view;
    }

    @NonNull
    @Override
    public Loader<ArrayList<MovieItems>> onCreateLoader(int i, @Nullable Bundle args) {
        String kumpulanMovie ="";
        if (args !=  null){
            kumpulanMovie = args.getString(EXTRAS_MOVIE);
        }
        return new SearchLoader(getActivity(), kumpulanMovie);
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

    View.OnClickListener myListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String movie = editMovie.getText().toString();

            if (TextUtils.isEmpty(movie)) return;

            Bundle bundle = new Bundle();
            bundle.putString(EXTRAS_MOVIE, movie);
            getLoaderManager().restartLoader(0, bundle,  SearchFragment.this);
        }
    };
}
