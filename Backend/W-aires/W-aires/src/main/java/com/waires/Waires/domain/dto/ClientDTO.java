package com.waires.Waires.domain.dto;


public class ClientDTO {

    private String numDocumento;
    private String nombre;
    private String telefono;
    private String celular;
    private String correo;
    private String direccion;
    private Character activo;
    private String idTipoCliente;
    private String idTipoDocumento;

    public String getNumDocumento() {
        return numDocumento;
    }

    public void setNumDocumento(String numDocumento) {
        this.numDocumento = numDocumento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Character getActivo() {
        return activo;
    }

    public void setActivo(Character activo) {
        this.activo = activo;
    }

    public String getIdTipoCliente() {
        return idTipoCliente;
    }

    public void setIdTipoCliente(String idTipoCliente) {
        this.idTipoCliente = idTipoCliente;
    }

    public String getIdTipoDocumento() {
        return idTipoDocumento;
    }

    public void setIdTipoDocumento(String idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
    }
}
