package org.demo.documentation.widgets.assoc.colortitle;

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
public class MyExample3056Service extends VersionAwareResponseService<MyExample3056DTO, MyEntity3056> {

	private final MyEntity3056Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample3056Meta> meta = MyExample3056Meta.class;
	@Autowired
	private EntityManager entityManager;

	@Override
	protected CreateResult<MyExample3056DTO> doCreateEntity(MyEntity3056 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample3056DTO> doUpdateEntity(MyEntity3056 entity, MyExample3056DTO data, BusinessComponent bc) {
		if (data.isFieldChanged(MyExample3056DTO_.customFieldMultiConst)) {
			entity.getCustomFieldMultiConstList().clear();
			entity.getCustomFieldMultiConstList().addAll(data.getCustomFieldMultiConst().getValues().stream()
					.map(MultivalueFieldSingleValue::getId)
					.filter(Objects::nonNull)
					.map(Long::parseLong)
					.map(e -> entityManager.getReference(MyEntity3056Multi.class, e))
					.toList());
		}
		if (data.isFieldChanged(MyExample3056DTO_.customFieldMulti)) {
			entity.getCustomFieldMultiList().clear();
			entity.getCustomFieldMultiList().addAll(data.getCustomFieldMulti().getValues().stream()
					.map(MultivalueFieldSingleValue::getId)
					.filter(Objects::nonNull)
					.map(Long::parseLong)
					.map(e -> entityManager.getReference(MyEntity3056Multi.class, e))
					.toList());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample3056DTO> getActions() {
		return Actions.<MyExample3056DTO>builder()
				.save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]
}
