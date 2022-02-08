package com.waires.Waires.domain.service;

import com.waires.Waires.domain.dto.EmployDTO;

import java.util.List;

public interface IEmployService {
    
    EmployDTO getEmployById(String id);

    List<EmployDTO> getEmploys();

    EmployDTO createEmploy(EmployDTO employDTO);

    EmployDTO modifiedEmploy(EmployDTO employDTO);

    String deleteEmploy(String id);
}
