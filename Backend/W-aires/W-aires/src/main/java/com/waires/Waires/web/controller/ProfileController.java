package com.waires.Waires.web.controller;

import com.waires.Waires.domain.dto.ProfileDTO;
import com.waires.Waires.domain.service.IProfileService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("profile")
public class ProfileController {

    private final IProfileService profileService;

    public ProfileController(IProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfileDTO> getProfileById(@PathVariable("id") String id){
        return new ResponseEntity(profileService.getProfileById(id), HttpStatus.OK);
    }

    @GetMapping("/profiles")
    public ResponseEntity<List<ProfileDTO>> getProfiles(){
        return new ResponseEntity(profileService.getProfiles(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ProfileDTO> createProfile(@RequestBody ProfileDTO profileDTO){
        return new ResponseEntity(profileService.createProfile(profileDTO), HttpStatus.CREATED);
    }

    @PutMapping("/modified")
    public ResponseEntity<ProfileDTO> modifiedProfile(@RequestBody ProfileDTO profileDTO){
        return new ResponseEntity(profileService.modifiedProfile(profileDTO), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ProfileDTO> deleteProfile(@PathVariable("id") String id){
        return new ResponseEntity(profileService.deleteProfile(id), HttpStatus.OK);
    }
}
