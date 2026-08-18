package org.demo.documentation.widgets.tree.showcondition.byparententity.inner;


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
public class Myexample3270Service extends VersionAwareResponseService<Myexample3270DTO, Myexample3270> {

	@Getter(onMethod_ = @Override)
	private final Class<Myexample3270MetaBuilder> meta = Myexample3270MetaBuilder.class;

	private final MyEntity3270Repository myexample3270Repository;

	@Autowired
	private EntityManager entityManager;


	@Override
	protected Specification<Myexample3270> getSpecification(BusinessComponent bc) {
		return super.getSpecification(bc);
	}

	@Override
	protected CreateResult<Myexample3270DTO> doCreateEntity(Myexample3270 entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, myexample3270Repository.save(entity)));
	}

	@Override
	protected ActionResultDTO<Myexample3270DTO> doUpdateEntity(Myexample3270 entity, Myexample3270DTO data, BusinessComponent bc) {
		if (data.isFieldChanged(Myexample3270DTO_.departments)) {
			entity.getDepartmentsList().clear();
			entity.getDepartmentsList().addAll(data.getDepartments().getValues().stream()
					.map(MultivalueFieldSingleValue::getId)
					.filter(Objects::nonNull)
					.map(Long::parseLong)
					.map(e -> entityManager.getReference(Myexample3261.class, e))
					.collect(Collectors.toList()));
		}
		if (data.isFieldChanged(Myexample3270DTO_.departmentId)) {
			entity.setDepartmentEntity(data.getDepartmentId() != null
					? entityManager.getReference(Myexample3261.class, data.getDepartmentId())
					: null);
		}
		return new ActionResultDTO<>(entityToDto(bc, myexample3270Repository.save(entity)))
				.setAction(PostAction.refreshBc(bc));
	}

	@Override
	public Actions<Myexample3270DTO> getActions() {
		return Actions.<Myexample3270DTO>builder()
				.create(crt -> crt.text("Create"))
				.delete(dlt -> dlt.text("Delete"))
				.save(sv -> sv.text("Save"))
				.associate(assoc -> assoc.text("Associate"))
				.build();
	}

}
