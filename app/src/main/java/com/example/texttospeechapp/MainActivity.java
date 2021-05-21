package com.example.texttospeechapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.EditText;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private TextToSpeech tts;
    private EditText textSpeak;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textSpeak = findViewById(R.id.textSpeak);

        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {

                if(status != TextToSpeech.ERROR) {
                    tts.setLanguage(Locale.US);
                }
            }
        });
    }

    public void convertToVoice(View view) {

        String text = textSpeak.getText().toString();
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
    }
}