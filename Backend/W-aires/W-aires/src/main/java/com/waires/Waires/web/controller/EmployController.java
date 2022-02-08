package com.waires.Waires.web.controller;

import com.waires.Waires.domain.dto.EmployDTO;
import com.waires.Waires.domain.service.IEmployService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employ")
public class EmployController {

    private final IEmployService employService;

    public EmployController(IEmployService employService) {
        this.employService = employService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployDTO> getEmployById(@PathVariable ("id") String id){
        return new ResponseEntity(employService.getEmployById(id), HttpStatus.OK);
    }

    @GetMapping("/employs")
    public ResponseEntity<List<EmployDTO>> getEmploys(){
        return new ResponseEntity(employService.getEmploys(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<EmployDTO> createEmploy(@RequestBody EmployDTO employDTO){
        return new ResponseEntity(employService.createEmploy(employDTO), HttpStatus.CREATED);
    }

    @PutMapping("/modified")
    public ResponseEntity<EmployDTO> modifiedEmploy(@RequestBody EmployDTO employDTO){
        return new ResponseEntity(employService.modifiedEmploy(employDTO), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<EmployDTO> deleteEmploy(@PathVariable("id") String id){
        return new ResponseEntity(employService.deleteEmploy(id), HttpStatus.OK);
    }
}
