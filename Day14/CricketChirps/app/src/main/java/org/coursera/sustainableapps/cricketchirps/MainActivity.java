package org.coursera.sustainableapps.cricketchirps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView intro;
    Button btnTemp;
    EditText numEdit;
    ImageView thermView;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intro = findViewById(R.id.introText);
        btnTemp= findViewById(R.id.button);
        numEdit = findViewById(R.id.editTextNumber);
        thermView=findViewById(R.id.imageView2);
        result=findViewById(R.id.resultText);

        result.setVisibility(View.GONE);

        btnTemp.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                int chirps = Integer.parseInt(numEdit.getText().toString());

                double temp = ((double)chirps/3.0)+4.0;

                String text = "The approximate temperature outside is " + temp + " degrees Celsius";
                result.setText(text);
                result.setVisibility(View.VISIBLE);
            }
        });
    }
}