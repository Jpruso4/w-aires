package com.waires.Waires.domain.mapper;


import com.waires.Waires.domain.dto.EmployeeDTO;
import com.waires.Waires.persistence.entity.Employee;

import java.util.List;

public interface IEmployeeMapper {

    EmployeeDTO mapFromEntity(Employee employee);

    Employee mapFromDTO(EmployeeDTO employDTO);

    List<EmployeeDTO> mapListEmployees(List<Employee> listEmployee);
}
