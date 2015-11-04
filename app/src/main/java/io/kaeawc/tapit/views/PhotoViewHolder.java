package io.kaeawc.tapit.views;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import io.kaeawc.tapit.R;
import io.kaeawc.tapit.entities.Photo;
import timber.log.Timber;

public class PhotoViewHolder extends RecyclerView.ViewHolder {

    @NonNull
    ImageView mImageView;

    public PhotoViewHolder(@NonNull View itemView, int viewType) {
        super(itemView);
        mImageView = (ImageView) itemView.findViewById(R.id.photo_image);
    }

    public void onBindData(@NonNull Photo photo) {
        Timber.d("Binding photo url %s", photo.getUrl());
        String description = photo.getDescription();

        if (description != null) {
            mImageView.setContentDescription(description);
        }

        Picasso.with(mImageView.getContext()).load(photo.getUrl()).into(mImageView);
    }
}
