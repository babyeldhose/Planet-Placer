package com.example.planetplacer.levelthread;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

import com.example.planetplacer.gameview.Panel;



public class TransitionView extends Thread {
	
	private Panel mPanel;
	private SurfaceHolder xHolder;
	private boolean xRun = false;
	private long xStartTime;
	private long xtimeElapsed;
	
	public TransitionView(Panel panel){
		mPanel = panel;
		xHolder = mPanel.getHolder();
	}
	public void setRun(boolean run){
		xRun = run;
	}
	public void run(){
		Canvas canvas = null;
		xStartTime = System.currentTimeMillis();
		while(xRun){
			canvas = xHolder.lockCanvas();
			if(canvas != null){
				
				mPanel.animate(xtimeElapsed);
				mPanel.doDraw(xtimeElapsed, canvas);
				xtimeElapsed = System.currentTimeMillis() - xStartTime;
				mPanel.purgeDestroyed();
				xHolder.unlockCanvasAndPost(canvas);
				
			}
			  xStartTime = System.currentTimeMillis();
		}
	}
}
