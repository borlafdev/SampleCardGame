package com.astraliss.cardgame;


import android.os.Bundle;
import android.app.Activity;
import android.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;

public class GameActivity extends FragmentActivity {
	MenuFragment menuFragment;
	SettingsFragment settingsFragment;
	CreditsFragment creditsFragment;
	FragmentManager fm;
	FragmentTransaction ft;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		   
		menuFragment = new MenuFragment();
		settingsFragment = new SettingsFragment();
		creditsFragment = new CreditsFragment();
		fm = getSupportFragmentManager();
		ft = fm.beginTransaction();
		ft.setCustomAnimations(
			      R.anim.fadein, R.anim.fadeout, R.anim.fadein, R.anim.fadeout);
		ft.replace(R.id.MainFragment, menuFragment, "MENU");
		ft.addToBackStack(null);
		ft.commit();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
