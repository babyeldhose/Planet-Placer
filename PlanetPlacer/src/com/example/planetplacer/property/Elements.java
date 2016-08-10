/**
 * 
 */
/**
 * @author ELDHOSE
 *
 */
package com.example.planetplacer.property;

import java.util.Random;

import com.example.planetplacer.R;
import com.example.planetplacer.gameview.Panel;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;


public class Elements
{
private static int speedDivider = 100;
	
	private float mX;
	private float mY;
	
	private double mSpeedX;
	private double mSpeedY;

	private static Bitmap kBitmap;
	private static Bitmap bBitmap;

	private float dX;
	private float dY;

	private float yPositiveOffset;
	private float yNegativeOffset;

	private float xPositiveOffset;
	private float xNegativeOffset;

	private boolean destroy = false;

	public boolean isDestroyed() {
		return destroy;
	}

	public Elements(Resources res, int x, int y) {
		Random rand = new Random();
		setGraphics(res);
		mX = x - kBitmap.getWidth() / 2;
		mY = y - kBitmap.getHeight() / 2;

		// offsets based on height (y axis) and width (x axis)
		xPositiveOffset = kBitmap.getWidth() / 2;
		xNegativeOffset = kBitmap.getWidth() / 2;
		yPositiveOffset = kBitmap.getHeight() / 2;
		yNegativeOffset = kBitmap.getHeight() / 2;

		mSpeedX = rand.nextInt(8) - 3;
		mSpeedY = rand.nextInt(8) - 3;
	}
	
	public Elements(Resources res, int x, int y, int speedX, int speedY) {
		Random rand = new Random();
		setGraphics(res);
		mX = x - kBitmap.getWidth() / 2;
		mY = y - kBitmap.getHeight() / 2;

		// offsets based on height (y axis) and width (x axis)
		xPositiveOffset = kBitmap.getWidth() / 2;
		xNegativeOffset = kBitmap.getWidth() / 2;
		yPositiveOffset = kBitmap.getHeight() / 2;
		yNegativeOffset = kBitmap.getHeight() / 2;

		mSpeedX = speedX/speedDivider;
		mSpeedY = speedY/speedDivider;
		while(mSpeedX ==0 && mSpeedY == 0 ){
			mSpeedX = rand.nextInt(8) - 3;
			mSpeedY = rand.nextInt(8) - 3;
		}
	}

	public static void setGraphics(Resources res) {
		if(kBitmap == null) kBitmap = BitmapFactory.decodeResource(res, R.drawable.bubble);
		if(bBitmap == null) bBitmap = BitmapFactory.decodeResource(res, R.drawable.burst);
	}


	public void animate(Long elapsedTime) {
		if (!isDestroyed()) {
			mX += mSpeedX * (elapsedTime / 25f);
			mY += mSpeedY * (elapsedTime / 25f);
			checkBorders();
		}
	}

	public void setDestroyed() {
		dX = mX;
		dY = mY;
		destroy = true;
	}
	
	

	private void checkBorders() {
		if (mX <= 0) {
			mSpeedX = -mSpeedX;
			mX = 0;
		}
		else if (mX + kBitmap.getWidth() >= Panel.mWidth)
		{
			mSpeedX = -mSpeedX;
			mX = Panel.mWidth - kBitmap.getWidth();
		}
		if (mY <= 0)
		{
			mY = 0;
			mSpeedY = -mSpeedY;
		}
		if (mY + kBitmap.getHeight() >= Panel.mHeight)
		
		{
			mSpeedY = -mSpeedY;
			mY = Panel.mHeight - kBitmap.getHeight();
		}
	}
	
	

	public void doDraw(Canvas canvas) {
		if (!destroy)
			canvas.drawBitmap(kBitmap, mX, mY, null);
		else
			canvas.drawBitmap(bBitmap, dX, dY, null);
	}

	public boolean isOccupyingSameSpace(Elements other) {
		int oX = (int) other.mX;
		int oY = (int) other.mY;
		int tX = (int) mX;
		int tY = (int) mY;
		if (checkForOverlap(oX, oY, tX, tY))
		
		{
			return true;
		} else
			return false;
	}

	
	
	private boolean checkForOverlap(int oX, int oY, int tX, int tY) {
		if (checkForXAxisOverlap(oX, tX) && checkForYAxisOverlap(oY, tY))
			return true;
		else
			return false;

	}

	private boolean checkForYAxisOverlap(int oY, int tY)
	{
		return oY + yPositiveOffset >= tY && oY - yNegativeOffset <= tY;
	}

	private boolean checkForXAxisOverlap(int oX, int tX) 
	{
		return oX + xPositiveOffset >= tX && oX - xNegativeOffset <= tX;
	}

	public static int getSpeedDivider()
	
	{
		return speedDivider;
	}

	public static void setSpeedDivider(int speedDivider)
	{
		Elements.speedDivider = speedDivider;
	}

	public double getmSpeedX() 
	{
		return mSpeedX;
	}

	public void setmSpeedX(double mSpeedX)
{
		this.mSpeedX = mSpeedX;
	}

	public double getmSpeedY() 
	{
		return mSpeedY;
	}

	public void setmSpeedY(double mSpeedY) 
	{
		this.mSpeedY = mSpeedY;
	}

	

}