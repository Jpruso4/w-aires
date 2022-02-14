package com.waires.Waires.web.controller;

import com.waires.Waires.domain.dto.ClientDTO;
import com.waires.Waires.domain.service.IClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    private final IClientService  clientService;

    public ClientController(IClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/{numDocumento}")
    public ResponseEntity<ClientDTO> getClientById(@PathVariable("numDocumento") String numDocumento){
        return new ResponseEntity(clientService.getClientById(numDocumento), HttpStatus.OK);
    }

    @GetMapping("/clients")
    public ResponseEntity<List<ClientDTO>> getClients(){
        return new ResponseEntity(clientService.getClients(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ClientDTO> createClient(@RequestBody ClientDTO clientDTO){
        return new ResponseEntity(clientService.createClient(clientDTO), HttpStatus.CREATED);
    }

    @PutMapping("/modified")
    public ResponseEntity<ClientDTO> modifiedClient(@RequestBody ClientDTO clientDTO){
        return new ResponseEntity(clientService.modifiedClient(clientDTO), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{numDocumento}")
    public ResponseEntity<ClientDTO> deleteClient(@PathVariable("numDocumento") String numDocumento){
        return new ResponseEntity(clientService.deleteClient(numDocumento), HttpStatus.OK);
    }
}
