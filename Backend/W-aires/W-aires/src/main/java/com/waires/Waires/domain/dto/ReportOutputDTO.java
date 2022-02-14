package com.waires.Waires.domain.dto;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

public class ReportOutputDTO {

    private Integer idReporte;
    private Integer idServicio;
    private Integer idEmpleado;
    private String nombreEmpleado;
    private String celularEmpleado;
    private Integer idCliente;
    private String nombreCliente;
    private String celularCliente;
    private List<ActivitiesTypeDTO> activitiesTypeList;
    private Integer idEquipo;
    private String ubicacion;
    private Integer idTipoEquipo;
    private String tipoEquipo;
    private Integer idMarca;
    private String nombreMarca;
    private Integer idTipoRefrigerante;
    private String refrigerante;
    private Integer idCapacidadEquipo;
    private String capacidad;
    private String voltaje;
    private String ammperaje;
    private String tempAmbiente;
    private String tempSalida;
    private String ammperajel1;
    private String ammperajel2;
    private String ammperajel3;
    private String voltajel1_l2;
    private String voltajel2_l3;
    private String voltajel1_l3;
    private String presionCondesadora;
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

    public Integer getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(Integer idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Integer getIdTipoEquipo() {
        return idTipoEquipo;
    }

    public void setIdTipoEquipo(Integer idTipoEquipo) {
        this.idTipoEquipo = idTipoEquipo;
    }

    public String getTipoEquipo() {
        return tipoEquipo;
    }

    public void setTipoEquipo(String tipoEquipo) {
        this.tipoEquipo = tipoEquipo;
    }

    public Integer getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(Integer idMarca) {
        this.idMarca = idMarca;
    }

    public String getNombreMarca() {
        return nombreMarca;
    }

    public void setNombreMarca(String nombreMarca) {
        this.nombreMarca = nombreMarca;
    }

    public Integer getIdTipoRefrigerante() {
        return idTipoRefrigerante;
    }

    public void setIdTipoRefrigerante(Integer idTipoRefrigerante) {
        this.idTipoRefrigerante = idTipoRefrigerante;
    }

    public String getRefrigerante() {
        return refrigerante;
    }

    public void setRefrigerante(String refrigerante) {
        this.refrigerante = refrigerante;
    }

    public Integer getIdCapacidadEquipo() {
        return idCapacidadEquipo;
    }

    public void setIdCapacidadEquipo(Integer idCapacidadEquipo) {
        this.idCapacidadEquipo = idCapacidadEquipo;
    }

    public String getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(String capacidad) {
        this.capacidad = capacidad;
    }

    public String getVoltaje() {
        return voltaje;
    }

    public void setVoltaje(String voltaje) {
        this.voltaje = voltaje;
    }

    public String getAmmperaje() {
        return ammperaje;
    }

    public void setAmmperaje(String ammperaje) {
        this.ammperaje = ammperaje;
    }

    public String getTempAmbiente() {
        return tempAmbiente;
    }

    public void setTempAmbiente(String tempAmbiente) {
        this.tempAmbiente = tempAmbiente;
    }

    public String getTempSalida() {
        return tempSalida;
    }

    public void setTempSalida(String tempSalida) {
        this.tempSalida = tempSalida;
    }

    public String getAmmperajel1() {
        return ammperajel1;
    }

    public void setAmmperajel1(String ammperajel1) {
        this.ammperajel1 = ammperajel1;
    }

    public String getAmmperajel2() {
        return ammperajel2;
    }

    public void setAmmperajel2(String ammperajel2) {
        this.ammperajel2 = ammperajel2;
    }

    public String getAmmperajel3() {
        return ammperajel3;
    }

    public void setAmmperajel3(String ammperajel3) {
        this.ammperajel3 = ammperajel3;
    }

    public String getVoltajel1_l2() {
        return voltajel1_l2;
    }

    public void setVoltajel1_l2(String voltajel1_l2) {
        this.voltajel1_l2 = voltajel1_l2;
    }

    public String getVoltajel2_l3() {
        return voltajel2_l3;
    }

    public void setVoltajel2_l3(String voltajel2_l3) {
        this.voltajel2_l3 = voltajel2_l3;
    }

    public String getVoltajel1_l3() {
        return voltajel1_l3;
    }

    public void setVoltajel1_l3(String voltajel1_l3) {
        this.voltajel1_l3 = voltajel1_l3;
    }

    public String getPresionCondesadora() {
        return presionCondesadora;
    }

    public void setPresionCondesadora(String presionCondesadora) {
        this.presionCondesadora = presionCondesadora;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}
