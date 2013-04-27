package com.example.gittest1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity
		{
	// private GestureLibrary gestureLib;
	// private static final String DEBUG_TAG = "Gestures";
	public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE"; // Must be added to pass
    private Button mButton1;
    //	private GestureDetector gestureDetector;
	// View.OnTouchListener gestureListener;																	//	an intent into a new activity (key to the EXTRAS0
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
//		// Used for setting listeners to layout buttons etc
		// Future slide-submit will need a new object that incorporates EditText and Slider
//		 mEditText1 = (EditText) findViewById(R.id.editText1);
		// alternative to android.onClick="" in the layout xml. Good for keeping track of actions
	    mButton1 = (Button) findViewById(R.id.submit_context); // links field with button in layout
	    mButton1.setOnClickListener(new Button_Event()); // new click listener activated (new event)
	}
class Button_Event implements Button.OnClickListener
	{
	// change onClick activity to do bufferMessage
	  public void onClick(View v) 
	  {
		  if(v==mButton1)
	       {
	            bufferMessage(); 
	       }  
	  }  
	}
//	        //
//		gestureDetector = new GestureDetector(this, new MyGestureDetector());
//        gestureListener = new View.OnTouchListener() {
//            public boolean onTouch(View v, MotionEvent event) {
//                return gestureDetector.onTouchEvent(event);
//            }
//        };
//		GestureOverlayView gestureOverlayView = new GestureOverlayView(this);
//	    View inflate = getLayoutInflater().inflate(R.layout.activity_main, null);
//	    gestureOverlayView.addView(inflate);
//	    gestureOverlayView.addOnGesturePerformedListener(this);
//	    gestureLib = GestureLibraries.fromRawResource(this, R.raw.gestures);
//	    if (!gestureLib.load()) {
//	      finish();
//	    }
//	    setContentView(gestureOverlayView);
		    
	
	public void bufferMessage() {
		// create an intent to start an activity called DisplayMessageActivity
		Intent submit = new Intent(this, DisplayMessageActivity.class);
		// copies EditText object from inputs
		EditText usertextQ = (EditText) findViewById(R.id.textQuestion);
		EditText usertextA_choiceA = (EditText) findViewById(R.id.answer_a);
		EditText usertextA_choiceB = (EditText) findViewById(R.id.answer_b);
		// convert text in EditText object to String
		String textQuestion = usertextQ.getText().toString();
		// create a key for Bundle of text string
//		String textQ = new String();
		// add some int to Bundle
		Bundle newQuipo = new Bundle();
		
		newQuipo.putString("textA_choiceA", usertextA_choiceA.getText().toString());
		newQuipo.putString("textA_choiceB", usertextA_choiceB.getText().toString());
		int line_length = 10;
		// key for int to Bundle
//		String length = new String();
		// instance new Bundle
		
		// Put User inputed String into Bundle
		newQuipo.putString("textQ", textQuestion);
		// put the int into bundle
		newQuipo.putInt("length", line_length);
		// add Extras to the intent
//		submit.putExtra(EXTRA_MESSAGE, newQuipo);
		submit.putExtras(newQuipo);
		// start new activity with submitted intent
		startActivity(submit);
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

//class MyGestureDetector extends SimpleOnGestureListener
//{
//		@Override
//		public boolean onDoubleTap(MotionEvent e) {
//			bufferMessage();
//			return true;
//		}
//}
}


