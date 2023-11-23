package org.demo.documentation.multivalue.validationannotation;

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
public class MyExample198Service extends VersionAwareResponseService<MyExample198DTO, MyEntity198> {

	private final MyEntity198Repository repository;

	@Autowired
	private EntityManager entityManager;

	public MyExample198Service(MyEntity198Repository repository) {
		super(MyExample198DTO.class, MyEntity198.class, null, MyExample198Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample198DTO> doCreateEntity(MyEntity198 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample198DTO> doUpdateEntity(MyEntity198 entity, MyExample198DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample198DTO_.customField)) {
			entity.getCustomFieldList().clear();
			entity.getCustomFieldList().addAll(data.getCustomField().getValues().stream()
					.map(MultivalueFieldSingleValue::getId)
					.filter(Objects::nonNull)
					.map(Long::parseLong)
					.map(e -> entityManager.getReference(MyEntity199.class, e))
					.toList());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample198DTO> getActions() {
		return Actions.<MyExample198DTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}
	// --8<-- [end:getActions]

}