package io.kaeawc.tapit.views;

import android.test.suitebuilder.annotation.SmallTest;
import android.view.View;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import io.kaeawc.tapit.BuildConfig;
import io.kaeawc.tapit.R;
import io.kaeawc.tapit.TestApp;
import io.kaeawc.tapit.views.MainActivity;

import static org.assertj.core.api.Assertions.assertThat;

@SmallTest
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21, application = TestApp.class)
public class MainViewTest {

    @Test
    public void mainActivity_shouldInflate() throws Exception {

        MainActivity activity = Robolectric.buildActivity(MainActivity.class)
                .create()
                .get();

        View view = activity.getLayoutInflater().inflate(R.layout.activity_main, null, false);
    }
}
