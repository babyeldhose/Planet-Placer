package com.example.planetplacer.activity;


import com.example.planetplacer.R;
import com.example.planetplacer.levelthread.Transition;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;

public class PlanetStart extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		requestWindowFeature(Window.FEATURE_NO_TITLE);
    	setContentView(R.layout.planethome);
    	Transition logohome = new Transition(this,new Intent("com.example.planetplacer.activity.PLANETMENU"),2000);
    	logohome.start();
	}


}
