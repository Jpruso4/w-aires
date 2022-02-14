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
        ClientDTO clientInputDTO = new ClientDTO();
        clientInputDTO.setNumDocumento(client.getNumDocumento());
        clientInputDTO.setNombre(client.getNombre());
        clientInputDTO.setTelefono(client.getTelefono());
        clientInputDTO.setCelular(client.getCelular());
        clientInputDTO.setCorreo(client.getCorreo());
        clientInputDTO.setDireccion(client.getDireccion());
        clientInputDTO.setActivo(client.getActivo());
        clientInputDTO.setIdTipoCliente(client.getIdTipoCliente());
        clientInputDTO.setIdTipoDocumento(client.getIdTipoDocumento());
        return clientInputDTO;
    }

    @Override
    public Client mapFromDTO(ClientDTO clientInputDTO) {
        Client client = new Client();
        client.setNumDocumento(clientInputDTO.getNumDocumento());
        client.setNombre(clientInputDTO.getNombre());
        client.setTelefono(clientInputDTO.getTelefono());
        client.setCelular(clientInputDTO.getCelular());
        client.setCorreo(clientInputDTO.getCorreo());
        client.setDireccion(clientInputDTO.getDireccion());
        client.setActivo(clientInputDTO.getActivo());
        client.setIdTipoCliente(clientInputDTO.getIdTipoCliente());
        client.setIdTipoDocumento(clientInputDTO.getIdTipoDocumento());
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
