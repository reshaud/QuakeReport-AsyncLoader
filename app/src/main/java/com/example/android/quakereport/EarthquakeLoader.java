package com.example.android.quakereport;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;

/**
 * Created by Reshaud Ally on 3/9/2017.
 */

public class EarthquakeLoader extends AsyncTaskLoader<List<Earthquake>> {
    private String url;

    public EarthquakeLoader(Context context, String urls) {
        super(context);
        this.url = urls;
    }

    //start loading data
    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<Earthquake> loadInBackground() {
        // Don't perform the request if there are no URLs, or the first URL is null
        if (url == null) {
            return null;
        }

        List<Earthquake> result = QueryUtils.fetchEarthquakeData(url);
        return result;
    }
}