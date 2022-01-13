package com.waires.Waires.persistence.repository;

import com.waires.Waires.persistence.entity.Employ;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployRepository extends MongoRepository<Employ, String> {
}
