package com.plasmadev.captiondad.carddashboard;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        this.getWindow().setStatusBarColor(this.getResources().getColor(R.color.indigo));
        final SplashScreen context = this;
        final int duration = 2000;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(context, MainActivity.class);
                context.startActivity(i);
                context.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        context.finish();
                    }
                }, duration + 100);
            }
        }, duration);
    }
}
