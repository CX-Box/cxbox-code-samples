package org.demo.documentation.widgets.picktreepopup;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.widgets.picktreepopup.tree.MyEntity3261Repository;
import org.demo.documentation.widgets.picktreepopup.tree.Myexample3261;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity3261TestDataLoadService {

	@Autowired
	MyEntity3261Repository repository3261;

	@Autowired
	MyEntity3260Repository repository3260;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository3261.deleteAll();
		repository3260.deleteAll();
		repository3261.save(new Myexample3261()
				.setDepartment("IT Department")
				.setIsLeaf(false));

		repository3261.save(new Myexample3261()
				.setParentId(1L)
				.setDepartment("Development team")
				.setIsLeaf(false));

		repository3261.save(new Myexample3261()
				.setParentId(2L)
				.setDepartment("John Smith")
				.setIsLeaf(true));

		repository3261.save(new Myexample3261()
				.setParentId(2L)
				.setDepartment("Peter Brown")
				.setIsLeaf(true));

		repository3261.save(new Myexample3261()
				.setParentId(1L)
				.setDepartment("QA team")
				.setIsLeaf(false));

		repository3261.save(new Myexample3261()
				.setParentId(5L)
				.setDepartment("Anna White")
				.setIsLeaf(true));

		repository3261.save(new Myexample3261()
				.setParentId(1L)
				.setDepartment("Support team")
				.setIsLeaf(false));

		repository3261.save(new Myexample3261()
				.setParentId(7L)
				.setDepartment("Kim Foster")
				.setIsLeaf(true));

		repository3261.save(new Myexample3261()
				.setDepartment("Finance Department")
				.setIsLeaf(false));

		repository3261.save(new Myexample3261()
				.setParentId(9L)
				.setDepartment("Accounting team")
				.setIsLeaf(false));

		repository3261.save(new Myexample3261()
				.setParentId(10L)
				.setDepartment("Robert Clark")
				.setIsLeaf(true));

		repository3261.save(new Myexample3261()
				.setParentId(10L)
				.setDepartment("Maria Lopez")
				.setIsLeaf(true));
		
		repository3260.save(new Myexample3260());
	}

}