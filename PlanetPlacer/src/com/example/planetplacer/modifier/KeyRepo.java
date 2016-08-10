/**
 * 
 */
/**
 * @author ELDHOSE
 *
 */
package com.example.planetplacer.modifier;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class KeyRepo
{
	private SharedPreferences preference;
	private SharedPreferences.Editor edit;
	public KeyRepo(Context context){
		 preference = PreferenceManager.getDefaultSharedPreferences(context);
		 edit = preference.edit();
	}
	public int getIntValue(String key){
		return preference.getInt(key, 0);
	}
	
	public void saveInt(String key, int value){
		edit.putInt(key, value);
		edit.commit();
	}
}