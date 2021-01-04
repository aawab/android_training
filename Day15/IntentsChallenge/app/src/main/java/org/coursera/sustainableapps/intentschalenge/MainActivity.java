package org.coursera.sustainableapps.intentschalenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView title;
    ImageView face;
    ImageView phone;
    ImageView web;
    ImageView location;
    Button btn;

    String name;
    Uri phoneNum, webAdd, locationName;

    final int CREATE_CONTACT=3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        title = findViewById(R.id.titleView);
        btn =findViewById(R.id.buttonNew);
        face=findViewById(R.id.smileyResult);
        phone=findViewById(R.id.phoneResult);
        web=findViewById(R.id.webResult);
        location=findViewById(R.id.locationResult);

        face.setVisibility(View.GONE);
        phone.setVisibility(View.GONE);
        web.setVisibility(View.GONE);
        location.setVisibility(View.GONE);

        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(),org.coursera.sustainableapps.
                        intentschalenge.create_contact.class);
                startActivityForResult(intent,CREATE_CONTACT);
            }
        });

        phone.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent=  new Intent(Intent.ACTION_DIAL,phoneNum);
                startActivity(intent);
            }
        });

        web.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(Intent.ACTION_VIEW,webAdd);
                startActivity(intent);
            }
        });

        location.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(Intent.ACTION_VIEW,locationName);
                startActivity(intent);
            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);

        if(requestCode==CREATE_CONTACT){
            if(resultCode==RESULT_OK){
                String smile = data.getStringExtra(create_contact.faceKey);

                if(smile.equals("green")) face.setImageResource(R.drawable.greenface);
                else if(smile.equals("yellow")) face.setImageResource(R.drawable.yellowface);
                else if(smile.equals("red")) face.setImageResource(R.drawable.redface);

                face.setVisibility(View.VISIBLE);
                phone.setVisibility(View.VISIBLE);
                web.setVisibility(View.VISIBLE);
                location.setVisibility(View.VISIBLE);

                name = data.getStringExtra(create_contact.nameKey);
                phoneNum = Uri.parse(data.getStringExtra(create_contact.phoneKey));
                webAdd = Uri.parse(data.getStringExtra(create_contact.webKey));
                locationName = Uri.parse(data.getStringExtra(create_contact.locationKey));

            }
        }
        else Toast.makeText(getApplicationContext(),"Activity has been cancelled!",
                Toast.LENGTH_SHORT).show();
    }
}