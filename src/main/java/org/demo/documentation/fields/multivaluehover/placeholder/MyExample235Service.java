package org.demo.documentation.fields.multivaluehover.placeholder;

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
import java.util.stream.Collectors;


@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample235Service extends VersionAwareResponseService<MyExample235DTO, MyEntity235> {

	private final MyEntity235Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample235Meta> meta = MyExample235Meta.class;
	@Autowired
	private EntityManager entityManager;

	@Override
	protected CreateResult<MyExample235DTO> doCreateEntity(MyEntity235 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample235DTO> doUpdateEntity(MyEntity235 entity, MyExample235DTO data,
															  BusinessComponent bc) {
		if (data.isFieldChanged(MyExample235DTO_.customFieldMultivalueHover)) {
			entity.getCustomFieldMultivalueHoverList().clear();
			entity.getCustomFieldMultivalueHoverList().addAll(data.getCustomFieldMultivalueHover().getValues().stream()
					.map(MultivalueFieldSingleValue::getId)
					.filter(Objects::nonNull)
					.map(Long::parseLong)
					.map(e -> entityManager.getReference(MyEntityMulti235.class, e))
					.collect(Collectors.toList()));
		}
		if (data.isFieldChanged(MyExample235DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample235DTO> getActions() {
		return Actions.<MyExample235DTO>builder()
				.save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]

}