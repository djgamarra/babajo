package com.plasmadev.captiondad.carddashboard;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.google.firebase.firestore.DocumentSnapshot;

import java.util.List;

public class EventAdapter extends FragmentStatePagerAdapter {
    private List<DocumentSnapshot> data;

    EventAdapter(FragmentManager fm, List<DocumentSnapshot> data) {
        super(fm);
        this.data = data;
    }

    @Override
    public Fragment getItem(int position) {
        EventFragment frag = new EventFragment();
        Bundle b = new Bundle();
        DocumentSnapshot doc = this.data.get(position);
        b.putString("imagen", doc.getString("imagen"));
        b.putString("titulo", doc.getString("nombre"));
        b.putString("fecha", doc.getString("fecha"));
        b.putString("detalle", doc.getString("detalle"));
        b.putString("telefono", doc.getString("telefono"));
        b.putString("email", doc.getString("email"));
        frag.setArguments(b);
        return frag;
    }

    @Override
    public int getCount() {
        return Math.min(this.data.size(), 5);
    }
}
