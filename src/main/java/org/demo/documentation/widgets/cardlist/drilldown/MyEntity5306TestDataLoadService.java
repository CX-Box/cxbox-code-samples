package org.demo.documentation.widgets.cardlist.drilldown;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.cxbox.core.file.dto.FileUploadDto;
import org.demo.services.SampleFiles;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyEntity5306TestDataLoadService {

	private final SampleFiles sampleFiles;

	private final MyEntity5306Repository repository;

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

	private MyEntity5306 save(String title, String description) {
		FileUploadDto file = sampleFiles.upload(title).getData();
		MyEntity5306 entity = new MyEntity5306();
		entity.setDocument(file.getName());
		entity.setDocumentId(file.getId());
		entity.setCustomField(title);
		entity.setCustomFieldDescription(description);
		return repository.save(entity);
	}

}
