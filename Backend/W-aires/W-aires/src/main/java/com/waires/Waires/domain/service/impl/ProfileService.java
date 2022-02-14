package com.waires.Waires.domain.service.impl;

import com.waires.Waires.domain.dto.ProfileTypeDTO;
import com.waires.Waires.domain.mapper.IProfileMapper;
import com.waires.Waires.domain.service.IProfileService;
import com.waires.Waires.persistence.repository.IProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileService implements IProfileService {

    private final IProfileMapper profileMapper;
    private final IProfileRepository profileRepository;

    public ProfileService(IProfileMapper profileMapper, IProfileRepository profileRepository) {
        this.profileMapper = profileMapper;
        this.profileRepository = profileRepository;
    }

    @Override
    public List<ProfileTypeDTO> getProfiles() {
        return profileMapper.mapListProfile(profileRepository.findAll());
    }

}
