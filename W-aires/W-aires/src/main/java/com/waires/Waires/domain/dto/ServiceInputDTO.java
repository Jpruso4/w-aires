package com.waires.Waires.domain.dto;


import java.sql.Time;
import java.sql.Date;
import lombok.Data;

@Data
public class ServiceInputDTO {

    private Integer idServicio;
    private Integer idEmpleado;
    private Integer idCliente;
    private Integer idActtividad;
    private Date fecha;
    private Character realizado;
    private Time tiempoEstimado;
    private Time tiempoUtilizado;

}
