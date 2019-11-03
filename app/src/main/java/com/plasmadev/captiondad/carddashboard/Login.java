package com.plasmadev.captiondad.carddashboard;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity implements FirebaseHolder.AuthListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void login(View v) {
        String email = ((EditText) this.findViewById(R.id.email)).getText().toString();
        String pass = ((EditText) this.findViewById(R.id.password)).getText().toString();
        if (email.isEmpty() || pass.isEmpty()) {
            Toast.makeText(this, "Complete todos los campos", Toast.LENGTH_SHORT).show();
            return;
        }
        FirebaseHolder.login(email, pass);
    }

    public void signup(View v) {
        Intent i = new Intent(this, SignUp.class);
        this.startActivity(i);
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
        if (FirebaseHolder.isAuth()) finish();
    }

    @Override
    public void onChange(FirebaseUser user) {
        if (user == null)
            Toast.makeText(this, "Contraseña o usuario equivocado", Toast.LENGTH_LONG).show();
        else {
            Toast.makeText(this, "Sesión iniciada", Toast.LENGTH_SHORT).show();
            this.finish();
        }
    }
}
