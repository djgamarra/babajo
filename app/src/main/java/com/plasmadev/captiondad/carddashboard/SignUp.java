package com.plasmadev.captiondad.carddashboard;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseUser;

public class SignUp extends AppCompatActivity implements FirebaseHolder.AuthListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }

    public void signup(View v) {
        String email = ((EditText)this.findViewById(R.id.email)).getText().toString();
        String pass = ((EditText)this.findViewById(R.id.password)).getText().toString();
        String pass2 = ((EditText)this.findViewById(R.id.password2)).getText().toString();
        if (email.isEmpty() || pass.isEmpty() || pass2.isEmpty()) {
            Toast.makeText(this, "Complete todos los campos", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!pass.equals(pass2)) {
            Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_LONG).show();
            return;
        }
        FirebaseHolder.signup(email, pass);
    }

    @Override
    protected void onPause() {
        super.onPause();
        FirebaseHolder.unSubscribe();
    }

    @Override
    protected void onResume() {
        super.onResume();
        FirebaseHolder.subscribe(this);
    }

    @Override
    public void onChange(FirebaseUser user) {
        if (user == null)
            Toast.makeText(this, "El email registrado ya existe", Toast.LENGTH_LONG).show();
        else {
            Toast.makeText(this, "Sesión iniciada", Toast.LENGTH_SHORT).show();
            this.finish();
        }
    }
}
