package org.demo.documentation.multivaluero.validationbusinessex;

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
public class MyExample218Service extends VersionAwareResponseService<MyExample218DTO, MyEntity218> {

	private final MyEntity218Repository repository;

	@Autowired
	private EntityManager entityManager;

	public MyExample218Service(MyEntity218Repository repository) {
		super(MyExample218DTO.class, MyEntity218.class, null, MyExample218Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample218DTO> doCreateEntity(MyEntity218 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample218DTO> doUpdateEntity(MyEntity218 entity, MyExample218DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample218DTO_.customField)) {
			entity.getCustomFieldList().clear();
			entity.getCustomFieldList().addAll(data.getCustomField().getValues().stream()
					.map(MultivalueFieldSingleValue::getId)
					.filter(Objects::nonNull)
					.map(Long::parseLong)
					.map(e -> entityManager.getReference(MyEntity219.class, e))
					.collect(Collectors.toList()));
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample218DTO> getActions() {
		return Actions.<MyExample218DTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}

}