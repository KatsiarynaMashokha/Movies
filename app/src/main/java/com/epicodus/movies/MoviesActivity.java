package com.epicodus.movies;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

public class MoviesActivity extends AppCompatActivity {
    private TextView mLocationTextView;
    private ListView mListView;
    private String[] movies = new String[] {"It"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);

//        mListView = (ListView) findViewById(R.id.);
//        mLocationTextView = (TextView) findViewById(R.id.location_edit_text);

    }
}
