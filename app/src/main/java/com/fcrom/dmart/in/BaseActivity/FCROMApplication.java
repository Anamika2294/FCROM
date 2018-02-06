package com.fcrom.dmart.in.BaseActivity;

import android.app.Application;

import com.fcrom.dmart.in.R;
import com.fcrom.library.Constant.API_urls;
import com.fcrom.library.Utils.Logger;

/**
 * Created by anamika.chavan on 10-01-2018.
 */

public class FCROMApplication extends Application {
    private static FCROMApplication mInstance = null;
    public static FCROMApplication getInstance() {
        return mInstance;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        Logger.log("ABC","");
        API_urls.initialize(this,getString(R.string.baseurl));
        //CachingManager.saveAppContext(this);
    }
}
