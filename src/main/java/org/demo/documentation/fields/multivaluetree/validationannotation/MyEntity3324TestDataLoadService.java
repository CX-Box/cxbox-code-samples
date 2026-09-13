package org.demo.documentation.fields.multivaluetree.validationannotation;


import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MyEntity3324TestDataLoadService {

	@Autowired
	MyEntity3324Repository repository;

	@Autowired
	MyEntity3324MultivalueRepository repository3324Multivalue;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository3324Multivalue.deleteAll();
		MyEntity3324Multivalue myEntity1 = new MyEntity3324Multivalue().setCustomField("Test123 data");
		MyEntity3324Multivalue myEntity2 = new MyEntity3324Multivalue().setCustomField("Abs123 data");
		repository3324Multivalue.save(myEntity1);
		repository3324Multivalue.save(myEntity2);
		repository.save(new MyEntity3324());
		MyEntity3324Multivalue myEntity3324MultivalueGroup = repository3324Multivalue.save(new MyEntity3324Multivalue().setCustomField("Test group"));
		repository3324Multivalue.findAll().stream()
				.filter(e -> !e.getId().equals(myEntity3324MultivalueGroup.getId()))
				.forEach(e -> repository3324Multivalue.save(e.setParentId(myEntity3324MultivalueGroup.getId())));
	}

}