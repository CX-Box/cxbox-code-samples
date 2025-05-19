package org.demo.documentation.fields.date.filtration;

import java.time.LocalDateTime;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
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
		repository.save(new dateFiltrationEntity().setCustomField(LocalDateTime.of(2025, 5, 15, 1,1)));
		repository.save(new dateFiltrationEntity().setCustomField(LocalDateTime.of(2025, 4, 15, 1,1)));
		repository.save(new dateFiltrationEntity().setCustomField(LocalDateTime.of(2022, 5, 13, 1,1)));
		repository.save(new dateFiltrationEntity().setCustomField(LocalDateTime.of(2023, 5, 14, 1,1)));
		repository.save(new dateFiltrationEntity().setCustomField(LocalDateTime.of(2025, 5, 13, 1,1)));
		repository.save(new dateFiltrationEntity().setCustomField(LocalDateTime.of(2024, 5, 15, 1,1)));
		repository.save(new dateFiltrationEntity().setCustomField(LocalDateTime.of(2023, 5, 15, 1,1)));
		repository.save(new dateFiltrationEntity().setCustomField(LocalDateTime.of(2025, 6, 15, 1,1)));
		repository.save(new dateFiltrationEntity().setCustomField(LocalDateTime.of(2025, 7, 15, 1,1)));
	}

}