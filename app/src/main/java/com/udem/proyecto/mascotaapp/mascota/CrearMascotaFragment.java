package com.udem.proyecto.mascotaapp.mascota;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.udem.proyecto.mascotaapp.Constantes;
import com.udem.proyecto.mascotaapp.FirebaseHelper;
import com.udem.proyecto.mascotaapp.R;
import com.udem.proyecto.mascotaapp.mascota.adaptador.MascotaAdapter;
import com.udem.proyecto.mascotaapp.mascota.mvp.ContratoMascota;
import com.udem.proyecto.mascotaapp.mascota.mvp.PresentadorMascotaImpl;
import com.udem.proyecto.mascotaapp.modelos.Mascota;

import java.util.List;


public class CrearMascotaFragment extends Fragment implements ContratoMascota.VistaMascota, View.OnClickListener , ActionClick {
    private FloatingActionButton btnCrearMascota;
    private View view;
    private ContratoMascota.PresentadorMascota presentadorMascota;
    private RecyclerView recyclerViewMascota;
    private MascotaAdapter mascotaAdapter;
    private ProgressDialog progressDialog;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        presentadorMascota = new PresentadorMascotaImpl(this);
        view = inflater.inflate(R.layout.fragment_crear_mascota, container, false);
        inicializarinterfazGrafica();
        inicializarMascotaAdapter();
        presentadorMascota.listarMascotas();
        return view;
    }

    private  void inicializarinterfazGrafica(){
        btnCrearMascota = view.findViewById(R.id.fabCrearMascota);
        recyclerViewMascota = view.findViewById(R.id.rvMascotas);
        setEventListeners();
    }
    private void setEventListeners(){
        btnCrearMascota.setOnClickListener(this);
    }
    private void inicializarMascotaAdapter(){
        mascotaAdapter = new MascotaAdapter(this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerViewMascota.setLayoutManager(layoutManager);
        recyclerViewMascota.setAdapter(mascotaAdapter);

    }


    @Override
    public void mostrarProgreso() {
        progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("Cargando información....");
        progressDialog.setCancelable(false);
        progressDialog.show();
    }

    @Override
    public void ocultarProfreso() {
        progressDialog.dismiss();
    }

    @Override
    public void agregarMascota(Mascota mascota) {
        mascotaAdapter.agregarMascota(mascota);
    }

    @Override
    public void listarMascotas(List<Mascota> listaMascotas) {
        mascotaAdapter.agregarListaMascotas(listaMascotas);
    }


    @Override
    public void onClick(View v) {
        //Se ejecuta al dar click en el floatActionButton para crear mascota

        presentadorMascota.agregarMascota();

    }

    @Override
    public void myClick(int action, Mascota mascota,int posicionMascota) {
        switch (action){
            case Constantes.ACCION_BORRAR_MASCOTA:
                mascotaAdapter.borrarMascota(mascota);
                break;
                case Constantes.ACCION_GUARDAR_MASCOTA:
                    FirebaseHelper.getFirebaseDB().child(Constantes.RAMA_MASCOTAS).push().setValue(mascota);
                    break;
        }
    }
}
