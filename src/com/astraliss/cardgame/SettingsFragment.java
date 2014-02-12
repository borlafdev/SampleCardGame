package com.astraliss.cardgame;

import android.os.Bundle;
import android.support.v4.preference.PreferenceFragment;
import android.support.v4.preferencefragment.*;


public class SettingsFragment extends PreferenceFragment {

 @Override
 public void onCreate(Bundle savedInstanceState) {
  // TODO Auto-generated method stub
  super.onCreate(savedInstanceState);
  
  // Load the preferences from an XML resource
        addPreferencesFromResource(R.xml.preferences);
 }
 
}