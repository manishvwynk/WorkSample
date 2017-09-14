package com.example.manishverma.myapplication.model;

import android.content.Context;

/**
 * Created by manishverma on 8/19/17.
 */

public class SomeRandomSampleClass {
    private static SomeRandomSampleClass instance;
    private Context mContext;

    private SomeRandomSampleClass(Context context){
        mContext=context;
    }

    public static SomeRandomSampleClass getInstance(Context context){
//        if(instance ==null){
            instance =new SomeRandomSampleClass(context);
//        }
        return instance;
    }
}