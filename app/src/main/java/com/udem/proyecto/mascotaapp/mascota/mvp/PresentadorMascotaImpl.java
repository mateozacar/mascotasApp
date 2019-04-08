package com.udem.proyecto.mascotaapp.mascota.mvp;

import com.udem.proyecto.mascotaapp.GenericRepository;
import com.udem.proyecto.mascotaapp.modelos.Mascota;

import java.util.List;

public class PresentadorMascotaImpl implements ContratoMascota.PresentadorMascota {

    private ContratoMascota.VistaMascota vistaMascota;
    private ContratoMascota.RepositorioMascota repositorioMascota;
    public PresentadorMascotaImpl(ContratoMascota.VistaMascota vistaMascota){
        this.vistaMascota = vistaMascota;
        repositorioMascota = new RepositorioMascotaImpl();
    }
    @Override
    public void agregarMascota() {
        vistaMascota.agregarMascota(crearMascota());
    }

    private Mascota crearMascota(){
        String identificacion="";
        String nombre = "";
        String foto ="";
        String tipoMascota= "";
        String descripcion="";
        return new Mascota(identificacion,nombre,foto,tipoMascota,descripcion);
    }

    @Override
    public void listarMascotas() {
        vistaMascota.mostrarProgreso();
        repositorioMascota.consultarMascotas(new GenericRepository<List<Mascota>>() {
            @Override
            public void onRequestSuccess(List<Mascota> mascotas) {
                vistaMascota.listarMascotas(mascotas);
                vistaMascota.ocultarProfreso();
            }

            @Override
            public void onRequestFailure(String error) {

            }
        });
    }
}
