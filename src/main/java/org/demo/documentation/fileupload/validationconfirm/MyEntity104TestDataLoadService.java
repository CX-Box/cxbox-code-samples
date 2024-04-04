package org.demo.documentation.fileupload.validationconfirm;

import javax.annotation.PostConstruct;
import  jakarta.transaction.Transactional;

import lombok.AllArgsConstructor;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.cxbox.core.file.dto.CxboxResponseDTO;
import org.cxbox.core.file.dto.FileUploadDto;
import org.demo.services.CustomFileUploadServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MyEntity104TestDataLoadService {

	@Autowired
	MyEntity104Repository repository;

	@Autowired
	InternalAuthorizationService authzService;

	private final CustomFileUploadServices customFileUploadServices;
	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		CxboxResponseDTO<FileUploadDto> file = customFileUploadServices.uploadTxt();
		repository.save(new MyEntity104().setCustomField(file.getData().getName())
				.setCustomFieldId(file.getData().getId()));
	}

}