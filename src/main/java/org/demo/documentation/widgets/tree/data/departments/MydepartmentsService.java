package org.demo.documentation.widgets.tree.data.departments;


import jakarta.persistence.EntityManager;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.multivalue.MultivalueFieldSingleValue;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.dto.rowmeta.PostAction;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.widgets.tree.data.users.My3261Users;
import org.demo.repository.core.MydepartmentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Getter
@RequiredArgsConstructor
public class MydepartmentsService extends VersionAwareResponseService<MydepartmentsDTO, Mydepartments> {

	@Getter(onMethod_ = @Override)
	private final Class<MydepartmentsMetaBuilder> meta = MydepartmentsMetaBuilder.class;

	private final MydepartmentsRepository mydepartmentsRepository;

	@Autowired
	private EntityManager entityManager;


	@Override
	protected Specification<Mydepartments> getSpecification(BusinessComponent bc) {
		return super.getSpecification(bc);
	}

	@Override
	protected CreateResult<MydepartmentsDTO> doCreateEntity(Mydepartments entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, mydepartmentsRepository.save(entity)));
	}

	@Override
	protected ActionResultDTO<MydepartmentsDTO> doUpdateEntity(Mydepartments entity, MydepartmentsDTO data, BusinessComponent bc) {
		if (data.isFieldChanged(MydepartmentsDTO_.fullName)) {
			entity.getFullNameList().clear();
			entity.getFullNameList().addAll(data.getFullName().getValues().stream()
					.map(MultivalueFieldSingleValue::getId)
					.filter(Objects::nonNull)
					.map(Long::parseLong)
					.map(e -> entityManager.getReference(My3261Users.class, e))
					.collect(Collectors.toList()));
		}
		setIfChanged(data, MydepartmentsDTO_.parentId, entity::setParentId);
		setIfChanged(data, MydepartmentsDTO_.description, entity::setDescription);
		setIfChanged(data, MydepartmentsDTO_.departmentName, entity::setDepartmentName);
		return new ActionResultDTO<>(entityToDto(bc, mydepartmentsRepository.save(entity)))
				.setAction(PostAction.refreshBc(bc));
	}

	@Override
	public Actions<MydepartmentsDTO> getActions() {
		return Actions.<MydepartmentsDTO>builder()
				.create(crt -> crt.text("Create"))
				.delete(dlt -> dlt.text("Delete"))
				.save(sv -> sv.text("Save"))
				.build();
	}

}
