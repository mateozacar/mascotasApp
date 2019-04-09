package com.udem.proyecto.mascotaapp.servicio;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.udem.proyecto.mascotaapp.Constantes;
import com.udem.proyecto.mascotaapp.R;
import com.udem.proyecto.mascotaapp.modelos.Mascota;
import com.udem.proyecto.mascotaapp.modelos.Servicio;
import com.udem.proyecto.mascotaapp.servicio.adaptador.ServicioAdapter;
import com.udem.proyecto.mascotaapp.servicio.mvp.ContratoServicio;
import com.udem.proyecto.mascotaapp.servicio.mvp.PresentadorServicioImpl;

import java.util.List;


public class ListarServiciosFragment extends Fragment  implements ContratoServicio.VistaServicio, ActionClickServicio {
    private View view;
    private ServicioAdapter servicioAdapter;

    private RecyclerView recyclerView;
    private ProgressDialog progressDialog;
    private String mascotaSelecionada = "";
    private ContratoServicio.PresentadorServicio presentadorServicio;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_listar_servicios, container, false);
        presentadorServicio = new PresentadorServicioImpl(this);
        inicializarInterfazGrafica();
        inicializarAdaptador();
        presentadorServicio.listarServicios();
        return view;
    }

    private void inicializarInterfazGrafica(){
        recyclerView = view.findViewById(R.id.rvServicios);
    }
    private void inicializarAdaptador(){
        servicioAdapter = new ServicioAdapter(this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(servicioAdapter);
    }


    @Override
    public void mostrarProgreso() {
        progressDialog = new ProgressDialog(getContext());
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Cargando servicios....");
        progressDialog.show();
    }

    @Override
    public void ocultarProgreso() {
        progressDialog.dismiss();
    }

    @Override
    public void listarServicios(List<Servicio> listaServicios) {
        servicioAdapter.agregarListaServicios(listaServicios);
    }

    @Override
    public void listarMascotasParaAsignarAlServicio(List<Mascota> list) {
        dialogoSeleccionMascota(listMascotasToArrayMascotas(list)).show();
    }

    private String[] listMascotasToArrayMascotas(List<Mascota>listaMascota){
        String[] arrayNombreMascota = new String[listaMascota.size()];
        for(int i = 0; i < listaMascota.size();i++){
            arrayNombreMascota[i] = listaMascota.get(i).getNombre();
        }
        return arrayNombreMascota;
    }

    public AlertDialog dialogoSeleccionMascota(final String[] arrayNombreMascotas) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());


        builder.setTitle("Seleccionar mascota a asignar")
                .setSingleChoiceItems(arrayNombreMascotas, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mascotaSelecionada = arrayNombreMascotas[which];
                        Toast.makeText(
                                getActivity(),
                                "Servicio asignado a: " + arrayNombreMascotas[which],
                                Toast.LENGTH_SHORT)
                                .show();
                        dialog.dismiss();
                    }
                });

        return builder.create();
    }

    @Override
    public void myClick(int action, Servicio servicio, int posicionServicio) {
        switch (action){
            case Constantes.ACCION_ASIGNAR_SERVICIO:
                presentadorServicio.listarNombreMascotasParaAsignarAlServicio();
                break;
        }

    }
}
