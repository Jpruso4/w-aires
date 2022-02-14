package com.waires.Waires.domain.dto;


import java.sql.Date;
import java.sql.Time;
import java.util.List;
import lombok.Data;

@Data
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

}
