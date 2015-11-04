package io.kaeawc.tapit.interactors;

import android.test.suitebuilder.annotation.SmallTest;

import org.junit.Test;
import org.mockito.Mock;

import io.kaeawc.tapit.presenters.MainPresenter;
import io.kaeawc.tapit.storage.PhotoCache;
import io.kaeawc.tapit.storage.PhotoStorage;

import static org.mockito.Mockito.*;

@SmallTest
public class MainInteractorTest {

    @Mock
    PhotoStorage mStorage;

    @Test
    public void getPhotos_withMinimumOfOne_shouldRequestPhotosFromStorage() {
        MainInteractor presenter = new MainInteractor(mStorage);
        presenter.getPhotos(1);
        doCallRealMethod().when(mStorage).getMostRecentPhotos(any(long.class), eq(MainPresenter.MINIMUM_DISPLAYED_PHOTOS));
        when(mStorage.getPhotosOrderedByTimestamp()).thenReturn(
                new PhotoCache().getFakeList()
        );
        verify(mStorage, times(1)).getMostRecentPhotos(any(long.class), eq(MainPresenter.MINIMUM_DISPLAYED_PHOTOS));
    }

    @Test
    public void getPhotos_withMinimumOfZero_shouldRequestPhotosFromStorage() {
        MainInteractor presenter = new MainInteractor(mStorage);
        presenter.getPhotos(0);
        verify(mStorage, times(1)).getMostRecentPhotos(any(long.class), eq(MainPresenter.MINIMUM_DISPLAYED_PHOTOS));
    }
}
