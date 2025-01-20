package org.demo.documentation.fields.multivalue.drilldown;

import java.util.ArrayList;
import java.util.List;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity182TestDataLoadService {

	@Autowired
	MyEntity182Repository repository;

	@Autowired
	MyEntity183Repository repository183;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		MyEntity183 myEntity1 = new MyEntity183().setCustomField("Test data");
		MyEntity183 myEntity2 = new MyEntity183().setCustomField("Abs data");
		List<MyEntity183> list = new ArrayList<>();
		list.add(myEntity1);
		list.add(myEntity2);
		repository.save(new MyEntity182().setCustomFieldList(list));
	}

}