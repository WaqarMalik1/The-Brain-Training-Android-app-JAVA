package com.example.thebraintraining;

import android.os.Bundle; //required import
import android.app.Activity; //required import
import android.view.Menu;	//required import	
import android.content.Intent;	//required import
import android.view.View;	//required import
import android.view.View.OnClickListener;	//required import
import android.app.AlertDialog;	//required import
import android.content.DialogInterface;	//required import
import android.util.Log;	//required import

public class Brainactivity extends Activity implements OnClickListener { //This implements for on click listener
	static int difficulty;	//static variable for difficulty
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_brainactivity);

		View continueButton = findViewById(R.id.continue_button);	//displays continue
		continueButton.setOnClickListener(this);		//on click for the continue button
		View newButton = findViewById(R.id.new_button);	//new button
		newButton.setOnClickListener(this);				// on click listener for this button
		View aboutButton = findViewById(R.id.about_button);	// displays about button
		aboutButton.setOnClickListener(this);			// on click listener for this 
		View exitButton = findViewById(R.id.exit_button); // exit button
		exitButton.setOnClickListener(this);		// exits application 
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) { //implements menu
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.brainactivity, menu); // displays menu
		return true; //returns
	}


	public void onClick(View v) {  						//This is a method to get the about button on click listener
		switch (v.getId()) {							//switch statement
		case R.id.about_button:							// case id about button
			Intent i = new Intent(this, About.class);	// calls it from about class
			startActivity(i);							//starts activity
			break;										//break
		case R.id.exit_button:							//exit  button	
			finish();									// finishes the app
			break;										//break
		case R.id.new_button:							//new game button
			openNewGameDialog();						//opens the game dialog
			break;										// break

			// More buttons go here (if any) ...
		}
	}

	private static final String TAG = "BrainGame" ;			//the game name
	private void openNewGameDialog() {						//opens new game 
		new AlertDialog.Builder(this)						// alert dialog builder
		.setTitle(R.string.new_game_title)					// gets string from new game
		.setItems(R.array.difficulty,						// sets items array difficulty
				new DialogInterface.OnClickListener() {		// onclick listener
			public void onClick(DialogInterface				//onclick listener
					dialoginterface, int i) {				// dialog with the variable name
				startGame(i);								// starts game with i varible
			}
		})
		.show();										// shows starts
	}
	private void startGame(int i) {					// method for to start game

		Log.d(TAG, "clicked on " + i);				// when clicked plus I
		
		switch (i){								// switch statement for I
		
		case 0:																// case 0 for novice
			Intent intent = new Intent(Brainactivity.this, Game.class);		//gets novice from game class
			startActivity(intent);											//starts activity novice
			difficulty =0;													// novice class case 0
			break;															//break
			
		case 1:																// case 1 for easy
			Intent easy = new Intent(Brainactivity.this, Game.class);		//gets easy from game class
			startActivity(easy);											//starts activity easy
			difficulty =1;													//easy class case 1
			break;															//break
			
		case 2:																// case 2 for medium
			Intent medium = new Intent(Brainactivity.this, Game.class);		//gets medium from game class
			startActivity(medium);											//starts activity medium
			difficulty =2;													//medium class case 2
			break;															//Break													
		
		case 3:																// case 3 for novice
			Intent guru = new Intent(Brainactivity.this, Game.class);		//gets guru from game class
			startActivity(guru);											// starts activity guru							
			difficulty =3;													// guru class case 3
			break;															// break
		}
	}
	}
