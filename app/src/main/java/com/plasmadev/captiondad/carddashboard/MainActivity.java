package com.plasmadev.captiondad.carddashboard;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
        Log.d("hola", "hola");
        Log.d(data.getStringExtra("KEY_QR_CODE"), "" + requestCode);
    }
}
