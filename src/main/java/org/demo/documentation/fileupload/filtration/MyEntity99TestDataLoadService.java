package org.demo.documentation.fileupload.filtration;

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
public class MyEntity99TestDataLoadService {

	@Autowired
	MyEntity99Repository repository;

	@Autowired
	InternalAuthorizationService authzService;

	private final CustomFileServices customFileServices;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		CxboxResponseDTO<FileUploadDto> file = customFileServices.uploadTxt();
		repository.save(new MyEntity99().setCustomField(file.getData().getName())
				.setCustomFieldId(file.getData().getId()));
		CxboxResponseDTO<FileUploadDto> file2 = customFileServices.uploadTxt();
		repository.save(new MyEntity99().setCustomField(file2.getData().getName())
				.setCustomFieldId(file2.getData().getId()));
		CxboxResponseDTO<FileUploadDto> file3 = customFileServices.uploadTxt();
		repository.save(new MyEntity99().setCustomField(file3.getData().getName())
				.setCustomFieldId(file3.getData().getId()));

	}

}