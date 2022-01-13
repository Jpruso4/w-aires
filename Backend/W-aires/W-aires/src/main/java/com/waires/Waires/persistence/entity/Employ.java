package com.waires.Waires.persistence.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Data
@Document
public class Employ {

    @Id
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
