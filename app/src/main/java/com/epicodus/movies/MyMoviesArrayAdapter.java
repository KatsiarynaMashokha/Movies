package com.epicodus.movies;


import android.content.Context;
import android.widget.ArrayAdapter;



public class MyMoviesArrayAdapter extends ArrayAdapter {
    private Context mContext;
    private String [] mMovies;
    private String [] mGenre;

    public MyMoviesArrayAdapter(Context mContext, int resource, String[] mMovies, String[] mGenre) {
        super(mContext, resource);
        this.mContext = mContext;
        this.mMovies = mMovies;
        this.mGenre = mGenre;
    }
    @Override
    public Object getItem(int position){
        String movie = mMovies[position];
        String genre = mGenre[position];
        return String.format("%s \nis a great: %s", movie, genre);
    }
    @Override
    public int getCount() {
        return mMovies.length;
    }
}
