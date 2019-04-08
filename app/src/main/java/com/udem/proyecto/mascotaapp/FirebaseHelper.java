package com.udem.proyecto.mascotaapp;

import android.content.Context;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FirebaseHelper {
    public static DatabaseReference getFirebaseDB(){

        return FirebaseDatabase.getInstance().getReference();
    }
}
