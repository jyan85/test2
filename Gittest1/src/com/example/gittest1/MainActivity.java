package com.example.gittest1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends Activity
	{
	private Button mButton1;
	private Button mButtonAddPic;
	private EditText Question;
	private EditText AnswerA;
	private EditText AnswerB; // need to dynamically generater this later
	private LinearLayout layout;
	private LinearLayout.LayoutParams layoutParams;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// setContentView(R.layout.activity_main);
		LayoutParams params =
				new LinearLayout.LayoutParams(
						LayoutParams.MATCH_PARENT,
						LayoutParams.WRAP_CONTENT);
		// Layout Params for Layout which holds the Views:
		// specific to linearlayouts
		layoutParams =
				new LinearLayout.LayoutParams(
						LayoutParams.MATCH_PARENT,
						LayoutParams.WRAP_CONTENT);
		
		layout = new LinearLayout(this);
		layout.setOrientation(LinearLayout.VERTICAL);
		
		// change to dynamic later;
		Question = new EditText(this);
		Question.setHint(R.string.advise_question);
		Question.setLayoutParams(params);
		layout.addView(Question);
		
		AnswerA = new EditText(this);
		AnswerA.setHint(R.string.advise_answer);
		AnswerA.setLayoutParams(params);
		layout.addView(AnswerA);
		
		AnswerB = new EditText(this);
		AnswerB.setHint(R.string.advise_answer);
		AnswerB.setLayoutParams(params);
		layout.addView(AnswerB);
		
		mButton1 = new Button(this); // links field with button in layout
		mButton1.setText(R.string.but_Submit);
	    mButton1.setOnClickListener(new Button_Event()); // new click listener activated (new event)
	    mButton1.setLayoutParams(params);
	    layout.addView(mButton1);
	    
	    mButtonAddPic = new Button(this);
	    mButtonAddPic.setText(R.string.Add_Picture);
	    mButtonAddPic.setOnClickListener(new Button_Event());
	    mButtonAddPic.setLayoutParams(params);
	    layout.addView(mButtonAddPic);
	    
	    this.addContentView(layout, layoutParams);
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
		  if(v==mButtonAddPic)
		  {
			  Toast.makeText(getBaseContext(), "Clicked",
					 Toast.LENGTH_SHORT).show();
//			  layout.addView(AnswerB);
//			  Context d = getBaseContext()
//			  d.addContentView(layout, layoutParams);
		  }
	  }  
	}
		// What happens when you click on send    
	public void bufferMessage() {
		// create an intent to start an activity called DisplayMessageActivity
		Intent submit = new Intent(this, DisplayMessageActivity.class);
		// copies EditText object from inputs
		// EditText usertextQ = (EditText) findViewById(R.id.textQuestion);
		EditText usertextQ = Question;
		EditText usertextA_choiceA = AnswerA;
		EditText usertextA_choiceB = AnswerB;
		// convert text in EditText object to String
		String textQuestion = usertextQ.getText().toString();
		// add some int to Bundle
		Bundle newQuipo = new Bundle();
		newQuipo.putString("textA_choiceA", usertextA_choiceA.getText().toString());
		newQuipo.putString("textA_choiceB", usertextA_choiceB.getText().toString());
		int line_length = 10;
		// Put User inputed String into Bundle
		newQuipo.putString("textQ", textQuestion);
		// put the int into bundle
		newQuipo.putInt("length", line_length);
		// add Extras to the intent
		submit.putExtras(newQuipo);
		startActivity(submit);
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}}


