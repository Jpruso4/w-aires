package com.waires.Waires.domain.service;

import com.waires.Waires.domain.dto.ClientTypeDTO;

import java.util.List;

public interface IClientTypeService {
    
    ClientTypeDTO getClientTypeById(String id);

    List<ClientTypeDTO> getClientTypes();

    ClientTypeDTO createClientType(ClientTypeDTO clientTypeDTO);

    ClientTypeDTO modifiedClientType(ClientTypeDTO clientTypeDTO);

    String deleteClientType(String id);
}
