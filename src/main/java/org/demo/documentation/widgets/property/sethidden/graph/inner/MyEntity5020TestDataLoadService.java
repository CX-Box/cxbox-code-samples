package org.demo.documentation.widgets.property.sethidden.graph.inner;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.widgets.property.sethidden.graph.inner.enums.ProductNameEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity5020TestDataLoadService {

	@Autowired
	MyEntity5020Repository repository;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository.save(new MyEntity5020().setSum(50015L).setCustomField("test data4").setClientName("LLC TelemedOperations").setProductName(ProductNameEnum.EQUIPMENT));
		repository.save(new MyEntity5020().setSum(30020L).setCustomField("test data2").setClientName("LLC “Web Project Communication”").setProductName(ProductNameEnum.EXPERTISE));
		repository.save(new MyEntity5020().setSum(40015L).setCustomField("test data3").setClientName("Trade Prof Media LLC").setProductName(ProductNameEnum.EQUIPMENT));
		repository.save(new MyEntity5020().setSum(20000L).setCustomField("test data").setClientName("Trade Prof Media LLC").setProductName(ProductNameEnum.EXPERTISE));
	}

}