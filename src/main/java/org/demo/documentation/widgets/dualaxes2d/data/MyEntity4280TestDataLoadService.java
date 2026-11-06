package org.demo.documentation.widgets.dualaxes2d.data;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity4280TestDataLoadService {

	@Autowired
	MyEntity4280Repository repository;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository.save(new MyEntity4280().setMonth(1L).setClientName("Trade Prof Media LLC").setProductName(ProductEnum.EQUIPMENT).setSum(1600L));
		repository.save(new MyEntity4280().setMonth(1L).setClientName("AcademWeb Holding").setProductName(ProductEnum.EQUIPMENT).setSum(1000L));
		repository.save(new MyEntity4280().setMonth(1L).setClientName("Trade Prof Media LLC").setProductName(ProductEnum.EXPERTISE).setSum(1000L));
		repository.save(new MyEntity4280().setMonth(1L).setClientName("AcademWeb Holding").setProductName(ProductEnum.EXPERTISE).setSum(400L));
		repository.save(new MyEntity4280().setMonth(1L).setClientName("GlobalTrade Partners").setProductName(ProductEnum.EXPERTISE).setSum(700L));
		repository.save(new MyEntity4280().setMonth(1L).setClientName("Trade Prof Media LLC").setProductName(ProductEnum.EXPERTISE).setSum(1000L));
		repository.save(new MyEntity4280().setMonth(2L).setClientName("Trade Prof Media LLC").setProductName(ProductEnum.EQUIPMENT).setSum(1400L));
		repository.save(new MyEntity4280().setMonth(2L).setClientName("AcademWeb Holding").setProductName(ProductEnum.EQUIPMENT).setSum(1700L));
		repository.save(new MyEntity4280().setMonth(2L).setClientName("GlobalTrade Partners").setProductName(ProductEnum.EQUIPMENT).setSum(1100L));
		repository.save(new MyEntity4280().setMonth(2L).setClientName("Trade Prof Media LLC").setProductName(ProductEnum.EXPERTISE).setSum(800L));
		repository.save(new MyEntity4280().setMonth(2L).setClientName("AcademWeb Holding").setProductName(ProductEnum.EXPERTISE).setSum(1100L));
		repository.save(new MyEntity4280().setMonth(3L).setClientName("Trade Prof Media LLC").setProductName(ProductEnum.EQUIPMENT).setSum(1200L));
		repository.save(new MyEntity4280().setMonth(3L).setClientName("AcademWeb Holding").setProductName(ProductEnum.EQUIPMENT).setSum(1500L));
		repository.save(new MyEntity4280().setMonth(3L).setClientName("Trade Prof Media LLC").setProductName(ProductEnum.EXPERTISE).setSum(600L));
		repository.save(new MyEntity4280().setMonth(3L).setClientName("AcademWeb Holding").setProductName(ProductEnum.EXPERTISE).setSum(900L));
		repository.save(new MyEntity4280().setMonth(3L).setClientName("GlobalTrade Partners").setProductName(ProductEnum.EXPERTISE).setSum(300L));
		repository.save(new MyEntity4280().setMonth(3L).setClientName("Trade Prof Media LLC").setProductName(ProductEnum.EXPERTISE).setSum(600L));
		repository.save(new MyEntity4280().setMonth(3L).setClientName("AcademWeb Holding").setProductName(ProductEnum.EXPERTISE).setSum(900L));
		repository.save(new MyEntity4280().setMonth(4L).setClientName("Trade Prof Media LLC").setProductName(ProductEnum.EQUIPMENT).setSum(1000L));
		repository.save(new MyEntity4280().setMonth(4L).setClientName("AcademWeb Holding").setProductName(ProductEnum.EQUIPMENT).setSum(1300L));
		repository.save(new MyEntity4280().setMonth(4L).setClientName("GlobalTrade Partners").setProductName(ProductEnum.EQUIPMENT).setSum(1600L));
		repository.save(new MyEntity4280().setMonth(4L).setClientName("Trade Prof Media LLC").setProductName(ProductEnum.EQUIPMENT).setSum(1000L));
		repository.save(new MyEntity4280().setMonth(4L).setClientName("Trade Prof Media LLC").setProductName(ProductEnum.EXPERTISE).setSum(400L));
		repository.save(new MyEntity4280().setMonth(4L).setClientName("AcademWeb Holding").setProductName(ProductEnum.EXPERTISE).setSum(700L));
		repository.save(new MyEntity4280().setMonth(4L).setClientName("GlobalTrade Partners").setProductName(ProductEnum.EXPERTISE).setSum(1000L));
		repository.save(new MyEntity4280().setMonth(5L).setClientName("Trade Prof Media LLC").setProductName(ProductEnum.EQUIPMENT).setSum(1700L));
		repository.save(new MyEntity4280().setMonth(5L).setClientName("AcademWeb Holding").setProductName(ProductEnum.EQUIPMENT).setSum(1100L));
		repository.save(new MyEntity4280().setMonth(5L).setClientName("GlobalTrade Partners").setProductName(ProductEnum.EQUIPMENT).setSum(1400L));
		repository.save(new MyEntity4280().setMonth(5L).setClientName("Trade Prof Media LLC").setProductName(ProductEnum.EXPERTISE).setSum(1100L));
		repository.save(new MyEntity4280().setMonth(5L).setClientName("AcademWeb Holding").setProductName(ProductEnum.EXPERTISE).setSum(500L));
		repository.save(new MyEntity4280().setMonth(5L).setClientName("GlobalTrade Partners").setProductName(ProductEnum.EXPERTISE).setSum(800L));
		repository.save(new MyEntity4280().setMonth(5L).setClientName("Trade Prof Media LLC").setProductName(ProductEnum.EXPERTISE).setSum(1100L));
		repository.save(new MyEntity4280().setMonth(5L).setClientName("AcademWeb Holding").setProductName(ProductEnum.EXPERTISE).setSum(500L));
		repository.save(new MyEntity4280().setMonth(5L).setClientName("GlobalTrade Partners").setProductName(ProductEnum.EXPERTISE).setSum(800L));
		repository.save(new MyEntity4280().setMonth(6L).setClientName("Trade Prof Media LLC").setProductName(ProductEnum.EQUIPMENT).setSum(1500L));
		repository.save(new MyEntity4280().setMonth(6L).setClientName("AcademWeb Holding").setProductName(ProductEnum.EQUIPMENT).setSum(900L));
		repository.save(new MyEntity4280().setMonth(6L).setClientName("GlobalTrade Partners").setProductName(ProductEnum.EQUIPMENT).setSum(1200L));
		repository.save(new MyEntity4280().setMonth(6L).setClientName("Trade Prof Media LLC").setProductName(ProductEnum.EQUIPMENT).setSum(1500L));
		repository.save(new MyEntity4280().setMonth(6L).setClientName("AcademWeb Holding").setProductName(ProductEnum.EQUIPMENT).setSum(900L));
		repository.save(new MyEntity4280().setMonth(6L).setClientName("Trade Prof Media LLC").setProductName(ProductEnum.EXPERTISE).setSum(900L));
		repository.save(new MyEntity4280().setMonth(6L).setClientName("AcademWeb Holding").setProductName(ProductEnum.EXPERTISE).setSum(300L));
		repository.save(new MyEntity4280().setMonth(6L).setClientName("GlobalTrade Partners").setProductName(ProductEnum.EXPERTISE).setSum(600L));
		repository.save(new MyEntity4280().setMonth(6L).setClientName("Trade Prof Media LLC").setProductName(ProductEnum.EXPERTISE).setSum(900L));
	}

}
