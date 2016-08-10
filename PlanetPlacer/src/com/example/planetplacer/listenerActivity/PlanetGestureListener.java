/**
 * 
 */
/**
 * @author ELDHOSE
 *
 */
package com.example.planetplacer.listenerActivity;

import com.example.planetplacer.gameview.Panel;

import android.view.MotionEvent;
import android.view.View;
import android.view.GestureDetector.SimpleOnGestureListener;



public class PlanetGestureListener extends SimpleOnGestureListener {
	private View view;

	public PlanetGestureListener(View view) {
		this.view = view;
	}

	
	@Override
	public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
			float velocityY) {
		((Panel) view).addElement(e1, velocityX, velocityY);
		return false;
	}

	
	@Override
	public boolean onSingleTapConfirmed(MotionEvent e) {
		((Panel) view).addElement(e);
		return super.onSingleTapConfirmed(e);
	}


}