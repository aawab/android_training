package org.coursera.sustainableapps.loginactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "LoginActivity/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG,"in onCreate()");

        final EditText emailInput = findViewById(R.id.emailInput);
        final EditText passInput= findViewById(R.id.passInput);
        final Button button =  findViewById(R.id.button);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailInput.getText().toString();
                String pass = passInput.getText().toString();
                if(isValidEmail(email)) {
                    checkValidPassword(pass);
                }
                else Toast.makeText(getApplicationContext(),"Invalid email address",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
    //helper method to identify a valid email
    public boolean isValidEmail(String email){
        int atCharIndex=email.indexOf('@');
        if(atCharIndex<1) {
            return false;
        }
        String afterAtChar=email.substring(atCharIndex,email.length());
        //checks if at least 3 characters after @, and contains a . chara
        if(afterAtChar.length()<3) return false;
        else if(afterAtChar.indexOf('.')<0) return false;
        else return true;
    }
    //helper method to identify a valid password
    public void checkValidPassword(String pass){
        int len = pass.length();
        if (len >= 8) {
            if (!(pass.indexOf(' ') < 0)) {
                //checks if entered password is entirely space characters.
                if (allCharSame(pass)) {
                    Toast.makeText(getApplicationContext(), "The provided password " +
                            "is " + "invalid", Toast.LENGTH_SHORT).show();
                }
                else Toast.makeText(getApplicationContext(),"Login success!",
                        Toast.LENGTH_SHORT).show();
            }
            else Toast.makeText(getApplicationContext(),"Login success!",
                    Toast.LENGTH_SHORT).show();
        }
        else Toast.makeText(getApplicationContext(), "The provided password is " +
                "too short", Toast.LENGTH_SHORT).show();
    }
    //helper method to check if all charas in a string are the same
    public boolean allCharSame (String str){
        char first = str.charAt(0);
        for(char c:str.toCharArray()){
            if(c!=first) return false;
        }
        return true;
    }


    protected void onStart(){
        super.onStart();
        Log.d(TAG,"in onStart()");
    }

    protected void onPause(){
        super.onPause();
        Log.d(TAG,"in onPause()");
    }

    protected void onStop(){
        super.onStop();
        Log.d(TAG,"in onStop()");
    }

    protected void onRestart() {
        super.onRestart();
        Log.d(TAG,"in onRestart()");
    }

    protected void onResume(){
        super.onResume();
        Log.d(TAG,"in onResume()");
    }

    protected void onDestroy(){
        super.onDestroy();
        Log.d(TAG,"in onDestroy()");
    }
}