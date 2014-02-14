package com.astraliss.samplecardgame;


import android.app.Activity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class MenuFragment extends Fragment implements OnClickListener {
  
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
	  final View view = inflater.inflate(R.layout.activity_main ,container, false);
	  Button btnplay = (Button) view.findViewById(R.id.btnPlay);
	  Button btnsettings = (Button) view.findViewById(R.id.btnSettings);
	  Button btncredits = (Button) view.findViewById(R.id.btnCredits);
	  btnplay.setOnClickListener(this);
	  btnsettings.setOnClickListener(this);
	  btncredits.setOnClickListener(this);
	  
    

     return view;
  }
  
	@Override
	public void onClick(View v) {
	Activity a = getActivity();
		if(v.getId() == R.id.btnPlay )
			((MainActivity) a).changeToFragment(1);
		else if(v.getId() == R.id.btnSettings )
			((MainActivity) a).changeToFragment(2);
		else if(v.getId() == R.id.btnCredits )
			((MainActivity) a).changeToFragment(3);
		
	}

  
} 