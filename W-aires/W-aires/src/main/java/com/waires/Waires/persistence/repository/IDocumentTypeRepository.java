package com.waires.Waires.persistence.repository;

import com.waires.Waires.persistence.entity.DocumentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDocumentTypeRepository extends JpaRepository<DocumentType, String> {
}
