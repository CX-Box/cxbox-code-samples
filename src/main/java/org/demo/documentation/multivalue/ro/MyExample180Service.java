package org.demo.documentation.multivalue.ro;

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
public class MyExample180Service extends VersionAwareResponseService<MyExample180DTO, MyEntity180> {

	private final MyEntity180Repository repository;

	@Autowired
	private EntityManager entityManager;

	public MyExample180Service(MyEntity180Repository repository) {
		super(MyExample180DTO.class, MyEntity180.class, null, MyExample180Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample180DTO> doCreateEntity(MyEntity180 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample180DTO> doUpdateEntity(MyEntity180 entity, MyExample180DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample180DTO_.customField)) {
			entity.getCustomFieldList().clear();
			entity.getCustomFieldList().addAll(data.getCustomField().getValues().stream()
					.map(MultivalueFieldSingleValue::getId)
					.filter(Objects::nonNull)
					.map(Long::parseLong)
					.map(e -> entityManager.getReference(MyEntity181.class, e))
					.toList());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample180DTO> getActions() {
		return Actions.<MyExample180DTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}

}