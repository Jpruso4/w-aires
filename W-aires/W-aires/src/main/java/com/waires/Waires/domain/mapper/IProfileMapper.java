package com.waires.Waires.domain.mapper;

import com.waires.Waires.domain.dto.ProfileTypeDTO;
import com.waires.Waires.persistence.entity.ProfileType;

import java.util.List;

public interface IProfileMapper {

    ProfileTypeDTO mapFromEntity(ProfileType profile);

    List<ProfileTypeDTO> mapListProfile(List<ProfileType> profileList);
}
