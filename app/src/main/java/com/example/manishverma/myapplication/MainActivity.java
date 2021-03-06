package com.example.manishverma.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    String TAG = getClass().getSimpleName();
    TextView textView1,textView2,textView3;
    private CollapsingToolbarLayout collapsingToolbarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("mvv"," "+TAG+" onCreate ");
        setContentView(R.layout.activity_main);
        textView1 = (TextView)findViewById(R.id.b);
        textView2 = (TextView)findViewById(R.id.c);
        textView3 = (TextView)findViewById(R.id.d);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        textView1.setOnClickListener(listener);
        textView2.setOnClickListener(listener);
        textView3.setOnClickListener(listener);

        dynamicToolbarColor();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                taskbuilder(MainActivity.this,true);
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    View.OnClickListener listener = new View.OnClickListener(){

        @Override
        public void onClick(View v) {
            if(v.getId() == R.id.b){
               startActivity(new Intent(MainActivity.this, BActivity.class));
            }else if(v.getId() == R.id.c){
                startActivity(new Intent(MainActivity.this, CActivity.class));
            }else if(v.getId() == R.id.d){
                startActivity(new Intent(MainActivity.this, DActivity.class));
            }

        }
    };

    private void dynamicToolbarColor() {

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),
                R.drawable.tutorialsbuzz);
        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(Palette palette) {
                collapsingToolbarLayout.setContentScrimColor(palette.getMutedColor(R.attr.colorPrimary));
                collapsingToolbarLayout.setStatusBarScrimColor(palette.getMutedColor(R.attr.colorPrimaryDark));
            }
        });
    }


    private void taskbuilder(Context context, boolean buildBackStack){
        if (context == null ) {
            throw new IllegalArgumentException("Invalid context");
        }
        Intent intent = new Intent(context, DActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        if(buildBackStack) {
            TaskStackBuilder tsb = TaskStackBuilder.create(context);
            tsb.addParentStack((Activity) context);
            tsb.addNextIntent(new Intent(context, BActivity.class));
            tsb.addNextIntent(new Intent(context, CActivity.class));
//            tsb.addNextIntent(new Intent(context, DActivity.class));
            tsb.addNextIntent(intent);
            tsb.startActivities();
        }else{
            context.startActivity(intent);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
