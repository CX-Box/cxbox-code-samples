package org.demo.documentation.widgets.tree.any.data.users;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.widgets.tree.any.data.departments.MydepartmensRepository;
import org.demo.documentation.widgets.tree.any.data.departments.Mydepartments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntityMyusers361TestDataLoadService {
 
	@Autowired
	Myusers361Repository repository;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.save(new My3261Users()
				.setLastName("Smith")
				.setFirstName("John")
				.setMiddleName("Michael"));

		repository.save(new My3261Users()
				.setLastName("Johnson")
				.setFirstName("Emily")
				.setMiddleName("Anne"));

		repository.save(new My3261Users()
				.setLastName("Williams")
				.setFirstName("David")
				.setMiddleName("Robert"));

		repository.save(new My3261Users()
				.setLastName("Brown")
				.setFirstName("Sarah")
				.setMiddleName("Elizabeth"));

		repository.save(new My3261Users()
				.setLastName("Jones")
				.setFirstName("James")
				.setMiddleName("William"));

		repository.save(new My3261Users()
				.setLastName("Garcia")
				.setFirstName("Maria")
				.setMiddleName("Louise"));

		repository.save(new My3261Users()
				.setLastName("Miller")
				.setFirstName("Robert")
				.setMiddleName("Edward"));

		repository.save(new My3261Users()
				.setLastName("Davis")
				.setFirstName("Jennifer")
				.setMiddleName("Lynn"));

		repository.save(new My3261Users()
				.setLastName("Rodriguez")
				.setFirstName("Michael")
				.setMiddleName("Thomas"));

		repository.save(new My3261Users()
				.setLastName("Martinez")
				.setFirstName("Linda")
				.setMiddleName("Marie"));

		repository.save(new My3261Users()
				.setLastName("Hernandez")
				.setFirstName("William")
				.setMiddleName("Joseph"));

		repository.save(new My3261Users()
				.setLastName("Lopez")
				.setFirstName("Patricia")
				.setMiddleName("Ann"));

		repository.save(new My3261Users()
				.setLastName("Wilson")
				.setFirstName("Richard")
				.setMiddleName("Charles"));

		repository.save(new My3261Users()
				.setLastName("Anderson")
				.setFirstName("Susan")
				.setMiddleName("Kay"));

		repository.save(new My3261Users()
				.setLastName("Thomas")
				.setFirstName("Thomas")
				.setMiddleName("Daniel"));

		repository.save(new My3261Users()
				.setLastName("Taylor")
				.setFirstName("Jessica")
				.setMiddleName("Rose"));

		repository.save(new My3261Users()
				.setLastName("Moore")
				.setFirstName("Christopher")
				.setMiddleName("Paul"));

		repository.save(new My3261Users()
				.setLastName("Jackson")
				.setFirstName("Karen")
				.setMiddleName("Sue"));

		repository.save(new My3261Users()
				.setLastName("Martin")
				.setFirstName("Matthew")
				.setMiddleName("George"));

		repository.save(new My3261Users()
				.setLastName("Lee")
				.setFirstName("Nancy")
				.setMiddleName("Jane"));
		repository.deleteAll();
	}

}