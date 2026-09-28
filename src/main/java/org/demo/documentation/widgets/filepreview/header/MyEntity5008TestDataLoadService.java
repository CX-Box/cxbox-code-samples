package org.demo.documentation.widgets.filepreview.header;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.services.SampleFiles;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyEntity5008TestDataLoadService {

	private final MyEntity5008Repository repository;

	private final InternalAuthorizationService authzService;

	private final SampleFiles sampleFiles;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		var file = sampleFiles.contract().getData();
		repository.save(new MyEntity5008()
				.setDocument(file.getName())
				.setDocumentId(file.getId())
				.setCustomFieldTitle("Service contract No 15")
				.setCustomFieldHint("Signed on 1 September"));
	}

}
