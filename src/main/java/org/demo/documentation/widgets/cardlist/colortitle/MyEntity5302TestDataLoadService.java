package org.demo.documentation.widgets.cardlist.colortitle;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.cxbox.core.file.dto.FileUploadDto;
import org.demo.services.SampleFiles;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyEntity5302TestDataLoadService {

	private static final String[] COLORS = {"#edaa6a", "#6aa6ed", "#6aed8a", "#ed6a6a", "#b06aed", "#edd86a", "#6aede0", "#a0a0a0"};

	private final SampleFiles sampleFiles;

	private final MyEntity5302Repository repository;

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

	private MyEntity5302 save(String title, String description) {
		FileUploadDto file = sampleFiles.upload(title).getData();
		MyEntity5302 entity = new MyEntity5302();
		entity.setDocument(file.getName());
		entity.setDocumentId(file.getId());
		entity.setCustomField(title);
		entity.setCustomFieldDescription(description);
		entity.setCustomFieldColor(COLORS[(int) repository.count() % COLORS.length]);
		return repository.save(entity);
	}

}
