package io.kaeawc.tapit.storage;

import android.support.annotation.NonNull;
import android.text.format.DateUtils;

import java.util.ArrayList;
import java.util.List;

import de.greenrobot.event.EventBus;
import io.kaeawc.tapit.entities.Photo;
import io.kaeawc.tapit.entities.PhotosLoadedEvent;
import timber.log.Timber;

public abstract class PhotoStorage {

    public static final long RECENT = DateUtils.HOUR_IN_MILLIS;

    @NonNull
    public abstract List<Photo> getPhotosOrderedByTimestamp();

    public void getMostRecentPhotos(long currentTimestamp, int minimum) {
        List<Photo> photos = getPhotosOrderedByTimestamp();

        if (photos.isEmpty()) {
            Timber.d("Retrieved no photos");
            EventBus.getDefault().post(new PhotosLoadedEvent(photos));
            return;
        }

        List<Photo> recent = new ArrayList<>();
        for (Photo photo : photos) {
            if (recent.size() < minimum || currentTimestamp - photo.getTimestamp() < RECENT) {
                recent.add(photo);
            }
        }

        Timber.d("Retrieved %s photos", recent.size());
        EventBus.getDefault().post(new PhotosLoadedEvent(recent));
    }
}
