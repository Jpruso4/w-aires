package com.waires.Waires.persistence.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Data
@Document
public class Client {

    @Id
    private String id;
    private String name;
    private String phone;
    private String email;
    private String address;
    private String active;
    private String idClientType;

}
