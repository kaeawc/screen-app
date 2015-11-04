package io.kaeawc.tapit;

import android.content.Intent;
import android.support.test.rule.ActivityTestRule;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.View;

import com.facebook.testing.screenshot.Screenshot;
import com.facebook.testing.screenshot.ViewHelpers;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import io.kaeawc.tapit.views.MainActivity;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@LargeTest
public class ScreenshotTest {

    private static final String INTENT_ACTION_MAIN = "android.intent.action.MAIN";
    private static final String INTENT_CATEGORY_LAUNCH = "android.intent.category.LAUNCHER";

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    MainActivity mActivity;

    @Before
    public void setup() {
        mActivity = mActivityRule.launchActivity(withLaunchIntent());
    }

    @Test
    public void inflateCreatesTheExpectedScreen() throws Exception {

        /**
         * Create and set up your view some how. This might be inflating,
         * or creating from a view class. You might want to set properties
         * on the view.
         */

        Thread.sleep(3000L);

        onView(withId(R.id.photo_list))
                .check(matches(isDisplayed()));

        View activityLayout = mActivity.getLayoutInflater().inflate(R.layout.activity_main, null, false);
        View photoList = activityLayout.findViewById(R.id.photo_list);

        /**
         * Measure and layout the view. In this example we give an exact
         * width but all the height to be WRAP_CONTENT.
         */
        ViewHelpers.setupView(photoList)
                .setExactWidthDp(300)
                .layout();

        /**
         * Take the actual screenshot. At the end of this call the screenshot
         * is stored on the device, and the gradle plugin takes care of
         * pulling it and displaying it to you in nice ways.
         */
        Screenshot.snap(photoList)
                .record();
    }

    public Intent withLaunchIntent() {
        Intent intent = new Intent();
        intent.setAction(INTENT_ACTION_MAIN);
        intent.addCategory(INTENT_CATEGORY_LAUNCH);
        return intent;
    }
}
