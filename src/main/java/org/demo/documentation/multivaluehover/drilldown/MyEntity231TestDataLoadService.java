package org.demo.documentation.multivaluehover.drilldown;


import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import  jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity231TestDataLoadService {

	@Autowired
	MyEntity231Repository repository;

	@Autowired
	MyEntity232Repository repository232;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		MyEntity232 myEntity1 = new MyEntity232().setCustomField(
				"Saturn's interior is thought to be composed of a rocky core, surrounded by a deep layer of metallic hydrogen, an intermediate layer of liquid hydrogen and liquid helium");
		MyEntity232 myEntity2 = new MyEntity232().setCustomField(
				"Despite consisting mostly of hydrogen and helium, most of Saturn's mass is not in the gas phase, because hydrogen becomes a non-ideal liquid when the density is above 0.01 g/cm3, which is reached at a radius containing 99.9% of Saturn's mass.");
		List<MyEntity232> list = new ArrayList<>();
		list.add(myEntity1);
		list.add(myEntity2);
		repository.save(new MyEntity231().setCustomFieldList(list));
	}

}