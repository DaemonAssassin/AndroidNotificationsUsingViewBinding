package com.gmail.mateendev3.androidnotificationsv2.application;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

import androidx.core.app.NotificationManagerCompat;

public class App extends Application {

    public static final String CHANNEL_ID_1 = "com.gmail.mateendev3.androidnotificationsv2.application.id.1";
    public static final String CHANNEL_ID_2 = "com.gmail.mateendev3.androidnotificationsv2.application.id.2";

    @Override
    public void onCreate() {
        super.onCreate();

        createNotificationChannels();
    }

    private void createNotificationChannels() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {


            //channel 1
            NotificationChannel channel1 = new NotificationChannel(
                    CHANNEL_ID_1,
                    "Audio",
                    NotificationManager.IMPORTANCE_HIGH
            );
            channel1.setDescription("This category is for audio notifications");

            //channel 2
            NotificationChannel channel2 = new NotificationChannel(
                    CHANNEL_ID_2,
                    "Video",
                    NotificationManager.IMPORTANCE_DEFAULT
            );
            channel2.setDescription("This category is for video notifications");

            //setting manager
            NotificationManagerCompat manager = NotificationManagerCompat.from(this);
            manager.createNotificationChannel(channel1);
            manager.createNotificationChannel(channel2);
        }
    }
}
