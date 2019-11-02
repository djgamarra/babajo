package com.plasmadev.captiondad.carddashboard;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class ScanActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ZXingScannerView camera = new ZXingScannerView(this);
        setContentView(camera);
        camera.setResultHandler(this);
        camera.startCamera();
    }

    @Override
    public void handleResult(Result result) {
        Log.d("r", result.getText());
        Intent intent = new Intent();
        intent.putExtra("KEY_QR_CODE", result.getText());
        setResult(1, intent);
        finish();
    }
}
