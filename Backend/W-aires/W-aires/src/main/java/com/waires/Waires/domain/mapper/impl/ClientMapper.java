package com.waires.Waires.domain.mapper.impl;

import com.waires.Waires.domain.dto.ClientDTO;
import com.waires.Waires.domain.mapper.IClientMapper;
import com.waires.Waires.persistence.entity.Client;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class ClientMapper implements IClientMapper {

    @Override
    public ClientDTO mapFromEntity(Client client) {
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setId(client.getId());
        clientDTO.setName(client.getName());
        clientDTO.setPhone(client.getPhone());
        clientDTO.setEmail(client.getEmail());
        clientDTO.setAddress(client.getAddress());
        clientDTO.setActive(client.getActive());
        clientDTO.setIdClientType(client.getIdClientType());
        return clientDTO;
    }

    @Override
    public Client mapFromDTO(ClientDTO clientDTO) {
        Client client = new Client();
        client.setId(clientDTO.getId());
        client.setName(clientDTO.getName());
        client.setPhone(clientDTO.getPhone());
        client.setEmail(clientDTO.getEmail());
        client.setAddress(clientDTO.getAddress());
        client.setActive(clientDTO.getActive());
        client.setIdClientType(clientDTO.getIdClientType());
        return client;
    }

    @Override
    public List<ClientDTO> mapListClient(List<Client> listClient) {
        List<ClientDTO> listClientDTO = new LinkedList<>();
        for (Client client : listClient){
            listClientDTO.add(mapFromEntity(client));
        }
        return listClientDTO;
    }


}
