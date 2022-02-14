package com.waires.Waires.domain.dto;


import java.sql.Date;
import java.sql.Time;
import java.util.List;

public class ServiceOutputDTO {

    private Integer idServicio;
    private Integer idEmpleado;
    private String nombreEmpleado;
    private String celularEmpleado;
    private Integer idCliente;
    private String nombreCliente;
    private String celularCliente;
    private List<ActivitiesTypeDTO> activitiesTypeList;
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

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public String getCelularEmpleado() {
        return celularEmpleado;
    }

    public void setCelularEmpleado(String celularEmpleado) {
        this.celularEmpleado = celularEmpleado;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getCelularCliente() {
        return celularCliente;
    }

    public void setCelularCliente(String celularCliente) {
        this.celularCliente = celularCliente;
    }

    public List<ActivitiesTypeDTO> getActivitiesTypeList() {
        return activitiesTypeList;
    }

    public void setActivitiesTypeList(List<ActivitiesTypeDTO> activitiesTypeList) {
        this.activitiesTypeList = activitiesTypeList;
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
