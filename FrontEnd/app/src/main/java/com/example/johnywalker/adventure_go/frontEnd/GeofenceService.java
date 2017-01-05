package com.example.johnywalker.adventure_go.frontEnd;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.util.Log;

import com.example.johnywalker.adventure_go.R;
import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofencingEvent;

import java.util.List;

/**
 * Created by Dimitriadis983 on 24-Dec-16.
 */

public class GeofenceService extends IntentService
{
    public static final String TAG = "GeofenceService";

    public GeofenceService()
    {
        super(TAG);

    }

    @Override
    protected void onHandleIntent(Intent intent)
    {
        GeofencingEvent event = GeofencingEvent.fromIntent(intent);

        int transition = event.getGeofenceTransition();
        List<Geofence> geofences = event.getTriggeringGeofences();
        Geofence geofence = geofences.get(0);
        String requestId = geofence.getRequestId();

        if(event.hasError())
        {

            Log.d(TAG, "Houston we have a problem - " + requestId + transition);
        }
        else
        {

            if(transition == Geofence.GEOFENCE_TRANSITION_ENTER)
            {
                Log.d(TAG,"Entering geofence - "+ requestId);
                Intent viewIntent = new Intent(GeofenceService.this,PopMenu.class);
                viewIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(viewIntent);


            }
            else if (transition == Geofence.GEOFENCE_TRANSITION_EXIT)
            {
                Log.d(TAG,"Exiting geofence - "+ requestId);
            }
        }
    }
}
