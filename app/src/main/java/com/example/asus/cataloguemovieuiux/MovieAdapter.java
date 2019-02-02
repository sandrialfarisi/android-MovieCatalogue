package com.example.asus.cataloguemovieuiux;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieHolder>{

    private ArrayList<MovieItems> listMovie;
    private Context context;

    MovieAdapter(Context context){
        listMovie = new ArrayList<>();
        this.context = context;
    }

    private ArrayList<MovieItems> getListMovie(){
        return listMovie;
    }

    void setListMovie(ArrayList<MovieItems> listMovie){
        this.listMovie = listMovie;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MovieAdapter.MovieHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_movie, parent, false);
        return new MovieHolder(view);
    }

    @Override
    public void onBindViewHolder(MovieHolder movieHolder, int position) {
        final MovieItems movieItems = getListMovie().get(position);

        movieHolder.tvtitle.setText(movieItems.getTitle());
        movieHolder.tvoverview.setText(movieItems.getOverview());
        movieHolder.tvrelease_date.setText(movieItems.getRelease_date());
        movieHolder.tvvote_average.setText("Vote : "+Double.toString(movieItems.getVote_average()));
        Glide.with(context)
                .load("http://image.tmdb.org/t/p/w154/"+movieItems.getPoster_path())
                .override(200,400)
                .into(movieHolder.imgposter_path);
/*
        movieHolder.btnDetail.setOnClickListener(new CustomOnItemClickListener(position, new CustomOnItemClickListener.OnItemClickCallback() {
            @Override
            public void onItemClicked(View view, int position) {

                Intent intent = new Intent(context, DetailMovie.class);
                intent.putExtra(DetailMovie.EXTRA_ITEMS, listMovie);
                context.startActivity(intent);
            }
        }));
*/


        movieHolder.btnShare.setOnClickListener(new CustomOnItemClickListener(position, new CustomOnItemClickListener.OnItemClickCallback() {
            @Override
            public void onItemClicked(View view, int position) {
                Toast.makeText(context, "Share "+getListMovie().get(position).getTitle(), Toast.LENGTH_SHORT).show();
            }
        }));

    }

    @Override
    public int getItemCount() {
//        return getListMovie().size();
//        return (getListMovie() == null) ? 0 : getListMovie().size();
        if (listMovie == null)return 0;
        return getListMovie().size();
    }

    public class MovieHolder extends RecyclerView.ViewHolder{
        TextView tvtitle;
        TextView tvoverview;
        TextView tvrelease_date;
        TextView tvvote_average;
        ImageView imgposter_path;

        Button btnDetail, btnShare;
        MovieHolder(View itemView){
            super(itemView);
            tvtitle = (TextView)itemView.findViewById(R.id.judul);
            tvoverview = (TextView)itemView.findViewById(R.id.overview);
            tvrelease_date = (TextView)itemView.findViewById(R.id.tgl);
            tvvote_average = (TextView)itemView.findViewById(R.id.rating);
            imgposter_path = (ImageView)itemView.findViewById(R.id.poster);
            btnDetail = (Button)itemView.findViewById(R.id.btn_detail);
            btnShare = (Button)itemView.findViewById(R.id.btn_set_share);
        }
    }
}
