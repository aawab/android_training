package org.coursera.sustainableapps.testapp;

import android.app.Application;

import com.backendless.Backendless;

public class TestApplication extends Application {

    public static final String APPLICATION_ID = "3CEC4A26-DA11-9576-FF3E-8E5578314D00";
    public static final String API_KEY = "9F1E80E5-E50E-4B67-95FC-D29760AFB1DD";
    public static final String SERVER_URL = "https://api.backendless.com";

    @Override
    public void onCreate() {
        super.onCreate();

        Backendless.setUrl(SERVER_URL);
        Backendless.initApp(getApplicationContext(),APPLICATION_ID,API_KEY);

    }
}
