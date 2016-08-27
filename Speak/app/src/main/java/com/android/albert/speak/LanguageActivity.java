package com.android.albert.speak;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import ai.api.AIService;

import static android.widget.ArrayAdapter.*;

/**
 * Created by Albert on 8/27/2016.
 */
public class LanguageActivity extends AppCompatActivity {
    private Button nextButton;
    private TextView resultTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        nextButton = (Button) findViewById(R.id.nextButton);
        resultTextView = (TextView) findViewById(R.id.resultTextView);

        bindViews();
        bindButtons();

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
    // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = createFromResource(this,
            R.array.spinner, android.R.layout.simple_spinner_item);
    // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

}
    private void bindViews() {
        nextButton = (Button) findViewById(R.id.nextButton);
    }

    private void bindButtons() {
        nextButton.setOnClickListener(new StartOnClickListener());
    }

    public class StartOnClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {

            switch (v.getId()) {
                case R.id.nextButton:
                    Spinner spinner1 = (Spinner) findViewById(R.id.spinner);
                    Log.i("Language ",String.valueOf(spinner1.getSelectedItem()));
                    Intent intent = new Intent(v.getContext(), ContextActivity.class);
                    startActivity(intent);
                    Log.i("test", "Next pressed");
                    break;
            }
        }
    }

    public class SpinnerActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

        public void onItemSelected(AdapterView<?> parent, View view,
                                   int pos, long id) {
            // An item was selected. You can retrieve the selected item using
            Log.i("Response","is "+parent.getItemAtPosition(pos));
        }

        public void onNothingSelected(AdapterView<?> parent) {
            // Another interface callback
        }
    }
}
