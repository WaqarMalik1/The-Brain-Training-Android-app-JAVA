package com.example.thebraintraining;

import android.app.Activity;		//required imports
import android.os.Bundle;			//required imports
import android.widget.TextView;		//required imports

public class scoredisplay extends Activity {		//method for score display

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {	
		super.onCreate(savedInstanceState);
		setContentView(R.layout.scoredisplay);				//displays score content
		
		
		TextView score = (TextView) findViewById(R.id.DisplayScore);	//finds the text view for score

		score.setText(String.valueOf(Game.score));				// displays score
		
}
}

