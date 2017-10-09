package com.epicodus.movies;


import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

public class MainActivityInstrumentationTest {
    @Rule
    public ActivityTestRule<MainActivity> activityTestRule =
            new ActivityTestRule<MainActivity>(MainActivity.class);

    @Test
    public void validateEditText(){
        onView(withId(R.id.location_edit_text)).perform(typeText("Portland"))
                .check(matches(withText("Portland")));

    }
    @Test
    public void locationIsSentToMoviesActivity(){
        String location = "Portland";
        onView(withId(R.id.location_edit_text)).perform(typeText(location));
        onView(withId(R.id.find_movies_button)).perform(click());
        onView(withId(R.id.movies_text_view)).check(matches(withText("Here are all the movies near: " + location)));
        }

}
