package com.udem.proyecto.mascotaapp.mascota.mvp;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.udem.proyecto.mascotaapp.Constantes;
import com.udem.proyecto.mascotaapp.FirebaseHelper;
import com.udem.proyecto.mascotaapp.GenericRepository;
import com.udem.proyecto.mascotaapp.mascota.mvp.ContratoMascota;
import com.udem.proyecto.mascotaapp.modelos.Mascota;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;

public class RepositorioMascotaImpl implements ContratoMascota.RepositorioMascota {
    @Override
    public void consultarMascotas(final GenericRepository<List<Mascota>> mascotaResponse) {
        FirebaseHelper.getFirebaseDB().child(Constantes.RAMA_MASCOTAS).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                List<Mascota> listaMascotas = new ArrayList<>();
                for(DataSnapshot value:dataSnapshot.getChildren()){
                    Mascota mascota = value.getValue(Mascota.class);
                    listaMascotas.add(mascota);
                }
                mascotaResponse.onRequestSuccess(listaMascotas);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
