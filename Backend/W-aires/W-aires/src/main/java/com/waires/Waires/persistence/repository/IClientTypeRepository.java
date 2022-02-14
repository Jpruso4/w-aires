package com.waires.Waires.persistence.repository;

import com.waires.Waires.persistence.entity.ClientType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClientTypeRepository extends JpaRepository<ClientType, String> {
}
