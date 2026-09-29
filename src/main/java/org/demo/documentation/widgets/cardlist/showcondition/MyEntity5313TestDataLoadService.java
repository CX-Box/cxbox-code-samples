package org.demo.documentation.widgets.cardlist.showcondition;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.cxbox.core.file.dto.FileUploadDto;
import org.demo.services.SampleFiles;
import org.demo.documentation.widgets.cardlist.showcondition.parent.MyEntity5303;
import org.demo.documentation.widgets.cardlist.showcondition.parent.MyEntity5303Repository;
import org.demo.documentation.widgets.cardlist.showcondition.child.MyEntity5313;
import org.demo.documentation.widgets.cardlist.showcondition.child.MyEntity5313Repository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyEntity5313TestDataLoadService {

	private final SampleFiles sampleFiles;

	private final MyEntity5313Repository repository;

	private final InternalAuthorizationService authzService;

	private final MyEntity5303Repository parentRepository;

	private MyEntity5303 parentEntity;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		parentRepository.deleteAll();
		parentEntity = parentRepository.save(new MyEntity5303().setCustomFieldNumber(8L));
		save("Contract", "Signed by both parties");
		save("Meeting notes", "Weekly sync");
		save("Invoice", "Due in 10 days");
		save("Price list", "Valid until December");
		save("Floor plan", "Second floor");
		save("Certificate", "Issued to the Main office");
	}

	private MyEntity5313 save(String title, String description) {
		FileUploadDto file = sampleFiles.upload(title).getData();
		MyEntity5313 entity = new MyEntity5313();
		entity.setDocument(file.getName());
		entity.setDocumentId(file.getId());
		entity.setCustomField(title);
		entity.setCustomFieldDescription(description);
			entity.setCustomFieldEntity(parentEntity);
		return repository.save(entity);
	}

}
