package org.demo.documentation.multivalue.drilldown;

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
public class MyExample182Service extends VersionAwareResponseService<MyExample182DTO, MyEntity182> {

	private final MyEntity182Repository repository;

	@Autowired
	private EntityManager entityManager;

	public MyExample182Service(MyEntity182Repository repository) {
		super(MyExample182DTO.class, MyEntity182.class, null, MyExample182Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample182DTO> doCreateEntity(MyEntity182 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample182DTO> doUpdateEntity(MyEntity182 entity, MyExample182DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample182DTO_.customField)) {
			entity.getCustomFieldList().clear();
			entity.getCustomFieldList().addAll(data.getCustomField().getValues().stream()
					.map(MultivalueFieldSingleValue::getId)
					.filter(Objects::nonNull)
					.map(Long::parseLong)
					.map(e -> entityManager.getReference(MyEntity183.class, e))
					.toList());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample182DTO> getActions() {
		return Actions.<MyExample182DTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}
	// --8<-- [end:getActions]

}