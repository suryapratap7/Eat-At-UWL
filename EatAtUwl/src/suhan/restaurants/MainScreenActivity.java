package suhan.restaurants;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainScreenActivity extends Activity {
	Button first, second, third, forth;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_screen);
		first=(Button)findViewById(R.id.button1);
		second=(Button)findViewById(R.id.button2);
		third=(Button)findViewById(R.id.button3);
		forth=(Button)findViewById(R.id.button4);
		
		 first.setOnClickListener(new OnClickListener() {
			   
		     @Override
		     public void onClick(View v) {
		    	 Intent first = new Intent(MainScreenActivity.this, AllProductsActivity.class);
		           
		           startActivity(first);
		     }
		 });
		 second.setOnClickListener(new OnClickListener() {
			   
		     @Override
		     public void onClick(View v) {
		    	 Intent first = new Intent(MainScreenActivity.this, AllProductsActivity1.class);
		           
		           startActivity(first);
		     }
		 });
		 third.setOnClickListener(new OnClickListener() {
			   
		     @Override
		     public void onClick(View v) {
	    	 Intent login = new Intent(MainScreenActivity.this, Third.class);
		           
		          startActivity(login);
		     }
		 });
		 forth.setOnClickListener(new OnClickListener() {
			   
		     @Override
		     public void onClick(View v) {
	    	 Intent help = new Intent(MainScreenActivity.this, Fourth.class);
		           
		           startActivity(help);
		     }
		 });
		 
	}

}
