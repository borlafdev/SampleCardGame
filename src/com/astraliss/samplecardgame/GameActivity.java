package com.astraliss.samplecardgame;


import android.os.Bundle;
import android.app.Activity;
import android.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;

public class GameActivity extends FragmentActivity {
	CardShowFragment cardShow;
	FragmentManager fm;
	FragmentTransaction ft;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.game_container);
		   
		cardShow = new CardShowFragment();
		fm = getSupportFragmentManager();
		ft = fm.beginTransaction();
		ft.setCustomAnimations(
			      R.anim.fadein, R.anim.fadeout, R.anim.fadein, R.anim.fadeout);
		ft.replace(R.id.GameFragment, cardShow, "MENU");
		ft.addToBackStack(null);
		ft.commit();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	 @Override
	    public void onBackPressed() {
	    	finish();
	        
	    }

}
