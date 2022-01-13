package com.waires.Waires.persistence.repository;

import com.waires.Waires.persistence.entity.ActivitiesType;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IActivitiesTypeRepository extends MongoRepository<ActivitiesType, String> {
}
