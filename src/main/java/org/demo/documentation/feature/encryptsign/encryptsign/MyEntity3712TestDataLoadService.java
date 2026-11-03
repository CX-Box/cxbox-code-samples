package org.demo.documentation.feature.encryptsign.encryptsign;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import java.util.LinkedHashMap;
import java.util.Map;
import lombok.AllArgsConstructor;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.cxbox.core.file.dto.CxboxResponseDTO;
import org.cxbox.core.file.dto.FileUploadDto;
import org.demo.documentation.feature.encryptsign.encryptsign.enums.CustomFieldDictionaryEnum;
import org.demo.services.CustomFileUploadServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MyEntity3712TestDataLoadService {

	@Autowired
	MyEntity3712Repository repository;

	@Autowired
	InternalAuthorizationService authzService;

	private final CustomFileUploadServices customFileUploadServices;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		// rows for the mass operation: three of every value of the dictionary and one without a value
		Map<String, CustomFieldDictionaryEnum> files = new LinkedHashMap<>();
		files.put("1", CustomFieldDictionaryEnum.HIGH);
		files.put("2", CustomFieldDictionaryEnum.HIGH);
		files.put("3", CustomFieldDictionaryEnum.HIGH);
		files.put("4", CustomFieldDictionaryEnum.MIDDLE);
		files.put("5", CustomFieldDictionaryEnum.MIDDLE);
		files.put("6", CustomFieldDictionaryEnum.MIDDLE);
		files.put("7", CustomFieldDictionaryEnum.LOW);
		files.put("8", CustomFieldDictionaryEnum.LOW);
		files.put("9", CustomFieldDictionaryEnum.LOW);
		files.put("10", null);
		files.forEach((fileName, dictionary) -> {
			CxboxResponseDTO<FileUploadDto> file = customFileUploadServices.uploadPdf(fileName);
			repository.save(new Myexample3712()
					.setFile(file.getData().getName())
					.setFileId(file.getData().getId())
					.setCustomFieldDictionary(dictionary));
		});
	}

}