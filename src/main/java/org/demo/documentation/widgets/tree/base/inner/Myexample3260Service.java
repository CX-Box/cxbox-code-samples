package org.demo.documentation.widgets.tree.base.inner;


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
import org.demo.documentation.widgets.tree.data.inner.Myexample3261;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Getter
@RequiredArgsConstructor
public class Myexample3260Service extends VersionAwareResponseService<Myexample3260DTO, Myexample3260> {

	@Getter(onMethod_ = @Override)
	private final Class<Myexample3260MetaBuilder> meta = Myexample3260MetaBuilder.class;

	private final MyEntity3260Repository myexample3260Repository;

	@Autowired
	private EntityManager entityManager;


	@Override
	protected Specification<Myexample3260> getSpecification(BusinessComponent bc) {
		return super.getSpecification(bc);
	}

	@Override
	protected CreateResult<Myexample3260DTO> doCreateEntity(Myexample3260 entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, myexample3260Repository.save(entity)));
	}

	@Override
	protected ActionResultDTO<Myexample3260DTO> doUpdateEntity(Myexample3260 entity, Myexample3260DTO data, BusinessComponent bc) {
		if (data.isFieldChanged(Myexample3260DTO_.departments)) {
			entity.getDepartmentsList().clear();
			entity.getDepartmentsList().addAll(data.getDepartments().getValues().stream()
					.map(MultivalueFieldSingleValue::getId)
					.filter(Objects::nonNull)
					.map(Long::parseLong)
					.map(e -> entityManager.getReference(Myexample3261.class, e))
					.collect(Collectors.toList()));
		}
		if (data.isFieldChanged(Myexample3260DTO_.departmentId)) {
			entity.setDepartmentEntity(data.getDepartmentId() != null
					? entityManager.getReference(Myexample3261.class, data.getDepartmentId())
					: null);
		}
		return new ActionResultDTO<>(entityToDto(bc, myexample3260Repository.save(entity)))
				.setAction(PostAction.refreshBc(bc));
	}

	@Override
	public Actions<Myexample3260DTO> getActions() {
		return Actions.<Myexample3260DTO>builder()
				.create(crt -> crt.text("Create"))
				.delete(dlt -> dlt.text("Delete"))
				.save(sv -> sv.text("Save"))
				.associate(assoc -> assoc.text("Associate"))
				.build();
	}

}
