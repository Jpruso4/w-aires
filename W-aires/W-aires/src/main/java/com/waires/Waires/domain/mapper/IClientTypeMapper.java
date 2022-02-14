package com.waires.Waires.domain.mapper;


import com.waires.Waires.domain.dto.ClientTypeDTO;
import com.waires.Waires.persistence.entity.ClientType;

import java.util.List;

public interface IClientTypeMapper {

    ClientTypeDTO mapFromEntity(ClientType client);

    List<ClientTypeDTO> mapListClientType(List<ClientType> listClient);

}
