package com.epicodus.movies;

import android.support.test.espresso.core.deps.guava.base.Strings;
import android.support.test.rule.ActivityTestRule;
import android.view.View;

import org.junit.Rule;
import org.junit.Test;

import butterknife.Bind;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.core.IsNot.not;


public class MoviesActivityInstrumentationTest {

    @Rule
    public ActivityTestRule<MoviesActivity> activityTestRule =
            new ActivityTestRule<MoviesActivity>(MoviesActivity.class);

    @Test
    public void listItemClickDisplaysToastWithCorrectMovie() throws Exception {
        View activityDecorView = activityTestRule.getActivity().getWindow().getDecorView();
        String movieName = "It";
        onData(anything())
                .inAdapterView(withId(R.id.listView))
                .atPosition(0)
                .perform(click());

        onView(withText(movieName)).inRoot(withDecorView(not(activityDecorView)))
                .check(matches(withText(movieName)));

    }


}
