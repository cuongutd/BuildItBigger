package com.cuong.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ProgressBar;

import com.cuong.mylibrary.LibActivity;
import com.cuong.telljokes.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

/**
 * Created by Cuong on 8/7/2015.
 */
class EndPointsAsyncTask extends AsyncTask<String, Void, String> {

    private ProgressBar mSpinner;
    private Context mContext;
    private static MyApi mApiService = null;
    private boolean mTestMode;

    public EndPointsAsyncTask(Context context, ProgressBar spinner, boolean testMode){
        mContext= context;
        mSpinner = spinner;
        mTestMode = testMode;
    }

    private MyApi getApiService() {
        if (mApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl(mContext.getString(R.string.gceendpoint));

            if (!builder.getRootUrl().startsWith("https:"))//dev server
                // options for running against local devappserver
                // - 10.0.2.2 is localhost's IP address in Android emulator
                // - turn off compression when running against local devappserver
                builder.setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                    @Override
                    public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                        abstractGoogleClientRequest.setDisableGZipContent(true);
                    }
                });

            mApiService = builder.build();
        }
        return mApiService;
    }

    @Override
    public void onPreExecute() {
        if (!mTestMode)
            mSpinner.setVisibility(View.VISIBLE);
        super.onPreExecute();
    }

    @Override
    public String doInBackground(String... params) {

        String which= params[0];
        try {
            return getApiService().getAJoke(which).execute().getData();

        } catch (IOException e) {
            return "EXCEPTION: " + e.getMessage();
        }
    }

    @Override
    public void onPostExecute(String result) {
        if (!mTestMode){
            mSpinner.setVisibility(View.GONE);

            Intent intent = new Intent(mContext, LibActivity.class);
            intent.putExtra(LibActivity.JOKE_INTENT_EXTRA, result);
            mContext.startActivity(intent);
        }
    }
}