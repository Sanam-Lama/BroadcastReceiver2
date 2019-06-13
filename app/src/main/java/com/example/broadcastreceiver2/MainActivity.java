package com.example.broadcastreceiver2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // IntentFilter is used when you are passing an additional data along with the intent
    IntentFilter intentFilter;

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button)findViewById(R.id.button);
        intentFilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);

        // register the receiver
        registerReceiver(broadcastReceiver, intentFilter);

//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent();
//                intent.setAction(Intent.ACTION_BATTERY_CHANGED);
//
//                Log.e("Print", "Status of Broadcast");
//                sendBroadcast(intent);
//            }
//        });
    }

   BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
       @Override
       public void onReceive(Context context, Intent intent) {
           if(intent.getAction().equals(Intent.ACTION_BATTERY_CHANGED)) {
               Toast.makeText(MainActivity.this, "Broadcast is sent", Toast.LENGTH_SHORT).show();
           }

//            String value = intent.getStringExtra(Intent.ACTION_BATTERY_CHANGED);
//           Toast.makeText(MainActivity.this, value, Toast.LENGTH_SHORT).show();
       }
   };

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(broadcastReceiver);
    }
}
