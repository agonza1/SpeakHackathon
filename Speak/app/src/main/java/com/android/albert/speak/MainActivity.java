package com.android.albert.speak;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import ai.api.AIConfiguration;
import ai.api.AIListener;
import ai.api.AIService;
import ai.api.model.AIError;
import ai.api.model.AIResponse;
import ai.api.model.Result;
import java.util.Map;
import android.view.View;

import com.google.gson.JsonElement;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONException;

public class MainActivity extends AppCompatActivity{
    private static final int SPLASH_DISPLAY_TIME = 2500;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                Intent intent = new Intent();
                intent.setClass(getApplicationContext(),LanguageActivity.class);
                startActivity(intent);
            }
        }, SPLASH_DISPLAY_TIME);
        bindViews();
        bindButtons();
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

    private void bindViews() {
       // textFname = (TextView) findViewById(R.id.firstname);
    }

    private void bindButtons() {
    }

    public class StartOnClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {

            switch (v.getId()) {
                case R.id.nextButton:
                    Intent intent = new Intent(v.getContext(), LanguageActivity.class);
                    Log.i("test", "Next pressed1");
                    startActivity(intent);
                    Log.i("test", "Next pressed2");
                    break;
            }
        }
    }

   /* public void listenButtonOnClick(final View view) {
        aiService.startListening();
    }*/

}
