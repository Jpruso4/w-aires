package com.waires.Waires.domain.dto;

public class ReportInputDTO {

    private Integer idReporte;
    private Integer idServicio;
    private Integer idEquipo;
    private String observaciones;


    public Integer getIdReporte() {
        return idReporte;
    }

    public void setIdReporte(Integer idReporte) {
        this.idReporte = idReporte;
    }

    public Integer getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Integer idServicio) {
        this.idServicio = idServicio;
    }

    public Integer getIdEquipo() { return idEquipo; }

    public void setIdEquipo(Integer idEquipo) { this.idEquipo = idEquipo; }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

}
