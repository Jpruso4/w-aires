package com.waires.Waires.persistence.repository;

import com.waires.Waires.persistence.entity.ReportType;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IReportTypeRepository extends MongoRepository<ReportType, String> {
}
