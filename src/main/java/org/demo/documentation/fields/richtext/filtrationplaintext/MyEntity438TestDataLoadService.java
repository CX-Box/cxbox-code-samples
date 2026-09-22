package org.demo.documentation.fields.richtext.filtrationplaintext;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity438TestDataLoadService {

	@Autowired
	MyEntity438Repository repository;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository.save(new MyEntity438().setCustomField("**Metal** type: a font would not include a single definition of each character."));
		repository.save(new MyEntity438().setCustomField("The rest of the characters would be provided in *quantities* appropriate for the language."));
		repository.save(new MyEntity438().setCustomField("Some metal type characters, such as ~~dashes~~ and spaces, were generic pieces."));
		repository.save(new MyEntity438().setCustomField("A typeface may come in fonts of many {blue}(weights), from ultra-light to extra-bold."));
	}

}
