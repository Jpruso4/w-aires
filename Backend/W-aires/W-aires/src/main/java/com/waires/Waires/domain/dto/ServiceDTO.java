package com.waires.Waires.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServiceDTO {

    private String id;
    private String idEmploy;
    private String idClient;
    private String idActivity;
    private LocalDate date;
    private boolean completed;
    private int timeEstimated;
    private int timeSpent;

}
