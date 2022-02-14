package com.waires.Waires.web.controller;

import com.waires.Waires.domain.dto.EmployeeDTO;
import com.waires.Waires.domain.service.IEmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final IEmployeeService employService;

    public EmployeeController(IEmployeeService employService) {
        this.employService = employService;
    }


    @GetMapping("/{cedula}")
    public ResponseEntity<EmployeeDTO> getEmployById(@PathVariable ("cedula") String cedula){
        return new ResponseEntity(employService.getEmployById(cedula), HttpStatus.OK);
    }

    @GetMapping("/employees")
    public ResponseEntity<List<EmployeeDTO>> getEmploys(){
        return new ResponseEntity(employService.getEmploys(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<EmployeeDTO> createEmploy(@RequestBody EmployeeDTO employDTO){
        return new ResponseEntity(employService.createEmploy(employDTO), HttpStatus.CREATED);
    }

    @PutMapping("/modified")
    public ResponseEntity<EmployeeDTO> modifiedEmploy(@RequestBody EmployeeDTO employDTO){
        return new ResponseEntity(employService.modifiedEmploy(employDTO), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{cedula}")
    public ResponseEntity<EmployeeDTO> deleteEmploy(@PathVariable("cedula") String cedula){
        return new ResponseEntity(employService.deleteEmploy(cedula), HttpStatus.OK);
    }
}
