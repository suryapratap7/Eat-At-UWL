package suhan.restaurants;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class SubAdminDetails1 extends Activity{
	String email;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.subadmindetails1);
	Intent i = getIntent();
		   email = i.getStringExtra("text");
		   TextView productTitleTextView = (TextView) findViewById(R.id.textView2);
		   productTitleTextView.setText(email);
		   
			
	
		 Button button=(Button)findViewById(R.id.button1);
	      button.setOnClickListener(new OnClickListener() {
		
			     @Override
			     public void onClick(View v) {
			    	
			    	 Intent first = new Intent(SubAdminDetails1.this, DetailsSubadmin.class);
			    	
						first.putExtra("email", email);
			     startActivity(first);
			     }
	});
	}
	
}
