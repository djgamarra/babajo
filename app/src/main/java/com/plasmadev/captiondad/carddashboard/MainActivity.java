package com.plasmadev.captiondad.carddashboard;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private ViewPager mPager;
    private PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPager = findViewById(R.id.pager);
        pagerAdapter = new EventAdapter(getSupportFragmentManager(), FirebaseHolder.eventos);
        mPager.setAdapter(pagerAdapter);
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 0);
    }

    public void open(View v) {
        Intent i = new Intent(this, Eventos.class);
        this.startActivity(i);
    }

    public void open_lugares(View v) {
        Intent i = new Intent(this, Lugares.class);
        this.startActivity(i);
    }

    public void open_qr(View v) {
        Intent i = new Intent(this, ScanActivity.class);
        startActivityForResult(i, 1);
    }

    public void open_historia(View v) {
        Intent i = new Intent(this, Historia.class);
        this.startActivity(i);
    }

    public void open_ayuda(View v) {
        Intent i = new Intent(this, Ayuda.class);
        this.startActivity(i);
    }

    public void open_login(View v) {
        Intent i = new Intent(this, Login.class);
        this.startActivity(i);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 1 && data != null) {
            Log.d(data.getStringExtra("KEY_QR_CODE"), "" + requestCode);
        }
    }
}
