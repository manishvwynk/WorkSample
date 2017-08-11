/*
 * Copyright 2017, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.manishverma.myapplication;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.SeekBar;

/**
 * Shows a SeekBar that should be synced with a value in a ViewModel.
 */
public class Fragment_step5 extends Fragment {
    String TAG = "Fragment_step5";

    private SeekBar mSeekBar;
    public String name ;
    private static int count;
    EditText textView1;
    public int mProgress;

//    private SeekBarViewModel mSeekBarViewModel;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int tempProgress = -1;
        if(mSeekBar != null){
           tempProgress= mSeekBar.getProgress();
        }
        Log.d("mvv", TAG+" oncreate  Frag name " +tempProgress  + "  " + name);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_step5, container, false);
        name = "name  "+ ++count;
        mSeekBar = (SeekBar) root.findViewById(R.id.seekBar);
        textView1 = (EditText) root.findViewById(R.id.text1);
        Log.d("mvv", TAG+"   onCreateView");
                 subscribeSeekBar();

        return root;
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setRetainInstance(true);
        Log.d("mvv", TAG+" ###### onViewCreated");
    }

    private void subscribeSeekBar() {

        // Update the ViewModel when the SeekBar is changed.

        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // TODO: Set the ViewModel's value when the change comes from the user.
                Log.d("mvv", TAG+" !!  prob onProgressChanged "+progress+ " n "+name);
                mProgress = progress;
                textView1.setText("text :" + progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        // TODO: Update the SeekBar when the ViewModel is changed.
        // mSeekBarViewModel.seekbarValue.observe(...
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("mvv", TAG+" onDestroy Frag "+mSeekBar.getProgress()+ "  "+name);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("mvv", TAG+" onDestroyView Frag .." + mSeekBar.getProgress() + "  " + name);
    }
}
