package org.coursera.sustainableapps.contactsapp;

import android.app.Application;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;

import java.util.List;

public class ApplicationClass extends Application {

    public static final String APPLICATION_ID = "9DE3F3F4-AA83-925D-FFB2-92183CCB1600";
    public static final String API_KEY = "69851B05-C0C7-4B33-A9B3-3C42000CCB84";
    public static final String SERVER_URL = "https://api.backendless.com";

    public static BackendlessUser user;
    public static List<Contact> contacts;

    @Override
    public void onCreate() {
        super.onCreate();

        Backendless.setUrl(SERVER_URL);
        Backendless.initApp(getApplicationContext(),APPLICATION_ID ,API_KEY);
    }
}
