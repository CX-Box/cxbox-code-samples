package org.demo.documentation.fields.multivaluehover.ro;

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
public class MyExample229Service extends VersionAwareResponseService<MyExample229DTO, MyEntity229> {

	private final MyEntity229Repository repository;

	@Autowired
	private EntityManager entityManager;

	public MyExample229Service(MyEntity229Repository repository) {
		super(MyExample229DTO.class, MyEntity229.class, null, MyExample229Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample229DTO> doCreateEntity(MyEntity229 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample229DTO> doUpdateEntity(MyEntity229 entity, MyExample229DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample229DTO_.customField)) {
			entity.getCustomFieldList().clear();
			entity.getCustomFieldList().addAll(data.getCustomField().getValues().stream()
					.map(MultivalueFieldSingleValue::getId)
					.filter(Objects::nonNull)
					.map(Long::parseLong)
					.map(e -> entityManager.getReference(MyEntity230.class, e))
					.toList());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample229DTO> getActions() {
		return Actions.<MyExample229DTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
				.build();
	}
	// --8<-- [end:getActions]

}