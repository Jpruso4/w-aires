package com.waires.Waires.persistence.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.time.LocalDate;

@Data
@Document
public class Service {

    @Id
    private String id;
    private String idEmploy;
    private String idClient;
    private String idActivity;
    private LocalDate date;
    private boolean completed;
    private int timeEstimated;
    private int timeSpent;

}
