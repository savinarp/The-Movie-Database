package id.sch.smktelkom_mlg.privateassignment.xirpl331.the_movie_database.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import id.sch.smktelkom_mlg.privateassignment.xirpl331.the_movie_database.R;
import id.sch.smktelkom_mlg.privateassignment.xirpl331.the_movie_database.Utils.Utils;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainActivityFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        Utils.getDeviceSize(getActivity());
        return rootView;
    }

}
