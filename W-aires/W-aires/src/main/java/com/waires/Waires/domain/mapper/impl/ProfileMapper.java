package com.waires.Waires.domain.mapper.impl;

import com.waires.Waires.domain.dto.ProfileTypeDTO;
import com.waires.Waires.domain.mapper.IProfileMapper;
import com.waires.Waires.persistence.entity.ProfileType;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class ProfileMapper implements IProfileMapper {
    @Override
    public ProfileTypeDTO mapFromEntity(ProfileType profile) {
        ProfileTypeDTO profileDTO = new ProfileTypeDTO();
        profileDTO.setIdPerfil(profile.getIdPefil());
        profileDTO.setNombrePerfil(profile.getNombrePerfil());
        return profileDTO;
    }


    @Override
    public List<ProfileTypeDTO> mapListProfile(List<ProfileType> profileList) {
        List<ProfileTypeDTO> list = new LinkedList<>();
        for (ProfileType profile : profileList) {
            list.add(mapFromEntity(profile));
        }
        return list;
    }
}
