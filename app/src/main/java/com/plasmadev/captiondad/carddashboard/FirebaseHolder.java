package com.plasmadev.captiondad.carddashboard;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.List;

public class FirebaseHolder {
    private static final int MODULES = 3;
    public static List<DocumentSnapshot> eventos = null;
    public static List<DocumentSnapshot> historias = null;
    public static List<DocumentSnapshot> qrs = null;
    private static int loaded = 0;
    @Nullable
    private static FirebaseUser currentUser;
    @Nullable
    private static AuthListener authListener = null;

    public static FirebaseFirestore getInstance() {
        return FirebaseFirestore.getInstance();
    }

    public static FirebaseAuth getAuthInstance() {
        return FirebaseAuth.getInstance();
    }

    public static boolean isAuth() {
        return getAuthInstance().getCurrentUser() != null;
    }

    public static void init(final SplashScreen notif) {
        getInstance().collection("eventos").orderBy("fecha").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    eventos = task.getResult().getDocuments();
                    loaded++;
                }
                if (loaded == MODULES) notif.continuar();
            }
        });
        getInstance().collection("historias").orderBy("nombre").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    historias = task.getResult().getDocuments();
                    loaded++;
                }
                if (loaded == MODULES) notif.continuar();
            }
        });
        getInstance().collection("qrs").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    qrs = task.getResult().getDocuments();
                    loaded++;
                }
                if (loaded == MODULES) notif.continuar();
            }
        });
    }

    public static void subscribe(AuthListener listener) {
        authListener = listener;
    }

    public static void unSubscribe() {
        authListener = null;
    }

    public static void login(String username, String password) {
        getAuthInstance().signInWithEmailAndPassword(username, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful() && task.getResult() != null)
                    currentUser = task.getResult().getUser();
                else currentUser = null;
                if (authListener != null) authListener.onChange(currentUser);
            }
        });
    }

    public interface AuthListener {
        void onChange(FirebaseUser user);
    }
}
