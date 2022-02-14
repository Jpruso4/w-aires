package com.waires.Waires.web.controller;

import com.waires.Waires.domain.dto.ClientTypeDTO;
import com.waires.Waires.domain.service.IClientTypeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("clientType")
public class ClientTypeController {

    private final IClientTypeService iClientTypeService;

    public ClientTypeController(IClientTypeService iClientTypeService) {
        this.iClientTypeService = iClientTypeService;
    }

    @GetMapping("/clientsTypes")
    public ResponseEntity<List<ClientTypeDTO>> getProfiles(){
        return new ResponseEntity(iClientTypeService.getClientType(), HttpStatus.OK);
    }
}
