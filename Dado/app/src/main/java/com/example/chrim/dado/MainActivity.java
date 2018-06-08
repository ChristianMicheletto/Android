package com.example.chrim.dado;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    float dir;
    float x1, x2, y1, y2;
    final static float MIN_DISTANCE = 150.0f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (findViewById(R.id.fragment) != null) {
            Fragment f1 = new Fragment();
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.fragment, f1);
            ft.commit();
        }
    }

    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                x1 = event.getX();
                y1 = event.getY();
                break;
            case MotionEvent.ACTION_UP:
                x2 = event.getX();
                y2 = event.getY();
                float deltaX = x2 - x1;
                float deltaY = y2 - y1;
                dir = (Math.abs(deltaY) - Math.abs(deltaX));
                if ((Math.abs(deltaX) > MIN_DISTANCE) || (Math.abs(deltaY) > MIN_DISTANCE)) {
                    if (dir > 0) {
                        if (y2 > y1) {
                            changeFragmentFromAbove();
                        } else {
                            changeFragmentFromBelow();
                        }
                    } else {
                        if (x2 > x1) {
                            changeFragmentFromRight();
                        } else {
                            changeFragmentFromLeft();
                        }
                    }
                }
                break;
        }
        return super.onTouchEvent(event);
    }

    public void changeFragmentFromRight() {
        if (findViewById(R.id.fragment) != null) {
            FragmentManager fm = getFragmentManager();
            Fragment nextFragment;
            nextFragment = new Fragment();
            FragmentTransaction ft = fm.beginTransaction();
            ft.setCustomAnimations(R.animator.slide_in_left, R.animator.slide_out_right);
            ft.replace(R.id.fragment, nextFragment);
            ft.commit();
        } else {
            Toast.makeText(this, "LANDSCAPE", Toast.LENGTH_SHORT).show();
        }

    }
    public void changeFragmentFromLeft() {
        if (findViewById(R.id.fragment) != null) {
            FragmentManager fm = getFragmentManager();
            Fragment nextFragment;
            nextFragment = new Fragment();
            FragmentTransaction ft = fm.beginTransaction();
            ft.setCustomAnimations(R.animator.slide_in_right, R.animator.slide_out_left);
            ft.replace(R.id.fragment, nextFragment);
            ft.commit();
        } else {
            Toast.makeText(this, "LANDSCAPE", Toast.LENGTH_SHORT).show();
        }

    }
    public void changeFragmentFromBelow() {
        if (findViewById(R.id.fragment) != null) {
            FragmentManager fm = getFragmentManager();
            Fragment nextFragment;
            nextFragment = new Fragment();
            FragmentTransaction ft = fm.beginTransaction();
            ft.setCustomAnimations(R.animator.slide_in_above, R.animator.slide_out_below);
            ft.replace(R.id.fragment, nextFragment);
            ft.commit();
        } else {
            Toast.makeText(this, "LANDSCAPE", Toast.LENGTH_SHORT).show();
        }

    }
    public void changeFragmentFromAbove() {
        if (findViewById(R.id.fragment) != null) {
            FragmentManager fm = getFragmentManager();
            Fragment nextFragment;
            nextFragment = new Fragment();
            FragmentTransaction ft = fm.beginTransaction();
            ft.setCustomAnimations(R.animator.slide_in_below, R.animator.slide_out_above);
            ft.replace(R.id.fragment, nextFragment);
            ft.commit();
        } else {
            Toast.makeText(this, "LANDSCAPE", Toast.LENGTH_SHORT).show();
        }

    }
}
