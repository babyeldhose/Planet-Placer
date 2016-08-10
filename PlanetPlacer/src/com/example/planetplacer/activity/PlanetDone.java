package com.example.planetplacer.activity;



import com.example.planetplacer.R;
import com.example.planetplacer.levelthread.Transition;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

public class PlanetDone extends Activity{
	ImageView animEarth;
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.done);
		
		
		//Transition backToMenu = new Transition(this, new Intent(
			//	"com.example.planetplacer.activity.PLANETMENU"), 1000);
		//backToMenu.start();
		animEarth =(ImageView)findViewById(R.id.animEarth);
		RotateAnimation rotate = new RotateAnimation(0, 360);
		rotate.getInterpolator();
		
	}

	@Override
	public void onBackPressed() {

		Transition backToMenu = new Transition(this, new Intent(
				"com.example.planetplacer.activity.PLANETMENU"), 1000);
		backToMenu.start();

		return;
	}
}
