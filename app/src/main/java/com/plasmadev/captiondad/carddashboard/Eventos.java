package com.plasmadev.captiondad.carddashboard;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class Eventos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventos);
        RecyclerView rv = this.findViewById(R.id.eventosRV);
        rv.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rv.setLayoutManager(layoutManager);

        rv.setAdapter(new EventosAdapter(FirebaseHolder.eventos, this));
    }
}
