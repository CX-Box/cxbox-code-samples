package org.demo.documentation.fields.datetime.sorting;

import java.time.LocalDateTime;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DateTimeSortTestDataLoadService {

	@Autowired
	DateTimeSortRepository repository;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository.save(new DateTimeSort().setCustomField(LocalDateTime.of(2025, 5, 15, 8, 50)));
		repository.save(new DateTimeSort().setCustomField(LocalDateTime.of(2025, 5, 15, 8, 53)));
		repository.save(new DateTimeSort().setCustomField(LocalDateTime.of(2025, 5, 15, 9, 20)));
		repository.save(new DateTimeSort().setCustomField(LocalDateTime.of(2025, 5, 15, 6, 50)));
		repository.save(new DateTimeSort().setCustomField(LocalDateTime.of(2025, 5, 14, 6, 17)));
		repository.save(new DateTimeSort().setCustomField(LocalDateTime.of(2025, 5, 15, 9, 5)));
		repository.save(new DateTimeSort().setCustomField(LocalDateTime.of(2024, 5, 15, 5, 5)));
		repository.save(new DateTimeSort().setCustomField(LocalDateTime.of(2023, 5, 15, 8, 50)));
		repository.save(new DateTimeSort().setCustomField(LocalDateTime.of(2025, 6, 15, 6, 5)));
	}

}