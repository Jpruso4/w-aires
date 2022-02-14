package com.waires.Waires.persistence.repository;

import com.waires.Waires.persistence.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface IClientRepository extends JpaRepository<Client, String> {
}
