package com.waires.Waires.domain.service.impl;

import com.waires.Waires.domain.dto.ClientTypeDTO;
import com.waires.Waires.domain.mapper.IClientTypeMapper;
import com.waires.Waires.domain.service.IClientTypeService;
import com.waires.Waires.persistence.entity.ClientType;
import com.waires.Waires.persistence.repository.IClientTypeRepository;
import org.springframework.stereotype.Service;

import java.awt.image.renderable.RenderableImage;
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
    public ClientTypeDTO getClientTypeById(String id) {
        ClientType clientType = clientTypeRepository.findById(id).orElseThrow(() -> new RuntimeException("El tipo de cliente no fue encontrado"));
        return clientTypeMapper.mapFromEntity(clientType);
    }

    @Override
    public List<ClientTypeDTO> getClientTypes() {
        return clientTypeMapper.mapListClientType(clientTypeRepository.findAll());
    }

    @Override
    public ClientTypeDTO createClientType(ClientTypeDTO clientTypeDTO) {
        ClientType clientType = clientTypeMapper.mapFromDTO(clientTypeDTO);
        return clientTypeMapper.mapFromEntity(clientTypeRepository.save(clientType));
    }

    @Override
    public ClientTypeDTO modifiedClientType(ClientTypeDTO clientTypeDTO) {
        ClientType clientType = clientTypeMapper.mapFromDTO(clientTypeDTO);
        clientTypeRepository.findById(clientType.getId()).orElseThrow(() -> new RuntimeException("El tipo de cliente no existe"));
        return clientTypeMapper.mapFromEntity(clientTypeRepository.save(clientType));
    }

    @Override
    public String deleteClientType(String id) {
        clientTypeRepository.findById(id).orElseThrow(() -> new RuntimeException("El tipo de cliente no existe"));
        clientTypeRepository.deleteById(id);
        return "El tipo de cliente fue eliminado con exito";
    }
}
