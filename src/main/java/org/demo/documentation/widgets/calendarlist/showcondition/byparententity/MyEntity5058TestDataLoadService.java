package org.demo.documentation.widgets.calendarlist.showcondition.byparententity;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import java.time.LocalDate;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.widgets.calendarlist.showcondition.byparententity.child.MyEntity5059;
import org.demo.documentation.widgets.calendarlist.showcondition.byparententity.child.MyEntity5059Repository;
import org.demo.documentation.widgets.calendarlist.showcondition.byparententity.parent.MyEntity5058;
import org.demo.documentation.widgets.calendarlist.showcondition.byparententity.parent.MyEntity5058Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity5058TestDataLoadService {

	@Autowired
	MyEntity5058Repository repositoryParent;

	@Autowired
	MyEntity5059Repository repositoryChild;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repositoryChild.deleteAll();
		repositoryParent.deleteAll();
		LocalDate month = LocalDate.now();
		MyEntity5058 parent = repositoryParent.save(new MyEntity5058().setCustomField("Project").setCustomFieldNumber(8L));
		repositoryChild.save(new MyEntity5059().setCustomFieldEntity(parent).setCustomField("Meeting 1")
				.setStartDateTime(month.withDayOfMonth(10).atTime(10, 0))
				.setEndDateTime(month.withDayOfMonth(10).atTime(11, 0)));
		repositoryChild.save(new MyEntity5059().setCustomFieldEntity(parent).setCustomField("Meeting 2")
				.setStartDateTime(month.withDayOfMonth(12).atTime(14, 0))
				.setEndDateTime(month.withDayOfMonth(12).atTime(15, 30)));
	}

}
