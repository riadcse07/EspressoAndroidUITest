package com.example.mahmudriad.espressouitest;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {


    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule<>(MainActivity.class);
    
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.example.mahmudriad.espressouitest", appContext.getPackageName());
    }

    @Test
    public void ensureTextChangesWork() {
        // Type UserName
        onView(withId(R.id.userNameText))
                .perform(typeText("admin"));
    }

    @Test
    public void changeText_newActivity() {
        // Type Password.
        onView(withId(R.id.passwordText)).perform(typeText("123456"));
    }

    @Test
    public void login_newActivity() {
        // Type userName.
        onView(withId(R.id.userNameText))
                .perform(typeText("admin"));
        // Type Password.
        onView(withId(R.id.passwordText)).perform(typeText("123456"));
        // Tap on LogIn Button
        onView(withId(R.id.loginButton)).perform(click());
    }
}
