package com.astraliss.cardgame;


import android.os.Bundle;
import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity  extends FragmentActivity {
	MenuFragment menuFragment;
	SettingsFragment settingsFragment;
	CreditsFragment creditsFragment;
	FragmentManager fm;
	FragmentTransaction ft;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_containter);
		 

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
	protected void changeToFragment(int fragmentid){
		fm = getSupportFragmentManager();
		ft = fm.beginTransaction();
		switch (fragmentid) {
		case 1:
			
			break;
		case 2:
			ft.setCustomAnimations(
				      R.anim.fadein, R.anim.fadeout, R.anim.fadein, R.anim.fadeout);
			ft.replace(R.id.MainFragment, settingsFragment, "MENU");
			ft.addToBackStack(null);
			ft.commit();
			break;
		case 3:
			ft.setCustomAnimations(
				      R.anim.fadein, R.anim.fadeout, R.anim.fadein, R.anim.fadeout);
			ft.replace(R.id.MainFragment, creditsFragment, "MENU");
			ft.addToBackStack(null);
			ft.commit();
			break;

		case 4:
			ft.setCustomAnimations(
				      R.anim.fadein, R.anim.fadeout, R.anim.fadein, R.anim.fadeout);
			ft.replace(R.id.MainFragment, menuFragment, "MENU");
			ft.addToBackStack(null);
			ft.commit();
			break;
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

    @Override
    public void onBackPressed() {
    	MenuFragment menu = (MenuFragment) fm.findFragmentByTag("MY_FRAGMENT");
    	if (menu != null) {
            super.onBackPressed();
    	}else{
    		changeToFragment(4);
        }
    }
} 


