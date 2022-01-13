package com.waires.Waires.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployDTO {

    private String id;
    private String name;
    private String document;
    private String phone;
    private String email;
    private String user;
    private String password;
    private boolean active;
    private String idProfile;

}
