package org.coursera.sustainableapps.customedittext;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class MainActivity extends AppCompatActivity {

    AutoCompleteTextView etFirstName, etLastName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etFirstName=findViewById(R.id.etFirstName);
        etLastName=findViewById(R.id.etLastName);

        String[] names = {"James","John","Jill","Jack","Julius","Jenna","Janine", "Jennifer"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.custom_design_autocomplete,names);
        etFirstName.setAdapter(adapter);
    }
}