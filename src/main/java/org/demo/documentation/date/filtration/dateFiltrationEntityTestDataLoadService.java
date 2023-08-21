package org.demo.documentation.date.filtration;

import java.time.LocalDate;
import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class dateFiltrationEntityTestDataLoadService {

	@Autowired
	dateFiltrationEntityRepository repository;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository.save(new dateFiltrationEntity().setCustomField(LocalDate.now()));
		repository.save(new dateFiltrationEntity().setCustomField(LocalDate.now().minusDays(30)));
		repository.save(new dateFiltrationEntity().setCustomField(LocalDate.now().minusYears(3).minusDays(2)));
		repository.save(new dateFiltrationEntity().setCustomField(LocalDate.now().minusYears(2).minusDays(1)));
		repository.save(new dateFiltrationEntity().setCustomField(LocalDate.now().minusDays(2)));
		repository.save(new dateFiltrationEntity().setCustomField(LocalDate.now().minusYears(1)));
		repository.save(new dateFiltrationEntity().setCustomField(LocalDate.now().minusYears(2)));
		repository.save(new dateFiltrationEntity().setCustomField(LocalDate.now().plusMonths(1)));
		repository.save(new dateFiltrationEntity().setCustomField(LocalDate.now().plusMonths(2)));
	}

}