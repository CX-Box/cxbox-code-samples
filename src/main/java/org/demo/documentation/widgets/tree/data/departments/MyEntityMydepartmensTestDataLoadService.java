package org.demo.documentation.widgets.tree.data.departments;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.widgets.tree.data.users.My3261Users;
import org.demo.documentation.widgets.tree.data.users.Myusers361Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class MyEntityMydepartmensTestDataLoadService {

	@Autowired
	MydepartmensRepository repository;

	@Autowired
	Myusers361Repository repositoryUser;

	@Autowired
	InternalAuthorizationService authzService;


	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));

		repository.deleteAll();
		repositoryUser.deleteAll();

		List<Mydepartments> leafDepartments = new ArrayList<>();

		Mydepartments rootGov = new Mydepartments()
				.setDepartmentName("Government");
		repository.save(rootGov);

		Mydepartments structure = new Mydepartments()
				.setParentId(rootGov.getId())
				.setDepartmentName("Structure of Federal Executive Authorities");
		repository.save(structure);

		Mydepartments chairman = new Mydepartments()
				.setParentId(structure.getId())
				.setDepartmentName("Prime Minister");
		repository.save(chairman);

		Mydepartments deputies = new Mydepartments()
				.setParentId(chairman.getId())
				.setDepartmentName("Deputy Prime Ministers");
		repository.save(deputies);

		// Deputy Prime Ministers
		leafDepartments.add(repository.save(new Mydepartments()
				.setParentId(deputies.getId())
				.setDepartmentName("Head of the Government Office – Minister")));

		leafDepartments.add(repository.save(new Mydepartments()
				.setParentId(deputies.getId())
				.setDepartmentName("Federal Service for Surveillance in Healthcare")));

		leafDepartments.add(repository.save(new Mydepartments()
				.setParentId(deputies.getId())
				.setDepartmentName("Federal Medical-Biological Agency")));

		leafDepartments.add(repository.save(new Mydepartments()
				.setParentId(deputies.getId())
				.setDepartmentName("Federal Agency for Tourism")));

		leafDepartments.add(repository.save(new Mydepartments()
				.setParentId(deputies.getId())
				.setDepartmentName("Federal Service for Supervision in Education and Science")));

		leafDepartments.add(repository.save(new Mydepartments()
				.setParentId(deputies.getId())
				.setDepartmentName("Federal Agency for Youth Affairs")));

		leafDepartments.add(repository.save(new Mydepartments()
				.setParentId(deputies.getId())
				.setDepartmentName("Federal Service for Hydrometeorology and Environmental Monitoring")));

		leafDepartments.add(repository.save(new Mydepartments()
				.setParentId(deputies.getId())
				.setDepartmentName("Federal Service for Supervision of Natural Resources")));

		leafDepartments.add(repository.save(new Mydepartments()
				.setParentId(deputies.getId())
				.setDepartmentName("Federal Agency for Water Resources")));

		leafDepartments.add(repository.save(new Mydepartments()
				.setParentId(deputies.getId())
				.setDepartmentName("Federal Agency for Forestry")));

		leafDepartments.add(repository.save(new Mydepartments()
				.setParentId(deputies.getId())
				.setDepartmentName("Federal Agency for Subsoil Use")));

		leafDepartments.add(repository.save(new Mydepartments()
				.setParentId(deputies.getId())
				.setDepartmentName("Federal Agency for Technical Regulation and Metrology")));

		leafDepartments.add(repository.save(new Mydepartments()
				.setParentId(deputies.getId())
				.setDepartmentName("Federal Service for Supervision of Communications, Information Technology and Mass Media")));

		leafDepartments.add(repository.save(new Mydepartments()
				.setParentId(deputies.getId())
				.setDepartmentName("Federal Agency for Press and Mass Communications")));

		leafDepartments.add(repository.save(new Mydepartments()
				.setParentId(deputies.getId())
				.setDepartmentName("Federal Communications Agency")));

		leafDepartments.add(repository.save(new Mydepartments()
				.setParentId(deputies.getId())
				.setDepartmentName("Federal Service for Veterinary and Phytosanitary Surveillance")));

		leafDepartments.add(repository.save(new Mydepartments()
				.setParentId(deputies.getId())
				.setDepartmentName("Federal Agency for Fisheries")));

		leafDepartments.add(repository.save(new Mydepartments()
				.setParentId(deputies.getId())
				.setDepartmentName("Federal Service for Supervision in Transport")));

		leafDepartments.add(repository.save(new Mydepartments()
				.setParentId(deputies.getId())
				.setDepartmentName("Federal Air Transport Agency")));

		leafDepartments.add(repository.save(new Mydepartments()
				.setParentId(deputies.getId())
				.setDepartmentName("Federal Road Agency")));

		leafDepartments.add(repository.save(new Mydepartments()
				.setParentId(deputies.getId())
				.setDepartmentName("Federal Railway Agency")));

		leafDepartments.add(repository.save(new Mydepartments()
				.setParentId(deputies.getId())
				.setDepartmentName("Federal Agency for Maritime and River Transport")));

		Mydepartments rootPresident = new Mydepartments()
				.setDepartmentName("President");
		repository.save(rootPresident);

		// President
		leafDepartments.add(repository.save(new Mydepartments()
				.setParentId(rootPresident.getId())
				.setDepartmentName("Ministry of Internal Affairs")));

		leafDepartments.add(repository.save(new Mydepartments()
				.setParentId(rootPresident.getId())
				.setDepartmentName("Ministry for Civil Defense, Emergencies and Disaster Relief")));

		leafDepartments.add(repository.save(new Mydepartments()
				.setParentId(rootPresident.getId())
				.setDepartmentName("Ministry of Foreign Affairs")));

		leafDepartments.add(repository.save(new Mydepartments()
				.setParentId(rootPresident.getId())
				.setDepartmentName("Federal Agency for CIS Affairs, Compatriots Living Abroad, and International Humanitarian Cooperation")));

		leafDepartments.add(repository.save(new Mydepartments()
				.setParentId(rootPresident.getId())
				.setDepartmentName("Ministry of Defense")));

		leafDepartments.add(repository.save(new Mydepartments()
				.setParentId(rootPresident.getId())
				.setDepartmentName("Federal Service for Military-Technical Cooperation")));

		leafDepartments.add(repository.save(new Mydepartments()
				.setParentId(rootPresident.getId())
				.setDepartmentName("Federal Service for Technical and Export Control")));

		leafDepartments.add(repository.save(new Mydepartments()
				.setParentId(rootPresident.getId())
				.setDepartmentName("Ministry of Justice")));

		leafDepartments.add(repository.save(new Mydepartments()
				.setParentId(rootPresident.getId())
				.setDepartmentName("Federal Penitentiary Service")));

		leafDepartments.add(repository.save(new Mydepartments()
				.setParentId(rootPresident.getId())
				.setDepartmentName("Federal Bailiff Service")));


		repositoryUser.save(new My3261Users()
				.setLastName("Smith")
				.setFirstName("John")
				.setMiddleName("Michael"));



		for (Mydepartments dept : leafDepartments) {
			int count = ThreadLocalRandom.current().nextInt(0, 6);
			List<My3261Users> usersForDept = new ArrayList<>();
			for (int i = 0; i < count; i++) {
				My3261Users user = new My3261Users()
						.setLastName("Smith" + i)
						.setFirstName("John" + i )
						.setMiddleName("Michael" + i );
				repositoryUser.save(user);
				usersForDept.add(user);
			}
			dept.setFullNameList(usersForDept);
			repository.save(dept);
		}
	}
}