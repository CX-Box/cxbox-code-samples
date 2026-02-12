package org.demo.documentation.other.alltypes;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.other.alltypes.enums.DictionaryTypeEnum;
import org.demo.documentation.other.alltypes.enums.MultipleTypeEnum;
import org.demo.documentation.other.alltypes.enums.RadioTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class MyEntity421TestDataLoadService {

	@Autowired
	MyEntity421Repository repository;
	@Autowired
	MyEntity422Repository repository422;
	@Autowired
	MyEntity423Repository repository423;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		MyEntity422 myEntity422 = new MyEntity422().setCustomField("Test data");
		MyEntity423 myEntity423 = new MyEntity423().setCustomField("Test data");
		repository423.save(myEntity423);
		MyEntity424 myEntity424 = new MyEntity424().setCustomField("Test data");
		repository422.save(new MyEntity422().setCustomField("New data"));
		repository423.save(new MyEntity423().setCustomField("New data"));
		List<MyEntity422> list = new ArrayList<>();
		list.add(myEntity422);
		List<MyEntity424> list424 = new ArrayList<>();
		list424.add(myEntity424);
		repository.save(new MyEntity421()
				.setMultipleType(Collections.singleton(MultipleTypeEnum.LOW))
				.setMultihoverTypeList(list424)
				.setMultivalueTypeList(list)
				.setInlinepicklistTypeEntity(myEntity423)
				.setPicklistTypeEntity(myEntity422)
				.setRadioType(RadioTypeEnum.MIDDLE)
				.setPercentTypeDouble(Double.valueOf(27000.78))
				.setPercentType(Long.valueOf(27000))
				.setInputField("Test data")
				.setTextType("Text data")
				.setHiddenType("Test data")
				.setNumberTypeDouble(Double.valueOf(27000.78))
				.setNumberType(Long.valueOf(27000))
				.setDictionaryType(DictionaryTypeEnum.MIDDLE)
				.setMoneyType(Double.valueOf(27000.78))
				.setDateTimeWithSecondsType(LocalDateTime.now())
				.setDateType(LocalDateTime.now())
				.setDateTimeType(LocalDateTime.now())
				.setCustomField("test data")
				.setCheckboxType(Boolean.TRUE)
				.setHintType("Hint text"));
	}

}