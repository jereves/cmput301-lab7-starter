package com.example.androiduitesting;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.hasToString;
import static org.hamcrest.Matchers.startsWith;

import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.intent.Intents;
import androidx.test.espresso.intent.rule.IntentsTestRule;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class ShowActivityTest {
    @Rule
    public ActivityScenarioRule<MainActivity> scenario = new
            ActivityScenarioRule<>(MainActivity.class);

    @Before
    public void setupIntents() {
        Intents.init();
    }

    @After
    public void removeIntents() {
        Intents.release();
    }

    @Test
    public void testAcivitySwitch() {
        // add edmonton
        onView(withId(R.id.button_add)).perform(click());
        onView(withId(R.id.editText_name)).perform(ViewActions.typeText("Edmonton"));
        onView(withId(R.id.button_confirm)).perform(click());
        // click on edmonton
        onData(hasToString(startsWith("Edmonton"))).perform(click());

//        Intended = switched to new activity
        intended(hasComponent(ShowActivity.class.getName()));
    }

    @Test
    public void testCityDisplay() {


        // add to city list
        String cityName = "Victoria";
        onView(withId(R.id.button_add)).perform(click());
        onView(withId(R.id.editText_name)).perform(ViewActions.typeText(cityName));
        onView(withId(R.id.button_confirm)).perform(click());

        // click on item
        onData(hasToString(startsWith(cityName))).perform(click());

        /// TEST CHECK THAT CITY NAME IS DISPLAYED ON ACTIVITY 2
        onView(withText(cityName)).check(matches(isDisplayed()));
    }

    @Test
    public void testBackButton() {

        // add to city list
        String cityName = "Victoria";
        onView(withId(R.id.button_add)).perform(click());
        onView(withId(R.id.editText_name)).perform(ViewActions.typeText(cityName));
        onView(withId(R.id.button_confirm)).perform(click());

        // click on item switch activity
        onData(hasToString(startsWith(cityName))).perform(click());

        // click back
        onView(withId(R.id.go_back)).perform(click());

        // TEST THAT MAIN ACTIVITY IS NOW BACK
        intended(hasComponent(MainActivity.class.getName()));

        // TEST FOR AN ELEMENT ON SCREEN

        onView(withId(R.id.button_clear)).check(matches(isDisplayed()));

    }
}


