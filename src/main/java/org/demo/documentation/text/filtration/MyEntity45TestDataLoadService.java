package org.demo.documentation.text.filtration;

import javax.annotation.PostConstruct;
import  jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity45TestDataLoadService {

	@Autowired
	MyEntity45Repository repository;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository.save(new MyEntity45().setCustomField(
				"Unlike a digital typeface, a metal font would not include a single definition of each character, but commonly used characters (such as vowels and periods) would have more physical type-pieces included."));
		repository.save(new MyEntity45().setCustomField(
				"The rest of the characters would be provided in quantities appropriate for the distribution of letters in that language."));
		repository.save(new MyEntity45().setCustomField(
				"Some metal type characters required in typesetting, such as dashes, spaces and line-height spacers, were not part of a specific font, but were generic pieces that could be used with any font"));
		repository.save(new MyEntity45().setCustomField(
				"A typeface may come in fonts of many weights, from ultra-light to extra-bold or black; four to six weights are not unusual, and a few typefaces have as many as a dozen. "));

	}

}