package com.waires.Waires.persistence.repository;

import com.waires.Waires.persistence.entity.ProfileType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProfileRepository extends JpaRepository<ProfileType, String> {
}
