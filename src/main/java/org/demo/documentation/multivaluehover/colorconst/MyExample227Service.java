package org.demo.documentation.multivaluehover.colorconst;

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
public class MyExample227Service extends VersionAwareResponseService<MyExample227DTO, MyEntity227> {

	private final MyEntity227Repository repository;

	@Autowired
	private EntityManager entityManager;

	public MyExample227Service(MyEntity227Repository repository) {
		super(MyExample227DTO.class, MyEntity227.class, null, MyExample227Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample227DTO> doCreateEntity(MyEntity227 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample227DTO> doUpdateEntity(MyEntity227 entity, MyExample227DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample227DTO_.customField)) {
			entity.getCustomFieldList().clear();
			entity.getCustomFieldList().addAll(data.getCustomField().getValues().stream()
					.map(MultivalueFieldSingleValue::getId)
					.filter(Objects::nonNull)
					.map(Long::parseLong)
					.map(e -> entityManager.getReference(MyEntity228.class, e))
					.toList());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample227DTO> getActions() {
		return Actions.<MyExample227DTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}
	// --8<-- [end:getActions]

}