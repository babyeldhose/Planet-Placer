package com.example.planetplacer.activity;


import com.example.planetplacer.R;
import com.example.planetplacer.gameview.SpeedPanel;
import com.example.planetplacer.property.Elements;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.Window;

public class PlanetFour extends Activity {
	private final int levelGoal = 9;
	private final Intent nextLevel = new Intent("com.example.planetplacer.activity.PLANETDONE");
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Elements.setSpeedDivider(50);
		final MediaPlayer highscoreSound = MediaPlayer.create(this, R.raw.fanfare);
		final MediaPlayer popSound = MediaPlayer.create(this, R.raw.pop);
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        SpeedPanel panel = new SpeedPanel("bubblefour",this,v,highscoreSound,popSound, BitmapFactory.decodeResource(getResources(),
				R.drawable.fourth),levelGoal, nextLevel );
        panel.setxSpeedMod(+0.3);
        panel.setMaxXSpeed(5);
        setContentView(panel); 
	}
	@Override
	public void onBackPressed() {
		  startActivity( new Intent(
					"com.example.planetplacer.activity.PLANETMENU"));
	}
}
