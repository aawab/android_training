package org.coursera.sustainableapps.intentschalenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class create_contact extends AppCompatActivity {

    public static final String nameKey = "name";
    public static final String phoneKey = "phone";
    public static final String webKey = "web";
    public static final String locationKey = "location";
    public static final String faceKey = "face";

    TextView nameInput;
    TextView phoneInput;
    TextView webInput;
    TextView locationInput;

    ImageView green;
    ImageView yellow;
    ImageView red;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_contact);

        nameInput=findViewById(R.id.nameInput);
        phoneInput=findViewById(R.id.phoneInput);
        webInput=findViewById(R.id.webInput);
        locationInput=findViewById(R.id.locationInput);

        green=findViewById(R.id.green);
        yellow=findViewById(R.id.yellow);
        red=findViewById(R.id.red);

        green.setOnClickListener(this::onClick);
        yellow.setOnClickListener(this::onClick);
        red.setOnClickListener(this::onClick);
    }

    public void onClick(View view){
        if(!nameInput.getText().toString().isEmpty()|| !phoneInput.getText().toString().isEmpty()||
                !webInput.getText().toString().isEmpty()|| !locationInput.getText().toString().isEmpty()){
            Intent intent = new Intent(getApplicationContext(),org.coursera.sustainableapps.
                    intentschalenge.MainActivity.class);
            String name = nameInput.getText().toString().trim();
            String number = phoneInput.getText().toString();
            if(number.length()==10) {
                intent.putExtra(phoneKey,"tel:" + number);
            }
            else {
                Toast.makeText(getApplicationContext(),"Number must be 10 digits",
                        Toast.LENGTH_SHORT).show();
            }
            String web = "https://" + webInput.getText().toString();
            intent.putExtra(webKey,web);
            String loc = "geo:0,0?q="+ locationInput.getText().toString();
            intent.putExtra(locationKey,loc);
            if(view.getId()==R.id.green) intent.putExtra(faceKey,"green");
            else if(view.getId()==R.id.yellow) intent.putExtra(faceKey,"yellow");
            else intent.putExtra(faceKey,"red");
            setResult(RESULT_OK,intent);
            create_contact.this.finish();
        }
        else Toast.makeText(getApplicationContext(),"No fields can be empty",
                Toast.LENGTH_SHORT).show();
    }
}