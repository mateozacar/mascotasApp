package com.udem.proyecto.mascotaapp.mascota.mvp;

import com.udem.proyecto.mascotaapp.GenericRepository;
import com.udem.proyecto.mascotaapp.modelos.Mascota;

import java.util.List;

public interface ContratoMascota {
    public interface VistaMascota{
        void mostrarProgreso();
        void ocultarProfreso();
        void agregarMascota(Mascota mascota);
        void listarMascotas(List<Mascota> listaMascotas);
    }
    public interface PresentadorMascota{
        void agregarMascota();
        void listarMascotas();
    }
    public interface RepositorioMascota{
        void consultarMascotas(GenericRepository<List<Mascota>> mascotaResponse);
    }
}
