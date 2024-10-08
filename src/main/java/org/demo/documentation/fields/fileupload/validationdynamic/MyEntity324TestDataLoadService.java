package org.demo.documentation.fields.fileupload.validationdynamic;

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
public class MyEntity324TestDataLoadService {

	@Autowired
	MyEntity324Repository repository;

	@Autowired
	InternalAuthorizationService authzService;

	private final CustomFileUploadServices customFileUploadServices;
	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		CxboxResponseDTO<FileUploadDto> file = customFileUploadServices.uploadTxt("1");
		CxboxResponseDTO<FileUploadDto> file1 = customFileUploadServices.uploadTxt("2");
		repository.save(new MyEntity324().setCustomField(file.getData().getName())
				.setCustomFieldId(file.getData().getId())
				.setCustomFieldAdditional(file1.getData().getName()).setCustomFieldAdditionalId(file1.getData().getId()));
	}

}

