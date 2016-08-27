package com.android.albert.speak;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.JsonElement;

import java.util.Map;

import ai.api.AIConfiguration;
import ai.api.AIListener;
import ai.api.AIService;
import ai.api.model.AIError;
import ai.api.model.AIResponse;
import ai.api.model.Result;

public class AiActivity extends AppCompatActivity implements AIListener {
    Button listenButton;
    Button nextButton;
    private TextView resultTextView;
    private AIService aiService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ai);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        bindViews();
        bindButtons();

        final AIConfiguration config = new AIConfiguration("206a3b63af1c4f66a1a311274b7b55e0",
                AIConfiguration.SupportedLanguages.English,
                AIConfiguration.RecognitionEngine.System);

        aiService = AIService.getService(this, config);
        aiService.setListener(this);

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
        resultTextView = (TextView) findViewById(R.id.resultTextView);
        nextButton = (Button) findViewById(R.id.nextButton);
        listenButton = (Button) findViewById(R.id.listenButton);
    }

    private void bindButtons() {
        nextButton.setOnClickListener(new StartOnClickListener());
        listenButton.setOnClickListener(new StartOnClickListener());
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
                case R.id.listenButton:
                    aiService.startListening();
                    break;
            }
        }
    }

   /* public void listenButtonOnClick(final View view) {
        aiService.startListening();
    }*/

    @Override
    public void onResult(AIResponse aiResponse) {
        Result result = aiResponse.getResult();

        // Get parameters
        String parameterString = "";
        if (result.getParameters() != null && !result.getParameters().isEmpty()) {
            for (final Map.Entry<String, JsonElement> entry : result.getParameters().entrySet()) {
                parameterString += "(" + entry.getKey() + ", " + entry.getValue() + ") ";
            }
        }

        // Show results in TextView.
        resultTextView.setText("Query:" + result.getResolvedQuery() +
                "\nAction: " + result.getAction() +
                "\nParameters: " + parameterString);
    }

    @Override
    public void onError(AIError aiError) {
        resultTextView.setText(aiError.toString());
    }

    @Override
    public void onAudioLevel(float v) {

    }

    @Override
    public void onListeningStarted() {

    }

    @Override
    public void onListeningCanceled() {

    }

    @Override
    public void onListeningFinished() {

    }
}
