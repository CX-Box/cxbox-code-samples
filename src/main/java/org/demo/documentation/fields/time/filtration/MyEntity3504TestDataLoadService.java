package org.demo.documentation.fields.time.filtration;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MyEntity3504TestDataLoadService {

	@Autowired
	MyEntity3504Repository repository;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		LocalDateTime BASE_NOW = LocalDateTime.of(2024, 1, 10, 12, 0, 0);
		LocalDateTime MINUS_30_MIN_4_DAYS = LocalDateTime.of(2024, 1, 6, 11, 30, 0);
		LocalDateTime MINUS_2_HOURS_1_YEAR = LocalDateTime.of(2023, 1, 10, 10, 0, 0);
		LocalDateTime MINUS_7_HOURS_2_MONTHS = LocalDateTime.of(2023, 11, 10, 5, 0, 0);
		LocalDateTime COMPLEX_DATE = LocalDateTime.of(2024, 1, 9, 9, 57, 0);

		repository.save(
				new MyEntity3504()
						.setCustomField(BASE_NOW)
						.setCustomFieldh(BASE_NOW)
						.setCustomFieldhmm(BASE_NOW)
						.setCustomFieldhmmA(BASE_NOW)
						.setCustomFieldmmss(BASE_NOW)
						.setCustomFieldhmmssA(BASE_NOW)
						.setCustomFieldss(BASE_NOW)
						.setCustomFieldmm(BASE_NOW)
		);

		repository.save(
				new MyEntity3504()
						.setCustomField(MINUS_30_MIN_4_DAYS)
						.setCustomFieldh(MINUS_30_MIN_4_DAYS)
						.setCustomFieldhmm(MINUS_30_MIN_4_DAYS)
						.setCustomFieldhmmA(MINUS_30_MIN_4_DAYS)
						.setCustomFieldmmss(MINUS_30_MIN_4_DAYS)
						.setCustomFieldhmmssA(MINUS_30_MIN_4_DAYS));

		repository.save(
				new MyEntity3504()
						.setCustomField(MINUS_2_HOURS_1_YEAR)
						.setCustomFieldh(MINUS_2_HOURS_1_YEAR)
						.setCustomFieldhmm(MINUS_2_HOURS_1_YEAR)
						.setCustomFieldhmmA(MINUS_2_HOURS_1_YEAR)
						.setCustomFieldmmss(MINUS_2_HOURS_1_YEAR)
						.setCustomFieldhmmssA(MINUS_2_HOURS_1_YEAR)
						.setCustomFieldss(MINUS_2_HOURS_1_YEAR)
						.setCustomFieldhA(MINUS_2_HOURS_1_YEAR)
						.setCustomFieldmm(MINUS_2_HOURS_1_YEAR));

		repository.save(
				new MyEntity3504()
						.setCustomField(COMPLEX_DATE)
						.setCustomFieldh(MINUS_7_HOURS_2_MONTHS)
						.setCustomFieldhmm(MINUS_7_HOURS_2_MONTHS)
						.setCustomFieldhmmA(MINUS_7_HOURS_2_MONTHS)
						.setCustomFieldmmss(MINUS_7_HOURS_2_MONTHS)
						.setCustomFieldhmmssA(MINUS_7_HOURS_2_MONTHS)
						.setCustomFieldss(MINUS_7_HOURS_2_MONTHS)
						.setCustomFieldmm(MINUS_7_HOURS_2_MONTHS));
	}

}