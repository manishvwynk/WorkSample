package com.example.manishverma.myapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

public class CActivity  extends EmptyActivity implements FragmentFirstA.ISwitchFragment {


    String TAG = getClass().getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d("mvv", " " + TAG + " onCreate ");
        setContentView(R.layout.activity_c);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        loadFrag();
    }


    private void loadFrag() {
        findViewById(R.id.container);

        if (getSupportFragmentManager().findFragmentById(R.id.container) == null) {
            Fragment mFragment = new FragmentFirstA();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
//            ft.addToBackStack(null);
            ft.add(R.id.container, mFragment).commit();
        } else {
            Log.d("mvv", " loaded Frag ....already  ");
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.d("mvv", " " + TAG + " onDestroy ");
        if(getSupportFragmentManager().findFragmentById(R.id.container) != null) {

            Fragment frg = getSupportFragmentManager().findFragmentById(R.id.container);

            if (frg instanceof FragmentFirstA) {
                Log.d("mvv", " onDestroy Activity " + ((FragmentFirstA) frg).name + " prg " + ((FragmentFirstA) frg).mProgress);
            }
        }

    }

    @Override
    public void switchFragmet() {

        if (getSupportFragmentManager().findFragmentById(R.id.container) == null) {
            Fragment mFragment = new FragmentFirstA();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.add(R.id.container, mFragment).commit();
            Log.d("mvv", " switchFragmet... add frag  ");
        } else {

            Fragment mFragment = new FragmentB();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
//            ft.addToBackStack(null);
            ft.replace(R.id.container, mFragment).commit();

            Log.d("mvv", " replace frag  ");
        }
    }
}
