package org.demo.documentation.feature.encryptsign.sign;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import java.util.List;
import lombok.AllArgsConstructor;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.cxbox.core.file.dto.CxboxResponseDTO;
import org.cxbox.core.file.dto.FileUploadDto;
import org.demo.services.CustomFileUploadServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MyEntity3711TestDataLoadService {

	@Autowired
	MyEntity3711Repository repository;

	@Autowired
	InternalAuthorizationService authzService;

	private final CustomFileUploadServices customFileUploadServices;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		// several rows for the mass operation
		for (String fileName : List.of("1", "2", "3")) {
			CxboxResponseDTO<FileUploadDto> file = customFileUploadServices.uploadPdf(fileName);
			repository.save(new Myexample3711().setFile(file.getData().getName()).setFileId(file.getData().getId()));
		}

	}

}