package com.ds.avare;

import android.app.Activity;
import android.location.GpsStatus;
import android.location.Location;
import android.os.Bundle;
import android.view.Window;

import com.ds.avare.gps.GpsInterface;
import com.ds.avare.storage.Preferences;
import com.ds.avare.utils.Helper;

public class BaseActivity extends Activity {

    protected StorageService mService;
    protected Preferences mPref;

    /**
     *
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        Helper.setTheme(this);

        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);

        mService = StorageService.getInstance();
        mPref = mService.getPreferences();
    }

    /*
     * For being on tab this activity discards back to main activity
     * (non-Javadoc)
     * @see android.app.Activity#onBackPressed()
     */
    @Override
    public void onBackPressed() {
        MainActivity m = (MainActivity)this.getParent();
        if(m != null) {
            m.showMapTab();
        }
    }

    protected GpsInterface mGpsInfc = new GpsInterface() {

        @Override
        public void statusCallback(GpsStatus gpsStatus) {
        }

        @Override
        public void locationCallback(Location location) {
        }

        @Override
        public void timeoutCallback(boolean timeout) {
        }

        @Override
        public void enabledCallback(boolean enabled) {
        }
    };

    /* (non-Javadoc)
     * @see android.app.Activity#onPause()
     */
    @Override
    protected void onPause() {
        super.onPause();
    }

    /**
     *
     */
    @Override
    public void onResume() {
        super.onResume();
        Helper.setOrientationAndOn(this);
    }

    /**
     *
     */
    @Override
    public void onDestroy() {
        super.onDestroy();
    }



}
