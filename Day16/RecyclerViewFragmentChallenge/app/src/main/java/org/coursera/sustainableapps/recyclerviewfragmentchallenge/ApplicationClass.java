package org.coursera.sustainableapps.recyclerviewfragmentchallenge;

import android.app.Application;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ApplicationClass extends Application {
    public static ArrayList<CarOwner> list;

    @Override
    public void onCreate(){
        super.onCreate();

        list = new ArrayList<>();
        list.add(new CarOwner("John","9175452323","Mercedes","Benz"));
        list.add(new CarOwner("Jack","8739238192","Volkswagen","Beetle"));
        list.add(new CarOwner("Jill","9121327382","Nissan","Almera"));
        list.add(new CarOwner("John","9175452323","Mercedes","Benz"));
        list.add(new CarOwner("Jack","8739238192","Volkswagen","Beetle"));
        list.add(new CarOwner("Jill","9121327382","Nissan","Almera"));

    }
}
