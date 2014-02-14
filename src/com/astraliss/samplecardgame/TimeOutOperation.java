package com.astraliss.samplecardgame;

import android.os.AsyncTask;

class GoToSleep extends AsyncTask<String, Void, Void>{

	public CardShowFragment activity;
	String param;
    public GoToSleep(CardShowFragment a)
    {
        this.activity = a;
    }
    @Override
    protected Void doInBackground(String... params) {
    	param = params[0];
    	if(params[0] == ""){
        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
    	}else{
    		
    	}
    	return null;
    }

    @Override
    protected void onPostExecute(Void result) {
    	if(param == "")
    	activity.flipBack();
    	
        super.onPostExecute(result);
    }
}