package com.example.planetplacer.activity;

import com.example.planetplacer.R;
import com.example.planetplacer.listenerActivity.SwitchRadioChangeListener;
import com.example.planetplacer.modifier.KeyRepo;
import com.example.planetplacer.property.PlanetSettings;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;



public class PlanetSettingsMenu extends Activity {

	private SwitchRadioChangeListener radioSettingListener;
	private KeyRepo keyValueRepository;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		keyValueRepository = new KeyRepo(this.getApplicationContext());
		setContentView(R.layout.planetsettings);
		setInitialState();
		
		radioSettingListener = new SwitchRadioChangeListener();
		RadioGroup soundRadioGrp = (RadioGroup) findViewById(R.id.groupSound);
		
		soundRadioGrp.setOnCheckedChangeListener(radioSettingListener);
		RadioGroup vibrateRadioGrp = (RadioGroup) findViewById(R.id.groupVibrate);
		vibrateRadioGrp.setOnCheckedChangeListener(radioSettingListener);
		
		RadioGroup devRadioGrp = (RadioGroup) findViewById(R.id.groupDev);
		devRadioGrp.setOnCheckedChangeListener(radioSettingListener);
		Button clearHigh = (Button) findViewById(R.id.resetHigh);
		
		clearHigh.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				keyValueRepository.saveInt("bubbleone-highscore", 0);
				keyValueRepository.saveInt("bubbletwo-highscore", 0);
				keyValueRepository.saveInt("bubblethree-highscore", 0);
				keyValueRepository.saveInt("bubblefour-highscore", 0);
				
			}
		});
	}

	private void setInitialState() {

		// Sound
		RadioButton soundOn = (RadioButton) findViewById(R.id.soundOnRadio);
		if (PlanetSettings.isSound())
			soundOn.setChecked(true);
		RadioButton soundOff = (RadioButton) findViewById(R.id.soundOffRadio);
		if (!PlanetSettings.isSound())
			soundOff.setChecked(true);

		// Vibration
		
		RadioButton vibrateOn = (RadioButton) findViewById(R.id.vibrateOnRadio);
		if (PlanetSettings.isVibration())
			vibrateOn.setChecked(true);
		
		RadioButton vibrateOff = (RadioButton) findViewById(R.id.vibrateOffRadio);
		if (!PlanetSettings.isVibration())
			vibrateOff.setChecked(true);

		// Devmode
		RadioButton devOn = (RadioButton) findViewById(R.id.devOnRadio);
		
		if (PlanetSettings.isDevmode())
			devOn.setChecked(true);
		
		RadioButton devOff = (RadioButton) findViewById(R.id.devOffRadio);
		if (!PlanetSettings.isDevmode())
			devOff.setChecked(true);

	}

}