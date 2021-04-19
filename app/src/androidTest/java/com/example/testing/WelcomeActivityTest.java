package com.example.testing;

import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isFocused;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class WelcomeActivityTest {
    @Rule
    public ActivityScenarioRule<WelcomeActivity> activityActivityScenarioRule = new ActivityScenarioRule<WelcomeActivity>(WelcomeActivity.class);

    @Test
    public void on_click_BackButton_go_MainActivity(){
        onView(withId(R.id.back_button)).perform(click());
        onView(withId(R.id.MainActivity)).check(matches(isCompletelyDisplayed()));
        pressBack();
        onView(withId(R.id.WelcomeActivity)).check(matches(isCompletelyDisplayed()));

    }

}
