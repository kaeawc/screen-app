package io.kaeawc.tapit;

import android.app.Application;

import timber.log.Timber;

/**
 * Created by jason on 10/28/15.
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Timber.plant(new Timber.DebugTree());
    }
}
