package org.demo.documentation.widgets.cardcarousellist.showcondition;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.cxbox.core.file.dto.FileUploadDto;
import org.demo.services.SampleFiles;
import org.demo.documentation.widgets.cardcarousellist.showcondition.parent.MyEntity5063;
import org.demo.documentation.widgets.cardcarousellist.showcondition.parent.MyEntity5063Repository;
import org.demo.documentation.widgets.cardcarousellist.showcondition.child.MyEntity5064;
import org.demo.documentation.widgets.cardcarousellist.showcondition.child.MyEntity5064Repository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyEntity5064TestDataLoadService {

	private final SampleFiles sampleFiles;

	private final MyEntity5064Repository repository;

	private final InternalAuthorizationService authzService;

	private final MyEntity5063Repository parentRepository;

	private MyEntity5063 parentEntity;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		parentRepository.deleteAll();
		parentEntity = parentRepository.save(new MyEntity5063().setCustomFieldNumber(8L));
		save("Contract", "Signed by both parties");
		save("Meeting notes", "Weekly sync");
		save("Invoice", "Due in 10 days");
		save("Price list", "Valid until December");
		save("Floor plan", "Second floor");
		save("Certificate", "Issued to the Main office");
	}

	private MyEntity5064 save(String title, String description) {
		FileUploadDto file = sampleFiles.upload(title).getData();
		MyEntity5064 entity = new MyEntity5064();
		entity.setDocument(file.getName());
		entity.setDocumentId(file.getId());
		entity.setCustomField(title);
		entity.setCustomFieldDescription(description);
		entity.setCustomFieldEntity(parentEntity);
		return repository.save(entity);
	}

}
