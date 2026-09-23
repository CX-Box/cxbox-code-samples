package org.demo.documentation.fields.text.height;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity437TestDataLoadService {

	@Autowired
	MyEntity437Repository repository;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository.save(new MyEntity437().setCustomField("""
				Meeting notes
				The client asked for a faster delivery and a monthly report.
				Prepare the contract draft.
				Agree the new schedule.
				Send the report to the manager.
				The next meeting is on Friday.
				"""));
	}

}