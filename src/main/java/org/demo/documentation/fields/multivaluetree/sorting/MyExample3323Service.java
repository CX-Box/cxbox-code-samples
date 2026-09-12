package org.demo.documentation.fields.multivaluetree.sorting;

import jakarta.persistence.EntityManager;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.multivalue.MultivalueFieldSingleValue;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;


@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample3323Service extends VersionAwareResponseService<MyExample3323DTO, MyEntity3323> {

	private final MyEntity3323Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample3323Meta> meta = MyExample3323Meta.class;

	@Autowired
	private EntityManager entityManager;

	@Override
	protected CreateResult<MyExample3323DTO> doCreateEntity(MyEntity3323 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample3323DTO> doUpdateEntity(MyEntity3323 entity, MyExample3323DTO data,
															  BusinessComponent bc) {
		if (data.isFieldChanged(MyExample3323DTO_.customField)) {
			entity.getCustomFieldList().clear();
			entity.getCustomFieldList().addAll(data.getCustomField().getValues().stream()
					.map(MultivalueFieldSingleValue::getId)
					.filter(Objects::nonNull)
					.map(Long::parseLong)
					.map(e -> entityManager.getReference(MyEntity3323Multivalue.class, e))
					.toList());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample3323DTO> getActions() {
		return Actions.<MyExample3323DTO>builder()
				.save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]

}