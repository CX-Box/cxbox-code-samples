package org.demo.documentation.fields.multivaluehover.color;

import java.util.Objects;
import java.util.stream.Collectors;
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
public class MyExample225Service extends VersionAwareResponseService<MyExample225DTO, MyEntity225> {

	private final MyEntity225Repository repository;

	@Autowired
	private EntityManager entityManager;

	public MyExample225Service(MyEntity225Repository repository) {
		super(MyExample225DTO.class, MyEntity225.class, null, MyExample225Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample225DTO> doCreateEntity(MyEntity225 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample225DTO> doUpdateEntity(MyEntity225 entity, MyExample225DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample225DTO_.customField)) {
			entity.getCustomFieldList().clear();
			entity.getCustomFieldList().addAll(data.getCustomField().getValues().stream()
					.map(MultivalueFieldSingleValue::getId)
					.filter(Objects::nonNull)
					.map(Long::parseLong)
					.map(e -> entityManager.getReference(MyEntity226.class, e))
					.toList());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample225DTO> getActions() {
		return Actions.<MyExample225DTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
				.build();
	}
	// --8<-- [end:getActions]

}