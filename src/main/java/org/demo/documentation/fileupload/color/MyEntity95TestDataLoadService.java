package org.demo.documentation.fileupload.color;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import lombok.AllArgsConstructor;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.cxbox.core.file.dto.CxboxResponseDTO;
import org.cxbox.core.file.dto.FileUploadDto;
import org.demo.services.CustomFileServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MyEntity95TestDataLoadService {

	@Autowired
	MyEntity95Repository repository;

	@Autowired
	InternalAuthorizationService authzService;

	private final CustomFileServices customFileServices;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		CxboxResponseDTO<FileUploadDto> file = customFileServices.uploadTxt();
		repository.save(new MyEntity95().setCustomField(file.getData().getName())
				.setCustomFieldId(file.getData().getId()));
	}

}