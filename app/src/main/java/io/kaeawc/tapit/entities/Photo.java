package io.kaeawc.tapit.entities;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class Photo {

    @NonNull
    private String url;
    @Nullable
    private String description;
    private long timestamp;

    public Photo(@NonNull String url, long timestamp) {
        this(url, timestamp, null);
    }

    public Photo(@NonNull String url, long timestamp, @Nullable String description) {
        this.url = url;
        this.timestamp = timestamp;
        this.description = description;
    }

    @NonNull
    public String getUrl() {
        return url;
    }

    @Nullable
    public String getDescription() {
        return description;
    }

    public long getTimestamp() {
        return timestamp;
    }
}
