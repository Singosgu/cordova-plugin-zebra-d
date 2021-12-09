package zebra.d;


import com.example.ZebraDLibrary.Statistics;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;

/**
 * This class echoes a string called from JavaScript.
 */
public class ZebraD extends CordovaPlugin {

  Statistics statistics;

  @Override
  public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
    String[] permissions = {
      "com.zebra.provider.READ", "com.symbol.emdk.permission.EMDK"
    };
    cordova.requestPermissions(this, 500, permissions);
    if (action.equals("getSerialNumber")) {
      this.getSerialNumber(callbackContext);
      return true;
    }
    if (action.equals("getIMEINumber")) {
      this.getIMEINumber(callbackContext);
      return true;
    }
    return false;
  }

  @Override
  protected void pluginInitialize() {
    statistics = new Statistics();
    statistics.statisticsSerialNumber(cordova);
  }

  private void getSerialNumber(CallbackContext callbackContext) {
    statistics.getSerialNumber(callbackContext, cordova);
  }

  private void getIMEINumber(CallbackContext callbackContext) {
    statistics.getIMEINumber(callbackContext, cordova);
  }
}
