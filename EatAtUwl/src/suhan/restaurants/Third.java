package suhan.restaurants;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Third extends Activity {
Button first, second;
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      setContentView(R.layout.third);
        first=(Button)findViewById(R.id.button1);
        second=(Button)findViewById(R.id.button2);
       first.setOnClickListener(new OnClickListener() {
			   
		     @Override
		     public void onClick(View v) {
	    	 Intent third = new Intent(Third.this, Owner.class);
		           
		          startActivity(third);
		     }
		 });
        second.setOnClickListener(new OnClickListener() {
			   
		     @Override
		     public void onClick(View v) {
	    	 Intent fourth = new Intent(Third.this, SubAdmin.class);
		           
		           startActivity(fourth);
		           
		     }
		 });
		 
		 
}
}