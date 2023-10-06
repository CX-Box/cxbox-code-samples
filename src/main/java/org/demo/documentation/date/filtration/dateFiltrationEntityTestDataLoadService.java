package org.demo.documentation.date.filtration;

import java.time.LocalDateTime;
import java.time.LocalDateTime;
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
		repository.save(new dateFiltrationEntity().setCustomField(LocalDateTime.now()));
		repository.save(new dateFiltrationEntity().setCustomField(LocalDateTime.now().minusDays(30)));
		repository.save(new dateFiltrationEntity().setCustomField(LocalDateTime.now().minusYears(3).minusDays(2)));
		repository.save(new dateFiltrationEntity().setCustomField(LocalDateTime.now().minusYears(2).minusDays(1)));
		repository.save(new dateFiltrationEntity().setCustomField(LocalDateTime.now().minusDays(2)));
		repository.save(new dateFiltrationEntity().setCustomField(LocalDateTime.now().minusYears(1)));
		repository.save(new dateFiltrationEntity().setCustomField(LocalDateTime.now().minusYears(2)));
		repository.save(new dateFiltrationEntity().setCustomField(LocalDateTime.now().plusMonths(1)));
		repository.save(new dateFiltrationEntity().setCustomField(LocalDateTime.now().plusMonths(2)));
	}

}