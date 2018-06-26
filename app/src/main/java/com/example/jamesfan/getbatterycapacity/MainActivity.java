package com.example.jamesfan.getbatterycapacity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    BatteryReceiver m_receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IntentFilter intentFilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        m_receiver = new BatteryReceiver();
        registerReceiver(m_receiver, intentFilter);

        Button showBatteryCapacity = (Button) findViewById(R.id.showBatteryCapacity);
        Button showBatteryInfo = (Button) findViewById(R.id.showBatteryInfo);
        //showBatteryCapacity.setOnClickListener(this);

        showBatteryCapacity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BatteryInfo batteryInfo = new BatteryInfo();
                String strBatteryInfo = batteryInfo.getCapaCity(MainActivity.this);
                Toast.makeText(MainActivity.this, strBatteryInfo, Toast.LENGTH_SHORT).show();
            }
        });


        showBatteryInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str;
                str = "CurrentLevel =" + m_receiver.getCurrentLevel()
                        + " Total=" + m_receiver.getTotal()
                        + " percent=" + m_receiver.getBatteryPercent();

                Toast.makeText(MainActivity.this, str, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(MainActivity.this,BatteryShowActivity.class);;
                intent.putExtra("data",str);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });


    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(m_receiver);
    }
}
