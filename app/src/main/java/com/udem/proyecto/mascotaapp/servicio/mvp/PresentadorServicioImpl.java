package com.udem.proyecto.mascotaapp.servicio.mvp;

import com.udem.proyecto.mascotaapp.GenericRepository;
import com.udem.proyecto.mascotaapp.modelos.Servicio;

import java.util.List;

public class PresentadorServicioImpl implements ContratoServicio.PresentadorServicio {


    private ContratoServicio.VistaServicio vistaServicio;
    private ContratoServicio.RepositorioServicio repositorioServicio;

    public PresentadorServicioImpl(ContratoServicio.VistaServicio vistaServicio){
        this.vistaServicio = vistaServicio;
        repositorioServicio = new RespositorioServicioImpl();
    }

    @Override
    public void listarServicios() {
        vistaServicio.mostrarProgreso();
        repositorioServicio.listarServicios(new GenericRepository<List<Servicio>>() {
            @Override
            public void onRequestSuccess(List<Servicio> servicios) {
                vistaServicio.listarServicios(servicios);
                vistaServicio.ocultarProgreso();
            }

            @Override
            public void onRequestFailure(String error) {

            }
        });
    }
}
