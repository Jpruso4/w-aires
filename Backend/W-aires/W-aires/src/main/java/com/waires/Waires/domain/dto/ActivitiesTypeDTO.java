package com.waires.Waires.domain.dto;

public class ActivitiesTypeDTO {

    private Integer idActividad;
    private String nombreActividad;
    private String descripcion;
    private Character activo;

    public Integer getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(Integer idActividad) {
        this.idActividad = idActividad;
    }

    public String getNombreActividad() {
        return nombreActividad;
    }

    public void setNombreActividad(String nombreActividad) {
        this.nombreActividad = nombreActividad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Character getActivo() {
        return activo;
    }

    public void setActivo(Character activo) {
        this.activo = activo;
    }
}
