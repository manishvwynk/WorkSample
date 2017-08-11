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


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

/**
 * Shows a SeekBar that should be synced with a value in a ViewModel.
 */
public class FragmentB extends Fragment {
    String TAG = "Fragment_step5";

    private SeekBar mSeekBar;
    public String name ;
    private static int count;
    EditText editText;
    public int mProgress;
    TextView textView;

    ISwitchFragment mISwitchFragment;
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
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof  ISwitchFragment){
            mISwitchFragment = (ISwitchFragment)context;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_step5, container, false);
        name = "name  "+ ++count;
        mSeekBar = (SeekBar) root.findViewById(R.id.seekBar);
        editText = (EditText) root.findViewById(R.id.text1);
        textView = (TextView)root.findViewById(R.id.text2);
        Log.d("mvv", TAG+"   onCreateView");
                 subscribeSeekBar();
        ( (root.findViewById(R.id.frame_container))).setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.red));

        return root;
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        setRetainInstance(true);
        Log.d("mvv", TAG+" ###### onViewCreated");
    }

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {



        }
    };

    private void subscribeSeekBar() {

        // Update the ViewModel when the SeekBar is changed.


        textView.setOnClickListener(listener);
        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // TODO: Set the ViewModel's value when the change comes from the user.
                Log.d("mvv", TAG+" !!  prob onProgressChanged "+progress+ " n "+name);
                mProgress = progress;
                editText.setText("text :" + progress);
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

    interface ISwitchFragment{
        void switchFragmet();
    }
}
