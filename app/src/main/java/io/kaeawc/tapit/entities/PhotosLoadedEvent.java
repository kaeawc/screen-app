package io.kaeawc.tapit.entities;

import java.util.List;

public class PhotosLoadedEvent {

    private List<Photo> photos;

    public PhotosLoadedEvent(List<Photo> photos) {
        this.photos = photos;
    }

    public List<Photo> getPhotos() {
        return photos;
    }
}
