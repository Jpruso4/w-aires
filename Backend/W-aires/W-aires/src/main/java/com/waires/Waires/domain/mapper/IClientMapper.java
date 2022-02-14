package com.waires.Waires.domain.mapper;

import com.waires.Waires.domain.dto.ClientDTO;
import com.waires.Waires.persistence.entity.Client;

import java.util.List;

public interface IClientMapper {

    ClientDTO mapFromEntity(Client client);

    Client mapFromDTO(ClientDTO clientDTO);

    List<ClientDTO> mapListClient(List<Client> listClient);

}
