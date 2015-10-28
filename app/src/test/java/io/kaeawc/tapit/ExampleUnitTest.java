package io.kaeawc.tapit;

import android.test.suitebuilder.annotation.SmallTest;
import android.view.View;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.Shadows;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowActivity;

import static org.assertj.core.api.Assertions.assertThat;

@SmallTest
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21, application = TestApp.class)
public class ExampleUnitTest {

    @Test
    public void addition_isCorrect() throws Exception {

        MainActivity activity = Robolectric.buildActivity(MainActivity.class)
                .create()
                .get();
    /*
     * Create and set up your view some how. This might be inflating,
     * or creating from a view class. You might want to set properties
     * on the view.
     */
        View view = activity.getLayoutInflater().inflate(R.layout.activity_main, null, false);

    /*
     * Measure and layout the view. In this example we give an exact
     * width but all the height to be WRAP_CONTENT.
     */
        ViewHelpers.setupView(view)
                .setExactWidthDp(300)
                .layout();

    /*
     * Take the actual screenshot. At the end of this call the screenshot
     * is stored on the device, and the gradle plugin takes care of
     * pulling it and displaying it to you in nice ways.
     */
        Screenshot.snap(view)
                .record();
    }
}
