package suhan.restaurants;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Dregistration extends Activity implements OnClickListener{
	
	EditText first,second,third,fourth,fifth,sixth;
	 // Progress Dialog
   private ProgressDialog pDialog;

   // JSON parser class
   JSONParser jsonParser = new JSONParser();
   
   //php register script
   
   //localhost :  
   //testing on your device
   //put your local ip instead,  on windows, run CMD > ipconfig
   //or in mac's terminal type ifconfig and look for the ip under en0 or en1
  // private static final String REGISTER_URL = "http://xxx.xxx.x.x:1234/webservice/register.php";
   
   //testing on Emulator:
   private static final String REGISTER_URL = "http://desirecharge.in/suhan/signup.php";
   
 //testing from a real server:
   //private static final String REGISTER_URL = "http://www.mybringback.com/webservice/register.php";
   
   //ids
   private static final String TAG_SUCCESS = "success";
   private static final String TAG_MESSAGE = "message";
	private static final String TAG_CATEGORY="category";
	Spinner spinner;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.registration);
		first=(EditText)findViewById(R.id.editText1);
	    second=(EditText)findViewById(R.id.editText2);
	    third=(EditText)findViewById(R.id.editText3);
	  
	    fifth=(EditText)findViewById(R.id.editText5);
	    sixth=(EditText)findViewById(R.id.editText6);
	    spinner = (Spinner) findViewById(R.id.spinner1);
		 ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
		         R.array.category_array, android.R.layout.simple_spinner_item);
		 adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		
		
			 spinner.setAdapter(adapter);
			 
				
	    Button button=(Button)findViewById(R.id.button1);
	    button.setOnClickListener(new OnClickListener() {			
	    	@Override
	    	public void onClick(View v) {
	    		// TODO Auto-generated method stub
			//Check all fields		
					if(first.length()<3)
					{
						Toast.makeText(Dregistration.this,"Please enter required field", Toast.LENGTH_LONG).show();
						return;
					}
					 if(second.length()<7)
					{				
						Toast.makeText(Dregistration.this,"Please enter required field", Toast.LENGTH_LONG).show();
						return;
					}
					 if(third.length()<3)
						{				
							Toast.makeText(Dregistration.this,"Please enter required field", Toast.LENGTH_LONG).show();
							return;
						} 
					
					 if(fifth.length()<9)
						{				
							Toast.makeText(Dregistration.this,"Please enter required field", Toast.LENGTH_LONG).show();
							return;
						}
					 if(sixth.length()<4)
						{				
							Toast.makeText(Dregistration.this,"Please enter required field", Toast.LENGTH_LONG).show();
							return;
						}
			//check connectivity		
					
			
			//from login.java		
					 new CreateUser().execute();
				}
	   
		
			   
	      
	      //Close code that check online details		
		  }); 
	        //Close log in 
	    }
	
	
	class CreateUser extends AsyncTask<String, String, String> {

		
       @Override
       protected void onPreExecute() {
           super.onPreExecute();
           pDialog = new ProgressDialog(Dregistration.this);
           pDialog.setMessage("Creating User...");
           pDialog.setIndeterminate(false);
           pDialog.setCancelable(true);
           pDialog.show();
       }
		
		@Override
		protected String doInBackground(String... args) {
			// TODO Auto-generated method stub
			 // Check for success tag
           int success;
       	String theText2 = spinner.getSelectedItem().toString();
           String username = first.getText().toString();
           String email = second.getText().toString();
           String name = third.getText().toString();
           String phone = fifth.getText().toString();
           String spin= theText2.toString(); 
           String password = sixth.getText().toString();
           try {
               // Building Parameters
               List<NameValuePair> params = new ArrayList<NameValuePair>();
               params.add(new BasicNameValuePair("username", username));
               params.add(new BasicNameValuePair("email", email));
               params.add(new BasicNameValuePair("name", name));
               params.add(new BasicNameValuePair("phone", phone));
               params.add(new BasicNameValuePair("password", password));
               params.add(new BasicNameValuePair(TAG_CATEGORY, spin));
               Log.d("request!", "starting");
               
               //Posting user data to script 
               JSONObject json = jsonParser.makeHttpRequest(
                      REGISTER_URL, "GET", params);

               // full json response
               Log.d("Registering attempt", json.toString());

               // json success element
               success = json.getInt(TAG_SUCCESS);
               if (success == 1) {
               	Log.d("User Created!", json.toString());              	
               	finish();
               	return json.getString(TAG_MESSAGE);
               }else{
               	Log.d("Registering Failure!", json.getString(TAG_MESSAGE));
               	return json.getString(TAG_MESSAGE);
               	
               }
           } catch (JSONException e) {
               e.printStackTrace();
           }

           return null;
			
		}
		
       protected void onPostExecute(String file_url) {
           // dismiss the dialog once product deleted
           pDialog.dismiss();
           if (file_url != null){
           	Toast.makeText(Dregistration.this, file_url, Toast.LENGTH_LONG).show();
           }

       }
		
	}


	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}


	
		
	}
		 


