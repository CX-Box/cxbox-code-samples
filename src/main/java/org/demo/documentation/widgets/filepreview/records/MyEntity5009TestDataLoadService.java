package org.demo.documentation.widgets.filepreview.records;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.services.SampleFiles;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyEntity5009TestDataLoadService {

	private final MyEntity5009Repository repository;

	private final InternalAuthorizationService authzService;

	private final SampleFiles sampleFiles;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		// the list shows the newest records first
		repository.save(new MyEntity5009().setCustomField("Price list"));
		for (String title : List.of("Meeting notes", "Floor plan", "Contract")) {
			var file = sampleFiles.upload(title).getData();
			repository.save(new MyEntity5009().setCustomField(title).setDocument(file.getName()).setDocumentId(file.getId()));
		}
	}

}
