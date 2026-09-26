package org.demo.documentation.widgets.cardlist.status;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.cxbox.core.file.dto.FileUploadDto;
import org.demo.services.SampleFiles;
import org.demo.documentation.widgets.cardlist.status.enums.StatusEnum;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyEntity5305TestDataLoadService {

	private final SampleFiles sampleFiles;

	private final MyEntity5305Repository repository;

	private final InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		save("Contract", "Signed by both parties");
		save("Meeting notes", "Weekly sync");
		save("Invoice", "Due in 10 days");
		save("Price list", "Valid until December");
		save("Floor plan", "Second floor");
		save("Certificate", "Issued to the Main office");
	}

	private MyEntity5305 save(String title, String description) {
		FileUploadDto file = sampleFiles.upload(title).getData();
		MyEntity5305 entity = new MyEntity5305();
		entity.setDocument(file.getName());
		entity.setDocumentId(file.getId());
		entity.setCustomField(title);
		entity.setCustomFieldDescription(description);
		entity.setStatus(StatusEnum.values()[(int) repository.count() % StatusEnum.values().length]);
		return repository.save(entity);
	}

}
