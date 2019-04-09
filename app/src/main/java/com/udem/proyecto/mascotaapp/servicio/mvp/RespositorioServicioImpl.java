package com.udem.proyecto.mascotaapp.servicio.mvp;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.udem.proyecto.mascotaapp.Constantes;
import com.udem.proyecto.mascotaapp.FirebaseHelper;
import com.udem.proyecto.mascotaapp.GenericRepository;
import com.udem.proyecto.mascotaapp.modelos.Mascota;
import com.udem.proyecto.mascotaapp.modelos.Servicio;
import com.udem.proyecto.mascotaapp.servicio.mvp.ContratoServicio;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;

public class RespositorioServicioImpl implements ContratoServicio.RepositorioServicio {
    @Override
    public void listarServicios(final GenericRepository<List<Servicio>> servicioResponse) {
        FirebaseHelper.getFirebaseDB().child(Constantes.RAMA_SERVICIOS).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                List<Servicio> listaServicios = new ArrayList<>();
                for(DataSnapshot value:dataSnapshot.getChildren()){
                    Servicio servicio = value.getValue(Servicio.class);
                    listaServicios.add(servicio);
                }
                servicioResponse.onRequestSuccess(listaServicios);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    @Override
    public void listarMascotasParaAsignarAServicio(final GenericRepository<List<Mascota>> servicioMascotaResponse) {
        FirebaseHelper.getFirebaseDB().child(Constantes.RAMA_MASCOTAS).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                List<Mascota> listaMascotas = new ArrayList<>();
                for(DataSnapshot value:dataSnapshot.getChildren()){
                    Mascota mascota = value.getValue(Mascota.class);
                    listaMascotas.add(mascota);
                }
                servicioMascotaResponse.onRequestSuccess(listaMascotas);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
