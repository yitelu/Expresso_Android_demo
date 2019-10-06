package com.ytl.expresso_android_demo;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.hamcrest.Matcher;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withInputType;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

/**
 * Created by Richard Yi-Te Lu on 06,October,2019
 */

@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mMainActivityActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    private String mName = "Richard";

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testNameInput(){

        //entering name in the editText
        Espresso.onView(withId(R.id.etEnterName)).perform(clearText());
        Espresso.onView(withId(R.id.etEnterName)).perform(typeText(mName));

        //hide the keyboard
        Espresso.closeSoftKeyboard();

        //press the button
        Espresso.onView(withId(R.id.btnShowName)).perform(click());

        //show the editText text in the TextView and check if it's correct
        //ViewMatchers.assertThat(Espresso.onView(withId(R.id.tvShowName)).toString(), (Matcher<String>) matches(withText(mName)));
        //Espresso.onView(withId(R.id.tvShowName)).toString().endsWith(mName);
        Espresso.onView(withId(R.id.tvShowName)).check(matches(withText("John")));

    }

    @After
    public void tearDown() throws Exception {
    }
}