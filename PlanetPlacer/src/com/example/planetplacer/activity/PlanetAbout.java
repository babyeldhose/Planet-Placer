package com.example.planetplacer.activity;

import com.example.planetplacer.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;



public class PlanetAbout extends Activity {
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.about);
		
	}
	
	
	public void onBackPressed() {
		  startActivity( new Intent(
				"com.example.planetplacer.activity.PLANETMENU"));
	}
}
