package com.example.asus.cataloguemovieuiux;

import java.util.ArrayList;

public class MovieData {
    static MovieItems movieItems = new MovieItems();
    public static String[][] data = new String[][]{
            {movieItems.getTitle(),movieItems.getRelease_date(),movieItems.getOverview(),movieItems.getPoster_path()}
    };

    public static ArrayList<MovieItems> getListData(){
        MovieItems movieItems1 = null;
        ArrayList<MovieItems> list = new ArrayList<>();
        for (int i = 0; i < data.length;i++){
            movieItems1 = new MovieItems();
            movieItems1.setTitle(data[i][0]);
            movieItems1.setRelease_date(data[i][1]);
            movieItems1.setOverview(data[i][2]);
            movieItems1.setPoster_path(data[i][3]);

            list.add(movieItems1);
        }
        return list;
    }

}
