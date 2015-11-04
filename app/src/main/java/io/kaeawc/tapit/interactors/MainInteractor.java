package io.kaeawc.tapit.interactors;

import io.kaeawc.tapit.storage.PhotoStorage;

public class MainInteractor {

    PhotoStorage mStorage;

    public MainInteractor(PhotoStorage storage) {
        mStorage = storage;
    }

    public void getPhotos(int minimum) {
        long now = System.currentTimeMillis();
        mStorage.getMostRecentPhotos(now, minimum);
    }
}
