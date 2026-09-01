package org.demo.documentation.widgets.tree.base.inner;


import jakarta.persistence.EntityManager;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.cxbox.api.data.dto.AssociateDTO;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.multivalue.MultivalueFieldSingleValue;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.AssociateResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.dto.rowmeta.PostAction;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.widgets.tree.data.inner.MyEntity3261Repository;
import org.demo.documentation.widgets.tree.data.inner.Myexample3261;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Getter
@RequiredArgsConstructor
public class Myexample3263Service extends VersionAwareResponseService<Myexample3263DTO, Myexample3263> {
	@Getter(onMethod_ = @Override)
	private final Class<Myexample3263MetaBuilder> meta = Myexample3263MetaBuilder.class;

	private final MyEntity3263Repository myexample3263Repository;
	private final MyEntity3261Repository myexample3261Repository;

	@Autowired
	private EntityManager entityManager;


	@Override
	protected Specification<Myexample3263> getSpecification(BusinessComponent bc) {
		return super.getSpecification(bc);
	}

	@Override
	protected CreateResult<Myexample3263DTO> doCreateEntity(Myexample3263 entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, myexample3263Repository.save(entity)));
	}

	@Override
	protected ActionResultDTO<Myexample3263DTO> doUpdateEntity(Myexample3263 entity, Myexample3263DTO data, BusinessComponent bc) {
		if (data.isFieldChanged(Myexample3263DTO_.departments)) {
			entity.getDepartmentsList().clear();
			entity.getDepartmentsList().addAll(data.getDepartments().getValues().stream()
					.map(MultivalueFieldSingleValue::getId)
					.filter(Objects::nonNull)
					.map(Long::parseLong)
					.map(e -> entityManager.getReference(Myexample3261.class, e))
					.collect(Collectors.toList()));
		}
		if (data.isFieldChanged(Myexample3263DTO_.departmentId)) {
			entity.setDepartmentEntity(data.getDepartmentId() != null
					? entityManager.getReference(Myexample3261.class, data.getDepartmentId())
					: null);
		}
		return new ActionResultDTO<>(entityToDto(bc, myexample3263Repository.save(entity)))
				.setAction(PostAction.refreshBc(bc));
	}

	@Override
	protected AssociateResultDTO doAssociate(List<AssociateDTO> data, BusinessComponent bc) {
		Myexample3263 myexample3263 = addNewRecords(data, bc);
		Myexample3263DTO dto = entityToDto(bc, myexample3263);
		String departmentsDisplayed = myexample3263.getDepartmentsList()
				.stream()
				.map(dept -> dept.getDepartment())
				.collect(Collectors.joining(", "));
		dto.setDepartmentsDisplayedKey(departmentsDisplayed);
		List<Myexample3263DTO> collect = new ArrayList<>();
		collect.add(dto);
		return new AssociateResultDTO((List) collect);
	}

	@SneakyThrows
	private Myexample3263 addNewRecords(List<AssociateDTO> dataIds, BusinessComponent bc) {
		Myexample3263 myexample3263 = new Myexample3263();
		List<Myexample3261> listMultivalue = new ArrayList<>();
		for (AssociateDTO item : dataIds) {
			Optional<Myexample3261> entityChild = myexample3261Repository.findById(Long.valueOf(item.getId()));
			listMultivalue.add(entityChild.get());
		}
		myexample3263.setDepartmentsList(listMultivalue);
		myexample3263Repository.save(myexample3263);
		return myexample3263;
	}

	@Override
	public Actions<Myexample3263DTO> getActions() {
		return Actions.<Myexample3263DTO>builder()
				.create(crt -> crt.text("Create"))
				.delete(dlt -> dlt.text("Delete"))
				.save(sv -> sv.text("Save"))
				.associate(assoc -> assoc.text("Associate"))
				.build();
	}

}
