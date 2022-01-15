package com.waires.Waires.web.controller;

import com.waires.Waires.domain.dto.ClientTypeDTO;
import com.waires.Waires.domain.service.IClientTypeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("clientType")
public class ClientTypeController {

    private final IClientTypeService clientTypeService;

    public ClientTypeController(IClientTypeService clientTypeService) {
        this.clientTypeService = clientTypeService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientTypeDTO> getClientById(@PathVariable("id") String id){
        return new ResponseEntity(clientTypeService.getClientTypeById(id), HttpStatus.OK);
    }

    @GetMapping("/clientTypes")
    public ResponseEntity<List<ClientTypeDTO>> getClientTypes(){
        return new ResponseEntity(clientTypeService.getClientTypes(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ClientTypeDTO> createClientType(@RequestBody ClientTypeDTO clientTypeDTO){
        return new ResponseEntity(clientTypeService.createClientType(clientTypeDTO), HttpStatus.CREATED);
    }

    @PutMapping("/modified")
    public ResponseEntity<ClientTypeDTO> modifiedClientType(@RequestBody ClientTypeDTO clientTypeDTO){
        return new ResponseEntity(clientTypeService.modifiedClientType(clientTypeDTO), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ClientTypeDTO> deleteClientType(@PathVariable("id") String id){
        return new ResponseEntity(clientTypeService.deleteClientType(id), HttpStatus.OK);
    }
}
