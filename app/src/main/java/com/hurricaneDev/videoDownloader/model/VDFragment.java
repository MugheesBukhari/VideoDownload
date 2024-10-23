/*
 * Copyright (c) 2021.  Hurricane Development Studios
 */

package com.hurricaneDev.videoDownloader.model;

import androidx.fragment.app.Fragment;

import com.hurricaneDev.videoDownloader.VDApp;
import com.hurricaneDev.videoDownloader.activity.MainActivity;

public class VDFragment extends Fragment {

    public MainActivity getVDActivity() {
        return (MainActivity) getActivity();
    }

    public VDApp getVDApp() {
        return (VDApp) getActivity().getApplication();
    }
}
