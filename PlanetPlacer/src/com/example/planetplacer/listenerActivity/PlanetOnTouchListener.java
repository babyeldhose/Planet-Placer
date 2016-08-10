package com.example.planetplacer.listenerActivity;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.example.planetplacer.listenerActivity.PlanetGestureListener;


public class PlanetOnTouchListener implements View.OnTouchListener {
	
	private GestureDetector gestureDetector;
	
	public PlanetOnTouchListener(View view){
		this.gestureDetector = new GestureDetector(new PlanetGestureListener(view));;
	}
	
	
	
	public boolean onTouch(View v, MotionEvent event) {
		if (gestureDetector.onTouchEvent(event)) {
			return true;
		}
		return false;
	}
}