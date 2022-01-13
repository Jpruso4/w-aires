package com.waires.Waires.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientDTO {

    private String id;
    private String name;
    private String phone;
    private String email;
    private String address;
    private boolean active;
    private String idClientType;

}
