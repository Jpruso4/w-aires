package com.waires.Waires.domain.mapper;

import com.waires.Waires.domain.dto.EmployDTO;
import com.waires.Waires.persistence.entity.Employ;

import java.util.List;

public interface IEmployMapper {

    EmployDTO mapFromEntity(Employ employ);

    Employ mapFromDTO(EmployDTO employDTO);

    List<EmployDTO> mapListEmploys(List<Employ> listEmploys);
}
