package com.udem.proyecto.mascotaapp;

import android.os.Bundle;

import androidx.annotation.NonNull;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.udem.proyecto.mascotaapp.mascota.CrearMascotaFragment;
import com.udem.proyecto.mascotaapp.servicio.ListarServiciosFragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {

                case R.id.navigation_dashboard:
                    loadFragment(CrearMascotaFragment.class);
                    return true;
                case R.id.navigation_notifications:
                    loadFragment(ListarServiciosFragment.class);
                    return true;
            }
            return false;
        }
    };

    private void loadFragment(Class fragmentForLoad){
        try{
            Class fragmentClass;
            Fragment fragment = null;
            fragmentClass = fragmentForLoad;
            fragment = (Fragment) fragmentClass.newInstance();
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.contentFragmentMascota, fragment).commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        loadFragment(CrearMascotaFragment.class);
    }

}
