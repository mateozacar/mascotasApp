package com.udem.proyecto.mascotaapp.servicio.mvp;

import com.udem.proyecto.mascotaapp.GenericRepository;
import com.udem.proyecto.mascotaapp.modelos.Servicio;

import java.util.List;

public interface ContratoServicio {

    interface VistaServicio{
        void mostrarProgreso();
        void ocultarProgreso();
        void listarServicios(List<Servicio>listaServicios);
    }
    interface  PresentadorServicio{
        void listarServicios();

    }
    interface RepositorioServicio{
        void listarServicios(GenericRepository<List<Servicio>> servicioResponse);
    }
}
