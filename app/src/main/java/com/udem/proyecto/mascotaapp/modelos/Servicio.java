package com.udem.proyecto.mascotaapp.modelos;

import java.util.List;

public class Servicio {

    private String identificacion;
    private String nombreServicio;
    private String descripcion;
    private String tipoServicio;

    public Servicio() {
    }

    public Servicio(String identificacion, String nombreServicio, String descripcion, String tipoServicio) {
        this.identificacion = identificacion;
        this.nombreServicio = nombreServicio;
        this.descripcion = descripcion;
        this.tipoServicio = tipoServicio;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombreServicio() {
        return nombreServicio;
    }

    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }
}