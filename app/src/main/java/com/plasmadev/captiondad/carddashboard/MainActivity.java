package com.plasmadev.captiondad.carddashboard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void open(View v) {
        Intent i = new Intent(this, Main2Activity.class);
        this.startActivity(i);
    }

    public void open_lugares(View v){
    Intent i = new Intent( this, Lugares.class);
    this.startActivity(i);
}

      public void open_qr(View v){

    Intent i = new Intent( this, ScanActivity.class);
    this.startActivity(i);

}
    public void open_historia(View v){

        Intent i = new Intent( this, Historia.class);

        this.startActivity(i);

    }
}
