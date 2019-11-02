package com.plasmadev.captiondad.carddashboard;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.zxing.Result;

import javax.annotation.Nullable;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class ScanActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler {
    private ZXingScannerView camera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.camera = new ZXingScannerView(this);
        setContentView(this.camera);
        this.camera.setResultHandler(this);
        this.camera.startCamera();
    }

    @Override
    protected void onPause() {
        super.onPause();
        this.camera.stopCamera();
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.camera.startCamera();
        this.camera.setResultHandler(this);
    }

    @Override
    public void handleResult(Result result) {
        this.camera.setResultHandler(null);
        final ScanActivity context = this;
        FirebaseHolder.getInstance().collection("historias").document(result.getText()).addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot doc, @Nullable FirebaseFirestoreException e) {
                if (e == null && doc != null && doc.exists()) {
                    Intent i = new Intent(context, Museo.class);
                    i.putExtra("img", doc.getString("imagen"));
                    i.putExtra("titulo", doc.getString("nombre"));
                    i.putExtra("fecha", doc.getString("ubicacion"));
                    i.putExtra("detalle", doc.getString("historia"));
                    i.putExtra("contacto", doc.getString("contacto") == null ? "---" : doc.getString("contacto"));
                    context.startActivity(i);
                } else {
                    context.camera.setResultHandler(context);
                }
            }
        });
    }
}
