package com.example.jamesfan.getbatterycapacity;

import android.content.Context;


public class BatteryInfo {

    public String getCapaCity(Context context) {
        Object mPowerProfile;
        double mBatteryCapacity = 0;
        String POWER_PROFILE_CLASS = "com.android.internal.os.PowerProfile";

        try {
            mPowerProfile = Class.forName(POWER_PROFILE_CLASS)
                    .getConstructor(Context.class)
                    .newInstance(context);


            mBatteryCapacity = (double) Class.forName(POWER_PROFILE_CLASS)
                    .getMethod("getBatteryCapacity")
                    .invoke(mPowerProfile);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return String.valueOf(mBatteryCapacity + " mAh");
    }

}