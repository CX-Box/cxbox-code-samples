package org.demo.documentation.multivalue.placeholder;

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
public class MyExample186Service extends VersionAwareResponseService<MyExample186DTO, MyEntity186> {

	private final MyEntity186Repository repository;

	@Autowired
	private EntityManager entityManager;

	public MyExample186Service(MyEntity186Repository repository) {
		super(MyExample186DTO.class, MyEntity186.class, null, MyExample186Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample186DTO> doCreateEntity(MyEntity186 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample186DTO> doUpdateEntity(MyEntity186 entity, MyExample186DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample186DTO_.customField)) {
			entity.getCustomFieldList().clear();
			entity.getCustomFieldList().addAll(data.getCustomField().getValues().stream()
					.map(MultivalueFieldSingleValue::getId)
					.filter(Objects::nonNull)
					.map(Long::parseLong)
					.map(e -> entityManager.getReference(MyEntity187.class, e))
					.toList());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample186DTO> getActions() {
		return Actions.<MyExample186DTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}
	// --8<-- [end:getActions]

}