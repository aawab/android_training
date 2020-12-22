package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("tag","In OnCreate");
    }
    protected void onStart(){
        super.onStart();
        Log.d("tag","In OnStart");
    }
    protected void onResume(){
        super.onResume();
        Log.d("tag","In OnResume");
    }
    protected void onPause(){
        super.onPause();
        Log.d("tag","In OnPause");
    }
    protected void onStop(){
        super.onStop();
        Log.d("tag","In OnStop");
    }


}