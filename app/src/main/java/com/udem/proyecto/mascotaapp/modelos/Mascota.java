package com.udem.proyecto.mascotaapp.modelos;

public class Mascota {
    private String identificacion;
    private String nombre;
    private String foto;
    private String tipoMascota;
    private String descripcion;

    public Mascota() {
    }

    public Mascota(String identificacion, String nombre, String foto, String tipoMascota, String descripcion) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.foto = foto;
        this.tipoMascota = tipoMascota;
        this.descripcion = descripcion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public void setTipoMascota(String tipoMascota) {
        this.tipoMascota = tipoMascota;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getFoto() {
        return foto;
    }

    public String getTipoMascota() {
        return tipoMascota;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
