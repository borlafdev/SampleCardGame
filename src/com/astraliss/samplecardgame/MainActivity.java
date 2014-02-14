package com.astraliss.samplecardgame;

import com.google.android.gms.ads.*;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

public class MainActivity  extends FragmentActivity {
	MenuFragment menuFragment;
	SettingsFragment settingsFragment;
	CreditsFragment creditsFragment;
	FragmentManager fm;
	FragmentTransaction ft;
	Context ctx;
	ActionBar ab;
	AdView adView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_containter);
		PreferenceManager.setDefaultValues(this, R.xml.preferences , false);
		 ab = getActionBar();
		    ab.setHomeButtonEnabled(false);
		    ab.setDisplayHomeAsUpEnabled(false);
		
		    adView = new AdView(this);
		    adView.setAdUnitId("");
		    adView.setAdSize(AdSize.BANNER);
		    LinearLayout layout = (LinearLayout) findViewById(R.id.Layout);
		    layout.addView(adView);
		    AdRequest request = new AdRequest.Builder().addTestDevice("0123456789ABCDEF") .build(); 
		    adView.loadAd(request);

		menuFragment = new MenuFragment();
		settingsFragment = new SettingsFragment();
		creditsFragment = new CreditsFragment();
		fm = getSupportFragmentManager();
		ft = fm.beginTransaction();
		changeToFragment(4);
		ctx = getApplicationContext();
	}

	protected void changeToFragment(int fragmentid){
		fm = getSupportFragmentManager();
		ft = fm.beginTransaction();
		switch (fragmentid) {
		case 1:
			Intent game = new Intent(ctx, GameActivity.class);
			startActivity(game);
			break;
		case 2:
			ft.setCustomAnimations(
				      R.anim.fadein, R.anim.fadeout, R.anim.fadein, R.anim.fadeout);
			ft.replace(R.id.MainFragment, settingsFragment, "");
			ft.commit();
			 ab.setDisplayHomeAsUpEnabled(true);
			break;
		case 3:
			ft.setCustomAnimations(
				      R.anim.fadein, R.anim.fadeout, R.anim.fadein, R.anim.fadeout);
			ft.replace(R.id.MainFragment, creditsFragment, "");
			ft.commit();
			 ab.setDisplayHomeAsUpEnabled(true);
			break;

		case 4:
			ft.setCustomAnimations(
				      R.anim.fadein, R.anim.fadeout, R.anim.fadein, R.anim.fadeout);
			ft.replace(R.id.MainFragment, menuFragment, "MENU");
			ft.commit();
			ab.setHomeButtonEnabled(false);
			 ab.setDisplayHomeAsUpEnabled(false);
			break;
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public boolean onMenuItemSelected(int featureId, MenuItem item) {

	    int itemId = item.getItemId();
	    switch (itemId) {
	    case android.R.id.home:
	    	changeToFragment(4);
	        break;
	    }
	    
	   

	    return true;
	}
	
    @Override
    public void onBackPressed() {
    	MenuFragment menu = null;
    	menu = (MenuFragment) fm.findFragmentByTag("MENU");
    	if (menu != null) {
            super.onBackPressed();
    	}else{
    		changeToFragment(4);
        }
    }
} 


