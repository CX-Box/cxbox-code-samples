package org.demo.documentation.fields.datetimewithseconds.sorting;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public class DateTimeWithSecondsSortingEntityTestDataLoadService {

	@Autowired
	DateTimeWithSecondsSortingEntityRepository repository;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository.save(new DateTimeWithSecondsSortingEntity().setCustomField(LocalDateTime.of(2025, 5, 15, 8, 50, 42)));
		repository.save(new DateTimeWithSecondsSortingEntity().setCustomField(LocalDateTime.of(2023, 5, 15, 9, 20, 42)));
		repository.save(new DateTimeWithSecondsSortingEntity().setCustomField(LocalDateTime.of(2025, 5, 15, 6, 50, 42)));
		repository.save(new DateTimeWithSecondsSortingEntity().setCustomField(LocalDateTime.of(2025, 5, 14, 7, 17, 42)));
		repository.save(new DateTimeWithSecondsSortingEntity().setCustomField(LocalDateTime.of(2025, 5, 13, 9, 5, 42)));
		repository.save(new DateTimeWithSecondsSortingEntity().setCustomField(LocalDateTime.of(2024, 5, 15, 5, 5, 42)));
		repository.save(new DateTimeWithSecondsSortingEntity().setCustomField(LocalDateTime.of(2025, 5, 13, 9, 5, 42)));
		repository.save(new DateTimeWithSecondsSortingEntity().setCustomField(LocalDateTime.of(2025, 6, 15, 6, 5, 42)));
		repository.save(new DateTimeWithSecondsSortingEntity().setCustomField(LocalDateTime.of(2025, 7, 15, 9, 20, 42)));
	}

}