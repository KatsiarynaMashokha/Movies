package com.epicodus.movies;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;


public class MoviesActivity extends AppCompatActivity {
    @Bind(R.id.listView) ListView mListView;
    @Bind(R.id.movies_text_view) TextView mLocationTextView;
//    @Bind(R.id.submitButton) Button mSubmitButton;
//    @Bind(R.id.cancelButton) Button mCancelButton;

    private String[] movies = new String[] {"It", "The Foreigner", "Marshall", "Happy Death Day", "The Secret Scripture"};
    private String[] genres = new String[] {"Horror", "Mystery", "Drama", "Comedy", "Romance"};
    FragmentManager fm = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);


        MoodDialogFragment mdf = new MoodDialogFragment();
        mdf.show(fm, "Sample Fragment");


        ButterKnife.bind(this);

        String receivedString = getIntent().getStringExtra("location");
        mLocationTextView.setText("Here are all the movies near: " + receivedString);

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
