package org.demo.documentation.fields.fileupload.filtration;

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
public class MyEntity99TestDataLoadService {

	private final CustomFileUploadServices customFileUploadServices;
	@Autowired
	MyEntity99Repository repository;
	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		CxboxResponseDTO<FileUploadDto> file = customFileUploadServices.uploadTxt("1");
		repository.save(new MyEntity99().setCustomField(file.getData().getName())
				.setCustomFieldId(file.getData().getId()));
		CxboxResponseDTO<FileUploadDto> file2 = customFileUploadServices.uploadTxt("2");
		repository.save(new MyEntity99().setCustomField(file2.getData().getName())
				.setCustomFieldId(file2.getData().getId()));
		CxboxResponseDTO<FileUploadDto> file3 = customFileUploadServices.uploadTxt("3");
		repository.save(new MyEntity99().setCustomField(file3.getData().getName())
				.setCustomFieldId(file3.getData().getId()));

	}

}