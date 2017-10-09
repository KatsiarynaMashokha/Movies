package com.epicodus.movies;


import android.os.Build;
import android.widget.ListView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

@Config(constants =  BuildConfig.class, sdk = Build.VERSION_CODES.LOLLIPOP)
@RunWith(RobolectricGradleTestRunner.class)

public class MoviesActivityTest {
    private MoviesActivity activity;
    private ListView mListView;


    @Before
    public void setUp() throws Exception {
        activity = Robolectric.setupActivity(MoviesActivity.class);
        mListView = (ListView) activity.findViewById(R.id.listView);
    }

    @Test
    public void restaurantListViewPopulates() throws Exception {
        assertNotNull(mListView.getAdapter());
        assertEquals(mListView.getAdapter().getCount(), 5);

    }
}
