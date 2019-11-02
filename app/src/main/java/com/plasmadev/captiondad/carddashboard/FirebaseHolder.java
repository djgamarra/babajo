package com.plasmadev.captiondad.carddashboard;

import android.support.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

public class FirebaseHolder {
    public static QuerySnapshot eventos = null;

    public static FirebaseFirestore getInstance() {
        return FirebaseFirestore.getInstance();
    }

    public static void init() {
        getInstance().collection("eventos").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    eventos = task.getResult();
                }
            }
        });
    }
}
