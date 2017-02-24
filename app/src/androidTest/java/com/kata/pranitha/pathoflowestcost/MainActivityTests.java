package com.kata.pranitha.pathoflowestcost;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by bh00992 on 2/24/17.
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityTests {
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule
            = new ActivityTestRule<>(MainActivity.class);
    @Test
    public void testValidInput() {
        onView(withId(R.id.path_input))
                .perform(typeText("1 2"), closeSoftKeyboard());
        onView(withText(R.string.button_text)).perform(click());
        onView(withText(R.string.result_title)).check(matches(isDisplayed()));
    }
    @Test
    public void testInvalidInput() {
        onView(withId(R.id.path_input))
                .perform(typeText("1 2 3\n4 5\n2"), closeSoftKeyboard());
        onView(withText(R.string.button_text)).perform(click());
        onView(withText(R.string.invalid_input_title)).check(matches(isDisplayed()));
    }
}
