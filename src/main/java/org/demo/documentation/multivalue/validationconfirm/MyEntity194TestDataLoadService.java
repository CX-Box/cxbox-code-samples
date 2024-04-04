package org.demo.documentation.multivalue.validationconfirm;


import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import  jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity194TestDataLoadService {

	@Autowired
	MyEntity194Repository repository;

	@Autowired
	MyEntity195Repository repository195;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		MyEntity195 myEntity1 = new MyEntity195().setCustomField("Test data");
		MyEntity195 myEntity2 = new MyEntity195().setCustomField("Abs data");
		List<MyEntity195> list = new ArrayList<>();
		list.add(myEntity1);
		list.add(myEntity2);
		repository.save(new MyEntity194().setCustomFieldList(list));
	}

}