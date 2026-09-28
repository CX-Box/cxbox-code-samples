package org.demo.documentation.widgets.filepreview.showcondition;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.cxbox.core.file.dto.CxboxResponseDTO;
import org.cxbox.core.file.dto.FileUploadDto;
import org.demo.services.SampleFiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MyEntity5006TestDataLoadService {

	private final SampleFiles sampleFiles;
	@Autowired
	MyEntity5006Repository repository;
	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		CxboxResponseDTO<FileUploadDto> file = sampleFiles.contract();
		repository.save(new MyEntity5006().setCustomField(file.getData().getName())
				.setCustomFieldId(file.getData().getId())
				.setCustomFieldShowCondition(true));
	}

}