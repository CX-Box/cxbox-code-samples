package org.demo.documentation.fields.multivalue.color;

import java.util.Objects;
import jakarta.persistence.EntityManager;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.multivalue.MultivalueFieldSingleValue;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MyExample174Service extends VersionAwareResponseService<MyExample174DTO, MyEntity174> {

	private final MyEntity174Repository repository;

	@Autowired
	private EntityManager entityManager;

	public MyExample174Service(MyEntity174Repository repository) {
		super(MyExample174DTO.class, MyEntity174.class, null, MyExample174Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample174DTO> doCreateEntity(MyEntity174 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample174DTO> doUpdateEntity(MyEntity174 entity, MyExample174DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample174DTO_.customField)) {
			entity.getCustomFieldList().clear();
			entity.getCustomFieldList().addAll(data.getCustomField().getValues().stream()
					.map(MultivalueFieldSingleValue::getId)
					.filter(Objects::nonNull)
					.map(Long::parseLong)
					.map(e -> entityManager.getReference(MyEntity175.class, e))
					.toList());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample174DTO> getActions() {
		return Actions.<MyExample174DTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
				.build();
	}
	// --8<-- [end:getActions]

}