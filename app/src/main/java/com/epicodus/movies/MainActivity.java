package com.epicodus.movies;

import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
     @Bind(R.id.title_text_view) TextView mTitleTextView;
     @Bind(R.id.find_movies_button) Button mFindMoviesButton;
     @Bind(R.id.location_edit_text) EditText mLocationEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Typeface mainActivityFont = Typeface.createFromAsset(getAssets(), "fonts/capture.ttf");
        ButterKnife.bind(this);
        mTitleTextView.setTypeface(mainActivityFont);
        mFindMoviesButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v){
                String location = mLocationEditText.getText().toString();
                Intent intent = new Intent(MainActivity.this, MoviesActivity.class);
                intent.putExtra("location", location);
                startActivity(intent);
            }
        });
    }
}
