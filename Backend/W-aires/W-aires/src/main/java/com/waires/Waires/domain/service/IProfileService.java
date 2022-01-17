package com.waires.Waires.domain.service;

import com.waires.Waires.domain.dto.ProfileDTO;

import java.util.List;

public interface IProfileService {
    
    ProfileDTO getProfileById(String id);

    List<ProfileDTO> getProfiles();

    ProfileDTO createProfile(ProfileDTO profileDTO);

    ProfileDTO modifiedProfile(ProfileDTO profileDTO);

    String deleteProfile(String id);
}
