package com.waires.Waires.domain.service.impl;

import com.waires.Waires.domain.dto.ClientTypeDTO;
import com.waires.Waires.domain.dto.ProfileDTO;
import com.waires.Waires.domain.mapper.IProfileMapper;
import com.waires.Waires.domain.service.IProfileService;
import com.waires.Waires.persistence.entity.Employ;
import com.waires.Waires.persistence.entity.Profile;
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
    public ProfileDTO getProfileById(String id) {
        Profile profile = profileRepository.findById(id).orElseThrow(() -> new RuntimeException("El id del perfil no fue encontrado"));
        return profileMapper.mapFromEntity(profile);
    }

    @Override
    public List<ProfileDTO> getProfiles() {
        return profileMapper.mapListEmploys(profileRepository.findAll());
    }

    @Override
    public ProfileDTO createProfile(ProfileDTO profileDTO) {
        return profileMapper.mapFromEntity(profileRepository.save(profileMapper.mapFromDTO(profileDTO)));
    }

    @Override
    public ProfileDTO modifiedProfile(ProfileDTO profileDTO) {
        Profile profile = profileMapper.mapFromDTO(profileDTO);
        profileRepository.findById(profile.getId()).orElseThrow(() -> new RuntimeException("El id del perfil no existe"));
        return profileMapper.mapFromEntity(profileRepository.save(profile));
    }

    @Override
    public String deleteProfile(String id) {
        profileRepository.findById(id).orElseThrow(() -> new RuntimeException("El id del perfil no existe"));
        profileRepository.deleteById(id);
        return "El perfil fue eliminado con exito";
    }
}
