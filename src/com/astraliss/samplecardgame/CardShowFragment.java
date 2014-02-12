package com.astraliss.samplecardgame;


import java.util.ArrayList;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout;

public class CardShowFragment extends Fragment implements OnClickListener {
	int pressed = 0;
	int ivpressed;
	View view;
	FlipImageView lastpressed;
	FlipImageView firstpressed;
	boolean free;
	LinearLayout rootLayout;
	private int remainTurns;
	private int elapsedTurns;
	private int points;
	Activity activity;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		remainTurns = 50;
		activity = getActivity();
		//Inflate the layout
		view = inflater.inflate(R.layout.card_show,container, false);
		//Saving the layout roots view to disable it further
		rootLayout = (LinearLayout) view.findViewById(R.id.scrollViewCards);
		//Instance two Decks of cards, every one with an array of numbers
		CardDeck deck1 = new CardDeck(12);
		CardDeck deck2 = new CardDeck(12);
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

		ArrayList<FlipImageView> mFlipImageView = new ArrayList<FlipImageView>();
		mFlipImageView.add((FlipImageView) view.findViewById(R.id.iv01));
		mFlipImageView.add(	  (FlipImageView) view.findViewById(R.id.iv02));
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
		refreshPoints(false, false);





		return view;
	}
	public void flipBack(){
		firstpressed.setFlipped(false);
		lastpressed.setFlipped(false);
		pressed = 0;
	}
	public void refreshPoints(boolean point, boolean turns){
		if(turns){
		remainTurns--;
		elapsedTurns++;
		}
		if(point)
			points+=2;
		((GameActivity) activity).refreshPuntuation(remainTurns, elapsedTurns, points);

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