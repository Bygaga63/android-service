package com.example.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import java.util.concurrent.TimeUnit;

public class LogService extends Service {
    public LogService() {
    }

    private boolean run;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        log("Старт сервиса");
        super.onCreate();
        run = true;
        Thread serviceThread = new Thread(() -> {
            int i = 0;

            while (run) {
                log("Прошло " + i + "c.");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                i++;
            }
        });


        serviceThread.start();
    }


    @Override
    public void onDestroy() {
        log("Остановка сервиса");
        super.onDestroy();
        run  = false;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        log("Запуск");
        return super.onStartCommand(intent, flags, startId);
    }

    private void log(String msg) {
        System.out.println(msg);
    }
}
