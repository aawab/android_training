package org.coursera.sustainableapps.smsmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etMessage, etTelNmbr;
    Button btnSend;

    int CUSTOM_REQUEST_CODE= 912903024;

    String SENT = "SMS_SENT";
    String DELIVERED = "SMS_DELIVERED";

    PendingIntent sentPI, deliveredPI;

    BroadcastReceiver smsSentReceiver;
    BroadcastReceiver smsDeliveredReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etMessage = findViewById(R.id.etMessage);
        etTelNmbr = findViewById(R.id.etTelNmbr);

        btnSend = findViewById(R.id.btnSend);

        sentPI = PendingIntent.getBroadcast(MainActivity.this,0,new
                Intent(SENT),0);
        deliveredPI = PendingIntent.getBroadcast(MainActivity.this,0,new
                Intent(DELIVERED),0);

    }

    @Override
    protected void onResume() {
        super.onResume();
        smsSentReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                switch(getResultCode()){
                    case Activity.RESULT_OK:
                        Toast.makeText(MainActivity.this,"SMS Sent",Toast.LENGTH_SHORT).show();
                        break;
                    case SmsManager.RESULT_ERROR_GENERIC_FAILURE:
                        Toast.makeText(MainActivity.this,"Generic failure",Toast.LENGTH_SHORT).show();
                        break;
                    case SmsManager.RESULT_ERROR_NO_SERVICE:
                        Toast.makeText(MainActivity.this,"No Service",Toast.LENGTH_SHORT).show();
                        break;
                    case SmsManager.RESULT_ERROR_NULL_PDU:
                        Toast.makeText(MainActivity.this,"Null PDU",Toast.LENGTH_SHORT).show();
                        break;
                    case SmsManager.RESULT_ERROR_RADIO_OFF:
                        Toast.makeText(MainActivity.this,"Radio Off",Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        };


        smsDeliveredReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                switch(getResultCode()){
                    case Activity.RESULT_OK:
                        Toast.makeText(MainActivity.this,"SMS delivered",Toast.LENGTH_SHORT).show();
                        break;
                    case Activity.RESULT_CANCELED:
                        Toast.makeText(MainActivity.this,"SMS not delivered",Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        };

        registerReceiver(smsSentReceiver,new IntentFilter(SENT));
        registerReceiver(smsDeliveredReceiver,new IntentFilter(DELIVERED));
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(smsDeliveredReceiver);
        unregisterReceiver(smsSentReceiver);
    }

    public void btn_SendSMS_OnClick(View v){
        String message = etMessage.getText().toString();
        String number = etTelNmbr.getText().toString();

        if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.SEND_SMS)
            != PackageManager.PERMISSION_GRANTED){

            ActivityCompat.requestPermissions(MainActivity.this,new String[]
                    {Manifest.permission.SEND_SMS},CUSTOM_REQUEST_CODE);
        }
        else{
            SmsManager manager = SmsManager.getDefault();
            manager.sendTextMessage(number,null, message,sentPI,deliveredPI);
        }

    }
}