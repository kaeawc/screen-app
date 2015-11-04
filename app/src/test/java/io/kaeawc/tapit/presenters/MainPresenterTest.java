package io.kaeawc.tapit.presenters;

import org.junit.Test;
import org.mockito.Mock;

import io.kaeawc.tapit.interactors.MainInteractor;

import static org.mockito.Mockito.*;

public class MainPresenterTest {

    @Mock
    MainInteractor mInteractor;

    @Test
    public void getPhotos_shouldRequestPhotosFromInteractor() {
        MainPresenter presenter = new MainPresenter(mInteractor);
        presenter.getPhotos();
        verify(mInteractor, times(1)).getPhotos(eq(MainPresenter.MINIMUM_DISPLAYED_PHOTOS));
    }
}
