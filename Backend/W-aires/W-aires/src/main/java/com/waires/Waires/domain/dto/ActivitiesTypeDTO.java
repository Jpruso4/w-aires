package com.waires.Waires.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActivitiesTypeDTO {

    private String idActivity;
    private String name;
    private String description;
    private boolean activo;

}
