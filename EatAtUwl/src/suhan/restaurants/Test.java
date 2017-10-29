package suhan.restaurants;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class Test extends Activity
{ private static final String TAG = "MyFirstApp";

@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    
    // Get the message from the intent
    Intent intent = getIntent();
   String uriString = intent.getStringExtra("text");
  
 
   

    Log.d(TAG, "Got Intent");
    
    // Create the text view
    TextView textView = new TextView(this);
    textView.setTextSize(40);
   
    textView.setText(uriString);

    // Set the text view as the activity layout
    setContentView(textView);
}
}