package io.kaeawc.tapit.storage;

import android.support.annotation.NonNull;
import android.text.format.DateUtils;

import java.util.Arrays;
import java.util.List;

import io.kaeawc.tapit.entities.Photo;
import timber.log.Timber;

public class PhotoCache extends PhotoStorage {

    @NonNull
    public List<Photo> getPhotosOrderedByTimestamp() {

        try {
            Thread.sleep(1000L);
        } catch (InterruptedException exception) {
            Timber.v("Interrupted sleep!");
        }

        long now = System.currentTimeMillis();
        long hour = DateUtils.HOUR_IN_MILLIS;
        long old = now - (hour * 2);
        return Arrays.asList(
                getRandomPhoto("recent", now),
                getRandomPhoto("recent", now - 1),
                getRandomPhoto("threshold", now - hour),
                getRandomPhoto("old", old),
                getRandomPhoto("old", old),
                getRandomPhoto("old", old),
                getRandomPhoto("old", old),
                getRandomPhoto("old", old),
                getRandomPhoto("old", old),
                getRandomPhoto("old", old),
                getRandomPhoto("old", old),
                getRandomPhoto("old", old),
                getRandomPhoto("old", old),
                getRandomPhoto("old", old),
                getRandomPhoto("old", old)
        );
    }

    public List<Photo> getFakeList() {
        long now = System.currentTimeMillis();
        long hour = DateUtils.HOUR_IN_MILLIS;
        long old = now - (hour * 2);
        return Arrays.asList(
                getRandomPhoto("recent", now),
                getRandomPhoto("recent", now - 1),
                getRandomPhoto("threshold", now - hour),
                getRandomPhoto("old", old),
                getRandomPhoto("old", old),
                getRandomPhoto("old", old),
                getRandomPhoto("old", old),
                getRandomPhoto("old", old),
                getRandomPhoto("old", old),
                getRandomPhoto("old", old),
                getRandomPhoto("old", old),
                getRandomPhoto("old", old),
                getRandomPhoto("old", old),
                getRandomPhoto("old", old),
                getRandomPhoto("old", old)
        );
    }

    public Photo getRandomPhoto(String text, long timestamp) {
        return new Photo(getRandomPhotoUrl("recent"), timestamp);
    }

    public String getRandomPhotoUrl(String text) {

        String background = "000";
        String foreground = "fff";

        return String.format(
                "http://dummyimage.com/100x100/%s/%s&text=%s",
                background,
                foreground,
                text);
    }
}
