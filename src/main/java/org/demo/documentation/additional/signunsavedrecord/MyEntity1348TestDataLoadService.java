package org.demo.documentation.additional.signunsavedrecord;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.cxbox.core.file.dto.CxboxResponseDTO;
import org.cxbox.core.file.dto.FileUploadDto;
import org.demo.services.CustomFileUploadServices;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyEntity1348TestDataLoadService {

	private final MyEntity1348Repository repository;

	private final InternalAuthorizationService authzService;

	private final CustomFileUploadServices customFileUploadServices;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		CxboxResponseDTO<FileUploadDto> file = customFileUploadServices.uploadPdf("1348");
		repository.save(new MyEntity1348()
				.setFile(file.getData().getName())
				.setFileId(file.getData().getId())
				.setNotes("Saved record"));
	}

}
