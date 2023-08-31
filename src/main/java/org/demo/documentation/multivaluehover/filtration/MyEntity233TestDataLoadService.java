package org.demo.documentation.multivaluehover.filtration;

import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class MyEntity233TestDataLoadService {

	@Autowired
	MyEntity233Repository repository;

	@Autowired
	MyEntity234Repository repository234;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		MyEntity234 myEntity1 = new MyEntity234().setCustomField(
				"Saturn's interior is thought to be composed of a rocky core, surrounded by a deep layer of metallic hydrogen, an intermediate layer of liquid hydrogen and liquid helium");
		MyEntity234 myEntity2 = new MyEntity234().setCustomField(
				"Despite consisting mostly of hydrogen and helium, most of Saturn's mass is not in the gas phase, because hydrogen becomes a non-ideal liquid when the density is above 0.01 g/cm3, which is reached at a radius containing 99.9% of Saturn's mass.");
		List<MyEntity234> list1 = new ArrayList<>();
		list1.add(myEntity1);
		List<MyEntity234> list2 = new ArrayList<>();
		list2.add(myEntity2);
		MyEntity233 myEntity3 = new MyEntity233().setCustomFieldList(list1);
		repository.save(myEntity3);
		MyEntity233 myEntity4 = new MyEntity233().setCustomFieldList(list2);
		repository.save(myEntity4);
	}

}