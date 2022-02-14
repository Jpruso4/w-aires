package com.waires.Waires.domain.service.impl;

import com.waires.Waires.domain.dto.DocumentTypeDTO;
import com.waires.Waires.domain.mapper.IDocumentTypeMapper;
import com.waires.Waires.domain.service.IDocumentTypeService;
import com.waires.Waires.persistence.repository.IDocumentTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentTypeService implements IDocumentTypeService {

    private final IDocumentTypeMapper documentTypeMapper;
    private final IDocumentTypeRepository documentTypeRepository;

    public DocumentTypeService(IDocumentTypeMapper documentTypeMapper, IDocumentTypeRepository documentTypeRepository) {
        this.documentTypeMapper = documentTypeMapper;
        this.documentTypeRepository = documentTypeRepository;
    }

    @Override
    public List<DocumentTypeDTO> getDocumentType() {
        return documentTypeMapper.mapListDocumentType(documentTypeRepository.findAll());
    }
}
