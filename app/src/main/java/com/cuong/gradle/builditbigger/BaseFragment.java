package com.cuong.gradle.builditbigger;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import com.cuong.mylibrary.LibActivity;
import com.cuong.telljokes.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

/**
 * Created by Cuong on 8/6/2015.
 */
public class BaseFragment extends Fragment {

    Button mNewGameButton;
    ProgressBar mSpinner;
    private MyApi mApiService = null;

    public BaseFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_main, container, false);

        mSpinner = (ProgressBar) root.findViewById(R.id.progressBar);

        mSpinner.setVisibility(View.GONE);

        mNewGameButton = (Button) root.findViewById(R.id.telljokeButton);

        mNewGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //show progress bar
                tellJoke();
            }
        });

        return root;
    }


    protected void tellJoke() {

        new EndPointsAsyncTask(getActivity(), mSpinner, false).execute("give me the joke");

    }

//    protected MyApi getApiService() {
//        if (mApiService == null) {  // Only do this once
//            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
//                    new AndroidJsonFactory(), null)
//                    .setRootUrl(getActivity().getString(R.string.gceendpoint));
//
//            if (!builder.getRootUrl().startsWith("https:"))//dev server
//                // options for running against local devappserver
//                // - 10.0.2.2 is localhost's IP address in Android emulator
//                // - turn off compression when running against local devappserver
//                builder.setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
//                            @Override
//                            public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
//                                abstractGoogleClientRequest.setDisableGZipContent(true);
//                            }
//                        });
//
//            mApiService = builder.build();
//        }
//        return mApiService;
//    }
//
//
//    class EndPointsAsyncTask extends AsyncTask<String, Void, String> {
//
//        @Override
//        protected void onPreExecute() {
//            mSpinner.setVisibility(View.VISIBLE);
//            super.onPreExecute();
//        }
//
//        @Override
//        protected String doInBackground(String... params) {
//
//            String name = params[0];
//
//            try {
//                return getApiService().getAJoke(name).execute().getData();
//            } catch (IOException e) {
//                return e.getMessage();
//            }
//        }
//
//        @Override
//        protected void onPostExecute(String result) {
//            mSpinner.setVisibility(View.GONE);
//            Intent intent = new Intent(getActivity(), LibActivity.class);
//            intent.putExtra(LibActivity.JOKE_INTENT_EXTRA, result);
//            getActivity().startActivity(intent);
//        }
//    }


}