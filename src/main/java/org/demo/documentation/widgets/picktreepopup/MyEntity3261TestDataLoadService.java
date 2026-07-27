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

		  Myexample3261 myexample1 = new Myexample3261()
				  .setDepartment("IT Department")
				  .setIsLeaf(false);
		repository3261.save(myexample1);
		Myexample3261 myexample2 = new Myexample3261()
				.setParentId(myexample1.getId())
				.setDepartment("Development team")
				.setIsLeaf(false);
		repository3261.save(myexample2);
		Myexample3261 myexample3 = new Myexample3261()
				.setParentId(myexample2.getId())
				.setDepartment("John Smith")
				.setIsLeaf(true);
		repository3261.save(myexample3);

		repository3261.save(new Myexample3261()
				.setParentId(myexample2.getId())
				.setDepartment("Peter Brown")
				.setIsLeaf(true));

		Myexample3261 myexample5 = new Myexample3261()
				.setParentId(myexample1.getId())
				.setDepartment("QA team")
				.setIsLeaf(false);

		repository3261.save(myexample5);
		Myexample3261 myexample6 =
		 new Myexample3261()
				.setParentId(myexample5.getId())
				.setDepartment("Anna White")
				.setIsLeaf(true);
		repository3261.save(myexample6);

		Myexample3261 myexample7 = new Myexample3261()
				.setParentId(myexample1.getId())
				.setDepartment("Support team")
				.setIsLeaf(false);
		repository3261.save(myexample7);

		repository3261.save(new Myexample3261()
				.setParentId(myexample7.getId())
				.setDepartment("Kim Foster")
				.setIsLeaf(true));

		Myexample3261 myexample9 = new Myexample3261()
				.setDepartment("Finance Department")
				.setIsLeaf(false);
		repository3261.save(myexample9);
		Myexample3261 myexample10 = new Myexample3261()
				.setParentId(myexample9.getId())
				.setDepartment("Accounting team")
				.setIsLeaf(false);
		repository3261.save(myexample10);
		repository3261.save(new Myexample3261()
				.setParentId(myexample10.getId())
				.setDepartment("Robert Clark")
				.setIsLeaf(true));

		repository3261.save(new Myexample3261()
				.setParentId(myexample10.getId())
				.setDepartment("Maria Lopez")
				.setIsLeaf(true));
		
		repository3260.save(new Myexample3260());
	}

}