package com.example.asus.cataloguemovieuiux;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

public class DetailMovie extends AppCompatActivity {
    static final String EXTRA_JUDUL = "EXTRA_JUDUL";
    static final String EXTRA_POSTER = "EXTRA_POSTER";
    static final String EXTRA_OVERVIEW = "EXTRA_OVERVIEW";
    static final String EXTRA_RELEASEDATE = "EXTRA_RELEASEDATE";

    public static String EXTRA_ITEMS = "extra_items";
    ImageView detailPoster;
    TextView TvdetailJudul, TvdetailOverview, TvdetailTgl;

    private ArrayList<MovieItems> listmovie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);

        detailPoster = findViewById(R.id.poster);
        TvdetailJudul = findViewById(R.id.judul);
        TvdetailOverview = findViewById(R.id.overview);
        TvdetailTgl= findViewById(R.id.tgl);

        MovieItems mMovieItems = getIntent().getParcelableExtra(EXTRA_ITEMS);

        String judul = mMovieItems.getTitle();
        String tgl = mMovieItems.getRelease_date();
        String overview = mMovieItems.getOverview();
        String poster = mMovieItems.getPoster_path();

        TvdetailJudul.setText(judul);
        TvdetailOverview.setText(overview);
        TvdetailTgl.setText(tgl);

        Glide.with(getApplicationContext())
                .load("http://image.tmdb.org/t/p/w185/"+poster)
                .into(detailPoster);
//        detailJudul.setText(judul);
//        detailOverview.setText(overview);

    }

}


/*
public class DetailMovie extends AppCompatActivity {

    TextView tvtitle;
    TextView tvoverview;
    TextView tvrelease_date;
    TextView tvvote_average;
    ImageView imgposter_path;

    MovieItems movieItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);

        imgposter_path = findViewById(R.id.poster);
        tvtitle = (TextView)findViewById(R.id.judul);
        tvoverview = (TextView)findViewById(R.id.overview);
        tvrelease_date = (TextView)findViewById(R.id.tgl);
        tvvote_average = (TextView)findViewById(R.id.rating);

        movieItems = new GsonBuilder()
                .create()
                .fromJson(getIntent().getStringExtra("movie"), MovieItems.class);

        tvtitle.setText(movieItems.getTitle());
        tvoverview.setText(movieItems.getOverview());
        tvrelease_date.setText(movieItems.getRelease_date());
        tvvote_average.setText(" Vote : "+Double.toString(movieItems.getVote_average()));
        Glide.with(DetailMovie.this)
                .load("http://image.tmdb.org/t/p/w154/"+movieItems.getPoster_path())
                .into(imgposter_path);

    }
}
*/