package org.demo.documentation.additional.forceactiveshowcondition;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.additional.forceactiveshowcondition.controlperson.MyEntity1434;
import org.demo.documentation.additional.forceactiveshowcondition.controlperson.MyEntity1434Repository;
import org.demo.documentation.additional.forceactiveshowcondition.controlperson.taxresidency.MyEntity1435;
import org.demo.documentation.additional.forceactiveshowcondition.controlperson.taxresidency.MyEntity1435Repository;
import org.demo.documentation.additional.forceactiveshowcondition.enums.CrsStatusEnum;
import org.demo.documentation.additional.forceactiveshowcondition.taxresidency.MyEntity1433;
import org.demo.documentation.additional.forceactiveshowcondition.taxresidency.MyEntity1433Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity1432TestDataLoadService {

	@Autowired
	MyEntity1432Repository repository;

	@Autowired
	MyEntity1433Repository repository1433;

	@Autowired
	MyEntity1434Repository repository1434;

	@Autowired
	MyEntity1435Repository repository1435;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository1435.deleteAll();
		repository1434.deleteAll();
		repository1433.deleteAll();
		repository.deleteAll();
		// child widgets are hidden on the first view open: accountableCrs = false
		MyEntity1432 parent = repository.save(new MyEntity1432()
				.setCrsStatus(CrsStatusEnum.ACTIVE_NFE)
				.setAccountableCrs(false));
		repository1433.save(new MyEntity1433().setParentEntity(parent).setCountry("Cyprus").setTin("CY-1433"));
		MyEntity1434 controlPerson = repository1434.save(new MyEntity1434().setParentEntity(parent)
				.setFullName("Control person").setInn("1434"));
		repository1435.save(new MyEntity1435().setParentEntity(controlPerson).setCountry("Latvia").setTin("LV-1435"));
	}

}
