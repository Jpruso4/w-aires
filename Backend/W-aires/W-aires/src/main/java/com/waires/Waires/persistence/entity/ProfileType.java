package com.waires.Waires.persistence.entity;

import javax.persistence.*;


@Entity
@Table(name = "tipo_perfil")
public class ProfileType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_perfil")
    private Integer idPefil;

    @Column(name = "nombre_perfil")
    private String nombrePerfil;

    public Integer getIdPefil() {
        return idPefil;
    }

    public void setIdPefil(Integer idPefil) {
        this.idPefil = idPefil;
    }

    public String getNombrePerfil() {
        return nombrePerfil;
    }

    public void setNombrePerfil(String nombrePerfil) {
        this.nombrePerfil = nombrePerfil;
    }
}
