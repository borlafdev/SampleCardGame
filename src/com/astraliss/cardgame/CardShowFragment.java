package com.astraliss.cardgame;


import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;

public class CardShowFragment extends Fragment {
  
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
	  final View view = inflater.inflate(R.layout.card_show,container, false);
    
    

     return view;
  }
  
  

  
} 