package com.waires.Waires.domain.dto;

import lombok.Data;

@Data
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

}
