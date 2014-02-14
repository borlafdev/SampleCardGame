package com.astraliss.samplecardgame;


import android.content.Intent;
import android.graphics.Typeface;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

public class CreditsFragment extends Fragment implements OnClickListener {
  
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
	  final View view = inflater.inflate(R.layout.credits_show,container, false);
	  TextView twitter = (TextView) view.findViewById(R.id.tvtwitter);
	  TextView git = (TextView) view.findViewById(R.id.tvgithub);
	  TextView web = (TextView) view.findViewById(R.id.tvweb);
	  TextView credit = (TextView) view.findViewById(R.id.credits2);
	  credit.setText(Html.fromHtml("&#8226; FlipImageView<br/>"));
	  git.setOnClickListener(this);
	  twitter.setOnClickListener(this);
	  web.setOnClickListener(this);
	  Typeface font = Typeface.createFromAsset(getActivity().getAssets(), "fonts/fontawesome-webfont.ttf");
	  git.setTypeface(font);
	  twitter.setTypeface(font);
	  web.setTypeface(font);
	  git.setTextSize(70);
	  web.setTextSize(70);
	  twitter.setTextSize(70);
    

     return view;
  }
  
	@Override
	public void onClick(View v) {
	Intent browserIntent;
		if(v.getId() == R.id.tvgithub ){
			browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.github.com/borlafdev"));
			startActivity(browserIntent);
		}else if(v.getId() == R.id.tvtwitter ){
			browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.twitter.com/borlafdev"));
			startActivity(browserIntent);
		}else if(v.getId() == R.id.tvweb ){
			browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.borlafdev.com"));
			startActivity(browserIntent);
		}
			
		
	}

  
} 