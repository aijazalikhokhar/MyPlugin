package com.example.myplugin;
 
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;
import android.app.Activity;
import android.content.Intent;
import android.widget.Toast;
public class TestToast extends CordovaPlugin {
	public static final String SHOW_TOAST = "showToast"; 

	@Override
	public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
		try {
				if (SHOW_TOAST.equals(action)) { 
						 JSONObject arg_object = args.getJSONObject(0);
						 Intent calIntent = new Intent(Intent.ACTION_EDIT)
					.setType("vnd.android.cursor.item/event")
					.putExtra("Msg", arg_object.getString("Msg"));
					Toast.makeText(getApplication(), "msg", 1).show();
				   this.cordova.getActivity().startActivity(calIntent);
				   callbackContext.success();
				   return true;
				}
				callbackContext.error("Invalid action");
				return false;
			} catch(Exception e) {
				System.err.println("Exception: " + e.getMessage());
				callbackContext.error(e.getMessage());
				return false;
			}//end catch 
	}//end execute method
}//end class