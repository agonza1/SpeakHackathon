package com.android.albert.speak;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import static android.widget.ArrayAdapter.createFromResource;

/**
 * Created by Albert on 8/27/2016.
 */
public class ContextActivity extends AppCompatActivity {
    private Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_context);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        bindViews();
        bindButtons();

    }
    private void bindViews() {
        nextButton = (Button) findViewById(R.id.nextButton2);
    }

    private void bindButtons() {
        nextButton.setOnClickListener(new StartOnClickListener());
    }

    public class StartOnClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {

            switch (v.getId()) {
                case R.id.nextButton2:
                    Intent intent = new Intent(v.getContext(), AiActivity.class);
                    startActivity(intent);
                    Log.i("test", "Next pressed!!");
                    break;
            }
        }
    }
}
