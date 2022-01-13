package com.waires.Waires.persistence.repository;

import com.waires.Waires.persistence.entity.Service;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IServiceRepository extends MongoRepository<Service, String> {
}
