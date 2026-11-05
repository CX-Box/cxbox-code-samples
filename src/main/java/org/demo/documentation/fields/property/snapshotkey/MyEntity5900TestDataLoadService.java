package org.demo.documentation.fields.property.snapshotkey;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.fields.property.snapshotkey.enums.CustomFieldEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity5900TestDataLoadService {

	@Autowired
	MyEntity5900Repository repository;

	@Autowired
	MyEntity5900PickRepository pickRepository;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		pickRepository.deleteAll();
		MyEntity5900Pick pickOld = pickRepository.save(new MyEntity5900Pick().setCustomField("Old data"));
		MyEntity5900Pick pickNew = pickRepository.save(new MyEntity5900Pick().setCustomField("New data"));
		pickRepository.save(new MyEntity5900Pick().setCustomField("Other data"));

		List<MyEntity5900> scenarios = new ArrayList<>();
		scenarios.add(new MyEntity5900()
				.setScenario("1. Value changed")
				.setInputField("New value").setInputFieldSnapshot("Old value")
				.setTextField("The quick red fox jumped over the lazy dog")
				.setTextFieldSnapshot("The quick brown fox jumps over the lazy dog")
				.setHintField("New hint").setHintFieldSnapshot("Old hint")
				.setNumberField(2000L).setNumberFieldSnapshot(1000L)
				.setMoneyField(2000.55).setMoneyFieldSnapshot(1000.25)
				.setPercentField(20L).setPercentFieldSnapshot(10L)
				.setDateField(LocalDateTime.of(2025, 2, 20, 0, 0))
				.setDateFieldSnapshot(LocalDateTime.of(2025, 1, 10, 0, 0))
				.setDateTimeField(LocalDateTime.of(2025, 2, 20, 18, 30))
				.setDateTimeFieldSnapshot(LocalDateTime.of(2025, 1, 10, 9, 15))
				.setDateTimeWithSecondsField(LocalDateTime.of(2025, 2, 20, 18, 30, 45))
				.setDateTimeWithSecondsFieldSnapshot(LocalDateTime.of(2025, 1, 10, 9, 15, 5))
				.setCheckboxField(true).setCheckboxFieldSnapshot(false)
				.setPickListEntity(pickNew).setPickListFieldSnapshot(pickOld.getCustomField())
				.setInlinePickListEntity(pickNew).setInlinePickListFieldSnapshot(pickOld.getCustomField())
				.setDictionaryField(CustomFieldEnum.HIGH).setDictionaryFieldSnapshot(CustomFieldEnum.LOW)
				.setRadioField(CustomFieldEnum.HIGH).setRadioFieldSnapshot(CustomFieldEnum.LOW));

		scenarios.add(new MyEntity5900()
				.setScenario("2. Value not changed")
				.setInputField("Same value").setInputFieldSnapshot("Same value")
				.setTextField("The quick brown fox jumps over the lazy dog")
				.setTextFieldSnapshot("The quick brown fox jumps over the lazy dog")
				.setHintField("Same hint").setHintFieldSnapshot("Same hint")
				.setNumberField(1000L).setNumberFieldSnapshot(1000L)
				.setMoneyField(1000.25).setMoneyFieldSnapshot(1000.25)
				.setPercentField(10L).setPercentFieldSnapshot(10L)
				.setDateField(LocalDateTime.of(2025, 1, 10, 0, 0))
				.setDateFieldSnapshot(LocalDateTime.of(2025, 1, 10, 0, 0))
				.setDateTimeField(LocalDateTime.of(2025, 1, 10, 9, 15))
				.setDateTimeFieldSnapshot(LocalDateTime.of(2025, 1, 10, 9, 15))
				.setDateTimeWithSecondsField(LocalDateTime.of(2025, 1, 10, 9, 15, 5))
				.setDateTimeWithSecondsFieldSnapshot(LocalDateTime.of(2025, 1, 10, 9, 15, 5))
				.setCheckboxField(true).setCheckboxFieldSnapshot(true)
				.setPickListEntity(pickOld).setPickListFieldSnapshot(pickOld.getCustomField())
				.setInlinePickListEntity(pickOld).setInlinePickListFieldSnapshot(pickOld.getCustomField())
				.setDictionaryField(CustomFieldEnum.MIDDLE).setDictionaryFieldSnapshot(CustomFieldEnum.MIDDLE)
				.setRadioField(CustomFieldEnum.MIDDLE).setRadioFieldSnapshot(CustomFieldEnum.MIDDLE));

		scenarios.add(new MyEntity5900()
				.setScenario("3. Value added (snapshot is empty)")
				.setInputField("New value")
				.setTextField("The quick brown fox jumps over the lazy dog")
				.setHintField("New hint")
				.setNumberField(2000L)
				.setMoneyField(2000.55)
				.setPercentField(20L)
				.setDateField(LocalDateTime.of(2025, 2, 20, 0, 0))
				.setDateTimeField(LocalDateTime.of(2025, 2, 20, 18, 30))
				.setDateTimeWithSecondsField(LocalDateTime.of(2025, 2, 20, 18, 30, 45))
				.setCheckboxField(true)
				.setPickListEntity(pickNew)
				.setInlinePickListEntity(pickNew)
				.setDictionaryField(CustomFieldEnum.HIGH)
				.setRadioField(CustomFieldEnum.HIGH));

		scenarios.add(new MyEntity5900()
				.setScenario("4. Value deleted (current value is empty)")
				.setInputFieldSnapshot("Old value")
				.setTextFieldSnapshot("The quick brown fox jumps over the lazy dog")
				.setHintFieldSnapshot("Old hint")
				.setNumberFieldSnapshot(1000L)
				.setMoneyFieldSnapshot(1000.25)
				.setPercentFieldSnapshot(10L)
				.setDateFieldSnapshot(LocalDateTime.of(2025, 1, 10, 0, 0))
				.setDateTimeFieldSnapshot(LocalDateTime.of(2025, 1, 10, 9, 15))
				.setDateTimeWithSecondsFieldSnapshot(LocalDateTime.of(2025, 1, 10, 9, 15, 5))
				.setCheckboxFieldSnapshot(true)
				.setPickListFieldSnapshot(pickOld.getCustomField())
				.setInlinePickListFieldSnapshot(pickOld.getCustomField())
				.setDictionaryFieldSnapshot(CustomFieldEnum.LOW)
				.setRadioFieldSnapshot(CustomFieldEnum.LOW));

		scenarios.add(new MyEntity5900()
				.setScenario("5. Values false and 0")
				.setNumberField(10L).setNumberFieldSnapshot(0L)
				.setMoneyField(10.0).setMoneyFieldSnapshot(0.0)
				.setPercentField(0L).setPercentFieldSnapshot(10L)
				.setCheckboxField(true).setCheckboxFieldSnapshot(false));

		scenarios.add(new MyEntity5900()
				.setScenario("6. Checkbox: true -> false")
				.setCheckboxField(false).setCheckboxFieldSnapshot(true));

		// the list shows the last saved record first: the scenarios are saved from the last one
		Collections.reverse(scenarios);
		repository.saveAll(scenarios);
	}

}
