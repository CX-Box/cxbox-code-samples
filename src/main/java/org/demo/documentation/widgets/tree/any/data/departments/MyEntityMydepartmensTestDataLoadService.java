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
				.setDepartmentName("Правительство");
		repository.save(rootGov);

		Mydepartments structure = new Mydepartments()
				.setParentId(rootGov.getId())
				.setDepartmentName("Структура федеральных органов исполнительной власти");
		repository.save(structure);

		Mydepartments chairman = new Mydepartments()
				.setParentId(structure.getId())
				.setDepartmentName("Председатель Правительства");
		repository.save(chairman);

		Mydepartments deputies = new Mydepartments()
				.setParentId(chairman.getId())
				.setDepartmentName("Заместители Председателя Правительства");
		repository.save(deputies);

		repository.save(new Mydepartments()
				.setParentId(deputies.getId())
				.setDepartmentName("Руководитель Аппарата Правительства – Министр"));

		repository.save(new Mydepartments()
				.setParentId(deputies.getId())
				.setDepartmentName("Федеральная служба по надзору в сфере здравоохранения"));

		repository.save(new Mydepartments()
				.setParentId(deputies.getId())
				.setDepartmentName("Федеральное медико-биологическое агентство"));

		repository.save(new Mydepartments()
				.setParentId(deputies.getId())
				.setDepartmentName("Федеральное агентство по туризму"));

		repository.save(new Mydepartments()
				.setParentId(deputies.getId())
				.setDepartmentName("Федеральная служба по надзору в сфере образования и науки"));

		repository.save(new Mydepartments()
				.setParentId(deputies.getId())
				.setDepartmentName("Федеральное агентство по делам молодежи"));

		repository.save(new Mydepartments()
				.setParentId(deputies.getId())
				.setDepartmentName("Федеральная служба по гидрометеорологии и мониторингу окружающей среды"));

		repository.save(new Mydepartments()
				.setParentId(deputies.getId())
				.setDepartmentName("Федеральная служба по надзору в сфере природопользования"));

		repository.save(new Mydepartments()
				.setParentId(deputies.getId())
				.setDepartmentName("Федеральное агентство водных ресурсов"));

		repository.save(new Mydepartments()
				.setParentId(deputies.getId())
				.setDepartmentName("Федеральное агентство лесного хозяйства"));

		repository.save(new Mydepartments()
				.setParentId(deputies.getId())
				.setDepartmentName("Федеральное агентство по недропользованию"));

		repository.save(new Mydepartments()
				.setParentId(deputies.getId())
				.setDepartmentName("Федеральное агентство по техническому регулированию и метрологии"));

		repository.save(new Mydepartments()
				.setParentId(deputies.getId())
				.setDepartmentName("Федеральная служба по надзору в сфере связи, информационных технологий и массовых коммуникаций"));

		repository.save(new Mydepartments()
				.setParentId(deputies.getId())
				.setDepartmentName("Федеральное агентство по печати и массовым коммуникациям"));

		repository.save(new Mydepartments()
				.setParentId(deputies.getId())
				.setDepartmentName("Федеральное агентство связи"));

		repository.save(new Mydepartments()
				.setParentId(deputies.getId())
				.setDepartmentName("Федеральная служба по ветеринарному и фитосанитарному надзору"));

		repository.save(new Mydepartments()
				.setParentId(deputies.getId())
				.setDepartmentName("Федеральное агентство по рыболовству"));

		repository.save(new Mydepartments()
				.setParentId(deputies.getId())
				.setDepartmentName("Федеральная служба по надзору в сфере транспорта"));

		repository.save(new Mydepartments()
				.setParentId(deputies.getId())
				.setDepartmentName("Федеральное агентство воздушного транспорта"));

		repository.save(new Mydepartments()
				.setParentId(deputies.getId())
				.setDepartmentName("Федеральное дорожное агентство"));

		repository.save(new Mydepartments()
				.setParentId(deputies.getId())
				.setDepartmentName("Федеральное железнодорожное агентство"));

		repository.save(new Mydepartments()
				.setParentId(deputies.getId())
				.setDepartmentName("Федеральное агентство по морскому и речному транспорту"));

		Mydepartments rootPresident = new Mydepartments()
				.setDepartmentName("Президент");
		repository.save(rootPresident);

		repository.save(new Mydepartments()
				.setParentId(rootPresident.getId())
				.setDepartmentName("Министерство внутренних дел"));

		repository.save(new Mydepartments()
				.setParentId(rootPresident.getId())
				.setDepartmentName("Министерство по делам гражданской обороны, чрезвычайным ситуациям и ликвидации последствий стихийных бедствий"));

		repository.save(new Mydepartments()
				.setParentId(rootPresident.getId())
				.setDepartmentName("Министерство иностранных дел"));

		repository.save(new Mydepartments()
				.setParentId(rootPresident.getId())
				.setDepartmentName("Федеральное агентство по делам СНГ, соотечественников, проживающих за рубежом и по международному гуманитарному сотрудничеству"));

		repository.save(new Mydepartments()
				.setParentId(rootPresident.getId())
				.setDepartmentName("Министерство обороны"));

		repository.save(new Mydepartments()
				.setParentId(rootPresident.getId())
				.setDepartmentName("Федеральная служба по военно-техническому сотрудничеству"));

		repository.save(new Mydepartments()
				.setParentId(rootPresident.getId())
				.setDepartmentName("Федеральная служба по техническому и экспортному контролю"));

		repository.save(new Mydepartments()
				.setParentId(rootPresident.getId())
				.setDepartmentName("Министерство юстиции"));

		repository.save(new Mydepartments()
				.setParentId(rootPresident.getId())
				.setDepartmentName("Федеральная служба исполнения наказаний"));

		repository.save(new Mydepartments()
				.setParentId(rootPresident.getId())
				.setDepartmentName("Федеральная служба судебных приставов"));
	}

}