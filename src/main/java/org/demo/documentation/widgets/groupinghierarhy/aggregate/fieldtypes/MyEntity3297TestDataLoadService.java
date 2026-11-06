package org.demo.documentation.widgets.groupinghierarhy.aggregate.fieldtypes;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import java.time.LocalDateTime;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.widgets.groupinghierarhy.aggregate.fieldtypes.enums.CustomFieldDictionaryEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity3297TestDataLoadService {

	@Autowired
	MyEntity3297Repository repository;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository.save(row(CustomFieldDictionaryEnum.MOVABLE, "Description 1", 100L, 1500.25, 10L,
				LocalDateTime.of(2025, 1, 15, 10, 30), "200", "#edeaa6"
		));
		repository.save(row(CustomFieldDictionaryEnum.MOVABLE, "Description 2", 300L, 2500.50, 30L,
				LocalDateTime.of(2025, 3, 20, 14, 0), "400", "#a6eda6"
		));
		repository.save(row(CustomFieldDictionaryEnum.IMMOVABLE, "Description 3", 500L, 10000.00, 50L,
				LocalDateTime.of(2025, 6, 1, 9, 15), "600", "#a6c8ed"
		));
		repository.save(row(CustomFieldDictionaryEnum.LAND, "Description 4", 700L, 750.75, 70L,
				LocalDateTime.of(2025, 9, 10, 18, 45), "800", "#eda6a6"
		));
	}

	private MyEntity3297 row(CustomFieldDictionaryEnum dictionary, String text, Long number, Double money, Long percent,
			LocalDateTime date, String input, String color) {
		return new MyEntity3297()
				.setCustomFieldDictionary(dictionary)
				.setCustomField(text)
				.setCustomFieldNumber(number)
				.setCustomFieldMoney(money)
				.setCustomFieldPercent(percent)
				.setCustomFieldDate(date)
				.setCustomFieldDateTime(date)
				.setCustomFieldInput(input)
				.setCustomFieldColor(color);
	}

}
