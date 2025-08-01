package org.demo.documentation.fields.multivalue.primary;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.multivalue.MultivalueFieldSingleValue;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;

import org.demo.conf.cxbox.extension.multivaluePrimary.MultivalueExt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.val;
import jakarta.persistence.EntityManager;
import java.util.Objects;
import java.util.stream.Collectors;


@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample2000Service extends VersionAwareResponseService<MyExample2000DTO, MyEntity2000> {

	private final MyEntity2000Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample2000Meta> meta = MyExample2000Meta.class;

    @Autowired
	private EntityManager entityManager;

    @Override
	protected CreateResult<MyExample2000DTO> doCreateEntity(MyEntity2000 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample2000DTO> doUpdateEntity(MyEntity2000 entity, MyExample2000DTO data,
															   BusinessComponent bc) {
		if (data.isFieldChanged(MyExample2000DTO_.customField)) {
			entity.getCustomFieldList().clear();
			entity.getCustomFieldList().addAll(data.getCustomField().getValues().stream()
					.map(MultivalueFieldSingleValue::getId)
					.filter(Objects::nonNull)
					.map(Long::parseLong)
					.map(e -> entityManager.getReference(MyEntity2001.class, e))
					.collect(Collectors.toList()));
			val primary = data.getCustomField().getValues().stream().filter(e -> e.getOptions().get(MultivalueExt.PRIMARY) != null && e.getOptions().get(MultivalueExt.PRIMARY).equalsIgnoreCase(Boolean.TRUE.toString())).findAny();
			primary.ifPresent(s -> entity.setPrimaryId(Long.parseLong(s.getId())));
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample2000DTO> getActions() {
		return Actions.<MyExample2000DTO>builder()
               .save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]

}