package com.plasmadev.captiondad.carddashboard;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

public class Wall extends AppCompatActivity implements View.OnClickListener {

    private ImageView logbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wall);

        RecyclerView rv = this.findViewById(R.id.pager);
        rv.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rv.setLayoutManager(layoutManager);

        rv.setAdapter(new PublicacionesAdapter(FirebaseHolder.publish, this));
        this.logbutton = findViewById(R.id.logbutton);
        this.logbutton.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (FirebaseHolder.isAuth())
            this.logbutton.setImageBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.logout));
        else
            this.logbutton.setImageBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.login));
    }

    @Override
    public void onClick(View view) {
        if (FirebaseHolder.isAuth()) {
            FirebaseHolder.logout();
            finish();
        } else {
            Intent i = new Intent(this, Login.class);
            this.startActivity(i);
        }
    }
}
