package com.waires.Waires.persistence.repository;

import com.waires.Waires.persistence.entity.ClientType;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClientTypeRepository extends MongoRepository<ClientType, String> {
}
