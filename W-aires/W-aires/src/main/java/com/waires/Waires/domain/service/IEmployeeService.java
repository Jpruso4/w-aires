package com.waires.Waires.domain.service;

import com.waires.Waires.domain.dto.EmployeeDTO;

import java.util.List;

public interface IEmployeeService {
    
    EmployeeDTO getEmployById(String cedula);

    List<EmployeeDTO> getEmploys();

    EmployeeDTO createEmploy(EmployeeDTO employDTO);

    EmployeeDTO modifiedEmploy(EmployeeDTO employDTO);

    String deleteEmploy(String cedula);
}
