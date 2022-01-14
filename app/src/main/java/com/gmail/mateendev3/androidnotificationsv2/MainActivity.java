package com.gmail.mateendev3.androidnotificationsv2;

import static com.gmail.mateendev3.androidnotificationsv2.application.App.CHANNEL_ID_1;
import static com.gmail.mateendev3.androidnotificationsv2.application.App.CHANNEL_ID_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;

import com.gmail.mateendev3.androidnotificationsv2.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    /*
    * ViewBinding enabled:
    * 1. viewBinding {
        enabled = true
    }
    * add above code in Build.gradle file of module level
    * 2.Create an instance of binding object using xml layout name
    * like here is ActivityMainBinding
    * 3. mActivityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
    * 4. setContentView(mActivityMainBinding.getRoot());
    * */
    //Declaring members
    ActivityMainBinding mActivityMainBinding;
    NotificationManagerCompat mManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mActivityMainBinding.getRoot());

        //instantiating manager
        mManager = NotificationManagerCompat.from(this);

        //setting listeners to buttons to send notifications
        setListenersToButtons();
    }

    private void setListenersToButtons() {

        mActivityMainBinding.btnNotify1.setOnClickListener(v -> {

            //Adding on notification click to notification
            Intent intent = new Intent(this, SecondActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(
                    this, RESULT_OK, intent, PendingIntent.FLAG_MUTABLE
            );

            Notification notification = new NotificationCompat.Builder(
                    this,
                    CHANNEL_ID_1
            )
                    .setSmallIcon(R.drawable.ic_one)
                    .setContentTitle("Message")
                    .setContentText("New Message Received")
                    .setPriority(NotificationCompat.PRIORITY_MAX)
                    .setContentIntent(pendingIntent)
                    .setAutoCancel(true)
                    .build();

            mManager.notify(1, notification);
        });

        mActivityMainBinding.btnNotify2.setOnClickListener(v -> {

            //Adding on notification click to notification
            Intent intent = new Intent(this, SecondActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(
                    this, RESULT_OK, intent, PendingIntent.FLAG_IMMUTABLE
            );

            Notification notification = new NotificationCompat.Builder(
                    this,
                    CHANNEL_ID_2
            )
                    .setSmallIcon(R.drawable.ic_two)
                    .setContentTitle("Video")
                    .setContentText("New Video Message Received")
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                    .setContentIntent(pendingIntent)
                    .setAutoCancel(true)
                    .build();


            mManager.notify(2, notification);
        });
    }
}