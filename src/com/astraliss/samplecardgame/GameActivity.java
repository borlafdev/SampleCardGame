package com.astraliss.samplecardgame;


import android.os.Bundle;
import android.app.Activity;
import android.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class GameActivity extends FragmentActivity implements OnClickListener {
	CardShowFragment cardShow;
	FragmentManager fm;
	FragmentTransaction ft;
	TextView tvRemainTurns, tvElapsedTurns, tvPoints;
	Button restart, exit;
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
		
		tvRemainTurns = (TextView) findViewById(R.id.tvrestantes);
		tvElapsedTurns = (TextView) findViewById(R.id.tvjugados);
		tvPoints = (TextView) findViewById(R.id.tvpuntos);
		
		restart = (Button) findViewById(R.id.restart);
		exit = (Button) findViewById(R.id.exit);
		restart.setOnClickListener(this);
		exit.setOnClickListener(this);
		
	}
	public void refreshPuntuation(int remainturns, int elapsedturns, int points){
		tvRemainTurns.setText(getResources().getString(R.string.trestante) + Integer.toString(remainturns));
		tvElapsedTurns.setText(getResources().getString(R.string.tjugados) + Integer.toString(elapsedturns));
		tvPoints.setText(getResources().getString(R.string.puntos) + Integer.toString(points));
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
	@Override
	public void onClick(View v) {
		if(v.getId() == R.id.restart){
			recreate();
		}else if(v.getId() == R.id.exit)
		{
			finish();
		}
	}

}
