package org.demo.documentation.widgets.statsblock.drilldown.parentchild.data;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.widgets.statsblock.drilldown.parentchild.data.enums.ExampleStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity4216TestDataLoadService {

	@Autowired
	MyEntity4216Repository repository;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository.save(new MyEntity4216().setCustomField("test data").setStatus(ExampleStatus.CANCELLED));
		repository.save(new MyEntity4216().setCustomField("test data2").setStatus(ExampleStatus.IN_COMPLETION));
		repository.save(new MyEntity4216().setCustomField("test data3").setStatus(ExampleStatus.IN_PROGRESS));
		repository.save(new MyEntity4216().setCustomField("test data4").setStatus(ExampleStatus.COMPLETED));
		repository.save(new MyEntity4216().setCustomField("test data5").setStatus(ExampleStatus.NOT_STARTED));
		repository.save(new MyEntity4216().setCustomField("test data6").setStatus(ExampleStatus.IN_PROGRESS));
		repository.save(new MyEntity4216().setCustomField("test data7").setStatus(ExampleStatus.IN_PROGRESS));
		repository.save(new MyEntity4216().setCustomField("test data8").setStatus(ExampleStatus.COMPLETED));

	}

}