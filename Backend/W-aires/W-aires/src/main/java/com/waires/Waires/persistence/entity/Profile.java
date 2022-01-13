package com.waires.Waires.persistence.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Data
@Document
public class Profile {

    @Id
    private String id;
    private String name;
    private String description;

}
