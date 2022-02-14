package com.waires.Waires.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "empleados")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cedula")
    private String cedula;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "celular")
    private String celular;

    @Column(name = "correo")
    private String correo;

    @Column(name = "contraseña")
    private String contraseña;

    @Column(name = "activo")
    private Character activo;

    @Column(name = "id_perfil_fk")
    private String idPerfil;

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public Character getActivo() {
        return activo;
    }

    public void setActivo(Character activo) {
        this.activo = activo;
    }

    public String getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(String idPerfil) {
        this.idPerfil = idPerfil;
    }
}
