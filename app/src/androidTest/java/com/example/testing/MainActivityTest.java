package com.example.testing;


import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isFocused;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
    private String USER_TO_BE_TYPED = "Username", PASS_TO_BE_TYPED = "Password";
    @Rule
    public ActivityScenarioRule<MainActivity> activityScenarioRule =
            new ActivityScenarioRule<MainActivity>(MainActivity.class);

    @Test
    public void view_elements_are_Displayed() {

        onView(withId(R.id.TextViewTittle)).check(matches(isDisplayed()));
        onView(withId(R.id.button)).check(matches(isDisplayed()));

    }

    @Test
    public void view_elements_text(){

        onView(withId(R.id.TextViewTittle)).check(matches(withText(R.string.main_activity_tittle)));
        onView(withId(R.id.button)).check(matches(withText(R.string.next)));
    }

    @Test
    public void button_is_clickeable_and_clicked_change_text(){
        onView(withId(R.id.button)).check(matches(isClickable()));
        onView(withId(R.id.button)).perform(click()).check(matches(withText("Back")));
    }

    @Test
    public void login_from_behaviour(){
        onView(withId(R.id.editText_username)).perform(typeText(USER_TO_BE_TYPED)).perform(closeSoftKeyboard());
        onView(withId(R.id.editText_password)).perform(typeText(PASS_TO_BE_TYPED)).perform(closeSoftKeyboard());
        onView(withId(R.id.button)).perform(click()).check(matches(withText("Logged")));
    }
    @Test
    public void button_change_to_WelcomeActivity(){
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.WelcomeActivity)).check(matches(isCompletelyDisplayed()));
    }
    @Test
    @LargeTest
    public void username_password_introducced_nextButtonClick_go_WelcomeActivity_BackButtonClick_go_MainActivity(){
        onView(withId(R.id.editText_username)).perform(typeText(USER_TO_BE_TYPED));
        onView(withId(R.id.editText_password)).perform(typeText(PASS_TO_BE_TYPED)).perform(closeSoftKeyboard());
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.WelcomeActivity)).check(matches(isCompletelyDisplayed()));
        onView(withId(R.id.welcome_text)).check(matches(withText("Welcome Back "+USER_TO_BE_TYPED)));
        onView(withId(R.id.back_button)).perform(click());
        onView(withId(R.id.MainActivity)).check(matches(isCompletelyDisplayed()));
        onView(withId(R.id.editText_username)).check(matches(withText("")));
        onView(withId(R.id.editText_password)).check(matches(withText("")));
    }
}
