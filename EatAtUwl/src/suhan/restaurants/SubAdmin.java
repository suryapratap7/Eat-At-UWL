package suhan.restaurants;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class SubAdmin extends Activity {
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sublogin);
      Button first=(Button)findViewById(R.id.button1);
      
      Button second=(Button)findViewById(R.id.button2);
      first.setOnClickListener(new OnClickListener() {
			   
		     @Override
		     public void onClick(View v) {
		    	 EditText et = (EditText) findViewById(R.id.editText1);
		    	 EditText et1 = (EditText) findViewById(R.id.editText2);
		    	 String theText = et.getText().toString();
					String theText1 = et1.getText().toString();
		    	 Intent signup=new Intent(SubAdmin.this, SubAdminDetails.class);
		    		signup.putExtra("text", theText);
		    		signup.putExtra("text1", theText1);
			    	startActivity(signup);
		     }
		 });
      second.setOnClickListener(new OnClickListener() {
		   
		     @Override
		     public void onClick(View v) {
		    	Intent signup=new Intent(SubAdmin.this, Dregistration.class);
		    	startActivity(signup);
		     }
		 });
	}
	
}
