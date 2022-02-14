package com.waires.Waires.domain.mapper.impl;


import com.waires.Waires.domain.dto.EmployeeDTO;
import com.waires.Waires.domain.mapper.IEmployeeMapper;
import com.waires.Waires.persistence.entity.Employee;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class EmployeeMapper implements IEmployeeMapper {


    @Override
    public EmployeeDTO mapFromEntity(Employee employee) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setCedula(employee.getCedula());
        employeeDTO.setNombre(employee.getNombre());
        employeeDTO.setCelular(employee.getCelular());
        employeeDTO.setCorreo(employee.getCorreo());
        employeeDTO.setContraseña(employee.getContraseña());
        employeeDTO.setActivo(employee.getActivo());
        employeeDTO.setPerfil(employee.getIdPerfil());
        return employeeDTO;
    }

    @Override
    public Employee mapFromDTO(EmployeeDTO employDTO) {
        Employee employee = new Employee();
        employee.setCedula(employDTO.getCedula());
        employee.setNombre(employDTO.getNombre());
        employee.setCelular(employDTO.getCelular());
        employee.setCorreo(employDTO.getCorreo());
        employee.setContraseña(employDTO.getContraseña());
        employee.setActivo(employDTO.getActivo());
        employee.setIdPerfil(employDTO.getPerfil());
        return employee;
    }

    @Override
    public List<EmployeeDTO> mapListEmployees(List<Employee> listEmployee) {
        List<EmployeeDTO> list = new LinkedList<>();
        for (Employee employee : listEmployee) {
            list.add(mapFromEntity(employee));
        }
        return list;
    }
}
