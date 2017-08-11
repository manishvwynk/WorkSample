package com.example.manishverma.myapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

public class CActivity  extends EmptyActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
            Fragment mFragment = new Fragment_step5();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.add(R.id.container, mFragment).commit();
        } else {
            Log.d("mvv", " loaded Frag ....already  ");
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if(getSupportFragmentManager().findFragmentById(R.id.container) != null) {

            Fragment frg = getSupportFragmentManager().findFragmentById(R.id.container);

            if (frg instanceof Fragment_step5) {
                Log.d("mvv", " onDestroy Activity " + ((Fragment_step5) frg).name + " prg " + ((Fragment_step5) frg).mProgress);
            }
        }

    }
}
