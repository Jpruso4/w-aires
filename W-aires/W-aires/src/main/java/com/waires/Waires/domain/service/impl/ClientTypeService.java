package com.waires.Waires.domain.service.impl;

import com.waires.Waires.domain.dto.ClientTypeDTO;
import com.waires.Waires.domain.mapper.IClientTypeMapper;
import com.waires.Waires.domain.service.IClientTypeService;
import com.waires.Waires.persistence.repository.IClientTypeRepository;
import com.waires.Waires.persistence.repository.IProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientTypeService implements IClientTypeService {

    private final IClientTypeMapper clientTypeMapper;
    private final IClientTypeRepository clientTypeRepository;

    public ClientTypeService(IClientTypeMapper clientTypeMapper, IClientTypeRepository clientTypeRepository) {
        this.clientTypeMapper = clientTypeMapper;
        this.clientTypeRepository = clientTypeRepository;
    }

    @Override
    public List<ClientTypeDTO> getClientType() {
        return clientTypeMapper.mapListClientType(clientTypeRepository.findAll());
    }

}
