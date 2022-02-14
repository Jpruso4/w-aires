package com.waires.Waires.domain.dto;

import lombok.Data;

@Data
public class ReportInputDTO {

    private Integer idReporte;
    private Integer idServicio;
    private Integer idEquipo;
    private String observaciones;

}
