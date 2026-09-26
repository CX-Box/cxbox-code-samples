package org.demo.documentation.widgets.column2d.data;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyEntity4252TestDataLoadService {

	private final MyEntity4252Repository repository;

	private final InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository.save(new MyEntity4252().setClientName("AcademWeb Holding").setProduct(MyEntity4252Product.EXPERTISE).setAmount(1200L));
		repository.save(new MyEntity4252().setClientName("AcademWeb Holding").setProduct(MyEntity4252Product.EQUIPMENT).setAmount(800L));
		repository.save(new MyEntity4252().setClientName("AcademWeb Holding").setProduct(MyEntity4252Product.EXPERTISE).setAmount(600L));
		repository.save(new MyEntity4252().setClientName("GlobalTrade Partners").setProduct(MyEntity4252Product.EXPERTISE).setAmount(2100L));
		repository.save(new MyEntity4252().setClientName("GlobalTrade Partners").setProduct(MyEntity4252Product.EQUIPMENT).setAmount(1500L));
		repository.save(new MyEntity4252().setClientName("Info Trust").setProduct(MyEntity4252Product.EQUIPMENT).setAmount(3400L));
		repository.save(new MyEntity4252().setClientName("Info Trust").setProduct(MyEntity4252Product.EXPERTISE).setAmount(900L));
		repository.save(new MyEntity4252().setClientName("Info Trust").setProduct(MyEntity4252Product.EQUIPMENT).setAmount(1100L));
		repository.save(new MyEntity4252().setClientName("TelecomTrade").setProduct(MyEntity4252Product.EXPERTISE).setAmount(1700L));
		repository.save(new MyEntity4252().setClientName("TelecomTrade").setProduct(MyEntity4252Product.EQUIPMENT).setAmount(700L));
		repository.save(new MyEntity4252().setClientName("Trade Prof Media").setProduct(MyEntity4252Product.EXPERTISE).setAmount(2600L));
		repository.save(new MyEntity4252().setClientName("Trade Prof Media").setProduct(MyEntity4252Product.EQUIPMENT).setAmount(2200L));
	}

}
