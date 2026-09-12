package org.demo.documentation.fields.multivaluetree.primary;

import jakarta.persistence.EntityManager;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.multivalue.MultivalueFieldSingleValue;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.demo.conf.cxbox.extension.multivaluePrimary.MultivalueExt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.stream.Collectors;


@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample3320Service extends VersionAwareResponseService<MyExample3320DTO, MyEntity3320> {

	private final MyEntity3320Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample3320Meta> meta = MyExample3320Meta.class;

	@Autowired
	private EntityManager entityManager;

	@Override
	protected CreateResult<MyExample3320DTO> doCreateEntity(MyEntity3320 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample3320DTO> doUpdateEntity(MyEntity3320 entity, MyExample3320DTO data,
															   BusinessComponent bc) {
		if (data.isFieldChanged(MyExample3320DTO_.customField)) {
			entity.getCustomFieldList().clear();
			entity.getCustomFieldList().addAll(data.getCustomField().getValues().stream()
					.map(MultivalueFieldSingleValue::getId)
					.filter(Objects::nonNull)
					.map(Long::parseLong)
					.map(e -> entityManager.getReference(MyEntity3320Multivalue.class, e))
					.collect(Collectors.toList()));
			val primary = data.getCustomField().getValues().stream().filter(e -> e.getOptions().get(MultivalueExt.PRIMARY) != null && e.getOptions().get(MultivalueExt.PRIMARY).equalsIgnoreCase(Boolean.TRUE.toString())).findAny();
			primary.ifPresent(s -> entity.setPrimaryId(Long.parseLong(s.getId())));
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample3320DTO> getActions() {
		return Actions.<MyExample3320DTO>builder()
				.save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]

}