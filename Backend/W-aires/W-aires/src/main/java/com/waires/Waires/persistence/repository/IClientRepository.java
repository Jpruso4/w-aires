package com.waires.Waires.persistence.repository;

import com.waires.Waires.persistence.entity.Client;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClientRepository extends MongoRepository<Client, String> {
}
