package com.example.asus.cataloguemovieuiux;

import org.json.JSONObject;

public class MovieItems {

    private int id;
    private String title;
    private String overview;
    private String release_date;
    private String poster_path;
    private Double vote_average;

    public MovieItems(JSONObject object){
        try {
            String title = object.getString("title");
            String overview = object.getString("overview");
            String release_date = object.getString("release_date");
            String poster_path = object.getString("poster_path");
            Double vote_average = object.getDouble("vote_average");

            this.title = title;
            this.overview = overview;
            this.release_date = release_date;
            this.poster_path = poster_path;
            this.vote_average = vote_average;
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public MovieItems() {

    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getVote_average() {
        return vote_average;
    }

    public void setVote_average(Double vote_average) {
        this.vote_average = vote_average;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

}
