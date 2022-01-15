package com.waires.Waires.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Data
@Document
@AllArgsConstructor
public class ClientType {

    @Id
    private String id;
    private String name;

}
