package org.demo.documentation.widgets.tree.any.data.departments;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntityMydepartmensTestDataLoadService {

	@Autowired
	MydepartmensRepository repository;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));

		repository.deleteAll();
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

		repository.save(new Mydepartments()
				.setParentId(deputies.getId())
				.setDepartmentName("Head of the Government Office – Minister"));

		repository.save(new Mydepartments()
				.setParentId(deputies.getId())
				.setDepartmentName("Federal Service for Surveillance in Healthcare"));

		repository.save(new Mydepartments()
				.setParentId(deputies.getId())
				.setDepartmentName("Federal Medical-Biological Agency"));

		repository.save(new Mydepartments()
				.setParentId(deputies.getId())
				.setDepartmentName("Federal Agency for Tourism"));

		repository.save(new Mydepartments()
				.setParentId(deputies.getId())
				.setDepartmentName("Federal Service for Supervision in Education and Science"));

		repository.save(new Mydepartments()
				.setParentId(deputies.getId())
				.setDepartmentName("Federal Agency for Youth Affairs"));

		repository.save(new Mydepartments()
				.setParentId(deputies.getId())
				.setDepartmentName("Federal Service for Hydrometeorology and Environmental Monitoring"));

		repository.save(new Mydepartments()
				.setParentId(deputies.getId())
				.setDepartmentName("Federal Service for Supervision of Natural Resources"));

		repository.save(new Mydepartments()
				.setParentId(deputies.getId())
				.setDepartmentName("Federal Agency for Water Resources"));

		repository.save(new Mydepartments()
				.setParentId(deputies.getId())
				.setDepartmentName("Federal Agency for Forestry"));

		repository.save(new Mydepartments()
				.setParentId(deputies.getId())
				.setDepartmentName("Federal Agency for Subsoil Use"));

		repository.save(new Mydepartments()
				.setParentId(deputies.getId())
				.setDepartmentName("Federal Agency for Technical Regulation and Metrology"));

		repository.save(new Mydepartments()
				.setParentId(deputies.getId())
				.setDepartmentName("Federal Service for Supervision of Communications, Information Technology and Mass Media"));

		repository.save(new Mydepartments()
				.setParentId(deputies.getId())
				.setDepartmentName("Federal Agency for Press and Mass Communications"));

		repository.save(new Mydepartments()
				.setParentId(deputies.getId())
				.setDepartmentName("Federal Communications Agency"));

		repository.save(new Mydepartments()
				.setParentId(deputies.getId())
				.setDepartmentName("Federal Service for Veterinary and Phytosanitary Surveillance"));

		repository.save(new Mydepartments()
				.setParentId(deputies.getId())
				.setDepartmentName("Federal Agency for Fisheries"));

		repository.save(new Mydepartments()
				.setParentId(deputies.getId())
				.setDepartmentName("Federal Service for Supervision in Transport"));

		repository.save(new Mydepartments()
				.setParentId(deputies.getId())
				.setDepartmentName("Federal Air Transport Agency"));

		repository.save(new Mydepartments()
				.setParentId(deputies.getId())
				.setDepartmentName("Federal Road Agency"));

		repository.save(new Mydepartments()
				.setParentId(deputies.getId())
				.setDepartmentName("Federal Railway Agency"));

		repository.save(new Mydepartments()
				.setParentId(deputies.getId())
				.setDepartmentName("Federal Agency for Maritime and River Transport"));

		Mydepartments rootPresident = new Mydepartments()
				.setDepartmentName("President");
		repository.save(rootPresident);

		repository.save(new Mydepartments()
				.setParentId(rootPresident.getId())
				.setDepartmentName("Ministry of Internal Affairs"));

		repository.save(new Mydepartments()
				.setParentId(rootPresident.getId())
				.setDepartmentName("Ministry for Civil Defense, Emergencies and Disaster Relief"));

		repository.save(new Mydepartments()
				.setParentId(rootPresident.getId())
				.setDepartmentName("Ministry of Foreign Affairs"));

		repository.save(new Mydepartments()
				.setParentId(rootPresident.getId())
				.setDepartmentName("Federal Agency for CIS Affairs, Compatriots Living Abroad, and International Humanitarian Cooperation"));

		repository.save(new Mydepartments()
				.setParentId(rootPresident.getId())
				.setDepartmentName("Ministry of Defense"));

		repository.save(new Mydepartments()
				.setParentId(rootPresident.getId())
				.setDepartmentName("Federal Service for Military-Technical Cooperation"));

		repository.save(new Mydepartments()
				.setParentId(rootPresident.getId())
				.setDepartmentName("Federal Service for Technical and Export Control"));

		repository.save(new Mydepartments()
				.setParentId(rootPresident.getId())
				.setDepartmentName("Ministry of Justice"));

		repository.save(new Mydepartments()
				.setParentId(rootPresident.getId())
				.setDepartmentName("Federal Penitentiary Service"));

		repository.save(new Mydepartments()
				.setParentId(rootPresident.getId())
				.setDepartmentName("Federal Bailiff Service"));
	}

}