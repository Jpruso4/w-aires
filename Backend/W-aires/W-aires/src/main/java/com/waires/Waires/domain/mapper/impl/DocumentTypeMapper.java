package com.waires.Waires.domain.mapper.impl;


import com.waires.Waires.domain.dto.DocumentTypeDTO;
import com.waires.Waires.domain.mapper.IDocumentTypeMapper;
import com.waires.Waires.persistence.entity.DocumentType;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class DocumentTypeMapper implements IDocumentTypeMapper {


    @Override
    public DocumentTypeDTO mapFromEntity(DocumentType documentType) {
        DocumentTypeDTO documentTypeDTO = new DocumentTypeDTO();
        documentTypeDTO.setIdTipoDocumento(documentType.getIdTipoDocumento());
        documentTypeDTO.setDocumeno(documentType.getDocumento());
        return documentTypeDTO;
    }

    @Override
    public List<DocumentTypeDTO> mapListDocumentType(List<DocumentType> listDocumentType) {
        List<DocumentTypeDTO> listClientDTO = new LinkedList<>();
        for (DocumentType documentType : listDocumentType){
            listClientDTO.add(mapFromEntity(documentType));
        }
        return listClientDTO;
    }
}
