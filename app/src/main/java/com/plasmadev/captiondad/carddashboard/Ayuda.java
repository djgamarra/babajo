package com.plasmadev.captiondad.carddashboard;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Ayuda extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayuda);
    }


    //replicado en clase Evento.java, cuidado al modificar este método
    public void llamar(View v) {
        Intent extras = this.getIntent();
        String phone = "+57 3001237890";
        if (phone != null) {
            Uri u = Uri.parse("tel:" + phone);
            Intent i = new Intent(Intent.ACTION_DIAL, u);
            this.startActivity(i);
        }
    }

    //replicado en clase Evento.java, cuidado al modificar este método
    public void mail_to(View v) {
        Intent extras = this.getIntent();
        String email = "soporte@bajoelabonga.com";
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
