package suhan.restaurants;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Registration extends Activity {
	  EditText first,second,third,fourth,fifth,sixth;
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration);
     first=(EditText)findViewById(R.id.editText1);
      second=(EditText)findViewById(R.id.editText2);
      third=(EditText)findViewById(R.id.editText3);
   
      fifth=(EditText)findViewById(R.id.editText5);
      sixth=(EditText)findViewById(R.id.editText6);
      
      Button button=(Button)findViewById(R.id.button1);
      button.setOnClickListener(new OnClickListener() {
			   
		     @Override
		     public void onClick(View v) {
		    		String text = first.getText().toString();
		    		String text1 = second.getText().toString();
		    		String text2 = third.getText().toString();
		    		String text3 = fourth.getText().toString();
		    		String text4 = fifth.getText().toString();
		    		String text5 = sixth.getText().toString();
		    		
		    	 Intent signup=new Intent(Registration.this, Dregistration.class);
		    	 signup.putExtra("text", text);
		    	 signup.putExtra("text1", text1);
		    	 signup.putExtra("text2", text2);
		    	 signup.putExtra("text3", text3);
		    	 signup.putExtra("text4", text4);
		    	 signup.putExtra("text5", text5);
			    	startActivity(signup);
		     }
		 });
		 
	}
}
