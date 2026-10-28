package org.demo.documentation.additional.checkforceactiveshowcondition.basic;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.additional.checkforceactiveshowcondition.basic.controlperson.MyEntity1434;
import org.demo.documentation.additional.checkforceactiveshowcondition.basic.controlperson.MyEntity1434Repository;
import org.demo.documentation.additional.checkforceactiveshowcondition.basic.controlperson.taxresidency.MyEntity1435;
import org.demo.documentation.additional.checkforceactiveshowcondition.basic.controlperson.taxresidency.MyEntity1435Repository;
import org.demo.documentation.additional.checkforceactiveshowcondition.basic.enums.CrsStatusEnum;
import org.demo.documentation.additional.checkforceactiveshowcondition.basic.taxresidency.MyEntity1433;
import org.demo.documentation.additional.checkforceactiveshowcondition.basic.taxresidency.MyEntity1433Repository;
import org.demo.documentation.additional.checkforceactiveshowcondition.common.MyEntity1436;
import org.demo.documentation.additional.checkforceactiveshowcondition.common.MyEntity1436Repository;
import org.demo.documentation.additional.checkforceactiveshowcondition.groupinghierarchy.MyExample1443Service;
import org.demo.documentation.additional.checkforceactiveshowcondition.outsidehierarchy.MyExample1441Service;
import org.demo.documentation.additional.checkforceactiveshowcondition.outsidehierarchy.MyExample1447Service;
import org.demo.documentation.additional.checkforceactiveshowcondition.parentfilter.MyExample1446Service;
import org.demo.documentation.additional.checkforceactiveshowcondition.popup.MyExample1440Service;
import org.demo.documentation.additional.checkforceactiveshowcondition.tree.MyExample1442Service;
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
	MyEntity1436Repository repository1436;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository1436.deleteAll();
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
		loadCheckScenarios(parent);
	}

	private void loadCheckScenarios(MyEntity1432 parent) {
		repository1436.save(child(MyExample1440Service.SCENARIO, parent, "Popup record"));

		MyEntity1436 owner1 = repository1436.save(child(MyExample1447Service.SCENARIO, null, "Owner 1"));
		MyEntity1436 owner2 = repository1436.save(child(MyExample1447Service.SCENARIO, null, "Owner 2"));
		repository1436.save(child(MyExample1441Service.SCENARIO, null, "Child of owner 1").setOwnerId(owner1.getId()));
		repository1436.save(child(MyExample1441Service.SCENARIO, null, "Child of owner 2").setOwnerId(owner2.getId()));

		MyEntity1436 treeRoot = repository1436.save(child(MyExample1442Service.SCENARIO, parent, "Tree root"));
		repository1436.save(child(MyExample1442Service.SCENARIO, parent, "Tree leaf").setParentId(treeRoot.getId()));

		repository1436.save(child(MyExample1443Service.SCENARIO, parent, "Grouping active").setCrsStatus(CrsStatusEnum.ACTIVE_NFE));
		repository1436.save(child(MyExample1443Service.SCENARIO, parent, "Grouping passive").setCrsStatus(CrsStatusEnum.PASSIVE_NFE));

		repository1436.save(child(MyExample1446Service.SCENARIO, parent, "Active record").setCrsStatus(CrsStatusEnum.ACTIVE_NFE));
		repository1436.save(child(MyExample1446Service.SCENARIO, parent, "Passive record").setCrsStatus(CrsStatusEnum.PASSIVE_NFE));
	}

	private static MyEntity1436 child(String scenario, MyEntity1432 parent, String country) {
		return new MyEntity1436().setScenario(scenario).setParentEntity(parent).setCountry(country);
	}

}
