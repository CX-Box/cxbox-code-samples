package org.demo.documentation.multivalue.sorting;

import java.util.Objects;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.multivalue.MultivalueFieldSingleValue;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MyExample190Service extends VersionAwareResponseService<MyExample190DTO, MyEntity190> {

	private final MyEntity190Repository repository;

	@Autowired
	private EntityManager entityManager;

	public MyExample190Service(MyEntity190Repository repository) {
		super(MyExample190DTO.class, MyEntity190.class, null, MyExample190Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample190DTO> doCreateEntity(MyEntity190 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample190DTO> doUpdateEntity(MyEntity190 entity, MyExample190DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample190DTO_.customField)) {
			entity.getCustomFieldList().clear();
			entity.getCustomFieldList().addAll(data.getCustomField().getValues().stream()
					.map(MultivalueFieldSingleValue::getId)
					.filter(Objects::nonNull)
					.map(Long::parseLong)
					.map(e -> entityManager.getReference(MyEntity191.class, e))
					.toList());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample190DTO> getActions() {
		return Actions.<MyExample190DTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}
	// --8<-- [end:getActions]

}