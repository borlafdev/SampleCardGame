package com.astraliss.samplecardgame;


import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class EndGameFragment extends Fragment{
  
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
	  final View view;
	  if(((GameActivity) getActivity()).getResult()){
	  view = inflater.inflate(R.layout.win ,container, false);
	  }else{
	  view = inflater.inflate(R.layout.loss ,container, false);
	  }


     return view;
  }
  
  
} 