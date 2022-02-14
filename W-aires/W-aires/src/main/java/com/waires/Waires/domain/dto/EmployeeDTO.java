package com.waires.Waires.domain.dto;

import lombok.Data;

@Data
public class EmployeeDTO {

    private String cedula;
    private String nombre;
    private String celular;
    private String correo;
    private String contraseña;
    private Character activo;
    private String perfil;

}
