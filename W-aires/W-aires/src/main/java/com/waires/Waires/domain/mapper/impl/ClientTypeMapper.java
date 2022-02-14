package com.waires.Waires.domain.mapper.impl;


import com.waires.Waires.domain.dto.ClientDTO;
import com.waires.Waires.domain.dto.ClientTypeDTO;
import com.waires.Waires.domain.mapper.IClientMapper;
import com.waires.Waires.domain.mapper.IClientTypeMapper;
import com.waires.Waires.persistence.entity.Client;
import com.waires.Waires.persistence.entity.ClientType;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class ClientTypeMapper implements IClientTypeMapper {


    @Override
    public ClientTypeDTO mapFromEntity(ClientType client) {
        ClientTypeDTO clientTypeDTO = new ClientTypeDTO();
        clientTypeDTO.setIdTipoCliente(client.getIdTipoCliente());
        clientTypeDTO.setNombreTipoCliente(client.getNombreTipoCliente());
        return clientTypeDTO;
    }

    @Override
    public List<ClientTypeDTO> mapListClientType(List<ClientType> listClient) {
        List<ClientTypeDTO> listClientDTO = new LinkedList<>();
        for (ClientType client : listClient){
            listClientDTO.add(mapFromEntity(client));
        }
        return listClientDTO;
    }
}
