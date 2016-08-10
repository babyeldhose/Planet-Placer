package com.example.planetplacer.activity;



import com.example.planetplacer.property.PlanetSettings;
import com.example.planetplacer.R;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class PlanetMenu  extends Activity{
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.planetmenu);
	
	final MediaPlayer mpButtonClick = MediaPlayer.create(this, R.raw.buttonclick);

	
	
	Button startButton = (Button) findViewById(R.id.startButton);
	startButton.setOnClickListener(new View.OnClickListener() {

		
		
		
		@Override
		public void onClick(View v) {
			
			startActivity(new Intent("com.example.planetplacer.activity.PLANETONE"));
			if (PlanetSettings.isSound())
				mpButtonClick.start();
		}
	});

	Button settingButton = (Button) findViewById(R.id.settingButton);
	settingButton.setOnClickListener(new View.OnClickListener() {

		@Override
		public void onClick(View v) {
			startActivity(new Intent("com.example.planetplacer.activity.PLANETSETTINGSMENU"));
			if (PlanetSettings.isSound())
				mpButtonClick.start();
		}
		
	});
	Button instructButton = (Button)findViewById(R.id.instructButton);
	instructButton.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			startActivity(new Intent("com.example.planetplacer.activity.INSTRUCTIONS"));
			
		}
	});
	Button aboutButton = (Button)findViewById(R.id.aboutButton);
	aboutButton.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			startActivity(new Intent("com.example.planetplacer.activity.ABOUT"));
			
		}
	});
	Button exitButton = (Button)findViewById(R.id.exitButton);
	exitButton.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			finish();
			System.exit(0);
			
		}
	});
  
}

}
