package com.waires.Waires.domain.dto;


import java.sql.Time;
import java.sql.Date;

public class ServiceInputDTO {

    private Integer idServicio;
    private Integer idEmpleado;
    private Integer idCliente;
    private Integer idActtividad;
    private Date fecha;
    private Character realizado;
    private Time tiempoEstimado;
    private Time tiempoUtilizado;

    public Integer getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Integer idServicio) {
        this.idServicio = idServicio;
    }

    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getIdActtividad() {
        return idActtividad;
    }

    public void setIdActtividad(Integer idActtividad) {
        this.idActtividad = idActtividad;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Character getRealizado() {
        return realizado;
    }

    public void setRealizado(Character realizado) {
        this.realizado = realizado;
    }

    public Time getTiempoEstimado() {
        return tiempoEstimado;
    }

    public void setTiempoEstimado(Time tiempoEstimado) {
        this.tiempoEstimado = tiempoEstimado;
    }

    public Time getTiempoUtilizado() {
        return tiempoUtilizado;
    }

    public void setTiempoUtilizado(Time tiempoUtilizado) {
        this.tiempoUtilizado = tiempoUtilizado;
    }
}
