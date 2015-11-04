package io.kaeawc.tapit.presenters;

import io.kaeawc.tapit.interactors.MainInteractor;

public class MainPresenter {

    public static final int MINIMUM_DISPLAYED_PHOTOS = 6;

    private boolean mIsFinishedLoading = false;

    private MainInteractor mInteractor;

    public MainPresenter(MainInteractor interactor) {
        mInteractor = interactor;
    }

    public void getPhotos() {
        mInteractor.getPhotos(MINIMUM_DISPLAYED_PHOTOS);
    }

    public void onFinishedLoading() {
        mIsFinishedLoading = true;
    }

    public boolean isFinishedLoading() {
        return mIsFinishedLoading;
    }
}
