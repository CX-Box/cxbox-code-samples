package org.demo.documentation.fields.richtext.basic;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity425TestDataLoadService {

	@Autowired
	MyEntity425Repository repository;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository.save(new MyEntity425().setCustomField("""
				# Rich text

				A **bold** word, an *italic* one, ++underlined++, ~~struck out~~, `inline code` and {red}(coloured) text.

				- bullet item with {green}(colour)
				- bullet item with **bold**

				> A quote with a [link](https://cxbox.org).
				"""));
	}

}
