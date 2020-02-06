package com.t3h.buoi15.Service;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;
import android.widget.RemoteViews;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

import com.t3h.buoi15.R;
import com.t3h.buoi15.controller.MediaController;
import com.t3h.buoi15.controller.MediaListener;
import com.t3h.buoi15.model.Song;

import java.util.ArrayList;

public class MP3Service extends Service implements MediaListener {
    private MediaController controller ;
    private Muta

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.e(getClass().getSimpleName(), " onBind") ;
        return  new MP3Binder(this) ;

    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e(getClass().getSimpleName(), " onCreate") ;

}

    @Override
    public boolean onUnbind(Intent intent) {

        Log.e(getClass().getSimpleName(), " onUnbind") ;
        return super.onUnbind(intent);
    }
    private void pushNotify(){
        Intent intent = new Intent(this , getClass());
        startService(intent);
        NotificationManager manager =  (NotificationManager)
                getSystemService(NOTIFICATION_SERVICE) ;
        String chanel = " MP3Service";
        if (Build.VERSION.SDK_INT>= Build.VERSION_CODES.O) {
            NotificationChannel c = new NotificationChannel(
                    chanel,chanel,NotificationManager.IMPORTANCE_DEFAULT
            );
            manager.createNotificationChannel(c);
        }
        RemoteViews views = new RemoteViews(
                getPackageName(),
                R.layout.notification
        );
        views.setTextViewText(R.id.tv_Title,controller.getName());
        NotificationCompat.Builder builder = new NotificationCompat.Builder(
                this,
                chanel
        );
        builder.setSmallIcon(R.mipmap.ic_launcher) ;
      builder.setCustomBigContentView(views) ;
        startForeground(12030303,builder.build());
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e(getClass().getSimpleName()," onStartCommand");
//        START_STICKY
                return START_STICKY ;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(getClass().getSimpleName(), " onDestroy") ;
    }

 public void setSongData(ArrayList<Song> arr) {
        if (controller!= null){
            controller.release();
        }
        controller = new MediaController(this,arr,this) ;
 }

    public MediaController getController() {
        return controller;
    }

    @Override
    public void onStarted() {
        pushNotify();
    }

    @Override
    public void onPaused() {
        pushNotify();

    }

    public class MP3Binder extends Binder{
        private MP3Service service ;

        public MP3Binder(MP3Service service) {
            this.service = service;
        }

        public MP3Service getService() {
            return service;
        }
    }
}
