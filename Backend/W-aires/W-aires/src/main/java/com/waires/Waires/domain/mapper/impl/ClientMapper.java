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
        clientDTO.setNumDocumento(client.getNumDocumento());
        clientDTO.setNombre(client.getNombre());
        clientDTO.setTelefono(client.getTelefono());
        clientDTO.setCelular(client.getCelular());
        clientDTO.setCorreo(client.getCorreo());
        clientDTO.setDireccion(client.getDireccion());
        clientDTO.setActivo(client.getActivo());
        clientDTO.setIdTipoCliente(client.getIdTipoCliente());
        clientDTO.setIdTipoDocumento(client.getIdTipoDocumento());
        return clientDTO;
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
