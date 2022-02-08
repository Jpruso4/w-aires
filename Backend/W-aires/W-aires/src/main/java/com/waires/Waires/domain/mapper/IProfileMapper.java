package com.waires.Waires.domain.mapper;

import com.waires.Waires.domain.dto.ProfileDTO;
import com.waires.Waires.persistence.entity.Profile;

import java.util.List;

public interface IProfileMapper {

    ProfileDTO mapFromEntity(Profile profile);

    Profile mapFromDTO(ProfileDTO profileDTO);

    List<ProfileDTO> mapListEmploys(List<Profile> profileList);
}
