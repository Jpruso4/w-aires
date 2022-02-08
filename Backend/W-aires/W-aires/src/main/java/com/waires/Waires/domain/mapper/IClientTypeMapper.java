package com.waires.Waires.domain.mapper;

import com.waires.Waires.domain.dto.ClientTypeDTO;
import com.waires.Waires.persistence.entity.ClientType;

import java.util.List;

public interface IClientTypeMapper {

    ClientTypeDTO mapFromEntity(ClientType clientType);

    ClientType mapFromDTO(ClientTypeDTO clientTypeDTO);

    List<ClientTypeDTO> mapListClientType(List<ClientType> listClientType);
}
