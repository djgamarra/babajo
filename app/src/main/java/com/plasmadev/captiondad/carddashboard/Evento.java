package com.plasmadev.captiondad.carddashboard;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Evento extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evento);
        Intent extras = this.getIntent();
        String img = extras.getStringExtra("img");
        ImageView i = this.findViewById(R.id.eventoImg);
        i.setImageBitmap(Util.findOrCreateBy(img));
        ((TextView) findViewById(R.id.eventoTitulo)).setText(extras.getStringExtra("titulo"));
        ((TextView) findViewById(R.id.eventoFecha)).setText(extras.getStringExtra("fecha"));
        ((TextView) findViewById(R.id.eventoDetalle)).setText(extras.getStringExtra("detalle"));
        ((TextView) findViewById(R.id.eventoTelefono)).setText(extras.getStringExtra("telefono") == null ? "---" : extras.getStringExtra("telefono"));
        ((TextView) findViewById(R.id.eventoEmail)).setText(extras.getStringExtra("email") == null ? "---" : extras.getStringExtra("email"));
    }

    public void llamar(View v) {
        Intent extras = this.getIntent();
        String phone = extras.getStringExtra("telefono");
        if (phone != null) {
            Uri u = Uri.parse("tel:" + phone);
            Intent i = new Intent(Intent.ACTION_DIAL, u);
            this.startActivity(i);
        }
    }

    public void mail_to(View v) {
        Intent extras = this.getIntent();
        String email = extras.getStringExtra("email");
        if (email != null) {
            Intent i = new Intent(Intent.ACTION_SENDTO);
            i.setData(Uri.parse("mailto:"));
            i.putExtra(Intent.EXTRA_EMAIL, email);
            i.putExtra(Intent.EXTRA_SUBJECT, "");
            if (i.resolveActivity(getPackageManager()) != null) {
                startActivity(i);
            }
        }
    }
}
