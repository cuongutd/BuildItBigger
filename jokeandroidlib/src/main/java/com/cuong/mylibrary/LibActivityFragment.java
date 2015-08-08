package com.cuong.mylibrary;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A placeholder fragment containing a simple view.
 */
public class LibActivityFragment extends Fragment {

    public LibActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_lib, container, false);

        Intent intent = getActivity().getIntent();
        String joke = intent.getStringExtra(LibActivity.JOKE_INTENT_EXTRA);



        TextView v = (TextView)root.findViewById(R.id.jokeContentTextview);
        v.setText(joke);

        return root;
    }
}
