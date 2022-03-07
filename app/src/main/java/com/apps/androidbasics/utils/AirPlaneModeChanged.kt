package com.apps.androidbasics.utils

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class AirPlaneModeChanged : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        var isAirPlaneModeChanged = intent?.getBooleanExtra("state", false) ?: return

        if (isAirPlaneModeChanged) {
            Toast.makeText(context, "Air Plane Mode is ON", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(context, "Air Plane Mode is Disabled", Toast.LENGTH_LONG).show()
        }
    }
}