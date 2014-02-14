package com.astraliss.samplecardgame;


import java.util.ArrayList;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class CardShowFragment extends Fragment implements OnClickListener {
	int pressed = 0;
	private int remainTurns, elapsedTurns, points, ivpressed ,cards, cardsFlipped , difficulty;
	private ArrayList<FlipImageView> mFlipImageView;
	FlipImageView lastpressed, firstpressed;
	boolean free;
	View view;
	LinearLayout rootLayout, hide1, hide2, hide3;
	SharedPreferences prefs;
	Activity activity;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		//Inflate the layout
		view = inflater.inflate(R.layout.card_show,container, false);
		activity = getActivity();
		//Saving the layout roots view to disable it further
		rootLayout = (LinearLayout) view.findViewById(R.id.scrollViewCards);
		rootLayout.setEnabled(false);
		
		
		hide1 = (LinearLayout) view.findViewById(R.id.hide1);
		hide2 = (LinearLayout) view.findViewById(R.id.hide2);
		hide3 = (LinearLayout) view.findViewById(R.id.hide3);
		
		prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
		remainTurns = Integer.parseInt(prefs.getString("turns", ""));
		difficulty = Integer.parseInt(prefs.getString("difficulty", ""));
		loadGame(difficulty);
		
		//Instance two Decks of cards, every one with an array of numbers
		
		return view;
	}
	public void flipBack(){
		firstpressed.setFlipped(false);
		lastpressed.setFlipped(false);
		pressed = 0;
	}
	private void loadGame( int cards){
		mFlipImageView = new ArrayList<FlipImageView>();
		Drawable[] images = {getResources().getDrawable(R.drawable.ambulance),
				getResources().getDrawable(R.drawable.android),
				getResources().getDrawable(R.drawable.apple),
				getResources().getDrawable(R.drawable.bell),
				getResources().getDrawable(R.drawable.camera),
				getResources().getDrawable(R.drawable.certificate),
				getResources().getDrawable(R.drawable.cloud),
				getResources().getDrawable(R.drawable.cup),
				getResources().getDrawable(R.drawable.fire),
				getResources().getDrawable(R.drawable.flag),
				getResources().getDrawable(R.drawable.gift),
				getResources().getDrawable(R.drawable.globe)};
				CardDeck deck1, deck2;
		switch (cards) {
		case 12:
			refreshPoints(false, false);
			deck1 = new CardDeck(6);
			deck2 = new CardDeck(6);
			hide1.setVisibility(View.GONE);
			hide2.setVisibility(View.GONE);
			hide3.setVisibility(View.GONE);
			((FlipImageView) view.findViewById(R.id.iv06v)).setVisibility(View.VISIBLE);
			((FlipImageView) view.findViewById(R.id.iv11v)).setVisibility(View.VISIBLE);
			mFlipImageView.add((FlipImageView) view.findViewById(R.id.iv01));
			mFlipImageView.add((FlipImageView) view.findViewById(R.id.iv02));
			mFlipImageView.add((FlipImageView) view.findViewById(R.id.iv03));
			mFlipImageView.add((FlipImageView) view.findViewById(R.id.iv04));
			mFlipImageView.add((FlipImageView) view.findViewById(R.id.iv05));
			mFlipImageView.add((FlipImageView) view.findViewById(R.id.iv06v));
			mFlipImageView.add((FlipImageView) view.findViewById(R.id.iv06));
			mFlipImageView.add((FlipImageView) view.findViewById(R.id.iv07));
			mFlipImageView.add((FlipImageView) view.findViewById(R.id.iv08));
			mFlipImageView.add((FlipImageView) view.findViewById(R.id.iv09));
			mFlipImageView.add((FlipImageView) view.findViewById(R.id.iv10));
			mFlipImageView.add((FlipImageView) view.findViewById(R.id.iv11v));
			mFlipImageView.add((FlipImageView) view.findViewById(R.id.iv11));

			for(int i = 0; i < mFlipImageView.size(); i++)
			{ 
				if(i < 6){
					mFlipImageView.get(i).setFlippedDrawable(images[deck1.getCard(i)]);
					mFlipImageView.get(i).setTag(deck1.getCard(i));
				}else{
					mFlipImageView.get(i).setFlippedDrawable(images[deck2.getCard(i-6)]);
					mFlipImageView.get(i).setTag(deck2.getCard(i-6));
				}
				mFlipImageView.get(i).setOnClickListener(this);
			}
			
			break;
		case 18:
			refreshPoints(false, false);
			deck1 = new CardDeck(9);
			deck2 = new CardDeck(9);
			hide2.setVisibility(View.GONE);
			hide3.setVisibility(View.GONE);
			((FlipImageView) view.findViewById(R.id.iv06v)).setVisibility(View.VISIBLE);
			((FlipImageView) view.findViewById(R.id.iv11v)).setVisibility(View.VISIBLE);
			((FlipImageView) view.findViewById(R.id.iv16v)).setVisibility(View.VISIBLE);
			mFlipImageView.add((FlipImageView) view.findViewById(R.id.iv01));
			mFlipImageView.add((FlipImageView) view.findViewById(R.id.iv02));
			mFlipImageView.add((FlipImageView) view.findViewById(R.id.iv03));
			mFlipImageView.add((FlipImageView) view.findViewById(R.id.iv04));
			mFlipImageView.add((FlipImageView) view.findViewById(R.id.iv05));
			mFlipImageView.add((FlipImageView) view.findViewById(R.id.iv06v));
			mFlipImageView.add((FlipImageView) view.findViewById(R.id.iv06));
			mFlipImageView.add((FlipImageView) view.findViewById(R.id.iv07));
			mFlipImageView.add((FlipImageView) view.findViewById(R.id.iv08));
			mFlipImageView.add((FlipImageView) view.findViewById(R.id.iv09));
			mFlipImageView.add((FlipImageView) view.findViewById(R.id.iv10));
			mFlipImageView.add((FlipImageView) view.findViewById(R.id.iv11v));
			mFlipImageView.add((FlipImageView) view.findViewById(R.id.iv11));
			mFlipImageView.add((FlipImageView) view.findViewById(R.id.iv12));
			mFlipImageView.add((FlipImageView) view.findViewById(R.id.iv13));
			mFlipImageView.add((FlipImageView) view.findViewById(R.id.iv14));
			mFlipImageView.add((FlipImageView) view.findViewById(R.id.iv15));
			mFlipImageView.add((FlipImageView) view.findViewById(R.id.iv16v));
			for(int i = 0; i < mFlipImageView.size(); i++)
			{ 
				if(i < 9){
					mFlipImageView.get(i).setFlippedDrawable(images[deck1.getCard(i)]);
					mFlipImageView.get(i).setTag(deck1.getCard(i));
					
				}else{
					mFlipImageView.get(i).setFlippedDrawable(images[deck2.getCard(i-9)]);
					mFlipImageView.get(i).setTag(deck2.getCard(i-9));
				}
				mFlipImageView.get(i).setOnClickListener(this);
			}
			break;
		case 24:
			refreshPoints(false, false);
			deck1 = new CardDeck(12);
			deck2 = new CardDeck(12);
			mFlipImageView.add((FlipImageView) view.findViewById(R.id.iv01));
			mFlipImageView.add((FlipImageView) view.findViewById(R.id.iv02));
			mFlipImageView.add((FlipImageView) view.findViewById(R.id.iv03));
			mFlipImageView.add((FlipImageView) view.findViewById(R.id.iv04));
			mFlipImageView.add((FlipImageView) view.findViewById(R.id.iv05));
			mFlipImageView.add((FlipImageView) view.findViewById(R.id.iv06));
			mFlipImageView.add((FlipImageView) view.findViewById(R.id.iv07));
			mFlipImageView.add((FlipImageView) view.findViewById(R.id.iv08));
			mFlipImageView.add((FlipImageView) view.findViewById(R.id.iv09));
			mFlipImageView.add((FlipImageView) view.findViewById(R.id.iv10));
			mFlipImageView.add((FlipImageView) view.findViewById(R.id.iv11));
			mFlipImageView.add((FlipImageView) view.findViewById(R.id.iv12));
			mFlipImageView.add((FlipImageView) view.findViewById(R.id.iv13));
			mFlipImageView.add((FlipImageView) view.findViewById(R.id.iv14));
			mFlipImageView.add((FlipImageView) view.findViewById(R.id.iv15));
			mFlipImageView.add((FlipImageView) view.findViewById(R.id.iv16));
			mFlipImageView.add((FlipImageView) view.findViewById(R.id.iv17));
			mFlipImageView.add((FlipImageView) view.findViewById(R.id.iv18));
			mFlipImageView.add((FlipImageView) view.findViewById(R.id.iv19));
			mFlipImageView.add((FlipImageView) view.findViewById(R.id.iv20));
			mFlipImageView.add((FlipImageView) view.findViewById(R.id.iv21));
			mFlipImageView.add((FlipImageView) view.findViewById(R.id.iv22));
			mFlipImageView.add((FlipImageView) view.findViewById(R.id.iv23));
			mFlipImageView.add((FlipImageView) view.findViewById(R.id.iv24));
			for(int i = 0; i < mFlipImageView.size(); i++)
			{ 
				if(i < 12){
					mFlipImageView.get(i).setFlippedDrawable(images[deck1.getCard(i)]);
					mFlipImageView.get(i).setTag(deck1.getCard(i));
				}else{
					mFlipImageView.get(i).setFlippedDrawable(images[deck2.getCard(i-12)]);
					mFlipImageView.get(i).setTag(deck2.getCard(i-12));
				}
				mFlipImageView.get(i).setOnClickListener(this);
			}
			break;
		}
	}
	
	public void loadDifficulty(){
		switch (cards) {
		case 12:
			hide1.setVisibility(View.GONE);
			hide2.setVisibility(View.GONE);
			view.findViewById(R.id.iv21).setVisibility(View.GONE);
			view.findViewById(R.id.iv24).setVisibility(View.GONE);
			break;

		case 18:
			hide2.setVisibility(View.GONE);
			view.findViewById(R.id.iv21).setVisibility(View.GONE);
			break;
		case 24:
			break;
		}
	}
	public void refreshPoints(boolean point, boolean turns){
		if(turns){
		remainTurns--;
		elapsedTurns++;
		points--;
		}
		if(point)
			points+=5;
		((GameActivity) activity).refreshPuntuation(remainTurns, elapsedTurns, points, cardsFlipped, difficulty);

	}
	@Override
	public void onClick(View v) {
			switch (pressed) {
			case 0:
				ivpressed = v.getId();
				firstpressed = ((FlipImageView) view.findViewById(ivpressed));
				firstpressed.setFlipped(true);
				pressed++;
				break;

			case 1:
				rootLayout.setEnabled(false);
				lastpressed = ((FlipImageView) view.findViewById(v.getId()));
				lastpressed.setFlipped(true);
				if( firstpressed != lastpressed){
					pressed++;
					if(lastpressed.getTag() == firstpressed.getTag())
					{
						firstpressed.setEnabled(false);
						lastpressed.setEnabled(false);
						cardsFlipped += 2;
						pressed = 0;
						refreshPoints(true, true);
					}else
						new GoToSleep(this).execute("");
					refreshPoints(false, true);
				}
				break;
			}

	}

} 