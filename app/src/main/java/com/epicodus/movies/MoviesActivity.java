package com.epicodus.movies;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MoviesActivity extends AppCompatActivity {
    private TextView mLocationTextView;
    private ListView mListView;
    private String[] movies = new String[] {"It", "The Foreigner", "Marshall", "Happy Death Day", "The Secret Scripture"};
    private String[] genres = new String[] {"Horror", "Mystery", "Drama", "Comedy", "Romance"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);

        mListView = (ListView) findViewById(R.id.listView);
        mLocationTextView = (TextView) findViewById(R.id.movies_text_view);

        String receivedString = getIntent().getStringExtra("location");
        mLocationTextView.setText("Here are all the movies near: " + receivedString);

//        ArrayAdapter arrayAdapter = new ArrayAdapter(this, R.layout.item, movies);
        MyMoviesArrayAdapter adapter = new MyMoviesArrayAdapter(this,
                android.R.layout.simple_list_item_1,
                movies,
                genres);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String movies = ((TextView)view).getText().toString();
                Toast.makeText(MoviesActivity.this, movies, Toast.LENGTH_SHORT).show();
                view.setBackgroundColor(Color.RED);
            }
        });


    }
}
