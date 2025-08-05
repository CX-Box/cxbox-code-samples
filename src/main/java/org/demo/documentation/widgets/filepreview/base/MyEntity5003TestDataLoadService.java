package org.demo.documentation.widgets.filepreview.base;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.cxbox.core.file.dto.CxboxResponseDTO;
import org.cxbox.core.file.dto.FileUploadDto;
import org.demo.services.CustomFileUploadServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MyEntity5003TestDataLoadService {

    @Autowired
    MyEntity5003Repository repository;

    @Autowired
    InternalAuthorizationService authzService;

    private final CustomFileUploadServices customFileUploadServices;

    @Transactional
    @PostConstruct
    public void load() {
        authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
        repository.deleteAll();
        CxboxResponseDTO<FileUploadDto> file = customFileUploadServices.uploadTxt("1");
        repository.save(new MyEntity5003().setCustomField(file.getData().getName())
                .setCustomFieldId(file.getData().getId()));

    }

}