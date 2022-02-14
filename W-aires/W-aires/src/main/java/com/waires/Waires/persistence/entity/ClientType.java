package com.waires.Waires.persistence.entity;

import javax.persistence.*;


@Entity
@Table(name = "tipo_cliente")
public class ClientType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_cliente")
    private Integer idTipoCliente;

    @Column(name = "nombre_tipo_cliente")
    private String nombreTipoCliente;

    public Integer getIdTipoCliente() {
        return idTipoCliente;
    }

    public void setIdTipoCliente(Integer idTipoCliente) {
        this.idTipoCliente = idTipoCliente;
    }

    public String getNombreTipoCliente() {
        return nombreTipoCliente;
    }

    public void setNombreTipoCliente(String nombreTipoCliente) {
        this.nombreTipoCliente = nombreTipoCliente;
    }
}
