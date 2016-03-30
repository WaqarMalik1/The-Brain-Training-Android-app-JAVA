package com.example.thebraintraining; //package name

import android.app.Activity; //this is a required import
import android.os.Bundle; //this is a import
public class About extends Activity { //the class about extends activity
@Override
protected void onCreate(Bundle savedInstanceState) { // Protected void method
super.onCreate(savedInstanceState);	 //on create
setContentView(R.layout.about);	//sets the content for about
}
}
