package com.waires.Waires.domain.service.impl;

import com.waires.Waires.domain.dto.ClientDTO;
import com.waires.Waires.domain.mapper.IClientMapper;
import com.waires.Waires.domain.service.IClientService;
import com.waires.Waires.persistence.entity.Client;
import com.waires.Waires.persistence.repository.IClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService implements IClientService {

    private final IClientMapper clientMapper;
    private final IClientRepository clientRepository;

    public ClientService(IClientMapper clientMapper, IClientRepository clientRepository) {
        this.clientMapper = clientMapper;
        this.clientRepository = clientRepository;
    }

    @Override
    public ClientDTO getClientById(String numDocumento) {
        Client client = clientRepository.findById(numDocumento).orElseThrow(() -> new RuntimeException("El cliente no fue encontrado"));
        return clientMapper.mapFromEntity(client);
    }

    @Override
    public List<ClientDTO> getClients() {
        List<Client> listClient = clientRepository.findAll();
        return clientMapper.mapListClient(listClient);
    }

    @Override
    public ClientDTO createClient(ClientDTO clientDTO) {
        Client client = clientMapper.mapFromDTO(clientDTO);
        return clientMapper.mapFromEntity(clientRepository.save(client));
    }

    @Override
    public ClientDTO modifiedClient(ClientDTO clientDTO) {
        Client client = clientMapper.mapFromDTO(clientDTO);
        clientRepository.findById(client.getNumDocumento()).orElseThrow(() -> new RuntimeException("El cliente no fue encontrado"));
        return clientMapper.mapFromEntity(clientRepository.save(client));
    }

    @Override
    public String deleteClient(String numDocumento) {
        clientRepository.findById(numDocumento).orElseThrow(() -> new RuntimeException("El cliente no fue encontrado"));
        clientRepository.deleteById(numDocumento);
        return "El cliente fue eliminado con exito";
    }

}
