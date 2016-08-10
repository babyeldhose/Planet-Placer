/**
 * 
 */
/**
 * @author ELDHOSE
 *
 */
package com.example.planetplacer.gameview;

import com.example.planetplacer.property.Elements;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.media.MediaPlayer;
import android.os.Vibrator;

public class SpeedPanel extends Panel
{
	private double xSpeedMod = 0;
	private double ySpeedMod = 0;
	private double YmaxSpeed = 10;
	private double XmaxSpeed = 10;
	public SpeedPanel(String levelName, Context context, Vibrator vibrator,
			MediaPlayer highscoreSound, MediaPlayer popSound,
			Bitmap background, int goal, Intent newLevel) {
		super(levelName, context, vibrator, highscoreSound, popSound, background, goal,
				newLevel);
	}
	protected void drawContentOnCanvas(Canvas canvas) {
		synchronized (super.mElements) {
			for (Elements element : mElements) {
				checkForCrash(element);
				if(xSpeedMod != 0 && element.getmSpeedX()<=XmaxSpeed)
					element.setmSpeedX(element.getmSpeedX()+xSpeedMod);
				if(ySpeedMod != 0 && element.getmSpeedX()<=YmaxSpeed)
					element.setmSpeedX(element.getmSpeedX()+ySpeedMod);
				element.doDraw(canvas);
			}
		}
	}
	public void setxSpeedMod(double xSpeedMod) {
		this.xSpeedMod = xSpeedMod;
	}


	public void setySpeedMod(double ySpeedMod) {
		this.ySpeedMod = ySpeedMod;
	}


	public void setMaxYSpeed(double maxYSpeed) {
		this.YmaxSpeed = maxYSpeed;
	}


	public void setMaxXSpeed(double maxXSpeed) {
		this.XmaxSpeed = maxXSpeed;
	}
}