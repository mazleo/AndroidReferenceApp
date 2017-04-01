package com.app.reference.android.androidreferenceapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.TextView;

public class GestureActivity extends AppCompatActivity implements GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {

    private String strMessage;
    private TextView textviewGesture;
    private GestureDetector gestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gesture);

        textviewGesture = (TextView) findViewById(R.id.textviewGesture);
        this.gestureDetector = new GestureDetector(this, this);
        gestureDetector.setOnDoubleTapListener(this);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.gestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        strMessage = "Single Tap";
        textviewGesture.setText(strMessage);
        return false;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        strMessage = "Double Tap";
        textviewGesture.setText(strMessage);
        return false;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        strMessage = "Double Tap Event";
        textviewGesture.setText(strMessage);
        return false;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        strMessage = "Down Gesture";
        textviewGesture.setText(strMessage);
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {
        strMessage = "Show Press";
        textviewGesture.setText(strMessage);

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        strMessage = "Single Tap Up";
        textviewGesture.setText(strMessage);
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        strMessage = "Scroll";
        textviewGesture.setText(strMessage);
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        strMessage = "Long Press";
        textviewGesture.setText(strMessage);

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        strMessage = "Fling";
        textviewGesture.setText(strMessage);
        return false;
    }
}
