package com.plasmadev.captiondad.carddashboard;

import android.support.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.List;

public class FirebaseHolder {
    public static List<DocumentSnapshot> eventos = null;
    public static List<DocumentSnapshot> historias = null;
    public static List<DocumentSnapshot> qrs = null;

    public static FirebaseFirestore getInstance() {
        return FirebaseFirestore.getInstance();
    }

    public static void init() {
        getInstance().collection("eventos").orderBy("fecha").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    eventos = task.getResult().getDocuments();
                }
            }
        });
        getInstance().collection("historias").orderBy("nombre").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    historias = task.getResult().getDocuments();
                }
            }
        });
        getInstance().collection("qrs").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    qrs = task.getResult().getDocuments();
                }
            }
        });
    }
}
