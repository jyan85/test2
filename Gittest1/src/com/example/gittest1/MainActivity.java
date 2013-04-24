package com.example.gittest1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.MotionEventCompat;
import android.util.Log;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {
	public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE"; // Must be added to pass
																				//	an intent into a new activity (key to the EXTRAS0
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	public void bufferMessage(View view) {
		// create an intent to start an activity called DisplayMessageActivity
		Intent submit = new Intent(this, DisplayMessageActivity.class);
		// get the EditText object from the android:id of the user inputed text
		EditText usertextQ = (EditText) findViewById(R.id.textQuestion);
		// convert text in EditText object to String
		String textQuestion = usertextQ.getText().toString();
		// create a key for Bundle of text string
//		String textQ = new String();
		// add some int to Bundle
		int line_length = 10;
		// key for int to Bundle
//		String length = new String();
		// instance new Bundle
		Bundle newQuipo = new Bundle();
		// Put User inputed String into Bundle
		newQuipo.putString("textQ", textQuestion);
		// put the int into bundle
		newQuipo.putInt("length", line_length);
		// add Extras to the intent
		submit.putExtra(EXTRA_MESSAGE, newQuipo);
		// start new activity with submitted intent
		startActivity(submit);
	}
	
	public boolean onTouchEvent(MotionEvent event, String DEBUG_TAG){ 
        
	    int action = MotionEventCompat.getActionMasked(event);
	        
	    switch(action) {
	        case (MotionEvent.ACTION_DOWN) :
	            Log.d(DEBUG_TAG,"Action was DOWN");
	            return true;
	        case (MotionEvent.ACTION_MOVE) :
	            Log.d(DEBUG_TAG,"Action was MOVE");
	            return true;
	        case (MotionEvent.ACTION_UP) :
	            Log.d(DEBUG_TAG,"Action was UP");
	            return true;
	        case (MotionEvent.ACTION_CANCEL) :
	            Log.d(DEBUG_TAG,"Action was CANCEL");
	            return true;
	        case (MotionEvent.ACTION_OUTSIDE) :
	            Log.d(DEBUG_TAG,"Movement occurred outside bounds " +
	                    "of current screen element");
	            return true;      
	        default : 
	            return super.onTouchEvent(event);
	    }      
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
