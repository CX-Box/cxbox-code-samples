package org.demo.documentation.widgets.relationGraph.data;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity6151TestDataLoadService {

	@Autowired
	MyEntity6151Repository repository;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		var main = repository.save(new MyEntity6151().setName("Main office").setCity("Moscow"));
		var north = repository.save(new MyEntity6151().setName("North branch").setCity("Saint Petersburg")
				.setParentId(main.getId()).setSum(12000L));
		var south = repository.save(new MyEntity6151().setName("South branch").setCity("Sochi")
				.setParentId(main.getId()).setSum(4500L));
		var east = repository.save(new MyEntity6151().setName("East branch").setCity("Kazan")
				.setParentId(main.getId()).setSum(800L));
		repository.save(new MyEntity6151().setName("Trade Prof Media LLC").setCity("Saint Petersburg")
				.setParentId(north.getId()).setSum(7000L));
		repository.save(new MyEntity6151().setName("AcademWeb Holding").setCity("Veliky Novgorod")
				.setParentId(north.getId()).setSum(5000L));
		repository.save(new MyEntity6151().setName("GlobalTrade Partners").setCity("Krasnodar")
				.setParentId(south.getId()).setSum(4500L));
		repository.save(new MyEntity6151().setName("Smart Retail").setCity("Kazan")
				.setParentId(east.getId()).setSum(800L));
	}

}
