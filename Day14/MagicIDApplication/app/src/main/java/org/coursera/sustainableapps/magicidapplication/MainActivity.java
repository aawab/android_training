package org.coursera.sustainableapps.magicidapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnSubmit;
    EditText idSubmit;
    TextView idResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSubmit = findViewById(R.id.button);
        idSubmit = findViewById(R.id.editTextNumber);
        idResult = findViewById(R.id.textView);

        idResult.setVisibility(View.GONE);

        btnSubmit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String id = idSubmit.getText().toString().trim();
                String dOb = id.substring(0,6);

                int gender = Integer.parseInt(Character.toString(id.charAt(6)));
                String sGender;
                if(gender<5) sGender="Female";
                else sGender="Male";

                int race = Integer.parseInt(Character.toString(id.charAt(10)));
                String sRace;
                if(race==0) sRace="SA Citizen";
                else sRace="Permanent Resident";

                String text =getString(R.string.dob)+ dOb + getString(R.string.newline) +
                        getString(R.string.gender) + sGender + getString(R.string.newline) +
                        getString(R.string.nationality) + sRace;
                idResult.setText(text);

                idResult.setVisibility(View.VISIBLE);

            }
        });
    }
}