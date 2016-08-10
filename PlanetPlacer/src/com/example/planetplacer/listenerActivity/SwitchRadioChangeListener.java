package com.example.planetplacer.listenerActivity;

import com.example.planetplacer.R;
import com.example.planetplacer.property.PlanetSettings;

import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;



public class SwitchRadioChangeListener implements OnCheckedChangeListener {

	@Override
	public void onCheckedChanged(RadioGroup group, int checked) {
		switch(checked){
		case R.id.soundOffRadio:
			PlanetSettings.setSound(false);
			break;
		case R.id.soundOnRadio:
			PlanetSettings.setSound(true);
			break;
		case R.id.vibrateOnRadio:
			PlanetSettings.setVibration(true);
			break;
		case R.id.vibrateOffRadio:
			PlanetSettings.setVibration(false);
			break;
		case R.id.devOnRadio:
			PlanetSettings.setDevmode(true);
			break;
		case R.id.devOffRadio:
			PlanetSettings.setDevmode(false);
			break;
		}
		
	}

}
