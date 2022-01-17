package com.waires.Waires.domain.mapper.impl;

import com.waires.Waires.domain.dto.ProfileDTO;
import com.waires.Waires.domain.mapper.IProfileMapper;
import com.waires.Waires.persistence.entity.Profile;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class ProfileMapper implements IProfileMapper {
    @Override
    public ProfileDTO mapFromEntity(Profile profile) {
        ProfileDTO profileDTO = new ProfileDTO();
        profileDTO.setId(profile.getId());
        profileDTO.setName(profile.getName());
        profileDTO.setDescription(profile.getDescription());
        return profileDTO;
    }

    @Override
    public Profile mapFromDTO(ProfileDTO profileDTO) {
        Profile profile = new Profile();
        profile.setId(profileDTO.getId());
        profile.setName(profileDTO.getName());
        profile.setDescription(profileDTO.getDescription());
        return profile;
    }

    @Override
    public List<ProfileDTO> mapListEmploys(List<Profile> profileList) {
        List<ProfileDTO> list = new LinkedList<>();
        for (Profile profile : profileList) {
            list.add(mapFromEntity(profile));
        }
        return list;
    }
}
