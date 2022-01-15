package com.waires.Waires.domain.mapper.impl;

import com.waires.Waires.domain.dto.ClientTypeDTO;
import com.waires.Waires.domain.mapper.IClientTypeMapper;
import com.waires.Waires.persistence.entity.ClientType;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class ClientTypeMapper implements IClientTypeMapper {
    @Override
    public ClientTypeDTO mapFromEntity(ClientType clientType) {
        return new ClientTypeDTO(clientType.getId(), clientType.getName());
    }

    @Override
    public ClientType mapFromDTO(ClientTypeDTO clientTypeDTO) {
        return new ClientType(clientTypeDTO.getId(), clientTypeDTO.getName());
    }

    @Override
    public List<ClientTypeDTO> mapListClientType(List<ClientType> listClientType) {
        List<ClientTypeDTO> listClientDTO = new LinkedList<>();
        for(ClientType clientType : listClientType)
            listClientDTO.add(mapFromEntity(clientType));
        return listClientDTO;
    }
}
