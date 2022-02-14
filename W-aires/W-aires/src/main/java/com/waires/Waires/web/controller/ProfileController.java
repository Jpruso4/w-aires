package com.waires.Waires.web.controller;

import com.waires.Waires.domain.dto.ProfileTypeDTO;
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

    @GetMapping("/profiles")
    public ResponseEntity<List<ProfileTypeDTO>> getProfiles(){
        return new ResponseEntity(profileService.getProfiles(), HttpStatus.OK);
    }
}
