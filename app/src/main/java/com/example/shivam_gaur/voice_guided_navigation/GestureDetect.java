package com.example.shivam_gaur.voice_guided_navigation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v4.view.GestureDetectorCompat;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.Toast;

import java.util.Locale;

import android.speech.tts.TextToSpeech;


public class GestureDetect extends Activity implements GestureDetector.OnGestureListener,GestureDetector.OnDoubleTapListener {
    public static final String DEBUG_TAG="Gestures";
    TextToSpeech tts;
    private GestureDetectorCompat mDetector;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gesture_detect);
        mDetector=new GestureDetectorCompat(this,this);
        mDetector.setOnDoubleTapListener(this);

        tts=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    tts.setLanguage(Locale.ENGLISH);
                }
            }
        });
    }


    public boolean onTouchEvent(MotionEvent event){
        this.mDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    public boolean onDoubleTapEvent(MotionEvent event){
        Log.d(DEBUG_TAG,"onDoubleTapEvent: "+event.toString());
        Toast.makeText(this,"Double Tapped Event",Toast.LENGTH_LONG).show();
        Intent i=new Intent(GestureDetect.this, MapsActivity.class);

        tts.speak("Please Speak your destination", TextToSpeech.QUEUE_FLUSH, null);

        startActivity(i);
        return true;
    }

    public void onLongPress(MotionEvent event){

    }
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY){
        return true;
    }
    public boolean onDown(MotionEvent event){
        return true;
    }

    public boolean onFling(MotionEvent e1, MotionEvent e2, float vX, float vY){
        return true;
    }

    public void onShowPress(MotionEvent event){

    }

    public boolean onSingleTapUp(MotionEvent event){
        return true;
    }
    public boolean onDoubleTap(MotionEvent event){
        Log.d(DEBUG_TAG,"onDoubleTap: "+event.toString());
        Toast.makeText(this,"Double Tapped", Toast.LENGTH_LONG).show();
        // Intent i=new Intent(GestureDetect.this, HomeScreen.class);
        // startActivity(i);
        return true;
    }

    public boolean onSingleTapConfirmed(MotionEvent event){
        return true;
    }


}
