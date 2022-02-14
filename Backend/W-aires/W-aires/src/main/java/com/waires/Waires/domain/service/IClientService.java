package com.waires.Waires.domain.service;

import com.waires.Waires.domain.dto.ClientDTO;
import java.util.List;

public interface IClientService {

    ClientDTO getClientById(String numDocumento);

    List<ClientDTO> getClients();

    ClientDTO createClient(ClientDTO clientDTO);

    ClientDTO modifiedClient(ClientDTO clientDTO);

    String deleteClient(String numDocumento);

}
