package io.kaeawc.tapit;


import android.content.res.Resources;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.test.suitebuilder.annotation.SmallTest;
import android.view.LayoutInflater;
import android.view.View;

import com.facebook.testing.screenshot.Screenshot;
import com.facebook.testing.screenshot.ViewHelpers;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@LargeTest
public class ScreenshotTest {

    protected MainActivity activity;

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(
            MainActivity.class);

    @Test
    public void addition_isCorrect() throws Exception {

        /**
         * Create and set up your view some how. This might be inflating,
         * or creating from a view class. You might want to set properties
         * on the view.
         */
        View view = activity.getLayoutInflater().inflate(R.layout.activity_main, null, false);

        /**
         * Measure and layout the view. In this example we give an exact
         * width but all the height to be WRAP_CONTENT.
         */
        ViewHelpers.setupView(view)
                .setExactWidthDp(300)
                .layout();

        /**
         * Take the actual screenshot. At the end of this call the screenshot
         * is stored on the device, and the gradle plugin takes care of
         * pulling it and displaying it to you in nice ways.
         */
        Screenshot.snap(view)
                .record();
    }
}
