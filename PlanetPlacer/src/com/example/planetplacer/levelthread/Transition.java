/**
 * 
 */
/**
 * @author ELDHOSE
 *
 */
package com.example.planetplacer.levelthread;

import android.app.Activity;
import android.content.Intent;

public class Transition extends Thread
{
	private Activity create;
	private Intent newActivity;
	private int timeTaken;
	public Transition(Activity create, Intent newActivity, int timeTaken){
		this.create = create;
		this.newActivity = newActivity;
		this.timeTaken =timeTaken;		
		
	}
	public void run()
	{
		super.run();
		try
		{
			int ltimer=0;
			while(ltimer<timeTaken)
			{
				sleep(100);
				ltimer=ltimer+100;
				
			}
			create.startActivity(newActivity);
		} catch (InterruptedException e) {
			e.printStackTrace();
	}finally {
		create.finish();
	}
}
}
