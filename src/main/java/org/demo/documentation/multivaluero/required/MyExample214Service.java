package org.demo.documentation.multivaluero.required;

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
public class MyExample214Service extends VersionAwareResponseService<MyExample214DTO, MyEntity214> {

	private final MyEntity214Repository repository;

	@Autowired
	private EntityManager entityManager;

	public MyExample214Service(MyEntity214Repository repository) {
		super(MyExample214DTO.class, MyEntity214.class, null, MyExample214Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample214DTO> doCreateEntity(MyEntity214 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample214DTO> doUpdateEntity(MyEntity214 entity, MyExample214DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample214DTO_.customField)) {
			entity.getCustomFieldList().clear();
			entity.getCustomFieldList().addAll(data.getCustomField().getValues().stream()
					.map(MultivalueFieldSingleValue::getId)
					.filter(Objects::nonNull)
					.map(Long::parseLong)
					.map(e -> entityManager.getReference(MyEntity215.class, e))
					.collect(Collectors.toList()));
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample214DTO> getActions() {
		return Actions.<MyExample214DTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}

}