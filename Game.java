package com.example.thebraintraining;

// all the required imports

import android.app.Activity; 
//import android.app.Dialog;
import android.content.Intent; 
import android.graphics.Color;
//import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.os.CountDownTimer;
//import android.util.Log;
//import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
//import android.widget.Toast;
import android.widget.TextView;
import java.util.Random;


public class Game extends Activity{

	public static final String KEY_DIFFICULTY ="com.example.thebraintraining.difficulty" ;

	
	int Total; // Puts total answer in here
	Random random1 = new Random(); //Generates random
	int number1 = random1.nextInt(10); // gets a random number from 10 numbers for variable number1 
	int number2 = random1.nextInt(10);  // gets a random number from 10 numbers for variable number2
	int number3 = random1.nextInt(60); // gets a random number from 60 numbers for variable number3
	int number4 = random1.nextInt(60);  // gets a random number from 60 numbers for variable number4
	int number5 = random1.nextInt(90); // gets a random number from 90 numbers for variable number5
	int number6 = random1.nextInt(90); // gets a random number from 90 numbers for variable number6
	
	int selectnumber = random1.nextInt(4); // 4 signs declared
	CountDownTimer time; // This extends the object
	static Button Hash; // static button declared
	TextView timing; // timimg
	static int score; // variable for score
	int counterforscore =0; // variable to count score

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		time(); //time in the hash



		setContentView(R.layout.mainscreen);

