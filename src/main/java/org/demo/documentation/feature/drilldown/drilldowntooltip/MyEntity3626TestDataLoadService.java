package org.demo.documentation.feature.drilldown.drilldowntooltip;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity3626TestDataLoadService {

	@Autowired
	MyEntity3626Repository repository;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository.save(new MyEntity3626()
				.setCustomField("test data")
				.setCustomFieldDrillDown("Drill-down by id")
				.setCustomFieldFilterDrillDown("Drill-down with filtration")
				.setCustomFieldExternalDrillDown("External drill-down"));
		repository.save(new MyEntity3626()
				.setCustomField("test data2")
				.setCustomFieldDrillDown("Drill-down by id 2")
				.setCustomFieldFilterDrillDown("Drill-down with filtration 2")
				.setCustomFieldExternalDrillDown("External drill-down 2"));
		repository.save(new MyEntity3626()
				.setCustomField("other")
				.setCustomFieldDrillDown("Drill-down by id 3")
				.setCustomFieldFilterDrillDown("Drill-down with filtration 3")
				.setCustomFieldExternalDrillDown("External drill-down 3"));
	}

}
