package com.waires.Waires.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "clientes")
public class Client {

    @Id
    @Column(name = "num_documento")
    private String numDocumento;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "celular")
    private String celular;

    @Column(name = "correo")
    private String correo;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "activo")
    private Character activo;

    @Column(name = "id_tipo_cliente_fk")
    private String idTipoCliente;

    @Column(name = "id_tipo_documento_fk")
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
