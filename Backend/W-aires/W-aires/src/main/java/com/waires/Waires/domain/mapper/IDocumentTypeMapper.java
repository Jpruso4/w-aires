package com.waires.Waires.domain.mapper;


import com.waires.Waires.domain.dto.DocumentTypeDTO;
import com.waires.Waires.persistence.entity.DocumentType;

import java.util.List;

public interface IDocumentTypeMapper {

    DocumentTypeDTO mapFromEntity(DocumentType documentType);

    List<DocumentTypeDTO> mapListDocumentType(List<DocumentType> listDocumentType);

}
