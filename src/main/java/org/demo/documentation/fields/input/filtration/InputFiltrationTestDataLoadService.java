package org.demo.documentation.fields.input.filtration;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InputFiltrationTestDataLoadService {

	@Autowired
	InputFiltrationRepository repository;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();


		repository.save(new InputFiltration().setCustomField("Test data1").setName("1").setShortName("1sh").setInn("1111"));
		repository.save(new InputFiltration().setCustomField("Test data2").setName("2").setShortName("2sh").setInn("2111"));
		repository.save(new InputFiltration().setCustomField("Test data3").setName("3").setShortName("3sh").setInn("3111"));
		repository.save(new InputFiltration().setCustomField("Test data4").setName("4").setShortName("4sh").setInn("4111"));
		//repository.save(new InputFiltration().setCustomField("Test data5").setName("1").setShortName("1sh").setInn("1111"));
	//	repository.save(new InputFiltration().setCustomField("Test data6").setName("1").setShortName("1sh").setInn("1111"));
	//	repository.save(new InputFiltration().setCustomField("Test data7").setName("1").setShortName("1sh").setInn("1111"));
	}

}
