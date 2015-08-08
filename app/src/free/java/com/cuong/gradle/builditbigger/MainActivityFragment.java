package com.cuong.gradle.builditbigger;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends BaseFragment {

    InterstitialAd mInterstitialAd;
    AdView mAdView;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = super.onCreateView(inflater, container, savedInstanceState);

        mAdView = (AdView) root.findViewById(R.id.adView);
        mAdView.loadAd(buildTestAdRequest());


        mInterstitialAd = new InterstitialAd(getActivity());
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                requestNewInterstitial();
                tellJoke();
            }
        });

        //load add in advance
        requestNewInterstitial();
        //re-register new listener that will show ad
        mNewGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSpinner.setVisibility(View.VISIBLE);
                if (mInterstitialAd.isLoaded()) { //only show if the ad is ready otherwise skip
                    mInterstitialAd.show();
                } else {
                    tellJoke();
                }
            }
        });

        return root;
    }

    private void requestNewInterstitial() {
        mInterstitialAd.loadAd(buildTestAdRequest());
    }


    private AdRequest buildTestAdRequest(){
        return new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
    }
}
