package com.example.jamesfan.getbatterycapacity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class BatteryShowActivity extends Activity{


    TextView textView;
    String m_strShowBatteryInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_battery_show);

        m_strShowBatteryInfo = getIntent().getStringExtra("data");
        textView=(TextView)findViewById(R.id.Batteryinfo);
        textView.setText(m_strShowBatteryInfo);

    }

    @Override
    protected void onNewIntent(Intent intent) {

       // m_strShowBatteryInfo = getIntent().getStringExtra("data");
    }
}