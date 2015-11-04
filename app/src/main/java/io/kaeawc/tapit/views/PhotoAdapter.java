package io.kaeawc.tapit.views;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import io.kaeawc.tapit.R;
import io.kaeawc.tapit.entities.Photo;
import timber.log.Timber;

public class PhotoAdapter extends RecyclerView.Adapter<PhotoViewHolder> {

    public static final int INVALID_PHOTO = 1;
    public static final int VALID_PHOTO = 1;

    @NonNull
    List<Photo> mPhotos;

    public PhotoAdapter(@NonNull List<Photo> photos) {
        Timber.d("Starting with %s photos", photos.size());
        mPhotos = photos;
    }

    @Override
    public PhotoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Timber.d("onCreateViewHolder");

        View view = View.inflate(parent.getContext(), R.layout.view_photo, null);
        return new PhotoViewHolder(view, viewType);
    }

    @Override
    public void onBindViewHolder(PhotoViewHolder holder, int position) {
        Timber.d("onBindViewHolder");
        Photo photo = mPhotos.get(position);
        holder.onBindData(photo);
    }

    @Override
    public int getItemCount() {
        Timber.d("getItemCount: %s", mPhotos.size());
        return mPhotos.size();
    }

    @Override
    public int getItemViewType(int position) {

        if (position < 0 || position >= mPhotos.size()) {
            return INVALID_PHOTO;
        }

        return VALID_PHOTO;
    }
}
