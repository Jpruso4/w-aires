package com.waires.Waires.domain.service.impl;

import com.waires.Waires.domain.dto.EmployDTO;
import com.waires.Waires.domain.mapper.IEmployMapper;
import com.waires.Waires.domain.service.IEmployService;
import com.waires.Waires.persistence.entity.Employ;
import com.waires.Waires.persistence.repository.IEmployRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployService implements IEmployService {

    private final IEmployMapper employMapper;
    private final IEmployRepository employRepository;

    public EmployService(IEmployMapper employMapper, IEmployRepository employRepository) {
        this.employMapper = employMapper;
        this.employRepository = employRepository;
    }

    public EmployDTO getEmployById(String id) {
        Employ employ = employRepository.findById(id).orElseThrow(() -> new RuntimeException("El id del empleado no fue encontrado"));
        return employMapper.mapFromEntity(employ);
    }

    @Override
    public List<EmployDTO> getEmploys() {
        return employMapper.mapListEmploys(employRepository.findAll());
    }

    @Override
    public EmployDTO createEmploy(EmployDTO employDTO) {
        return employMapper.mapFromEntity(employRepository.save(employMapper.mapFromDTO(employDTO)));
    }

    @Override
    public EmployDTO modifiedEmploy(EmployDTO employDTO) {
        Employ employ = employMapper.mapFromDTO(employDTO);
        employRepository.findById(employ.getId()).orElseThrow(() -> new RuntimeException("El id del empleado no existe"));
        return employMapper.mapFromEntity(employRepository.save(employ));
    }

    @Override
    public String deleteEmploy(String id) {
        employRepository.findById(id).orElseThrow(() -> new RuntimeException("El id del empleado no existe"));
        employRepository.deleteById(id);
        return "El empleado fue eliminado con exito";
    }
}
