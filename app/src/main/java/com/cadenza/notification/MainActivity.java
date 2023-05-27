package com.cadenza.notification;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.iid.FirebaseInstanceIdReceiver;
import com.google.firebase.messaging.FirebaseMessaging;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {

    Button NotifyButton;

    // 1. Notification Channel
    // 2. Notification Builder
    // 3. Notification Manage

    // -> (1) channel id  (2) channel name  (3) channel description

    //these three thind crate our notification channel ...

    private static final String channel_id = "code_thread";
    private static final String channel_name = "code_thread";
    private static final String channel_desc = "Well come Code Threads";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        NotifyButton = findViewById(R.id.buttonNotify);

        // -----------------------------------------------------

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){

            NotificationChannel notiChannel = new NotificationChannel(channel_id,channel_name, NotificationManager.IMPORTANCE_DEFAULT);
            notiChannel.setDescription(channel_desc);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(notiChannel);
        }



        NotifyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DisplayNotificaton();

            }
        });



    }


    private void DisplayNotificaton(){

        //Notification Bulider object ---------------------------------------------------------------------

        NotificationCompat.Builder  mbuilder = new NotificationCompat.Builder(this,channel_id)
                .setSmallIcon(R.drawable.baseline_alarm_24)
                .setContentTitle("Facebook")
                .setContentText("Shiran Kumarasingha Visit Srilanka")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);


        //notification manager object create ---------------------------------------------------------------------


        ///notify the notification..

        NotificationManagerCompat notifiManager = NotificationManagerCompat.from(this);
        notifiManager.notify(1,mbuilder.build()); /*use the notification
                                                        manger object to
                                                       display notificatio */


    }
}