		Hash = (Button)findViewById(R.id.hash); //Hash button
		Hash.setOnClickListener(new OnClickListener(){ //Hash onclick listener method

			public void onClick(View A){ //method

				time.cancel(); //methods for time cancel
				time(); // time method
				Random ran = new Random(); //Generates random
				number1= ran.nextInt(10); // gets a random number from 10 numbers for variable number1 
				number2= ran.nextInt(10); // gets a random number from 10 numbers for variable number2 
				number3= ran.nextInt(60); // gets a random number from 60 numbers for variable number3 
				number4= ran.nextInt(60); // gets a random number from 60 numbers for variable number4 
				number5= ran.nextInt(90); // gets a random number from 90 numbers for variable number5
				number6= ran.nextInt(90); // gets a random number from 90 numbers for variable number6 
				
				char[]operator = {'+','-','/','*'}; // declared 4 operators
				char operationsrandom = operator[new Random().nextInt(4)]; // gets randomly operators 
				TextView question = (TextView) findViewById(R.id.question_label); //puts questions in here
				TextView abc = (TextView) findViewById(R.id.questionanswers); // displays question mark and user puts answer in here
				TextView comparingfield = (TextView) findViewById(R.id.incorrectorcorrect); //comparing field puts incorrect here

				String compvalue1 = abc.getText().toString();  //compares the value to string
				String compvalue2 = Integer.toString(Total); // compares value to to integer string total

				if (compvalue1.equals(compvalue2)){ //if statement compares value1 to value2
					comparingfield.setText("CORRECT!");	 //displays correct
					timing = (TextView)findViewById(R.id.timertxtfield); //Puts the timer in here
					String scoringdispaly = timing.getText().toString(); // string scoring display gets timing
					int scoring = Integer.parseInt(scoringdispaly); //puts score here and displays it
					score = score + 100 / 10 - scoring; // the score method for the CW
					
					abc.setText("?"); // displays a question mark when user presses key the question mark clears 
					comparingfield.setTextColor(Color.GREEN); //sets the text colour to green

				}
				else //declaring a else statement for when answer is wrong
				{
					comparingfield.setText("WRONG!"); //displays wrong	
					abc.setText("?"); // displays a question mark when user presses key the question mark clears 	
					comparingfield.setTextColor(Color.RED); //puts the text in green

				}
				
				
				counterforscore ++; // counter for score
				if (counterforscore == 10){ // if statement for if counterforscore ==10 does 10 questions 
				getingthescore(); //getting the score method
				}

				if (Brainactivity.difficulty == 0){ // this calls difficulty level NOVICE I HAVE DECLARED IT AS SWITICH 0 this is getting it from brainactivity.java
					
					operationsrandom = operator[new Random().nextInt(4)]; //selects random operators from 4 expressions
					switch(operationsrandom)  //switch statement
					
					{

					case '+': // do addition 
						Total = number1 + number2; //does the total for random number 1 and random number 2 the both numbers are random takes away
						question.setText(String.valueOf(number1+" " + "+" +" "+number2+" =")); //puts the answer in here and displays the questions with the both random numbers						
						break;  //break

					case '-': // does minus
						Total = number1 - number2; //does the total for random number 1 and random number 2 the both numbers are random takes away
						question.setText(String.valueOf(number1+" " + "-" +" "+number2+" =")); //puts the answer in here and displays the questions with the both random numbers
						break;  //break

					case '/': //does division
						if(number1 == 0||number2==0){ //this is a if statement for when 2 numbers divide so the dont equal 0 adds 1 to random number
							number1=number1+(1); //add 1 to this random number
							number2=number2+(1);} // add1 to random number 2
						Total = number1 / number2; //does the division
						question.setText(String.valueOf(number1+" " + "/" +" "+number2+" =")); //puts the answer in here and displays the questions with the both random number
						break; //beak


					case '*': //this does multiplication
						Total = number1 * number2; //multiply random number 1 by random number 2
						question.setText(String.valueOf(number1+" " + "*" +" "+number2+" =")); //puts the answer in here and displays the questions with the both random number
						break; //break

					}
					}
				
				if (Brainactivity.difficulty == 1) { // this calls difficulty level EASY I HAVE DECLARED IT AS SWITICH 1 this is getting it from brainactivity.java
						
					switch(operationsrandom ){ //Switch statement

					case '+': // do addition 
						Total = number1 + number2 - number4 ; //plus random number 1 by random number 2 and minus random number 4
						question.setText(String.valueOf(number1 + "+" + number2 + "-" + number4 + "=")); //displays all random numbers with required expressions random
						break; //break

					case '-': //do take away
						Total = number1 - number2 * number3 ; //plus random number 1 by random number 2 and minus random number 3
						question.setText(String.valueOf(number1 + "-" + number2 + "-"  + number3 + "=")); //displays all random numbers with required expressions random
						break; //break

					case '/': // do revision
						if(number1 == 0||number2==0){ //if statement for random number 1 and number 2 if equals to 0 plus 1
						number1=number1+(1);  //adds 1 to number1 if 0
						number2=number2+(1);}	// adds 1 to number2 
						Total = number1 / number2; // two random numbers dividing
						question.setText(String.valueOf(number1 + "/" +number2 + "=")); //displays question with 2 random numbers
						break; //break

					case '*': // does multiplication
						Total = number1 * number2; //multiply the 2 random numbers
						question.setText(String.valueOf(number1 + "*" + number2 + "=")); // displays the question with the 2 random numbers randomly
						break; //break
					}
					}

				

				if (Brainactivity.difficulty == 2) { //this is calling difficulty level medium from brainactivity.java this is Switch case 2

					switch(operationsrandom){ // switch statement

					case '+': // do addition 
						Total = number1 + number2 / number3; // gets random number1 adds it to random number2 and then divides random number3
						question.setText(String.valueOf(number1 + "+" + number2 + "/" + number3 + "=")); //displays the question with the random numbers
						break; //break

					case '-': // do minus 
						if(number1 == 0||number2==0){ //if statement for random number 1 and number 2 if equals to 0 plus 1
							number1=number1+(1);	//adds 1 to number1 if 0
							number2=number2+(1);}	//adds 1 to number2 if 0
						Total = number1 / number2 * number3 + number4; // doing a expression to all the random numbers declared
						question.setText(String.valueOf(number1+"/"+number2+ "*" + number3+ "+" + number4+ "=")); //displays the question with the random numbers
						break; //break

					case '/': // do divide
						if(number1 == 0||number2==0){ //if statement for random number 1 and number 2 if equals to 0 plus 1
							number1=number1+(1); //adds 1 to number1 if 0
							number2=number2+(1);} //adds 1 to number2 if 0
						Total = number1 / number2; //Doing division for random number1 and random number2
						question.setText(String.valueOf(number1+"/"+number2+" =")); //displays the questions
						break; //break

					case '*': // do multiplication 
						Total = number3 * number2 - number1 ; // getting number3 number2 number1 randomly doing required expression
						question.setText(String.valueOf( number3 + "*" +number2 + "-" + number1 + "=")); //displays the question
						break;	//break 	

				}
				}
				
				if (Brainactivity.difficulty == 3) { //this is calling difficulty level Guru from brainactivity.java this is Switch case 3

					switch(operationsrandom){ // Switch statement

					case '+': // do addition 
						Total = number1 + number2 * number5 - number4; // getting number1 number2 number5 number4 randomly doing required expression
						question.setText(String.valueOf(number1 + "+" +number2 + "*" + number5 + "-" + number4 + "=")); //displays the question
						break; //break

					case '-': // do minus 
						if(number1 == 0||number2==0){ //if statement for random number 1 and number 2 if equals to 0 plus 1
							number1=number1+(1); //adds 1 to random number 1
							number2=number2+(1);} //adds 1 to random number2
						Total = number1 / number2 * number6 + number5 * number4; // getting number1 number2 number6 number5 number4 randomly and doing required expression
						question.setText(String.valueOf(number1 + "/" + number2 + "*" + number6 + "+" + number5 + "*" + number4 + "=")); //displays question
						break; //break

					case '/': // do divide 
						if(number1 == 0||number2==0){ //if statement for random number 1 and number 2 if equals to 0 plus 1
							number1=number1+(1); //adds 1 to random number 1
							number2=number2+(1);} //adds 1 to random number 2
						Total = number1 / number2 * number4 * number5 + number3 - number6; // getting number1 number2 number4 number5 number3 number6 randomly and doing required expression
						question.setText(String.valueOf(number1 + "/" + number2 + "*" + number4 + "*" + number5 + "+" + number3 + "-" + number6 + "=")); //displays the question
						break; //break

					case '*': // do multiply 
						Total = number6 * number5 - number4 + number3 ; // getting number6 number5 number4 number3 randomly and doing required expression
						question.setText(String.valueOf( number6 + "*" + number5 + "-" + number4 + "+" + number3 + "=")); //displays question
						break; //break
					}
					}	
					}
					});
					}

	public void keypad1 (View A)	{ //method declared for keypad1

		TextView abc = (TextView) findViewById(R.id.questionanswers); //finds text and puts it in questionanswers text field
		String text = (String) abc.getText(); // gets the text
		if(text.contains("?")) //if statement if text contains a question mark
			text = text.replace("?", ""); //text will replace 
		abc.setText(text + "1");	} //replacing with 1 when clicked

	public void keypad2 (View A){	//method declared for keypad2

		TextView abc = (TextView) findViewById(R.id.questionanswers); //finds text and puts it in questionanswers text field
		String text = (String) abc.getText(); // gets the text
		if(text.contains("?")) //if statement if text contains a question mark
			text = text.replace("?", ""); //text will replace 
		abc.setText(text + "2");	} //replacing with 2 when clicked

	public void keypad3 (View A){ //method declared for keypad3

		TextView abc = (TextView) findViewById(R.id.questionanswers); //finds text and puts it in questionanswers text field
		String text = (String) abc.getText(); // gets the text
		if(text.contains("?")) //if statement if text contains a question mark
			text = text.replace("?", ""); //text will replace 
		abc.setText(text + "3");	} //replacing with 3 when clicked

	public void keypad4 (View A){ //method declared for keypad4

		TextView abc = (TextView) findViewById(R.id.questionanswers); //finds text and puts it in questionanswers text field
		String text = (String) abc.getText(); // gets the text
		if(text.contains("?")) //if statement if text contains a question mark
			text = text.replace("?", ""); //text will replace 
		abc.setText(text + "4");	} //replacing with 4 when clicked

	public void keypad5 (View A){	//method declared for keypad5
		
		TextView abc = (TextView) findViewById(R.id.questionanswers);	//finds text and puts it in questionanswers text field
		String text = (String) abc.getText(); // gets the text
		if(text.contains("?"))	//if statement if text contains a question mark
			text = text.replace("?", "");	//text will replace 
		abc.setText(text + "5");	}	//replacing with 5 when clicked

	public void keypad6 (View A){	//method declared for keypad6
		
		TextView abc = (TextView) findViewById(R.id.questionanswers);	//finds text and puts it in questionanswers text field
		String text = (String) abc.getText();	// gets the text
		if(text.contains("?"))	//if statement if text contains a question mark
			text = text.replace("?", "");	//text will replace 
		abc.setText(text + "6");	}	//replacing with 6 when clicked

	public void keypad7 (View A){	//method declared for keypad7

		TextView abc = (TextView) findViewById(R.id.questionanswers);	//finds text and puts it in questionanswers text field
		String text = (String) abc.getText();	// gets the text
		if(text.contains("?"))	//if statement if text contains a question mark
			text = text.replace("?", "");	//text will replace 
		abc.setText(text + "7");	}	//replacing with 7 when clicked

	public void keypad8 (View A){	//method declared for keypad8

		TextView abc = (TextView) findViewById(R.id.questionanswers); //finds text and puts it in questionanswers text field
		String text = (String) abc.getText();	// gets the text
		if(text.contains("?"))	//if statement if text contains a question mark
			text = text.replace("?", "");	//text will replace 
		abc.setText(text + "8");	}	//replacing with 8 when clicked

	public void keypad9 (View A){	//method declared for keypad9

		TextView abc = (TextView) findViewById(R.id.questionanswers);	//finds text and puts it in questionanswers text field
		String text = (String) abc.getText(); // gets the text
		if(text.contains("?"))	//if statement if text contains a question mark
			text = text.replace("?", "");	//text will replace 
		abc.setText(text + "9");	}	//replacing with 9 when clicked

	public void keypad0 (View A){	//method declared for keypad0

		TextView abc = (TextView) findViewById(R.id.questionanswers);	//finds text and puts it in questionanswers text field
		String text = (String) abc.getText();	// gets the text
		if(text.contains("?"))	//if statement if text contains a question mark
			text = text.replace("?", "");	//text will replace 
		abc.setText(text + "0");	}	//replacing with 0 when clicked

	public void keypadminus (View A){	//method declared for keypadminus

		TextView abc = (TextView) findViewById(R.id.questionanswers);	//finds text and puts it in questionanswers text field
		String text = (String) abc.getText();	// gets the text
		if(text.contains("?"))	//if statement if text contains a question mark
			text = text.replace("?", "");	//text will replace 
		abc.setText(text + "-");	//replacing with - when clicked
	}

	public void keypaddelete (View A){ // method declared for keypaddelete

		TextView abc = (TextView) findViewById(R.id.questionanswers);	//finds text and puts it in questionanswers text field
		String keypaddelete = (String) abc.getText();	// gets the text
		if (keypaddelete.length() >0 ) { //if statement if value greater then 0
			keypaddelete = keypaddelete.substring(0, keypaddelete.length() - 1); //kepaddelete will -1 when clicked delete a charectar
			abc.setText(keypaddelete);	// will delete charectar when clicked
	}
	}

	public void time (){ //Public timer method

		time = new CountDownTimer(10000, 1000) { //displaying the count down timer  
			Long millisUnitilFinished;		//The amount of time until finished.
		
			public void onTick(long millisUntilFinished) { // method Callback fired on regular interval
				TextView timing = (TextView) findViewById(R.id.timertxtfield); //This where the timer shows
				timing.setText(String.valueOf(millisUntilFinished / 1000)); // this makes sure its 10 seconds
				this.millisUnitilFinished = millisUntilFinished/1000;		} //sets 10 seconds

			public void onFinish() {	// Method Callback fired when the time is up.
				TextView timing = (TextView) findViewById(R.id.timertxtfield); //this is where the timer shows
				double leftover = millisUnitilFinished;		//left over varibale
				timing.setText("10");
				Hash.performClick(); //Performing the onclick for the hash button each time after 10 seconds
		}
		}.start(); //start the countdown timer
		}
	
	public void getingthescore(){ //Method for getting the score
		
		Intent score12 = new Intent(Game.this, scoredisplay.class); //this is in the score class
		startActivity(score12);	 //starts score activity
	}
	}
