package org.demo.documentation.multivaluero.validationconfirm;

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
public class MyExample220Service extends VersionAwareResponseService<MyExample220DTO, MyEntity220> {

	private final MyEntity220Repository repository;

	@Autowired
	private EntityManager entityManager;

	public MyExample220Service(MyEntity220Repository repository) {
		super(MyExample220DTO.class, MyEntity220.class, null, MyExample220Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample220DTO> doCreateEntity(MyEntity220 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample220DTO> doUpdateEntity(MyEntity220 entity, MyExample220DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample220DTO_.customField)) {
			entity.getCustomFieldList().clear();
			entity.getCustomFieldList().addAll(data.getCustomField().getValues().stream()
					.map(MultivalueFieldSingleValue::getId)
					.filter(Objects::nonNull)
					.map(Long::parseLong)
					.map(e -> entityManager.getReference(MyEntity223.class, e))
					.collect(Collectors.toList()));
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample220DTO> getActions() {
		return Actions.<MyExample220DTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}

}