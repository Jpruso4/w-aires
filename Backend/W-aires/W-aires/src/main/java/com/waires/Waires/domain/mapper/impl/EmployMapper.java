package com.waires.Waires.domain.mapper.impl;

import com.waires.Waires.domain.dto.EmployDTO;
import com.waires.Waires.domain.mapper.IEmployMapper;
import com.waires.Waires.persistence.entity.Employ;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class EmployMapper implements IEmployMapper {

    @Override
    public EmployDTO mapFromEntity(Employ employ) {
        EmployDTO employDTO = new EmployDTO();
        employDTO.setId(employ.getId());
        employDTO.setName(employ.getName());
        employDTO.setDocument(employ.getDocument());
        employDTO.setPhone(employ.getPhone());
        employDTO.setEmail(employ.getEmail());
        employDTO.setUser(employ.getUser());
        employDTO.setPassword(employ.getPassword());
        employDTO.setActive(employ.isActive());
        employDTO.setIdProfile(employ.getIdProfile());
        return employDTO;
    }

    @Override
    public Employ mapFromDTO(EmployDTO employDTO) {
        Employ employ = new Employ();
        employ.setId(employDTO.getId());
        employ.setName(employDTO.getName());
        employ.setDocument(employDTO.getDocument());
        employ.setPhone(employDTO.getPhone());
        employ.setEmail(employDTO.getEmail());
        employ.setUser(employDTO.getUser());
        employ.setPassword(employDTO.getPassword());
        employ.setActive(employDTO.isActive());
        employ.setIdProfile(employDTO.getIdProfile());
        return employ;
    }

    @Override
    public List<EmployDTO> mapListEmploys(List<Employ> listEmploys) {
        List<EmployDTO> listEmploysDTO = new LinkedList<>();
        for (Employ employ : listEmploys) {
            listEmploysDTO.add(mapFromEntity(employ));
        }
        return listEmploysDTO;
    }
}
