package org.demo.documentation.widgets.assoctree.colortitle.allfields;

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
public class MyExample3329Service extends VersionAwareResponseService<MyExample3329DTO, MyEntity3329> {

	private final MyEntity3329Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample3329Meta> meta = MyExample3329Meta.class;
	@Autowired
	private EntityManager entityManager;

	@Override
	protected CreateResult<MyExample3329DTO> doCreateEntity(MyEntity3329 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample3329DTO> doUpdateEntity(MyEntity3329 entity, MyExample3329DTO data, BusinessComponent bc) {
		if (data.isFieldChanged(MyExample3329DTO_.customFieldMulti)) {
			entity.getCustomFieldMultiList().clear();
			entity.getCustomFieldMultiList().addAll(data.getCustomFieldMulti().getValues().stream()
					.map(MultivalueFieldSingleValue::getId)
					.filter(Objects::nonNull)
					.map(Long::parseLong)
					.map(e -> entityManager.getReference(MyEntity3329Multi.class, e))
					.toList());
		}
		if (data.isFieldChanged(MyExample3329DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample3329DTO> getActions() {
		return Actions.<MyExample3329DTO>builder()
				.save(sv -> sv.text("Save"))
				.create(crt -> crt)
				.delete(dlt -> dlt)
				.build();
	}
	// --8<-- [end:getActions]
}
