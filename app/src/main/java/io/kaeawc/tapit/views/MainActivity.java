package io.kaeawc.tapit.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import java.util.Collections;
import java.util.List;

import de.greenrobot.event.EventBus;
import io.kaeawc.tapit.R;
import io.kaeawc.tapit.entities.Photo;
import io.kaeawc.tapit.entities.PhotosLoadedEvent;
import io.kaeawc.tapit.entities.RequestPhotosEvent;
import io.kaeawc.tapit.presenters.MainPresenter;

public class MainActivity extends AppCompatActivity {

    RecyclerView mPhotoRecyclerView;
    PhotoAdapter mPhotoAdapter;
    ProgressBar mProgressBar;
    final MainPresenter mPresenter = new MainPresenter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPhotoRecyclerView = (RecyclerView) findViewById(R.id.photo_list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mPhotoRecyclerView.setLayoutManager(layoutManager);
        mPhotoAdapter = new PhotoAdapter(Collections.<Photo>emptyList());
        mPhotoRecyclerView.setAdapter(mPhotoAdapter);
        mProgressBar = (ProgressBar) findViewById(R.id.photo_loading_progress);
    }

    @Override
    public void onResume() {
        super.onResume();
        EventBus.getDefault().register(this);

        if (mPresenter.isFinishedLoading()) {
            mProgressBar.setVisibility(View.GONE);
            mPhotoRecyclerView.setVisibility(View.VISIBLE);
        } else {
            mProgressBar.setVisibility(View.VISIBLE);
            mPhotoRecyclerView.setVisibility(View.GONE);
        }

        EventBus.getDefault().post(RequestPhotosEvent.Instance);
    }

    public void onPause() {
        super.onPause();
        EventBus.getDefault().unregister(this);
    }

    public void onEventMainThread(PhotosLoadedEvent event) {

        List<Photo> photos = event.getPhotos();
        if (photos.isEmpty()) {
            return;
        }

        mPhotoAdapter = new PhotoAdapter(photos);
        mPhotoRecyclerView.setAdapter(mPhotoAdapter);
        mPresenter.onFinishedLoading();

        if (mPresenter.isFinishedLoading()) {
            mProgressBar.setVisibility(View.GONE);
            mPhotoRecyclerView.setVisibility(View.VISIBLE);
        } else {
            mProgressBar.setVisibility(View.VISIBLE);
            mPhotoRecyclerView.setVisibility(View.GONE);
        }
    }

    public void onEventBackgroundThread(RequestPhotosEvent event) {
        mPresenter.getPhotos();
    }
}
