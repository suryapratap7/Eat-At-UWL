package suhan.restaurants;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class EditProductActivity extends Activity {

	EditText txtName;
	EditText txtPrice;
	EditText txtDesc;
	EditText txtCreatedAt;
	Button btnSave;
	Button btnDelete;
	Button call;
	String pid,cal;
ImageView img1;
	// Progress Dialog
	private ProgressDialog pDialog;

	// JSON parser class
	JSONParser jsonParser = new JSONParser();

	// single product url
	private static final String url_product_detials = "http://desirecharge.in/suhan/universitydetails.php";

	URL imageURL = null;
	// JSON Node names
	private static final String TAG_SUCCESS = "success";
	private static final String TAG_PRODUCT = "product";
	private static final String TAG_PID = "pid";
	private static final String TAG_NAME = "name";
	private static final String TAG_OFFERS="offers";
	private static final String TAG_DESCRIPTION = "facilities";
	private static final String TAG_PHONE = "phone";
	private static final String TAG_ADDRESS = "address";
	private static final String TAG_PICTURE = "picture";
	
	String imageLocation;
	Bitmap bitmap;
	String ph;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.edit_product);



		// getting product details from intent
		Intent i = getIntent();
		
		// getting product id (pid) from intent
		pid = i.getStringExtra(TAG_PID);

		// Getting complete product details in background thread
		new GetProductDetails().execute();

		// Create button
		call = (Button) findViewById(R.id.button1);
		
		// button click event
		

	}

	/**
	 * Background Async Task to Get complete product details
	 * */
	class GetProductDetails extends AsyncTask<String, String, String> {

		/**
		 * Before starting background thread Show Progress Dialog
		 * */
		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			pDialog = new ProgressDialog(EditProductActivity.this);
			pDialog.setMessage("Loading product details. Please wait...");
			pDialog.setIndeterminate(false);
			pDialog.setCancelable(true);
			pDialog.show();
		}

		/**
		 * Getting product details in background thread
		 * */
		protected String doInBackground(String... params) {

			// updating UI from Background Thread
			runOnUiThread(new Runnable() {
				public void run() {
					// Check for success tag
					int success;
					try {
						// Building Parameters
						List<NameValuePair> params = new ArrayList<NameValuePair>();
						params.add(new BasicNameValuePair("pid", pid));

						// getting product details by making HTTP request
						// Note that product details url will use GET request
						JSONObject json = jsonParser.makeHttpRequest(
								url_product_detials, "GET", params);

						// check your log for json response
						Log.d("Single Product Details", json.toString());
						
						// json success tag
						success = json.getInt(TAG_SUCCESS);
						if (success == 1) {
							// successfully received product details
							JSONArray productObj = json
									.getJSONArray(TAG_PRODUCT); // JSON Array
							
							// get first product object from JSON Array
							JSONObject product = productObj.getJSONObject(0);
						
							// product with this pid found
							// Edit Text
							final TextView num=(TextView)findViewById(R.id.textView5);
						
							TextView res=(TextView)findViewById(R.id.textView1);
							txtName=(EditText) findViewById(R.id.inputName);
							
							txtPrice = (EditText) findViewById(R.id.inputPrice);
							
							txtDesc = (EditText) findViewById(R.id.inputDesc);
							
							txtName.setKeyListener(null);
							
							
							txtPrice.setKeyListener(null);
							txtPrice.setEnabled(false);
							
							txtDesc.setKeyListener(null);
							
							
							
							
							 num.setText(product.getString(TAG_PHONE));
						
						
							 res.setText(product.getString(TAG_NAME));
						 txtName.setText(product.getString(TAG_OFFERS));
							txtPrice.setText(product.getString(TAG_DESCRIPTION));
							txtDesc.setText(product.getString(TAG_ADDRESS));
							
							 call=(Button)findViewById(R.id.button1);
							call.setOnClickListener(new OnClickListener() {

								@Override
								public void onClick(View v) {
									try {
										// set the data
										String uri = "tel:"+num.getText().toString();
										Intent callIntent = new Intent(Intent.ACTION_CALL, Uri.parse(uri));
										
										startActivity(callIntent);
									}catch(Exception e) {
										Toast.makeText(getApplicationContext(),"Your call has failed...",
											Toast.LENGTH_LONG).show();
										e.printStackTrace();
									}
								}
							});
						}else{
							// product with pid not found
						}
					} catch (JSONException e) {
						e.printStackTrace();
					}
				}
			});

			return null;
		}


		/**
		 * After completing background task Dismiss the progress dialog
		 * **/
		protected void onPostExecute(String file_url) {
			// dismiss the dialog once got all details
			pDialog.dismiss();
		}
	}

	
}
	